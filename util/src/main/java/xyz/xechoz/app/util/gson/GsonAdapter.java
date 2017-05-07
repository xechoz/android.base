package xyz.xechoz.app.util.gson;

/**
 * Created by xechoz.zheng on 07/05/2017.
 * Email: xechoz.zheng@gmail.com
 * 功能:
 * 文档:
 */

public @interface GsonAdapter {
    Class<?> unbox();
    Class<?> box();
}
