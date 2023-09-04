# gwaas-demo-java

## Start up

Edit gwaas-config.properties

Config the integration properties we provided.

Or set system environment:

- GWAAS_ENDPOINT
- GWAAS_MERCHANT-ID
- GWAAS_MERCHANT-PRIVATE-KEY
- GWAAS_GWAAS-PUBLIC-KEY

If both system environment and properties are configured. We will pick system environment as priority.

## RSA Key pairs

You can use openssl command to create key pairs.

Following examples are using 2048 key length. You can also use 4096 key length to improve security level.

```bash
# generate private key
openssl genrsa 2048 > merchant-private-key.pem

# export public key from private key
openssl rsa -in merchant-private-key.pem -pubout > merchant-public-key.pem
```

If your private key starts with `-----BEGIN RSA PRIVATE KEY-----`, you should convert this key to pkcs8 format.
With following command:
```bash
openssl topk8 -pkcs8 -nocrypt -in merchant-private-key.pem -inform pem -outform pem -out merchant-private-pkcs8-key.pem
```

Also, you can use java code to generate key pairs:
```java
try {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(2048, new SecureRandom());
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    System.out.println("Public key:"+Base64.getEncoder().encode(keyPair.getPublic().getEncoded()));
    System.out.println("Private key:"+Base64.getEncoder().encode(keyPair.getPrivate().getEncoded()));
} catch (NoSuchAlgorithmException e) {
    throw new RuntimeException(e);
}
```
