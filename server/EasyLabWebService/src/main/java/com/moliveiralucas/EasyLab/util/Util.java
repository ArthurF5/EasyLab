package com.moliveiralucas.EasyLab.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class Util {
	public static String toSHA1(String password) {
		MessageDigest mMessageDigest = null;
		try {
			mMessageDigest = MessageDigest.getInstance("SHA-1");
			mMessageDigest.reset();
			mMessageDigest.update(password.getBytes("UTF-8"));
			password = byteToHex(mMessageDigest.digest());
		}catch(NoSuchAlgorithmException nsae) {
			System.out.println(""+nsae.getMessage()+"\n");
			nsae.printStackTrace();
		}catch(UnsupportedEncodingException uee) {
			System.out.println(""+uee.getMessage()+"\n");
			uee.printStackTrace();
		}
		return password;
	}
	
	public static String byteToHex(final byte[] hash) {
		Formatter mFormatter = new Formatter();
		for(byte b : hash) {
			mFormatter.format("%02x", b);
		}
		String result = mFormatter.toString();
		mFormatter.close();
		return result;
	}
}
