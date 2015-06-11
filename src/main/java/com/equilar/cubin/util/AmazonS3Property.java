package com.equilar.cubin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public enum AmazonS3Property {
	
	PERSON_ID,
	IMAGE_PATH,
	
	
	AMAZON_ACCESS_KEY,
	AMAZON_SECRET_KEY,
	BUCKET_NAME,
	AMAZON_BASE_URL,
	AMAZON_DOMAIN,
	ENVIRONMENT
	;
	
	private String value;

	private AmazonS3Property() {
		this.value = ResourceBundle.getBundle("amazonS3").getString(this.name());
	}
	
	public String getValue(){
		return value;
	}
	
	public boolean getBoolean() {
		return Boolean.parseBoolean(value);
	}
	
	public int getIntValue() {
		return Integer.parseInt(value);
	}
	
	public Date getDateValue() {
		
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {
			date = df.parse(value);
		} catch (ParseException e) {
			//ignore
		}
		
		return date;
	}
	
	@Override
	public String toString() {
		return getValue();
	}
	

}
