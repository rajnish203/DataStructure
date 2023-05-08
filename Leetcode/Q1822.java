/* 
There is a function signFunc(x) that returns:
1 if x is positive.
-1 if x is negative.
0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.
Return signFunc(product).
Example 1:
Input: nums = [-1,-2,-3,-4,3,2,1]
Output: 1
Explanation: The product of all values in the array is 144, and signFunc(144) = 1
Example 2:
Input: nums = [1,5,0,2,-3]
Output: 0
Explanation: The product of all values in the array is 0, and signFunc(0) = 0
Example 3:
Input: nums = [-1,1,-1,1,-1]
Output: -1
Explanation: The product of all values in the array is -1, and signFunc(-1) = -1
Constraints:
1 <= nums.length <= 1000
-100 <= nums[i] <= 100
*/
public class Q1822 {
    public static int arraySign(int[] nums) {
        int x=1;
        for(int i: nums){
            if(i==0){
                return 0;
            }
            if(i<0){
                x=x*-1;
            }
        }
        return x;
    }
    public static void main(String[] args) {
        int nums[]={41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41};
        System.out.print(arraySign(nums));
    }
}