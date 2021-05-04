public class Student {
	// create data memebers
   private String lastName;
   private String firstName;
   private double average;
   
   
   // constructor
   public Student(String l, String f)
   {
       lastName=l;
       firstName=f;
       average=0;
   }
   
   // create accessor and mutator methods
   public String getLastName() { return lastName;  }
   
   public String getFirstName() { return firstName;}
   
   public double getAverage() { return average;  }
   
   public void setAverage(double a) {	average = a;}
  
   public Student() {  } // default constrcutor 
  
 
}