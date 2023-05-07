package practice;

import java.util.Arrays;
import java.util.Iterator;

public class PrK {

	public static void main(String[] args) {
	
		int[] a= {12,44,54,23,21,9,67};
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a.length; j++) {
				
				if (i==0 && j==3) {
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
