import org.com.restapitest.data.TestBase;

public class TestTry {
	
	public static void main(String args[])
	{
		
		TestBase tb=new TestBase();
	
		
	}

}

//EXTENDS IS INHERITANCE WHERE AS CREATING OBJECT IS "Association " and in Association it is
//AGGREGATION(AS WEAK BONDING BETWEEN Test.java & TestBase.java,meaning it can without TestBase,
//Test.java can survive, else would have Composition)

//Extends & Association>Aggregation(Weak Bonding)can be used simultaneously but as a part of good 
//practice follow one preferably Aggregation

//If we want to create an object or extends a class present in another package we have to first 
//import the package

//If we want to just create an object no need to extends it simply import the package in the 
//above scenario

//Extends only comes necessary when we need to use the methods or variables of the other class 
//without creating an object, be it the above case or within the package itself
