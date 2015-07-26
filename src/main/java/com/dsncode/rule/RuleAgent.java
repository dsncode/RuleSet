package com.dsncode.rule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RuleAgent {

	Set<RuleBean> rules = new LinkedHashSet<RuleBean>();
	Set<RuleGroup> rules_group = new LinkedHashSet<RuleGroup>();
	
	public void addRule(RuleBean rule)
	{
		rules.add(rule);
	}
	
	public void addRuleGroup(RuleGroup rule_group)
	{
		rules_group.add(rule_group);
	}
	
	private static String getRule(Set<RuleBean> dictionary)
	{
		StringBuilder rule = new StringBuilder();
		rule.append("(?i)");
		boolean first = true;
		for(RuleBean word : dictionary)
		{
			String word_rule = createWordRule(word.getKeyword());
			if(first==false)
			{
				rule.append("|");
				rule.append(word_rule);
			}
			if(first)
			{
				rule.append(word_rule);
				first = false;
			}
		}
		return rule.toString();
	}
	
	private static String createWordRule(String word)
	{
		String rule = null;
		
		if(word==null || word.isEmpty())
			return "";
		
		char[]word_char = word.toCharArray();
		boolean isFullWordMatchRequired=true;
		int x = 0;
		for(x=0;x<word_char.length;x++)
		{
			if((Character.UnicodeBlock.of(word_char[x])) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS)
			{
				isFullWordMatchRequired = false;
			}
		}
		
		if(word.contains("$"))
		{
			word = word.replaceAll("\\$", "\\\\\\$");
			rule = "("+word+")";
			return rule;
		}
		
		
		if(isFullWordMatchRequired)
		{
			rule = "(\\b"+word+"\\b)";
		}
		else
		{
			rule = "("+word+")";
		}
		
		return rule;
	}
	
	public String generateFullQuery()
	{
		StringBuilder sb = new StringBuilder();
		
		int limit = this.rules.size();
		
		while(limit>1)
		{
			List<RuleBean> list = new ArrayList<>(this.rules);
			Set<RuleBean> subSet = new LinkedHashSet<>(list.subList(0, limit));
			sb.append(generateQuery(subSet));
			sb.append(" OR ");
			limit--;
		}
		
		
		return sb.toString();
	}
	
	public static String generateQuery(Set<RuleBean> rules)
	{
		StringBuilder sb = new StringBuilder();

		int x =0;
		boolean first=true;
		for(RuleBean b : rules)
		{
			if(first)
			{
				sb.append("(\""+b.getKeyword()+"\" ");
				first=false;
			}
			else
			{
				sb.append("AND \""+b.getKeyword()+"\" ");
			}
		}
		sb.append(")");
		return sb.toString();
	}
	
	
	public boolean eval(String content)
	{
		boolean ans = false;
		
		
		
		
		return ans;
	}
	
}
