package com.dsncode.rule;

public class RuleBean {

	private String keyword;
	private boolean required;
	
	public RuleBean()
	{
		
	}
	
	public RuleBean(String keyword, boolean required)
	{
		this.keyword=keyword;
		this.required=required;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	
	
}
