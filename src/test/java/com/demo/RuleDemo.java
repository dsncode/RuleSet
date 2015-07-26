package com.demo;

import com.dsncode.rule.RuleAgent;
import com.dsncode.rule.RuleBean;

public class RuleDemo {

	public static void main(String[] args) {

		RuleAgent ra = new RuleAgent();
		
		ra.addRule(new RuleBean("usa",true));
		ra.addRule(new RuleBean("japan",true));
		ra.addRule(new RuleBean("iot",true));
		ra.addRule(new RuleBean("war",true));
		
		System.out.println(ra.generateFullQuery());
		
	}

}
