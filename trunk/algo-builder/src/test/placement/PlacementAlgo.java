/*******************************************************************
 *
 * Copyright (c) 2010 DClear Utilities. All rights reserved. 
 *
 * File:	PlacementAlgo.java
 * Author:	prajapati
 * Date:	Dec 30, 2010
 *
 *******************************************************************
 */

package test.placement;

import java.io.IOException;

import test.Test;
import test.io.SimpleInputSource;

/**
 *
 */
public class PlacementAlgo implements Test {

	private int[][] matrics;
	private int[][] gadgets;

	/* (non-Javadoc)
	 * @see test.Test#execute(java.lang.String[])
	 */
	@Override
	public int execute() throws Exception {
		
		return 0;
	}

	public void readInput(SimpleInputSource sin) throws IOException {
		System.out.print("Enter number of columns: ");
		int cols = sin.readInt();
		System.out.print("Enter number of rows: ");
		int rows = sin.readInt();
		matrics = new int[rows][cols];
		System.out.print("Enter number of gadgets: ");
		int numberOfGadgets = sin.readInt();
		gadgets = new int[numberOfGadgets][3];
		for(int i = 0; i < numberOfGadgets; ++i) {
			System.out.print("Enter gadget details: (id, height, width)");
			gadgets[i][0] = sin.readInt(); // id
			gadgets[i][1] = sin.readInt(); // height
			gadgets[i][2] = sin.readInt(); // width
		}
	}

}
