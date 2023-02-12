package corejava;

public class ConcatAppend {
	
	public static void main(String[] args)
	{
		String s="Saket";
		s.concat("add");
		System.out.println(s);
		s=s.concat("hello");
		System.out.println(s);
		
		StringBuffer sb=new StringBuffer("avisa");
		sb.append("saini");   //line 14 & 16 does the same as StringBuffer is mutable
		System.out.println(sb);
		sb=sb.append("baby");
		System.out.println(sb);
	}

}
