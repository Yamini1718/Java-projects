package day15;

public class Person {
	String Name;
	float Age;
	
	
  Person(String Name,float Age){
	  this.Name=Name;
	  this.Age=Age;
  }
  
  
  public String getName() {
	  return Name;
  }
  public  float getAge() {
	  return Age;
  }

  
  public void setName(String Name) {
	  this.Name=Name;
  }
  public void setAge(float Age) {
	  this.Age=Age;
  }
  public String toString() {
		return "Name: " + Name + ", Age: " + Age;
	}
}
