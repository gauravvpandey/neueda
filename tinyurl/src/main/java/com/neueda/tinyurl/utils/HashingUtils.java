package com.neueda.tinyurl.utils;

import java.nio.charset.Charset;

import com.google.common.hash.Hashing;

public class HashingUtils {
	
	public static String hashValue(String normalUrl) {
		return Hashing.murmur3_32().hashString(normalUrl, Charset.defaultCharset()).toString();
	}

}
