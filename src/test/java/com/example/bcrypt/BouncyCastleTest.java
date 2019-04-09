package com.example.bcrypt;

import java.security.SecureRandom;

import org.bouncycastle.crypto.generators.BCrypt;
import org.junit.jupiter.api.Test;

import com.example.Util;

public class BouncyCastleTest {
	
	@Test
	void bcTest() throws Exception {
		String password = "123456";
		
		SecureRandom rng = new SecureRandom();
		byte[] salt = rng.generateSeed(16); // 128 bit = 16 bytes * 8 bit

		long now = System.currentTimeMillis();
		byte[] hashBytes = BCrypt.generate(password.getBytes(), salt, 10);
		System.out.println("time: " + (System.currentTimeMillis() - now) + "ms");
		
		System.out.println(Util.bytesToHex(hashBytes));
	}

}
