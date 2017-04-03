// IBackendJob.aidl
package xyz.xechoz.app.concurrent;

// Declare any non-default types here with import statements
import xyz.xechoz.app.concurrent.ICallback;
import xyz.xechoz.app.concurrent.model.Request;

interface IBackendJob {
    oneway void post(in Request param, ICallback callback);
}
