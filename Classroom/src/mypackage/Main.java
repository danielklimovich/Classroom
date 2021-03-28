/**
 * 
 */
package mypackage;

import java.util.*;

/**
 * @author Daniel Klimovich Description: Creates classroom of students.
 */
public class Main {
	
	static ArrayList<Student> classroom = new ArrayList<Student>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		classroomMenu(scnr);
	}

	public static void createStudent(Scanner scnr) {

		print("Please enter the student's first name.");
		String firstName = scnr.nextLine();
		print("Please enter the student's last name.");
		String lastName = scnr.nextLine();
		print("Please enter the student's age.");
		String ageString = scnr.nextLine();
		int age = Integer.parseInt(ageString);
		print("Please enter the student's gender: Male, Female, or Other.");
		String gender = scnr.nextLine();
		GENDER studentGender = assignGender(gender);
		
		Student student = new Student(firstName, lastName, age, studentGender);
		print("Student id " + student.getID());
		classroom.add(student);

	}

	public static void deleteStudent(Scanner scnr) {
		Student student = search(scnr);
		if (student != null) {
			classroom.remove(student);
			print("The student has been deleted.");
		} else {
			print("Student not found");
		}

	}

	static void classroomMenu(Scanner scnr) {
		for (int i = 0; i < 3; i++) {
			print("Please add another student.");
			createStudent(scnr);
		}

		boolean flag = true;

		String menuAnswer = "";
		while (flag) {
			if (classroom.size() >= 1) {
				print("If you would like to get the number of students, enter \"amount\".");
				print("If you would like to get the average student age, enter \"average\".");
				print("If you would like to get the minimum student age, enter \"minimum\".");
				print("If you would like to get the maximum student age, enter \"maximum\".");
				print("If you would like to search for a student, enter \"search\".");
				print("If you would like to add another student, enter \"add\".");
				print("If you would like to delete a student, enter \"delete\".");
				print("If you would like to print all of the students, enter \"print all\".");
				print("If you would like to exit the program, enter \"exit\".");
				menuAnswer = scnr.nextLine();

			} else {
				print("There aren't enough students. Please add some more.");
			}
			switch (menuAnswer.toLowerCase()) {
			case "amount":
				print(classroom.size());
				break;
			case "average":
				print(averageAge());
				break;
			case "minimum":
				print(minAge());
				break;
			case "maximum":
				print(maxAge());
				break;
			case "add":
				createStudent(scnr);
				break;
			case "search":
				Student student = search(scnr);
				if (student != null) {
					print(student.toString());
				} else {
					print("Student not found");
				}
				break;
			case "delete":
				deleteStudent(scnr);
				break;
			case "print all":
				printAll();
				break;
			case "exit":
				flag = false;
				break;
			}

		}
	}

	static void print(Object message) {
		System.out.println(message);
	}

	public static GENDER assignGender(String studentGender) {
		GENDER temp = null;
		switch (studentGender.toLowerCase()) {
		case "male":
			temp = GENDER.MALE;
			break;
		case "female":
			temp = GENDER.FEMALE;
			break;
		case "other":
			temp = GENDER.OTHER;
			break;
		}
		return temp;
	}

	public static Student search(Scanner scnr) {
		print("Please enter the student's ID.");
		int tempID = scnr.nextInt();
		Student tempStudent = null;
		for (int i = 0; i < classroom.size(); i++) {

			if (classroom.get(i).getID() == tempID) {
				tempStudent = classroom.get(i);
				break;
			}

		}
		return tempStudent;
	}

	public static double averageAge() {
		int ageSum = 0;
		for (int i = 0; i < classroom.size(); i++) {
			ageSum += classroom.get(i).getAge();
		}
		return ageSum / classroom.size();
	}

	public static int maxAge() {
		int max = 0;
		for (int i = 0; i < classroom.size(); i++) {
			if (classroom.get(i).getAge() > max) {
				max = classroom.get(i).getAge();
			}
		}
		return max;
	}

	public static int minAge() {
		int min = 100;
		for (int i = 0; i < classroom.size(); i++) {
			if (classroom.get(i).getAge() < min) {
				min = classroom.get(i).getAge();
			}
		}
		return min;
	}

	public static ArrayList<Student> printAll() {
		for (int i = 0; i < classroom.size(); i++) {
			print(classroom.get(i).toString());
		}
		return classroom;

	}

}
