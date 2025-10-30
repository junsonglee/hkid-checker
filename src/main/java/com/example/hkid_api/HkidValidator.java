package com.example.hkid_api;

public class HkidValidator {

	public static boolean isValid(String hkid) {
		if (hkid == null) {
			return false;
		}

		hkid = hkid.trim().toUpperCase();

		if (!hkid.matches("^[A-Z]{1,2}[0-9]{6}\\([0-9A]\\)$")) {
			return false;
		}

		String core = hkid.substring(0, hkid.indexOf('('));
		char checkChar = hkid.charAt(hkid.length() - 2);

		int weight = 9;
		int sum = 0;
		int letters = Character.isLetter(core.charAt(1)) ? 2 : 1;

		if (letters == 1) {
			sum += 36 * weight--;
		}

		for (int i = 0; i < letters; i++) {
			sum += (core.charAt(i) - 'A' + 10) * weight--;
		}

		for (int i = letters; i < core.length(); i++) {
			sum += (core.charAt(i) - '0') * weight--;
		}

		int remainder = sum % 11;
		int checkValue = (remainder == 0) ? 0 : (11 - remainder);
		char expectedCheck = (checkValue == 10) ? 'A' : (char) ('0' + checkValue);

		return expectedCheck == checkChar;
	}

}
