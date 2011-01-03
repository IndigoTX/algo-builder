import java.util.HashMap;
import java.util.Map;

import test.Test;
import test.io.SimpleInputSource;
import test.placement.PlacementAlgo;

/*******************************************************************
 *
 * Copyright (c) 2010 DClear Utilities. All rights reserved. 
 *
 * File:	Main.java
 * Author:	prajapati
 * Date:	Dec 30, 2010
 *
 *******************************************************************
 */

/**
 *
 */
public class Main {

	private static Map<String, Test> testRegistery = new HashMap<String, Test>(); 
	
	static {
		testRegistery.put("placement", new PlacementAlgo());
	}
	
	public static void main(String[] args) throws Exception {
		if(args.length < 1) {
			System.out.println("Usage : java -jar AlgoBuilder.jar <algo name>");
			return ;
		}
		String testName = args[0];
		if(testName == null) {
			System.out.println("Alorithm name is invalid or not yet supported.");
			return ;
		}
		Test test = testRegistery.get(testName);
		test.readInput(new SimpleInputSource());
		test.execute();
	}
}
