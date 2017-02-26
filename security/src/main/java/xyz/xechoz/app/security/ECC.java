package xyz.xechoz.app.security;

import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import xyz.xechoz.app.security.api.ICipher;
import xyz.xechoz.app.security.api.ISign;

/**
 * Created by xechoz.zheng on 2/22/17.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public class ECC implements ICipher, ISign {
    private Cipher signCipher;
    private Cipher encryCipher;

    @Override
    public byte[] encrypt(byte[] data) {
        return new byte[0];
    }

    @Override
    public byte[] decrypt(byte[] data) {
        return new byte[0];
    }

    @Override
    public byte[] sign(byte[] data) {
        try {
            if (signCipher == null) {
                signCipher = Cipher.getInstance("SHA512withECDSA");
            }

            return signCipher.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }
}
