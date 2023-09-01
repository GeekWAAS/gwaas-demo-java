package com.geekwaas.core.security;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RSA2Signature {
    public static String sign(String content, String privateKey) {
        try {
            PrivateKey priKey = resolvePrivate(privateKey);
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initSign(priKey);
            signature.update(content.getBytes(StandardCharsets.UTF_8));
            byte[] signed = signature.sign();
            return Base64.getEncoder().encodeToString(signed);
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            //shall never happen
            throw new RuntimeException(e);
        }
    }

    public static boolean verify(String content, String publicKey, String signatureBase64){
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);

        try {
            PublicKey pubKey = resolvePublic(publicKey);
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(pubKey);
            signature.update(content.getBytes(StandardCharsets.UTF_8));
            return signature.verify(signatureBytes);
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            //shall never happen
            throw new RuntimeException(e);
        }
    }

    private static byte[] resolveKey(String keyString) {
        String concatedKeyString = keyString.lines().filter(Predicate.not(line -> line == null || line.isBlank() || line.startsWith("---")))
                .collect(Collectors.joining());
        return Base64.getDecoder().decode(concatedKeyString);
    }

    public static PrivateKey resolvePrivate(String privateKey) {
        byte[] bytes = resolveKey(privateKey);
        PKCS8EncodedKeySpec pkcs8 = new PKCS8EncodedKeySpec(bytes);
        try {
            KeyFactory factory = KeyFactory.getInstance("RSA");
            return factory.generatePrivate(pkcs8);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public static PublicKey resolvePublic(String publicKey) {
        byte[] bytes = resolveKey(publicKey);
        KeySpec x509 = new X509EncodedKeySpec(bytes);
        return resolvePublicKey(x509);
    }

    private static PublicKey resolvePublicKey(KeySpec keySpec) {
        try {
            KeyFactory factory = KeyFactory.getInstance("RSA");
            return factory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
