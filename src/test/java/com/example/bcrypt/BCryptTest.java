package com.example.bcrypt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

import com.example.Util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class BCryptTest {
	
	@Test
	void simpleTest() throws Exception {
		String password = "1234567890123456789012345678901234567890123456789012345678901234567890";
		long now = System.currentTimeMillis();
		String bcryptHashString = BCrypt.with(BCrypt.Version.VERSION_2A).hashToString(8, password.toCharArray());
		System.out.println("time: " + (System.currentTimeMillis() - now) + "ms");
		System.out.println(bcryptHashString);
		now = System.currentTimeMillis();
		BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
		System.out.println("time: " + (System.currentTimeMillis() - now) + "ms");
		assertTrue(result.verified);
	}
	
	@Test
	void sha3_256() throws NoSuchAlgorithmException {
		String originalString = "Lorem ipsum dolor sit amet consectetur adipiscing elit torquent iaculis.";
		
		final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
		final byte[] hashbytes = digest.digest(
		  originalString.getBytes(StandardCharsets.UTF_8));
		String sha3_256hex = Util.bytesToHex(hashbytes);		
		System.out.println(sha3_256hex);
		
		assertEquals("f3a10039c2d12f5357c5e8c60adac03f5683e7a7cd77ee2c877f1ac6eea9042b", sha3_256hex);
	}

}
