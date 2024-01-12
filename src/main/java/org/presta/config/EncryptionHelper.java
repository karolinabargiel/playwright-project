package org.presta.config;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

@Slf4j
public class EncryptionHelper {

    private static final String UNICODE_FORMAT = "UTF-8";

    public static String runEncryption(String text) {
        try {
            SecretKey key = generateKey("AES");
            Cipher cipher = Cipher.getInstance("AES");
            byte[] encryptedData = encryptString(text, key, cipher);
            String encryptedString = new String(encryptedData);
            System.out.println(encryptedString);
            String decrypted = decryptString(encryptedData, key, cipher);
            System.out.println(decrypted);
            return decrypted;

        } catch(Exception e) {
            log.info("Encryption failed");
            return null;
        }
    }

    public static String runDecryption(String encryptedData) {
        try {
            SecretKey key = generateKey("AES");
            Cipher cipher = Cipher.getInstance("AES");
            String decrypted = decryptString(encryptedData.getBytes(), key, cipher);
            System.out.println(decrypted);
            return decrypted;
        } catch (Exception e) {
            log.info("Decryption failed");
            return null;
        }
    }

    public static SecretKey generateKey(String encryptionType) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(encryptionType);
            return keyGenerator.generateKey();
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] encryptString(String dataToEncrypt, SecretKey myKey, Cipher cipher) {
        try {
            byte[] text = dataToEncrypt.getBytes(UNICODE_FORMAT);
            cipher.init(Cipher.ENCRYPT_MODE, myKey);
            return cipher.doFinal(text);

        } catch(Exception e) {
            return null;
        }
    }

    public static String decryptString(byte[] dataToDecrypt, SecretKey myKey, Cipher cipher) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, myKey);
            byte[] textDecrypted = cipher.doFinal(dataToDecrypt);
            return new String(textDecrypted);

        } catch(Exception e) {
            return null;
        }
    }
}
