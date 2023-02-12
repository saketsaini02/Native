package corejava;
public class ReverseString {

	public static void main(String[] args) {
		
		//StringBuffer
		
		String s="Saket";
		StringBuffer sb=new StringBuffer(s);
		sb.reverse();
		System.out.println(sb);
		
		//for loop
		
		for(int i=s.length()-1;i>=0;i--)
		{
			System.out.print(s.charAt(i));
		}
		
	}

}
