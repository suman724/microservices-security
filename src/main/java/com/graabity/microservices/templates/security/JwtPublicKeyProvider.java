package com.graabity.microservices.templates.security;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

@Component
public class JwtPublicKeyProvider {

    private PublicKey publicKey;
    private static String PUBLIC_KEY_FILE_NAME = "cert.der";
    private static String CERT_TYPE = "X.509";

    //TODO - Remove harcoding later
    public JwtPublicKeyProvider() throws Exception{
        ClassPathResource resource = new ClassPathResource(PUBLIC_KEY_FILE_NAME);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        Certificate cert = cf.generateCertificate(resource.getInputStream());
        publicKey = cert.getPublicKey();

    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
}
