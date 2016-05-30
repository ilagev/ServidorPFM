package data.entities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;

public class Encrypt {

    public static final String SHA1 = "SHA-1";

    private String algorithm;

    public Encrypt(String algorithm) {
        this.algorithm = algorithm;
    }

    public Encrypt() {
        this(SHA1);
    }

    public byte[] encrypt(String message) {
        byte[] digest = null;
        byte[] buffer = message.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException nsae) {
            LogManager.getLogger(this.getClass()).error("Error: " + nsae);
        }
        return digest;
    }

    public String encryptInBase64UrlSafe(String message) {
        byte[] digest = this.encrypt(message);
        String code64Url = Base64.getUrlEncoder().encodeToString(digest);
        return code64Url.substring(0, code64Url.indexOf("="));
    }

}
