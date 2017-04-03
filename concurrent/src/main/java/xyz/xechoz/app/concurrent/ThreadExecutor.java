package xyz.xechoz.app.concurrent;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by xechoz.zheng on 03/04/2017.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public class ThreadExecutor {
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(1, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final int KEEP_ALIVE_MILLISECONDS = 128;
    private static ScheduledThreadPoolExecutor executor;
    private static Handler mainHandler;

    static {
        executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        executor.setMaximumPoolSize(MAXIMUM_POOL_SIZE);
        executor.setKeepAliveTime(KEEP_ALIVE_MILLISECONDS, TimeUnit.MILLISECONDS);

        mainHandler = new Handler(Looper.getMainLooper());
    }

    private ThreadExecutor() {
        super();
    }

    public static void post(Runnable task) {
        post(task, 0);
    }

    public static void post(Runnable task, long delayMillis) {
        executor.schedule(task, delayMillis, TimeUnit.MILLISECONDS);
    }

    public static void scheduleAtFixedRate(Runnable command,
                                           long initialDelay,
                                           long period) {
        executor.scheduleAtFixedRate(command, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    public static void scheduleWithFixedDelay(Runnable command,
                                              long initialDelay,
                                              long delay) {
        executor.scheduleWithFixedDelay(command, initialDelay, delay, TimeUnit.MILLISECONDS);
    }

    public static void postUi(Runnable task) {
        post(task, 0);
    }


    public static void postUi(Runnable task, long delayMillis) {
        mainHandler.postDelayed(task, delayMillis);
    }
}
