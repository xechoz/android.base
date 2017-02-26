package xyz.xechoz.app.security.api;

/**
 * Created by xechoz.zheng on 2/22/17.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public interface ICipher {
    byte[] encrypt(byte[] data);
    byte[] decrypt(byte[] data);
}
