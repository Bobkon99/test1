package AutomationFramewrk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class javafile {

	public static void main(String[] args) {
		File myObj = new File("C:\\Eclipseworkspace\\JavaLearn\\InputData\\InputData.txt");
		try {
			
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		try {
		      FileWriter myWriter = new FileWriter(myObj);
		      myWriter.write("Files in Java might be tricky, but it is fun enough!");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		try {
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
//		if (myObj.delete()) {
//			System.out.println("Deleted the File: " + myObj.getName());
//		} else {
//			System.out.println("File to delete file.");
//		}
		String str1 = "ABC";
		String str2 = "ABC";
		System.out.println(str1.compareToIgnoreCase(str2));
//		int x, y, sum;
//	    Scanner myObj2 = new Scanner(System.in); // Create a Scanner object
//	    System.out.println("Type a number:");
//	    x = myObj2.nextInt(); // Read user input
//
//	    System.out.println("Type another number:");
//	    y = myObj2.nextInt(); // Read user input
//	    
//	    sum = x + y;  // Calculate the sum of x + y
//	    System.out.println("Sum is: " + sum); // Print the sum
	    
	  
	}
}