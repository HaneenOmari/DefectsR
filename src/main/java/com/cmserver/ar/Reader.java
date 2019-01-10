package com.cmserver.ar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Reader {
	private static BufferedReader reader = null;

	public Reader() {
		
	}

	public static Writer extracted(String filename) {
		try {
			FileReader fileReader = new FileReader(filename);
			reader = new BufferedReader(fileReader);
			return Process.readDefects(reader);
		} catch (FileNotFoundException e) {
			System.out.println("Error find file!");
		}
		return null;
	}

}
