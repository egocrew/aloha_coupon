package com.aloha_coupon.commons.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptedPropertyGenerator {
  public static void main(String[] args) {
    StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
    standardPBEStringEncryptor.setPassword("Password");
    standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");

    String cipherText =
        standardPBEStringEncryptor.encrypt("cipher");
    String plainText = standardPBEStringEncryptor.decrypt(cipherText);

    System.out.println("CipherText : " + cipherText);
    System.out.println("PlainText : " + plainText);
  }
}
