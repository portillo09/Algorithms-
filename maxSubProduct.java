/*
Omar Portillo	
Max subsequential Product
Find out the product of the largest among all the 
possible subsequences from any list of integers.
*/

import java.util.*;
public class maxSubProduct 
{
	public static void main(String[] args) 
	{
		Scanner kb = new Scanner(System.in); 
		int[] A = new int[200];
		int count = fillArray(A);		
		int start = 0;
		int end = A.length-1;
		int solution = maxSubProduct(A,start,end);
		System.out.println("The max subsequential product of your list is: "+ solution);
	}
	
	//FILLS ARRAY with user input
	private static int fillArray(int[] num)
	{
		int count = 0;
		Scanner kb = new Scanner(System.in);
		System.out.println("How many numbers do you want on your list?");
		count = kb.nextInt();
	   for(int i = 0; i < count; i++)
	   {
		 System.out.println("ENTER NUMBER:");
		 num[i] = kb.nextInt();
	   }
	return count;	
	}	 

	//Calculates the max product
	private static int maxSubProduct(int A[],int start,int end)
	{
		int maxLeftBorderProduct=0, maxRightBorderProduct=0;
		int leftBorderProduct=1, rightBorderProduct=1;
		int middle = (start+end)/2;
		if(start==end) return A[start];//Base Case
		
		int maxLeftProduct=maxSubProduct(A,start,middle);
		int maxRightProduct=maxSubProduct(A,middle+1,end);
		for( int i = middle; i >= start; i-- )
        {
            leftBorderProduct *= A[i];
            if( leftBorderProduct > maxLeftBorderProduct )
                maxLeftBorderProduct = leftBorderProduct;
        }

        for( int i = middle + 1; i <= end; i++ )
        {
            rightBorderProduct *= A[i];
            if( rightBorderProduct > maxRightBorderProduct )
                maxRightBorderProduct= rightBorderProduct;
        }
		return max3(maxLeftProduct, maxRightProduct, maxLeftBorderProduct * maxRightBorderProduct);
	}	
		//Returns the max
	 private static int max3( int a, int b, int c )
	 {
	     if(a>b && a>c)return a;
	     if(b>a && b>c)return b;
        if(c>a && c>b)return c;
        else return 0;
	 }
}