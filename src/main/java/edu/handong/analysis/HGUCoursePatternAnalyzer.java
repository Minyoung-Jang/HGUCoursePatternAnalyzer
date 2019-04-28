package edu.handong.analysis;

import edu.handong.analysis.datamodel.*;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		int i, j = 0;
		String names;
		Student studentnames;
		students = new Student[numOfStudents];
	
		for(i = 0; i < lines.length; i++) {
			names = lines[i].trim().split(", ")[1]; 
			studentnames = new Student(names);
			if(studentExist(students, studentnames)) {
				if(j < numOfStudents) {
					students[j] = studentnames;
					j++;
				}
			}
		}
		
		return students;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		// TODO: implement this method	
		for(int i = 0; students[i] != null; i++) {
			if((students[i].getName()).equals(student.getName())) {
				return false; 
			}
		}return true;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		int i, j = 0;
		String names;
		Course coursenames;
		courses = new Course[numOfCourses];
	
		for(i = 0; i < lines.length; i++) {
			names = lines[i].trim().split(", ")[2]; 
			coursenames = new Course(names);
			if(courseExist(courses, coursenames)) {
				if(j < numOfCourses) {
					courses[j] = coursenames;
					j++;
				}
			}
		}
		
		return courses;
		
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		for(int i = 0; courses[i] != null; i++) {
			if((courses[i].getCourseName()).equals(course.getCourseName())) {
				return false; 
			}
		}return true;
	}
}
