package com.cmserver.ar;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Process {

	public static Writer readDefects(BufferedReader reader) {
		String lineF = null;
		ArrayList<Defects> defectsList = new ArrayList<Defects>();
		Defects def = new Defects();
		try {
			while ((lineF = reader.readLine()) != null) {

				
				if ((lineF.indexOf("Caused by") != -1) && (lineF.indexOf("(") != -1) && (lineF.indexOf(")") != -1)) {
					int index = lineF.indexOf("-");
					int index1 = lineF.indexOf("(");
					int index2 = lineF.indexOf(")");
					if (index1 < index && index2 > index) {

						def.setCode(lineF.substring(index + 1, index2));
						if (lineF.charAt(index - 1) != '1')
							def.setApp((lineF.substring(index1 + 1, index - 1) + " Cus"));
						else
							def.setApp((lineF.substring(index1 + 1, index - 1) + " Core"));

						int x = lineF.charAt(index2 - 1);

						if (x >= 49 && x <= 51)// x>=1&&x<=3(asci)
							def.setSeverity("critical");
						else if (x >= 52 && x <= 54)
							def.setSeverity("error");
						else
							def.setSeverity("warning");
						defectsList.add(def);

					}

				}
			}

			Writer write = new Writer(defectsList);
			return write;
		} catch (IOException e1) {
			System.out.println("Error read file!");
			System.exit(1);
		}
		return null;
	}
}
