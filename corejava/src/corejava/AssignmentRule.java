package corejava;

public class AssignmentRule {

	public static void main(String[] args) {
		System.out.println("Genpact"+10+20);
		int y=4,x=10;
		x+=y; //For understanding purpose it is x=x+y but as per assignment operator rule right to left
		//x+y gets assigned to x 
		System.out.println(x);
		System.out.println(y);
		
		
		

	}

}


// All binary operators except for the assignment operators are evaluated from left to right;
//assignment operators are evaluated right to left.

//operators-> Equal (==) Not equal (!=) Less than (<) Greater than (>) Greater than or equal to (>=)
              //Less than or equal to (<=) Logical AND (&&) Logical OR (||) Plus (+) Minus (-)

//Assignment = += -= *= /= %= &= ^= |= Trick to remember, Assignment operator does not have any symbol in 
//double occurrence except these <<= >>= >>>=, which we really use less
