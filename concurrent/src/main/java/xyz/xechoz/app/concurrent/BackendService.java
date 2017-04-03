package xyz.xechoz.app.concurrent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import xyz.xechoz.app.concurrent.model.Request;

/**
 * Created by xechoz.zheng on 2/23/17.
 * Email: zheng1733@gmail.com
 * 功能: 分发外部请求
 * 文档:
 */

public class BackendService extends Service {
    private IBinder binder = new IBackendJob.Stub() {
        @Override
        public void post(Request param, @Nullable ICallback callback) throws RemoteException {

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
