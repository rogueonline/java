package com.tutorial.soa.core.crypto;

public class VigenereCipher {
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

	/**
	 * @param string to encrypt
	 * @param key
	 * 
	 * @return
	 */
	public String encrypt(String string, String key) {
		StringBuilder stringBuilder = new StringBuilder("");
		
		int j = 0;
		for (int i = 0; i < string.length(); i++) {
			if (j >= key.length()) {
				j = 0;
			}
			
			char currentChar = string.charAt(i);
			
			if (currentChar != ' ') {
				int index = alphabet.indexOf(Character.toLowerCase(currentChar)) + alphabet.indexOf(key.toLowerCase().charAt(j));
				
				if (index >= alphabet.length()) {
					index -= alphabet.length();
				}
				
				if (!Character.isUpperCase(currentChar)) {
					currentChar = alphabet.charAt(index);
				}
				else {
					currentChar = Character.toUpperCase(alphabet.charAt(index));
				}
				
				j++;
			}
			
			stringBuilder.append(currentChar);
		}
		
		return stringBuilder.toString();
	}
	
	/**
	 * @param string to decrypt
	 * @param key
	 * 
	 * @return
	 */
	public String decrypt(String string, String key) {
		StringBuilder stringBuilder = new StringBuilder("");
		
		int j = 0;
		for (int i = 0; i < string.length(); i++) {
			if (j >= key.length()) {
				j = 0;
			}
			
			char currentChar = string.charAt(i);
			
			if (currentChar != ' ') {
				int index = alphabet.indexOf(Character.toLowerCase(currentChar)) - alphabet.indexOf(key.toLowerCase().charAt(j));
				
				if (index < 0) {
					index += alphabet.length();
				}
				
				if (!Character.isUpperCase(currentChar)) {
					currentChar = alphabet.charAt(index);
				}
				else {
					currentChar = Character.toUpperCase(alphabet.charAt(index));
				}
				
				j++;
			}
			
			stringBuilder.append(currentChar);
		}
		
		return stringBuilder.toString();
	}
}
