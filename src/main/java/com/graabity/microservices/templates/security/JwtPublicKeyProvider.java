package com.graabity.microservices.templates.security;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.Key;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

@Component
public class JwtPublicKeyProvider {


    //TODO - Remove harcoding later
    public Key getSigningPublicKey() throws CertificateException, IOException {
        ClassPathResource resource = new ClassPathResource("cert.der");
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        Certificate cert = cf.generateCertificate(resource.getInputStream());
        PublicKey publicKey = cert.getPublicKey();
        return publicKey;
    }
}
