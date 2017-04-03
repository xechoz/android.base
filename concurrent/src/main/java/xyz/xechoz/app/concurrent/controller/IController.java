package xyz.xechoz.app.concurrent.controller;

import xyz.xechoz.app.concurrent.ICallback;
import xyz.xechoz.app.concurrent.model.Request;

/**
 * Created by xechoz.zheng on 03/04/2017.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public interface IController {
    boolean handle(Request request);
    void onRequest(Request request, ICallback callback);
}
