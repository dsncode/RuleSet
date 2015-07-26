package com.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexText {

	
	public static void main(String args[])
	{
		String rule ="(?=.*\\busa\\b)";
		String text1 ="japan and usa sign a iot cooperation";
		String text2 = "japan and chile are good countries";
		
		Pattern p = Pattern.compile(rule);
		Matcher m1 = p.matcher(text1);
		Matcher m2 = p.matcher(text2);
		
		System.out.println(m1.find());
		System.out.println(m2.find());
		
	}
	
}
