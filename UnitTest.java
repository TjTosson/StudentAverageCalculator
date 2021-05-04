import java.io.*;
import java.util.*;

public class UnitTest {
	// read in from file
	Scanner input = new Scanner(System.in);
	private ArrayList<String> answers = new ArrayList<String>();
	
	UnitTest (String s){
		
		try {
			input = new Scanner(new File(s));			
			} 
		catch (Exception e) 
		{
			System.out.println("Error opening file");
			e.printStackTrace();
			System.exit(0);  
		}
		while (input.hasNext()) {
			String text = input.next();
			answers.add(text);
		}
		input.close(); 	
		
	}
	
	
	/** calculate students average from file 
	 * 
	 * @param studentAnswers
	 * @return double of the students calculates average 
	 */
	public double calculateGrade(ArrayList<String> studentAnswers){
		
		double grade=100.00;
		
		for(int i = 0; i < answers.size(); i++) {
			if (!answers.get(i).equals(studentAnswers.get(i)) )
			{
				grade = grade - (100.00/answers.size());
			
			}
		
		}
		
		return grade;
		
	}


}