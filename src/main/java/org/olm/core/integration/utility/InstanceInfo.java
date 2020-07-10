package org.olm.core.integration.utility;

import java.util.Random; 
  
public class InstanceInfo{ 
  
    public static String getInstanceId() {    	
    	return String.valueOf(new Random().nextInt(10000));
    }
	
} 