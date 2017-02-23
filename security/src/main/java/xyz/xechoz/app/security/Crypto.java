package xyz.xechoz.app.security;


import xyz.xechoz.app.security.api.ICipher;
import xyz.xechoz.app.security.api.IDigest;
import xyz.xechoz.app.security.api.ISign;

/**
 * Created by xechoz.zheng on 2/22/17.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public class Crypto {
    private CryptoParam cryptoParam;

    public Crypto(CryptoParam param) {
        cryptoParam = param;
    }

    public String digest(byte[] data) {
        return toHex(cryptoParam.digest.digest(data));
    }

    public String sign(byte[] data) {
        return toHex(cryptoParam.sign.sign(data));
    }

    public String encrypt(byte[] data) {
        return toHex(cryptoParam.cipher.encrypt(data));
    }

    public String decrypt(byte[] data) {
        return toHex(cryptoParam.cipher.decrypt(data));
    }

    private static String toHex(byte[] from) {
        StringBuilder builder = new StringBuilder("0x");

        for (byte in : from) {
            String t = Integer.toHexString(in);

            if (t.length() == 1) {
                builder.append("0");
            }

            builder.append(t);
        }

        return builder.toString();
    }

    public static class Builder {
        private CryptoParam param;

        public Builder() {
            param = new CryptoParam();
        }

        Builder digest(IDigest digest) {
            param.digest = digest;
            return this;
        }

        Builder cipher(ICipher cipher) {
            param.cipher = cipher;
            return this;
        }

        Builder sign(ISign sign) {
            param.sign = sign;
            return this;
        }

        Crypto build() {

            CryptoParam.inflateParam(param);

            return new Crypto(param);
        }
    }

    private static class CryptoParam {
        IDigest digest;
        ISign sign;
        ICipher cipher;

        private static void inflateParam(CryptoParam param) {
            if (param.digest == null) {
                param.digest = new Sha512();
            }

            if (param.cipher == null) {
                param.cipher = new AES();
            }

            if (param.sign == null) {
                param.sign = new ECC();
            }
        }
    }
}
