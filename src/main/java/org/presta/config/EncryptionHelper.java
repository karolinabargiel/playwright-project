package org.presta.config;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;

@Slf4j
public class EncryptionHelper {

    public static StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    private static String originalPassword;
    private static String encryptionKey;

    public static void main(String[] args) {
        originalPassword = "password";
        encryptionKey = "key";
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setPassword(encryptionKey);
        String encryptedPassword = encryptor.encrypt(originalPassword);
        log.info("Encrypted Password: " + encryptedPassword);
        decryptPassword(encryptedPassword);
    }

    public static void decryptPassword(String encryptedPassword) {
        try {
            String decryptedPassword = encryptor.decrypt(encryptedPassword);
            System.out.println("Decrypted Password: " + decryptedPassword);
            System.setProperty("decrypted.password", decryptedPassword);
        } catch (EncryptionOperationNotPossibleException e) {
            System.err.println("Error decrypting password: " + e.getMessage());
            throw e; // Rethrow the exception to fail the test suite
        }
    }
}
