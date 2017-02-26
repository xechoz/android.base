package xyz.xechoz.app.security;

import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import xyz.xechoz.app.security.api.IDigest;

/**
 * Created by xechoz.zheng on 2/22/17.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public class Sha256 implements IDigest {
    private Cipher cipher;
    private final byte[] EMPTY_RESULT = new byte[0];

    @Override
    public byte[] digest(byte[] data) {
        try {
            if (cipher == null) {
                cipher = Cipher.getInstance("SHA-256");
            }

            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return EMPTY_RESULT;
    }
}
