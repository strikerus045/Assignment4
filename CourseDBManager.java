
/**
 * 
 * @author Chris D
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class CourseDBManager implements CourseDBManagerInterface {
	
	public CourseDBStructure keyInput = new CourseDBStructure(15);

	public void add(String courseID, int crn, int numCredits, String roomNumber, String teacherName) {
		
		CourseDBElement lcd1 = new CourseDBElement(courseID, crn, numCredits, roomNumber, teacherName);
		
		keyInput.add(lcd1);
	}


	public void readFile(File key) throws FileNotFoundException {
		
		Scanner file = new Scanner(key);
		
		while(file.hasNextLine()) {
			
			String row =  file.nextLine();
			String[] linkedArray = row.split("  ");
			String courseID = linkedArray[0];
			int crn = Integer.valueOf(linkedArray[1]);
			int numCredits = Integer.valueOf(linkedArray[2]);
			String roomNumber = linkedArray[3];
			String teacherName = null;
			
			for(int i = 3; i < linkedArray.length; i++) {
				
				teacherName += linkedArray[i];
			}
			
			this.add(courseID, crn, numCredits, roomNumber, teacherName);
		}
		
	}

	public ArrayList<String> presentAll() {

		ArrayList<String> all = new ArrayList<String>();
		
		for(int i = 0; i < keyInput.getTableSize(); i++) {
			
			if(keyInput.hashTable[i] != null) {
				
				for(int n = 0; n < keyInput.hashTable[i].size(); n++) {
					
					all.add(keyInput.hashTable[i].get(n).toString());
				}
			}
		}
		
		return all;
		
	}

	public CourseDBElement get(int crn) {
		
		try {
			
			return keyInput.get(crn);	
		}
		
		catch(Exception v) {
			
			v.printStackTrace();
			
		}
		return null;
	}

}