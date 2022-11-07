package application;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface myMgr = new CourseDBManager();

	@BeforeEach
	public void setUp() throws Exception {
		myMgr = new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		myMgr = null;
	}

	@Test
	public void testAddToDB() {
		
		try {
			
			myMgr.add("CMSC110",11001, 4,"B1001","Mr. Jones");
			
		}
		
		catch(Exception e) {
			
			fail("This should not have caused an Exception");
			
		}
	}
	
	@Test
	public void testRead() {
		
		try {
			
			File inputFile = new File("StudentTest.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC110 11001 4 B1001 Mr. Jones");

			inFile.close();
			myMgr.readFile(inputFile);
			assertEquals("CMSC07",myMgr.get(10534).getID());
			assertEquals("CMSC282",myMgr.get(16534).getID());
			
		} 
		
		catch (Exception e) {
			
			fail("Should not have thrown an exception");
			
		}
	}

}
