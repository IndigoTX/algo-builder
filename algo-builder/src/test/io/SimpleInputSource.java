/*******************************************************************
 *
 * Copyright (c) 2010 DClear Utilities. All rights reserved. 
 *
 * File:	SimpleInputSource.java
 * Author:	prajapati
 * Date:	Dec 30, 2010
 *
 *******************************************************************
 */

package test.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 *
 */
public class SimpleInputSource {

	
	private static final int BUFFER_SIZE = 32767;
	
	private BufferedInputStream inputStream;
	
	private String buffer = "";
	
	private int position;
	
	private int length;
	
	public SimpleInputSource() {
		inputStream = new BufferedInputStream(System.in);
	}
	
	public SimpleInputSource(String str) {
		inputStream = new BufferedInputStream(new ByteArrayInputStream(str.getBytes()));
	}
	
	public String readWord() throws IOException {
		skipWhiteSpaces();
		readLine();
		StringBuilder sb = new StringBuilder();
		int startPosition = position;
		while(position < length && !isWhiteSpace(buffer.charAt(position))) {
			position++;
		}
		if(startPosition < position) {
			sb.append(buffer.substring(startPosition, position));
		} else {
			sb.append(readWord());
		}
		return sb.toString();
	}

	public void skipWhiteSpaces() throws IOException {
		readLine();
		while(position < length && isWhiteSpace(buffer.charAt(position))) {
			position++;
		}
	}

	private boolean isWhiteSpace(char c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t';
	}
	
	public boolean eof() throws IOException {
		return position >= length && length == -1;
	}
	
	private void readLine() throws IOException {
		if(position >= length) {
			byte[] buff = new byte[BUFFER_SIZE];
			length = inputStream.read(buff, 0, BUFFER_SIZE);
			buffer = new String(buff, 0, length);
			buffer.trim();
			length = buffer.length();
			position = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		SimpleInputSource sin = new SimpleInputSource();
		int count = 5;
		System.out.print("Please enter " + count + " words : ");
		String words[] = new String[5];
		for(int i = 0; i < count; ++i) {
			words[i] = sin.readWord();
		}
		System.out.println("Read word are: ");
		for(String word : words) {
			System.out.print("[" + word + "]");
		}
	}

	public int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(readWord());
	}
}
