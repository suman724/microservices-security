package com.graabity.microservices.templates.security;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

@Component
public class JwtPrivateKeyProvider {

    //TODO - Remove harcoding later
    public Key getSigningKey() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        ClassPathResource resource = new ClassPathResource("keystore.jks");
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(resource.getInputStream(), "jkspassword".toCharArray());
        Key key = keystore.getKey("jwtkey", "keypassword".toCharArray());

        return key;
    }
}
