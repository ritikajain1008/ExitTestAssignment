package com.redbus.utils;

import org.testng.SkipException;

public class CommonUtils {
	
	 public static void CheckExecutionRequired(String executionRequired) {
	        
	        // if execution required field is N o
	        if(executionRequired.equals("NO")) {
	            throw new SkipException("Execution is not Required");
	        }
	        
	        // if execution required field is empty
	        if(executionRequired.equals("")) {
                 throw new SkipException("Execution is not Required");
	        }
	    }

}
