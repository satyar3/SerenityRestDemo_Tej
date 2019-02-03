package com.studentapp.utils;

import java.util.Random;

public class TestUtils
{
	public static String randomGen()
	{
		int val;
		
		Random rand = new Random();
		val = rand.nextInt(10000);
	
		return Integer.toString(val);
	}
}
