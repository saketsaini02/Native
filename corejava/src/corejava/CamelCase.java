package corejava;

public class CamelCase {

	public static void main(String[] args) {
		
		String s="I am in an Interview";
		//s=s.replaceAll("/\s/w", "/\s\w])/g"); //With regex it can be one liner :)
		//System.out.println(s);
				
		String [] str=s.split((" "));
		//int count=0; Not required if we add space at last instead first
		for(String str2:str)
		{
			//count++; Not required if we add space at last instead first
			//str2.toUpperCase(null); //gets all the character of the string to upper case

			//We can also use substring concept 
			str2=str2.replace(str2.charAt(0), Character.toUpperCase(str2.charAt(0)));
			//if(count>1)
			//str2=" "+str2; //instead if we use space at last :)
			str2=str2+" ";
			str2.concat(str2);
			System.out.print(str2);
		}
					
		System.out.println(str);
	}
}
