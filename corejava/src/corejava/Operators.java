
package corejava;

public class Operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=4, b=5;
		System.out.println((a==6) && (b++==6));
		System.out.println("b= "+b);
		//output
		//false
		//b=5;
		
		int c=4, d=5;
		System.out.println((c==6) &(d++==6));
		System.out.println("d= "+d);
		//output
		//false
		//d=6

	}
	/*
	 * Key Differences Between & and && 
	 * The & operator is a logical as well as a
	 * bitwise operator, as it operates on both booleans as well as binary data
	 * whereas, the && operator is only a logical operator as it operates only on a
	 * boolean data type. 
	 * The & operator evaluates both the side of the expression
	 * to obtain the final result whereas, the && operator evaluates only the left
	 * side of the expression & if turn out false it doesn�t even evaluate the right
	 * side of the expression.
	 */

}
