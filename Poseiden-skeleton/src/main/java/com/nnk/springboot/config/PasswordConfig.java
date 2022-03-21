package com.nnk.springboot.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordConfig {
	
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
