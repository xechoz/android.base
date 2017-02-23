package xyz.xechoz.app.security;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

import xyz.xechoz.app.security.api.IDigest;

/**
 * Created by xechoz.zheng on 2/22/17.
 * Email: zheng1733@gmail.com
 * 功能:
 * 文档:
 */

public class HmacSha512 implements IDigest {
    private static final String KEY_ALIAS = "key_" + HmacSha512.class.getName();

    private Mac mac;

    public void init() throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(
                "HmacSHA512", "AndroidKeyStore");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            keyGenerator.init(
                    new KeyGenParameterSpec.Builder(KEY_ALIAS, KeyProperties.PURPOSE_SIGN).build());
        }
        SecretKey key = keyGenerator.generateKey();

        mac = Mac.getInstance("HmacSHA512");
        mac.init(key);
    }

    public SecretKey getSecretKey() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, UnrecoverableKeyException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        return (SecretKey) keyStore.getKey(KEY_ALIAS, null);
    }

    @Override
    public byte[] digest(byte[] data) {
        return mac.doFinal(data);
    }
}
