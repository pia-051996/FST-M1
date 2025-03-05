package activities;

import java.util.Arrays;

class Activity4 {
    static void ascendingSort(int rawArray[]) {
        int size = rawArray.length;
        int i;
        
        for (i = 1; i < size; i++) {
            int key = rawArray[i];
            int j = i - 1;
            
            while (j >= 0 && key < rawArray[j]) {
            	rawArray[j + 1] = rawArray[j];
            	
                --j;
            }
            rawArray[j + 1] = key;
            System.out.println(Arrays.toString(rawArray));
        }
    }
    
    public static void main(String args[]) {
        int[] data = { 9, 5, 1, 4, 3 };
        ascendingSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}