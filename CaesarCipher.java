package com.tutorial.soa.core.crypto;

public class CaesarCipher {
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	/**
	 * @param string to encrypt
	 * @param offset amount to shift alphabet
	 * 
	 * @return
	 * 
	 * @throws IllegalArgumentException
	 */
	public static String encrypt(String string, int offset) throws IllegalArgumentException {
		if ((offset < 0) || (offset > 25)) {
			throw new IllegalArgumentException("Offset must be between 0-25");
		}
		
		StringBuilder stringBuilder = new StringBuilder("");
		
		for (int i = 0; i < string.length(); i++) {
			char currentChar = string.charAt(i);
			
			if (currentChar != ' ') {
				int currentOffset = alphabet.indexOf(Character.toLowerCase(currentChar)) - offset;
				
				if (currentOffset < 0) {
					currentOffset += alphabet.length();
				}
				
				if (!Character.isUpperCase(currentChar)) {
					currentChar = alphabet.charAt(currentOffset);
				}
				else {
					currentChar = Character.toUpperCase(alphabet.charAt(currentOffset));
				}
			}
			
			stringBuilder.append(currentChar);
		}
		
		return stringBuilder.toString();
	}
	
	/**
	 * @param string to decrypt
	 * @param offset amount to shift alphabet
	 * 
	 * @return
	 * 
	 * @throws IllegalArgumentException
	 */
	public static String decrypt(String string, int offset) throws IllegalArgumentException {
		if ((offset < 0) || (offset > 25)) {
			throw new IllegalArgumentException("Offset must be between 0-25");
		}
		
		StringBuilder stringBuilder = new StringBuilder("");
		
		for (int i = 0; i < string.length(); i++) {
			char currentChar = string.charAt(i);
			
			if (currentChar != ' ') {
				int currentOffset = alphabet.indexOf(Character.toLowerCase(currentChar)) + offset;
				
				if (currentOffset >= alphabet.length()) {
					currentOffset -= alphabet.length();
				}
				
				if (!Character.isUpperCase(currentChar)) {
					currentChar = alphabet.charAt(currentOffset);
				}
				else {
					currentChar = Character.toUpperCase(alphabet.charAt(currentOffset));
				}
			}
			
			stringBuilder.append(currentChar);
		}
		
		return stringBuilder.toString();
	}
}
