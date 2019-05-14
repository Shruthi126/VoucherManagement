package com.ecommerce.voucher.util;
 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureUtility {
	
	private SecureUtility() {}
	
	public static char[]  hashPassword(char[] passwordToHash,String salt) throws NoSuchAlgorithmException {
		
		//TODO SHA make it configurable
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(salt.getBytes());
		
		byte[] hashedPassword = md.digest(passwordToHash.toString().getBytes(StandardCharsets.UTF_8));
		
		StringBuilder sb = null; 
        sb=new StringBuilder();
        for (int i = 0; i < hashedPassword.length; i++) {
            sb.append(Integer.toString((hashedPassword[i] & 0xff) + 0x100, 16).substring(1));
        }
        
		return sb.toString().toCharArray();
	}

	public static String getSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return salt.toString();
	}
}
