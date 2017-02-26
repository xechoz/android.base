package xyz.xechoz.app.security.api;

/**
 * Created by xechoz.zheng on 2/22/17.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public interface IDigest {
    /**
     *
     * @param data data to compute digest
     * @return the digest in hex string
     */
    byte[] digest(byte[] data);
}
