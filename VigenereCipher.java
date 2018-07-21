package com.tutorial.soa.core.crypto;

public class VigenereCipher {
	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * @param string to encrypt
	 * @param password
	 * 
	 * @return
	 */
	public static synchronized String encrypt(String string, String password) {
		StringBuilder stringBuilder = new StringBuilder("");

		string = string.replaceAll(" ", "").toUpperCase();
		password = password.replaceAll(" ", "").toUpperCase();

		int j = 0;
		for (int i = 0; i < string.length(); i++) {
			int stringIndex = alphabet.indexOf(string.charAt(i));
			int passwordIndex = alphabet.indexOf(password.charAt(j));
			int offset = stringIndex + passwordIndex;

			if (offset >= alphabet.length()) {
				offset -= alphabet.length();
			}

			// Add space every 5th character
			if ((i % 5) == 0) {
				stringBuilder.append(" ");
			}

			stringBuilder.append(alphabet.charAt(offset));
			j++;

			if (j >= password.length()) {
				j = 0;
			}
		}

		// Remove 1st leading space
		stringBuilder.delete(0, 1);

		return stringBuilder.toString();
	}
	
	/**
	 * @param string to decrypt
	 * @param password
	 * 
	 * @return
	 */
	public static synchronized String decrypt(String string, String password) {
		StringBuilder stringBuilder = new StringBuilder("");

		string = string.replaceAll(" ", "").toUpperCase();
		password = password.replaceAll(" ", "").toUpperCase();

		int j = 0;
		for (int i = 0; i < string.length(); i++) {
			int stringIndex = alphabet.indexOf(string.charAt(i));
			int passwordIndex = alphabet.indexOf(password.charAt(j));
			int offset = stringIndex - passwordIndex;

			if (offset < 0) {
				offset += alphabet.length();
			}

			// Add space every 5th character
			if ((i % 5) == 0) {
				stringBuilder.append(" ");
			}

			stringBuilder.append(alphabet.charAt(offset));
			j++;

			if (j >= password.length()) {
				j = 0;
			}
		}

		// Remove 1st leading space
		stringBuilder.delete(0, 1);

		return stringBuilder.toString();
	}
}
