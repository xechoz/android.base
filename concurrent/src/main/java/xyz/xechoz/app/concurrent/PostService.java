package xyz.xechoz.app.concurrent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by xechoz.zheng on 2/23/17.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public class PostService extends Service {
    private IBinder binder = new IPost.Stub() {
        @Override
        public void hello(String message) throws RemoteException {
            Toast.makeText(PostService.this, message, Toast.LENGTH_LONG).show();
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
