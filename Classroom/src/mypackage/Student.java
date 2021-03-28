/**
 * 
 */
package mypackage;

import java.util.ArrayList;

/**
 * @author Daniel Klimovich
 * Description: Creates Student object.
 */
public class Student {
	private String firstName;
	private String lastName;
	private int age;
	private GENDER gender;
	private int id;

	public Student(String firstName, String lastName, int age, GENDER gender) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.id = IDGenerator.generateId();
	}

	// Getter
	public String getFirstName() {
		return firstName;
	}

	// Setter
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int newAge) {
		this.age = newAge;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER newGender) {
		this.gender = newGender;
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format((id) + ". " + firstName + " " + lastName + " " + age + " " + gender + " " + ".");
	}

	

}
