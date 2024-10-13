
// Author: karshav16   --Binary_Search_Optimised_Way--
/*This Java program performs an optimized binary search on both sorted and unsorted arrays.
After taking user input, it checks if the array is sorted using the `isSorted()` method.
If unsorted, the array is sorted using **TimSort** (`Arrays.sort()`), which has a time complexity of **O(n log n)**.
Once sorted, binary search is performed in **O(log n)** time by repeatedly dividing the array to find the target.
The program efficiently handles both sorted and unsorted arrays while minimizing overall time complexity,
making it ideal for larger datasets.
*/

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    // Optimized Binary Search function
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            // Optimized calculation to avoid overflow
            int middle = left + (right - left) / 2;

            // Check if the target is at the middle
            if (array[middle] == target) {
                return middle; // Target found
            }

            // If target is greater, ignore the left half
            if (array[middle] < target) {
                left = middle + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = middle - 1;
            }
        }

        // Target not found
        return -1;
    }

    // Check if the array is sorted in ascending order
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;  // Not sorted
            }
        }
        return true;  // Sorted
    }

    // Main method to take input from the user and display results
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Taking input for the elements of the array
        int[] array = new int[n];
        System.out.println("Enter " + n + " elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Taking input for the target element to search for
        System.out.print("Enter the target element to search: ");
        int target = scanner.nextInt();

        // Check if the array is already sorted
        if (!isSorted(array)) {
            // If unsorted, sort the array using an optimized approach (Arrays.sort uses QuickSort/MergeSort)
            System.out.println("Array is unsorted, sorting the array...");
            Arrays.sort(array);
            System.out.println("Sorted Array: " + Arrays.toString(array));
        } else {
            System.out.println("Array is already sorted.");
        }

        // Performing binary search and showing the result
        int index = binarySearch(array, target);
        if (index == -1) {
            System.out.println("Binary Search: Target not found.");
        } else {
            System.out.println("Binary Search: Target found at index " + index);
        }

        scanner.close();
    }
