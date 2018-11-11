package com.graabity.microservices.templates.security;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

@Component
public class JwtPrivateKeyProvider {
    private Key privateKey;

    //TODO - Remove hardcoding later
    public JwtPrivateKeyProvider()throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException{
        ClassPathResource resource = new ClassPathResource("keystore.jks");
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(resource.getInputStream(), "jkspassword".toCharArray());
        this.privateKey = keystore.getKey("jwtkey", "keypassword".toCharArray());

    }

    public Key getPrivateKey() {
        return privateKey;
    }

}
