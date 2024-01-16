package org.presta.config;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.salt.ZeroSaltGenerator;

@Slf4j
public class EncryptionHelper {

    private static final PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();

    private static StringEncryptor createEncryptor() {
        encryptor.setPoolSize(4);
        encryptor.setSaltGenerator(new ZeroSaltGenerator());
        encryptor.setPassword("key");
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        return encryptor;
    }

    public static void decryptPassword(String textToDecrypt) {
        StringEncryptor encryptor = createEncryptor();
        String decryptedValue = encryptor.decrypt(textToDecrypt);
        System.setProperty("decrypted.password", decryptedValue);
        log.info("Value decrypted successfully");
    }
}
