package activities;

public class Activity2 {

	public static void main(String[] args) {
		//Create object for the class
		Activity2 actObj = new Activity2();
		
		//Initialize array
		int[] inputArr = {10, 77, 10, 54, -11, 10};
		//Initialize the search num and expected sum
		int searchNum = 10;
		int finalSum = 30;
		//Call the calculation function
		System.out.println("Does the sum equal to 30?:" + actObj.result(inputArr, searchNum, finalSum));
		

	}
	public boolean result(int[] nums, int searchNum, int fixedSum) {
		int tempSum = 0;
		
		for(int num : nums) {
			if(num == searchNum) {
			tempSum += searchNum;
	}
			if(tempSum > fixedSum) {
				break;
		
	}
}
		return tempSum == fixedSum;
	}

}
