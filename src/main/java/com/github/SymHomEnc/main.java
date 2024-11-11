package com.github.SymHomEnc;

import java.math.BigInteger;

public class main {
    public static void main(String[] args) {
        // Using the SecureRandom class as the default random number generator
        SHEParameters param = new SHEParameters(SHEParameters.K0, SHEParameters.K1, SHEParameters.K2);
        SHEPrivateKey sk = param.getSHEPrivateKey();
        SHEPublicKey pk = param.getSHEPublicKey();
        SHEPublicParameter pb = param.getSHEPublicParameter();

        // Encryption with private key
        SHECipher a = SymHomEnc.enc(123456, sk);
        // Encryption with public key
        SHECipher b = SymHomEnc.enc(123456, pk);
        // Decryption with private key
        BigInteger c = SymHomEnc.dec(a, sk);

        System.out.println("密文a:" + a);

        System.out.println("解密后的明文c:" + c);
    }
}
