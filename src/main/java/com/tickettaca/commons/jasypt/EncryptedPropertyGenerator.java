package com.tickettaca.commons.jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptedPropertyGenerator {
  public static void main(String[] args) {
    StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
    standardPBEStringEncryptor.setPassword("");
    standardPBEStringEncryptor.setAlgorithm("PBEWithMD5AndDES");

    String cipherText =
        standardPBEStringEncryptor.encrypt("");
    String plainText = standardPBEStringEncryptor.decrypt("");

    System.out.println("CipherText : " + cipherText);
    System.out.println("PlainText : " + plainText);
  }
}
