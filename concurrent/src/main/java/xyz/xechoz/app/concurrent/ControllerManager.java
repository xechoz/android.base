package xyz.xechoz.app.concurrent;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import xyz.xechoz.app.concurrent.controller.IController;
import xyz.xechoz.app.concurrent.model.Request;

/**
 * Created by xechoz.zheng on 03/04/2017.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public class ControllerManager {
    private static final long CLEAN_INTERVAL = 10 * 1000;
    private final Object listLock = new Object();
    private final Object cleanLock = new Object();

    private List<WeakReference<IController>> controllerList = new ArrayList<>();
    private List<WeakReference<IController>> deadControllers = new ArrayList<>();

    public void post(Request request, ICallback callback) {
        for (WeakReference<IController> item: controllerList) {
            IController controller = item.get();

            if (controller != null) {
                if (controller.handle(request)) {
                    controller.onRequest(request, callback);
                }
            } else {
                synchronized (cleanLock) {
                    deadControllers.add(item);
                }

                ThreadExecutor.post(new Runnable() {
                    @Override
                    public void run() {
                        cleanDeadControllers();
                    }
                }, CLEAN_INTERVAL);
            }
        }
    }

    private void cleanDeadControllers() {
        synchronized (cleanLock) {
            for (WeakReference<IController> item: deadControllers) {
                synchronized (listLock) {
                    controllerList.remove(item);
                }
            }
        }
    }

    public void register(IController controller) {
        if (controller != null && !contains(controller)) {
            synchronized (listLock) {
                controllerList.add(new WeakReference<IController>(controller));
            }
        }
    }

    public void unRegister(IController controller) {
        synchronized (listLock) {
            controllerList.remove(get(controller));
        }
    }

    private boolean contains(IController controller) {
        return get(controller) != null;
    }

    private WeakReference<IController> get(IController controller) {
        synchronized (listLock) {
            if (controller != null && !controllerList.isEmpty()) {
                for (WeakReference<IController> item : controllerList) {
                    if (item.get() == controller) {
                        return item;
                    }
                }
            }

            return null;
        }
    }

    public void onDestroy() {
        controllerList.clear();
        controllerList = null;
    }
}
