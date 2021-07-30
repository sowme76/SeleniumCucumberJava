package utilities;

import java.util.Base64;

public class EncodeAndDecodeString {
	
	public static void main(String[] args) {
		// encode string
		String originalInput = "G3912812N";
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		
		System.out.print(encodedString);
	}
	
	public String decodeString(String encodedString) {
		
		// decode string
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes);
		return decodedString;
		
	}
	
}
