package activities;

import java.util.Arrays;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numArr = {10, 77, 10, 54, -11, 10, 12};
		System.out.println("Original Array: " + Arrays.toString(numArr));
		//Set constants
        int searchNum = 10;
        int fixedSum = 30;
        
      //Print result
        System.out.println("Does the sum equal to 30? " + result(numArr, searchNum, fixedSum));
	}

	public static boolean result(int [] numbers, int searchNum, int fixedSum) {
		
		int temp_sum = 0;
        //Loop through array
        for (int number : numbers) {
            //If value is 10
            if (number == searchNum) {
                //Add them
                temp_sum += searchNum;
            }

            //Sum should not be more than 30
            if (temp_sum > fixedSum) {
                break;
            }
        }

        //Return true if condition satisfies
        return (temp_sum == fixedSum);
	}
}
