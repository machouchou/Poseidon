package com.nnk.springboot.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordConfig {
	
	/*
	 private static PasswordConfig INSTANCE = new PasswordConfig();
	  private static String pattern = null;
	 
	 
	  
	   * Force the user to build a validator using this way only
	   * 
	  public PasswordConfig buildValidator( boolean forceSpecialChar,
	                          boolean forceCapitalLetter,
	                          boolean forceNumber,
	                          int minLength,
	                          int maxLength)
	  {
	    StringBuilder patternBuilder = new StringBuilder("((?=.*[a-z])");
	 
	    if (forceSpecialChar)
	    {
	      patternBuilder.append("(?=.*[@#$%])");
	    }
	 
	    if (forceCapitalLetter)
	    {
	      patternBuilder.append("(?=.*[A-Z])");
	    }
	 
	    if (forceNumber)
	    {
	      patternBuilder.append("(?=.*d)");
	    }
	 
	    patternBuilder.append(".{" + minLength + "," + maxLength + "})");
	    pattern = patternBuilder.toString();
	 
	    return INSTANCE;
	  }
	 
	  */
	  /**
	   * Here we will validate the password
	   * */
	  public boolean validatePassword(final String password)
	  {
		  String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&./])[A-Za-z0-9@$!%*?&./]{8,12}$";
	    Pattern p = Pattern.compile(pattern);
	    Matcher m = p.matcher(password);
	    return m.matches();
	  }

}
