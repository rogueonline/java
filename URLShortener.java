package com.tutorial.soa.core.util;

/**
 * Bijective Function for encoding/decoding numbers to shorten<br />
 * One-to-One relation between encoded and decoded value
 */
public class URLShortener {
	private static String characters = "abcdefghijklmnopqrstuvwxyz" +
	                                   "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
	                                   "0123456789";
	
	/**
	 * <pre>
	 * {@code
	 * EXAMPLE:  0 = a
	 *           1 = b
	 *          25 = z
	 *          52 = 0
	 *          61 = 9
	 *          9223372036854775807 (Long.MAX_VALUE) = k9viXaIfiWh
	 * }
	 * </pre>
	 * 
	 * @param number to shorten
	 * 
	 * @return encoded value<br />
	 *         if negative number is returned then number overflow
	 */
	public static synchronized String encode(long number) {
		StringBuilder encodeNumber = new StringBuilder("");
		
		while (number > 0) {
			encodeNumber.append(characters.charAt((int)(number % characters.length())));
			number /= characters.length();
		}
		
		switch (encodeNumber.toString()) {
			case "":
				if (number < 0) { // If overflow
					encodeNumber.append("1-");
				}
				else { // If 0
					encodeNumber.append(characters.charAt(0));
				}
				
				break;
		}
		
		return encodeNumber.reverse().toString();
	}
	
	/**
	 * <pre>
	 * {@code
	 * EXAMPLE: k9viXaIfiWh = 9223372036854775807 (Long.MAX_VALUE)
	 *
	 * FORMULA: e9a = [4, 61, 0] = (4 * 62^2) + (61 * 62^1) + (0 * 62^0) = 19158
	 * }
	 * </pre>
	 * 
	 * @param number to restore
	 * 
	 * @return decoded value<br />
	 *         if negative number is returned then number overflow
	 */
	public static synchronized long decode(String number) {
		long decodeNumber = 0;
		
		for (int i = 0; i < number.length(); i++) {
			decodeNumber += (long)(characters.indexOf(number.charAt(i)) * (Math.pow(characters.length(), ((number.length() - i) - 1))));
		}
		
		return decodeNumber;
	}
}
