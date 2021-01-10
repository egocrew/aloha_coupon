package com.tickettaca.commons.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptedPropertyGenerator {
  public static void main(String[] args) {
    StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
    standardPBEStringEncryptor.setPassword("Egoist2011!");
    standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");

    String cipherText =
        standardPBEStringEncryptor.encrypt("coupon-91937-firebase-adminsdk-crafv-e3eb8629d7.json");
    String plainText = standardPBEStringEncryptor.decrypt(cipherText);

    System.out.println("CipherText : " + cipherText);
    System.out.println("PlainText : " + plainText);
  }
}
