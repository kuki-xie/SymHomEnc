package com.github.SymHomEnc;

import java.math.BigInteger;

public class main {
    public static void main(String[] args) {
        // Using the SecureRandom class as the default random number generator
        SHEParameters param = new SHEParameters(SHEParameters.K0, SHEParameters.K1, SHEParameters.K2);
        SHEPrivateKey sk = param.getSHEPrivateKey();
        SHEPublicKey pk = param.getSHEPublicKey();
        SHEPublicParameter pb = param.getSHEPublicParameter();


        // 测量加密时间
        long encStartTime = System.nanoTime();

        BigInteger message = BigInteger.valueOf(2).pow(29);
        // Encryption with private key
        SHECipher a = SymHomEnc.enc(message, sk);

        long encEndTime = System.nanoTime();
        long encDuration = encEndTime - encStartTime;

        System.out.println("加密时间(nanoseconds): " + encDuration);

        System.out.println("密文a:" + a);


        // Encryption with public key
        SHECipher b = SymHomEnc.enc(123456789, pk);

        // 测量加密时间
        long decStartTime = System.nanoTime();

        // Decryption with private key
        BigInteger c = SymHomEnc.dec(a, sk);


        System.out.println("解密后的明文c:" + c);

        long decEndTime = System.nanoTime();
        long decDuration = encEndTime - encStartTime;

        System.out.println("解密时间(nanoseconds): " + encDuration);
    }
}
