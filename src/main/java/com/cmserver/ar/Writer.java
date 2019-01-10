package com.cmserver.ar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.example.Defects.DefectsApplication;

public class Writer {
	ArrayList defectsList;

	public ArrayList getDefectsList() {
		return defectsList;
	}

	public void setDefectsList(ArrayList defectsList) {
		this.defectsList = defectsList;
	}

	public Writer() {

	}

	public Writer(ArrayList defectsList) {

		// DefectsApplication d=new DefectsApplication(defectsList);

		if (defectsList.isEmpty())
			System.out.println("NO Defects");
		else {
			System.out.println("Some DEFECTS Founded:");
			for (int j = 0; j < defectsList.size(); j++) {
				System.out.println("Def App:" + ((Defects) defectsList.get(j)).getApp() + "---Def Code:"
						+ ((Defects) defectsList.get(j)).getCode() + "---Severity:"
						+ ((Defects) defectsList.get(j)).getSeverity());

			}
			Map<String, Integer> duplicates = new HashMap<String, Integer>();
			for (int i = 0; i < defectsList.size(); i++) {
				String str = ((Defects) defectsList.get(i)).getApp();
				if (duplicates.containsKey(str)) {
					duplicates.put(str, duplicates.get(str) + 1);
				} else {
					duplicates.put(str, 1);
				}
			}

			for (Map.Entry<String, Integer> entry : duplicates.entrySet()) {
				System.out.println(entry.getKey() + ":Def Num = " + entry.getValue());
			}
		}
		this.setDefectsList(defectsList);

	}
}
