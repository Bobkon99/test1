package AutomationFramewrk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class javalearn {
	int a = 5;
	int b = 10;
	double c = b;
	double d = a+b;
	String name="Bobby";
	String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void class1() {
		javalearn obj1= new javalearn();
		//		int a = 5;
		//		int b = 10;
		//		double c = b;
		//		double d = a+b;
		//		String name="Bobby";
		//		String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println("Hello World");
		System.out.println("The length of the txt string " + obj1.txt + " is " + obj1.txt.length());
		System.out.println(obj1.txt.indexOf("EFG"));
		System.out.println("Sum of a + b is : " + obj1.d + " and the name is " + obj1.name);
		String txt2 = "We are the so-called \"Vikings\" from the north.";
		System.out.println("New text is " + txt2);
		int day = 4;
		switch (day) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break; 
		}
		while (obj1.a<=obj1.b)
		{
			System.out.println("Value of a is : " + obj1.a);
			obj1.a++;
		}

		do {
			System.out.println("Value of a is : " + obj1.a);
			obj1.a++;
		}
		while (obj1.a <= obj1.b);
		for (int s= 0 ;s <= obj1.b; s++) {
			if
			(s==5) { continue;
			}
			System.out.println(s+obj1.b);
		}
		int f=5,g=6;
		if (f<g) 
		{ 
			System.out.println("Value of a= " + f + " is lesser than b= " + g);
		}
		else {
			System.out.println("Value of a= " + f + " is greater than b= " + g);
		}
	}
	public static void class2() {
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		cars[2] = "Raj";
		for (String i : cars) {
			System.out.println(i);
		}
		System.out.println(cars[2]);
		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]);
		}

		int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
		int x = myNumbers[0][1];
		System.out.println(x);
		System.out.println(cars.length);
		for (int i = 0; i < myNumbers.length; ++i) {
			for(int j = 0; j < myNumbers[i].length; ++j) {
				System.out.println(myNumbers[i][j]);
			}
		}
		for (int i = 0; i < cars.length; ++i) {
			System.out.println(cars[i]);
		}
	}
	public static void recursion() {
		int result = sum(5, 10);
		System.out.println(result);
	}
	public static int sum(int start, int end) {
		if (end > start) {
			return end + sum(start, end - 1);
		} else {
			return end;
		}
	}
	public static void array() {
		ArrayList<String> cars = new ArrayList<String>();
		cars.add("Volsdvo");
		cars.add("BdsdMW");
		cars.add("Fsdsord");
		cars.add("ssdsd");
		cars.set(0,"Tracy");
		System.out.println(cars);
		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i));
		}
	}
	public static void Linkedlst() {
		LinkedList<String> cars = new LinkedList<String>();
		cars.add("Ram");
		cars.add("Rahim");
		cars.add("Robert");

		// Use addFirst() to add the item to the beginning
		cars.addFirst("Raja");
		System.out.println(cars);
	}
	public static void Hashmap() {
		// Create a HashMap object called capitalCities
	    HashMap<String, String> capitalCities = new HashMap<String, String>();
	    HashMap<String, Integer> people = new HashMap<String, Integer>();

	    // Add keys and values (Country, City)
	    capitalCities.put("England", "London");
	    capitalCities.put("Germany", "Berlin");
	    capitalCities.put("Norway", "Oslo");
	    capitalCities.put("USA", "Washington DC");
	    System.out.println(capitalCities);
	    // Print keys
	    for (String i : capitalCities.keySet()) {
	      System.out.println(i);
	    }
	    // Add keys and values (Name, Age)
	    people.put("John", 32);
	    people.put("Steve", 30);
	    people.put("Angie", 33);
	    for (String i : people.keySet()) {
	    System.out.println("key: " + i + " value: " + people.get(i));
	    }
	}
	public static void main(String[] args) {
		int a =1 , b=2;
		array();
		Linkedlst();
		Hashmap();
		javalearn obj1= new javalearn();
		recursion();
//		if(obj1.a>obj1.b) 
//		{
//			class2();}
//		else {
//			class1();
//		}
	}
}