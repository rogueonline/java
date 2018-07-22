package com.tutorial.soa.core.crypto;

public class VigenereCipher {
	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * @param string to encrypt
	 * @param key
	 * 
	 * @return
	 */
	public static synchronized String encrypt(String string, String key) {
		StringBuilder stringBuilder = new StringBuilder("");

		string = string.replaceAll(" ", "").toUpperCase();
		key = key.replaceAll(" ", "").toUpperCase();

		int j = 0;
		for (int i = 0; i < string.length(); i++) {
			int stringIndex = alphabet.indexOf(string.charAt(i));
			int keyIndex = alphabet.indexOf(key.charAt(j));
			int offset = stringIndex + keyIndex;

			if (offset >= alphabet.length()) {
				offset -= alphabet.length();
			}

			// Add space every 5th character
			if ((i % 5) == 0) {
				stringBuilder.append(" ");
			}

			stringBuilder.append(alphabet.charAt(offset));
			j++;

			if (j >= key.length()) {
				j = 0;
			}
		}

		// Remove 1st leading space
		stringBuilder.delete(0, 1);

		return stringBuilder.toString();
	}
	
	/**
	 * @param string to decrypt
	 * @param key
	 * 
	 * @return
	 */
	public static synchronized String decrypt(String string, String key) {
		StringBuilder stringBuilder = new StringBuilder("");

		string = string.replaceAll(" ", "").toUpperCase();
		key = key.replaceAll(" ", "").toUpperCase();

		int j = 0;
		for (int i = 0; i < string.length(); i++) {
			int stringIndex = alphabet.indexOf(string.charAt(i));
			int keyIndex = alphabet.indexOf(key.charAt(j));
			int offset = stringIndex - keyIndex;

			if (offset < 0) {
				offset += alphabet.length();
			}

			// Add space every 5th character
			if ((i % 5) == 0) {
				stringBuilder.append(" ");
			}

			stringBuilder.append(alphabet.charAt(offset));
			j++;

			if (j >= key.length()) {
				j = 0;
			}
		}

		// Remove 1st leading space
		stringBuilder.delete(0, 1);

		return stringBuilder.toString();
	}
}
