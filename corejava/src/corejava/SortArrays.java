package corejava;

import java.util.Arrays;

public class SortArrays {

	public static void main(String[] args) {
		        
		        int arr[] = new int[2];
		               
				int arr2[] = {3,4,5};
				arr2.equals(arr); 				//comparing two arrays				
				int []arr3=arr2;
				arr3=arr2; 						//this is how we assign arrays
				arr3[2]=90;                     //this is how we change values for a given index.
				
				System.out.println(Arrays.toString(arr3));  //printing an array
				arr[0]=1;                       //this is how we change values for a given index.
				arr[1]=2;                       //this is how we change values for a given index.
				
				System.out.println();
				//System.out.println(arr.getClass());  //[I@27f6674d
				//System.out.println(arr.hashCode());  //Object class
				//System.out.println(arr.equals(arr)); //Object class
				System.out.println(arr.toString()); //same as below
				System.out.println(arr); //same as above);
				
				System.out.println(Arrays.toString(arr)); // to print arrays content
				
				Arrays.compare(arr2, 0, 0, arr3, 0, 0);
				Arrays.compare(arr2, arr3);
				//Arrays.compare(null, null);
				
				
				
				
				//Array to Strings
				

	}

}
