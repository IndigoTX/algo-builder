/*******************************************************************
 *
 * Copyright (c) 2010 DClear Utilities. All rights reserved. 
 *
 * File:	Test.java
 * Author:	prajapati
 * Date:	Dec 30, 2010
 *
 *******************************************************************
 */

package test;

import java.io.IOException;

import test.io.SimpleInputSource;

/**
 *
 */
public interface Test {

	/**
	 * This method will be called before execute(). 
	 * @throws IOException 
	 */
	void readInput(SimpleInputSource sin) throws IOException;
	
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	int execute() throws Exception;
}
