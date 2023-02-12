package corejava;

public class RevereseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int i=12345, rev=0;
		
		while(i!=0)
		{
			rev=rev*10+i%10;
			i=i/10;
		}
		System.out.println(rev);
		
		int j=98765;
		StringBuffer sb=new StringBuffer(String.valueOf(j));
		sb.reverse();
		System.out.println(sb);
		
		// sb=sb.reverse() Not required as sb is mutable, any changes reflect the same copy of reference

	}

}
