import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UnitTestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create object Exam and send file location of correct answers
		UnitTest Exam = new UnitTest("/Users/georgeayob/eclipse-workspace/CalcStudentAverages/answers.txt");
		
		//create student object 
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<String> studentAnswers;
		String temp;
		String[] answersArray;
		
		//create hashmap with key as student firstname/lastname and value as student answers
		HashMap<String, ArrayList<String>> Map = new HashMap<String, ArrayList<String>>();

		//read in from file and check for error while opening file
		Scanner input = new Scanner(System.in);
		
		try {
			input = new Scanner(new File("/Users/georgeayob/eclipse-workspace/CalcStudentAverages/allExams.txt"));			
			} 
		catch (Exception e) 
		{
			System.out.println("Error opening file");
			e.printStackTrace();
			System.exit(0);  
		}
		while (input.hasNext()) {
			// create key
			String last = input.next();
			String first = input.next();
			
			studentAnswers = new ArrayList<String>();
			
			temp =input.nextLine();
			temp=temp.trim();
			
			answersArray= temp.split(" ");
			 
		
			Student s = new Student(last,first);
			students.add(s);
			
			for(int i=0; i<answersArray.length; i++)
				studentAnswers.add(answersArray[i]); 

				
			
			String key = s.getLastName() + s.getFirstName();
			key = key.toLowerCase();
			
			//eneter all info into hashmap
			Map.put(key, studentAnswers);
			
		}
		input.close(); 	
		
		
		// calculate student grades
		for(int i =0; i<students.size();i++ )
		{
			Student s = students.get(i);
			
			String Key = s.getLastName() + s.getFirstName();
			Key = Key.toLowerCase();
			 
			
			double grade = Exam.calculateGrade(Map.get(Key));
			
			students.get(i).setAverage(grade);
		
			
		}
		
		
		// output results
		for(int i=0; i < students.size(); i++) {
			
			
			Student s = students.get(i);
			
			System.out.println(s.getFirstName() + " " + s.getLastName() + " " + s.getAverage() + "%");
			
			
		}
	
	
	}

	
	}

/*
 * Output:
 * 
 * 
 * Christian Tobacco 100.0%
James Russo 30.0%
John Smith 30.0%
James Henderson 30.0%
Michael Russo 20.0%
John DeMartino 80.0%
Frank Scafuri 80.0%
 */

