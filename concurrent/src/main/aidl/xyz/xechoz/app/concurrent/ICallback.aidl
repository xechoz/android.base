// IPost.aidl
package xyz.xechoz.app.concurrent;

// Declare any non-default types here with import statements
import xyz.xechoz.app.concurrent.model.Response;

interface ICallback {
    void onResponse(in Response response);
}
