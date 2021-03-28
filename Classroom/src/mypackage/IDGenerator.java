/**
 * 
 */
package mypackage;

/**
 * @author danie
 *
 */
public class IDGenerator {
private static int currentId = 0;
	
	
	public static int generateId() {
		currentId++;
		return currentId;
	}
}
