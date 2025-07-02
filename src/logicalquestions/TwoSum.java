package logicalquestions;

/*Given an array of integers nums and an integer target, return indices 
 of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you
 may not use the same element twice.
You can return the answer in any order.
*/
public class TwoSum {
	
	public static void main(String[] args) {
		int [] nums = {2,11,15,7};
		int target = 9;
		int newArr[] = new int[2];
		
		for(int i=0; i<nums.length-1; i++) {
			for(int j=i+1; j<nums.length; j++) {
				int sum = nums[i] + nums[j];
				if(sum == target) {
					newArr[0] = i;
					newArr[1] = j;
					break;
				}
				
			}
		}
		System.out.println(newArr[0] + " " + newArr[1]);
		
		
	}

}
