
/**
 * 
 * @author Chris D
 */

public class CourseDBElement implements Comparable {

	public String courseID, roomNumber, teacherName;
	public int crn, numCredits;
	
	public CourseDBElement(String courseID, int crn, int numCredits, String roomNumber, String teacherName) {
		
		this.courseID = courseID;
		this.crn = crn;
		this.numCredits = numCredits;
		this.roomNumber = roomNumber;
		this.teacherName = teacherName;
		
	}
	
	public CourseDBElement() {
		this.courseID = null;
		this.crn = 0;
		this.numCredits = 0;
		this.roomNumber = null;
		this.teacherName = null;
	}
	
	
	public String getID() {
		return courseID;
	}

	public int getCRN() {
		return crn;
	}

	public String getRoomNum() {
		return roomNumber;
	}
	
	public int getNumOfCredits() {
		return numCredits;
	}

public int compareTo(CourseDBElement o) {
		
		if (crn == o.crn)
			return 0;
		else if (crn > o.crn)
			return 1;
		else 
			return -1;
	}
	
	public String toString() {
		
		return "Course:" + courseID + " CRN:" + crn + " Credits:" + numCredits + " Instructor:" + teacherName + " Room:" + roomNumber;
		
	}
	
	public void setCRN(int parseInt) {
		crn= parseInt;
		
	}
	
	
	
 }