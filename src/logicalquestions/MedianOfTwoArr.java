package logicalquestions;

import java.util.Arrays;

public class MedianOfTwoArr {
	
	public static void main(String[] args) {
		double result;
		
		int nums1[] = {1,2};
		int nums2[] = {3,4};
		int size = nums1.length+nums2.length;
		int merged[] = new int[size];
		 System.arraycopy(nums1,0,merged,0,nums1.length);
		System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
		
		Arrays.sort(merged);
		System.out.println(size/2 + " :"+merged[size/2]);
		System.out.println(size/2 + " :"+merged[(size/2)-1]);
		System.out.println(Arrays.toString(merged));
		 if(size/2 == 0){
	            double res1 = merged[size/2];
	            double res2 = merged[(size/2)-1];
	            System.out.println(res1 + " "+res2);
	            result = (res1+res2)/2; 
	       }else{
	        result =merged[size/2];
	       }
		 System.out.println(result);
	}

}
