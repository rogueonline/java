package com.tutorial.soa.core.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Checksum {
	/**
	 * @param algorithm to use for hash
	 * @param input byte array to be hashed
	 * 
	 * @return String hex value of hash
	 * 
	 * @throws HashException
	 */
	public static synchronized String digest(Algorithm algorithm, byte[] input) throws HashException {
		StringBuffer hexString = new StringBuffer();
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm.value());
			messageDigest.reset();
			
			byte digestBytes[] = messageDigest.digest(input);
			
			// Convert to hex
			for (int i = 0; i < digestBytes.length; i++) {
				String hex = Integer.toHexString(0xFF & digestBytes[i]);
				
				if (hex.length() == 1) {
					hexString.append("0");
				}
				
				hexString.append(hex);
			}
		}
		catch (NoSuchAlgorithmException nsae) {
			throw new HashException(nsae.getMessage());
		}
		
		return hexString.toString();
	}
	
	public enum Algorithm {
		MD5("MD5"),
		SHA_1("SHA-1"),
		SHA_256("SHA-256"),
		SHA_512("SHA-512");
		
		private String value;
		
		private Algorithm(String value) {
			this.value = value;
		}
		
		public String value() {
			return value;
		}
	}
}
