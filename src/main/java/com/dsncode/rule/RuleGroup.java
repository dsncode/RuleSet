package com.dsncode.rule;

import java.util.HashMap;
import java.util.Map;

public class RuleGroup {
	
	private Map<String,RuleBean> rules = new HashMap<String,RuleBean>();
	private boolean isRequired=false;
	
	
	public void setRequired(boolean isRequired)
	{
		this.isRequired=isRequired;
	}
	
	public void addRule(RuleBean rule)
	{
		rules.put(rule.getKeyword(), rule);
	}

}
