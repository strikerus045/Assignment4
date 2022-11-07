
/**
 * 
 * @author Chris D
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class CourseDBStructure implements CourseDBStructureInterface {
	
	public int tableSize;
	public LinkedList<CourseDBElement>[] hashTable;
	public String Testing;
	public final double LOADFACTOR= 1.5;
	

	public CourseDBStructure(int i) {
		
		this.tableSize = i;
		LinkedList[] linkedLists = new LinkedList[i];
		hashTable = linkedLists;
		
	}

	public CourseDBStructure(String string, int i) {
		
		this.tableSize = i;
		LinkedList[] linkedLists = new LinkedList[i];
		hashTable = linkedLists;
		this.Testing = string;
		
	}

	public int getTableSize() {
		return tableSize;
		
	}

	public void add(CourseDBElement lcd1) {
		
		int indexFunction = lcd1.hashCode()%getTableSize();
		
		if(hashTable[indexFunction] == null) {
			
			LinkedList<CourseDBElement> nLinkedList = new LinkedList<CourseDBElement>();
			nLinkedList.add(lcd1);
			hashTable[indexFunction] = nLinkedList;
			
		}
		
			else {
				
			hashTable[indexFunction].addFirst(lcd1);
			
		}
		
		
	}

	public ArrayList<String> presentAll() {
		
		ArrayList<String> all = new ArrayList<String>();
		
		int count = 0;
		
			for(int i = 0; i < getTableSize(); i++) {
			
				if(hashTable[i] != null) {
				
					for(int n = 0; n < hashTable[i].size(); n++) {
					
						all.add(hashTable[i].get(n).toString());
					
				}
			}
		}
		
		for(int i = 0; i < all.size(); i++) {
			
			for(int n = 0; n < all.size(); n++) {
				
				if(all.get(i).equals(all.get(n))) {
					count++;
				}
				
				if(count > 1) {
					
					all.remove(i);
					
					count--;
				}
			}
		}

		return all;
		
	}

//	public static int getTableSize (int numCourses, double LOADFACTOR, int NumCourses) {
//		double temp;
//		int n;
//		int tableSize = 0;
//		
//		if  (numCourses% LOADFACTOR== 0) {
//			temp= numCourses / LOADFACTOR;
//			n = (int)temp;
//			}	
//				else {
//					temp= numCourses / LOADFACTOR;
//					n = (int)temp +1;
//					}
		
//		while (Prime == true) {
//			if ( isPrime(n) ) {
//				if ( (n - 3)%4 == 0 )
//
//				System.out.println("3 "+ n + " "+ tableSize);
//			}
//			
//			n++;
	
	public CourseDBElement get(int crn) throws IOException {
		
		String newCourse = String.valueOf(crn);
		int indexFunction = newCourse.hashCode()%getTableSize();
	
			if(hashTable[indexFunction] == null) {
			throw new IOException();
		}
			
			else {
			
				for(int i = 0; i < hashTable[indexFunction].size(); i++) {
				
					if(hashTable[indexFunction].get(i).getCRN() == crn) {
					
						return hashTable[indexFunction].get(i);
			    }
				
			}
			
			throw new IOException();
		}
		
	}

}
