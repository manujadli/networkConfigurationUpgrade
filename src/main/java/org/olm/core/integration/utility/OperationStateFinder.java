package org.olm.core.integration.utility;

import java.util.Random;

public class OperationStateFinder {
	
	public static int getOperationState(int factor) {
		Random random = new Random();
		int rand = 0;
		while (true){
		    rand = random.nextInt(factor+1);
		    if(rand !=0) break;
		}
		return rand;
	}
}
