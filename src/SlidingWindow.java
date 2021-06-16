/*
Sliding window pattern

* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


/*
Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.

Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].

Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
* */
class AverageOfSubarrayOfSizeKBruteForce {

    public static double[] findAverages(int size, int[] arr) {
        double[] result = new double[arr.length - size + 1];
        for(int i = 0; i < arr.length - size; i++) {
            double total = 0;
             for(int j = i; j < i +size; j++) {
                 total = total + arr[j];
             }
             result[i] = total/size;
        }
        return result;
    }
}

class AverageOfSubarrayOfSizeKSlidingWindow {

    public static double[] findAverages(int size, int[] arr) {
        double[] result = new double[arr.length - size + 1];
        double slingWindowTotal = 0;
        int slingWindowStartIndex = 0;
        for(int slingWindowEndIndex = 0; slingWindowEndIndex < arr.length; slingWindowEndIndex++) {
            slingWindowTotal = slingWindowTotal + arr[slingWindowEndIndex]; // add the next element
            if (slingWindowEndIndex >= size - 1) { // slide the window, we don't need to slide if we've not hit the required window size of 'k'
                result[slingWindowStartIndex] = slingWindowTotal/size; // calculate the average
                slingWindowTotal = slingWindowTotal - arr[slingWindowStartIndex]; //update slidingWindowTotal when window is complete
                slingWindowStartIndex = slingWindowStartIndex + 1; //move start index to next
            }
        }
        return result;
    }
}

/*
Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists
Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].

Input: [2, 1, 5, 2, 8], S=7
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].

Input: [3, 4, 1, 1, 6], S=8
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
* */
class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int slideWindowTotal = 0;
        int slideWindowStartIndex = 0;
        int slideWindowMax = 0;

        for(int slideWindowEnd = 0; slideWindowEnd < arr.length; slideWindowEnd++) {
            slideWindowTotal = slideWindowTotal + arr[slideWindowEnd];
            if(slideWindowEnd >= k-1) {
                if (slideWindowTotal > slideWindowMax) {
                    slideWindowMax = slideWindowTotal;
                }
                slideWindowTotal = slideWindowTotal - arr[slideWindowStartIndex];
                slideWindowStartIndex++;
            }
        }
        return slideWindowMax;
    }
}

/*
Input: [2, 1, 5, 2, 8], S=7
Output: 2
Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
* */
class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int windowTotal = 0;
        int minSubArrayCount = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowTotal = windowTotal + arr[windowEnd];
            while (windowTotal >= S) {
                minSubArrayCount = Math.min(minSubArrayCount, windowEnd - windowStart + 1);
                windowTotal = windowTotal - arr[windowStart];
                windowStart++;
            }
        }
        return minSubArrayCount == Integer.MAX_VALUE ? 0 : minSubArrayCount;
    }
}
/*
Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
* */
class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        int windowStart = 0;
        int maxLength = 0;
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            charFrequencyMap.put(str.charAt(windowEnd), charFrequencyMap.getOrDefault(str.charAt(windowEnd), 0) + 1);
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if(charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }
        return maxLength;
    }
}

/*
Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
* */

////A - 1

////B - 1

//C - 2
//A - 1

class MaxFruitCount2Type{
    public static int findLength(char[] arr) {

        Map<Character, Integer> basketMap = new HashMap<>();
        int windowStart = 0;
        int maxCount = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char rightFruit = arr[windowEnd];
            basketMap.put(rightFruit, basketMap.getOrDefault(rightFruit, 0) +1);
            while (basketMap.size() > 2) {
                char leftFruit = arr[windowStart];
                basketMap.put(leftFruit, basketMap.get(leftFruit) - 1);
                if(basketMap.get(leftFruit) == 0) {
                    basketMap.remove(leftFruit);
                }
                windowStart++;
            }

            maxCount = Math.max(maxCount, windowEnd-windowStart + 1);
        }
        return maxCount;
    }
}

public class SlidingWindow {
//    public static void  main(String[] args) {
//        System.out.println("Welcome to DS world");
//        double[] avgArr = AverageOfSubarrayOfSizeKBruteForce.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
//        System.out.println("Averages of subarrays of size K: " + Arrays.toString(avgArr));
//        double max = 0;
//        for(int i = 0; i < avgArr.length; i++) {
//            if (avgArr[i] > max) {
//                max = avgArr[i];
//            }
//        }
//        System.out.println(max);
//
//        double[] avgSlideArr = AverageOfSubarrayOfSizeKSlidingWindow.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
//        System.out.println("Averages of subarrays of size K: " + Arrays.toString(avgSlideArr));
//
//        int maxContinues = MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 });
//        System.out.println("max of subarrays of size K: " + maxContinues);
//
//        int minContinuesSum = MinSizeSubArraySum.findMinSubArray(7, new int[] { 8, 1, 5, 2, 3, 2 });
//        System.out.println("min of subarrays sum : " + minContinuesSum);
//
//
//        System.out.println("Longest substring with K distinct char:" + LongestSubstringKDistinct.findLength("araaci",2));
//
//        System.out.println("Longest substring with K distinct fruit:" + MaxFruitCount2Type.findLength(new char[] {'A', 'B', 'C', 'B', 'B', 'C'}));
//
//        System.out.println("Target sum at index:"+ Arrays.toString(PairWIthTargetSumUsingTwoPointer.search(new int[] {1, 2, 3, 4, 6},6)));
//        System.out.println("Target sum at index:"+ Arrays.toString(PairWIthTargetSumUsingHashMap.search(new int[] {1, 2, 3, 4, 6},6)));
//        System.out.println("Target sum at index:"+ RemoveDuplicate.remove(new int[] {2, 2, 2, 11}));
//        System.out.println("Target sum at index:"+ RemoveDuplicate.remove(new int[] {2, 3, 3, 3, 6, 9, 9}));
//
//        //detect linklist cycle
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//
//        System.out.println("List has cycle:"+ LinklistCycle.hasCycle(head));
//
//        head.next.next.next.next.next.next = head.next.next.next;
//
//        System.out.println("List has cycle:"+ LinklistCycle.hasCycle(head));
//
//        head.next.next.next.next.next.next = head;
//        System.out.println("List has cycle:"+ LinklistCycle.hasCycle(head));
//
//        System.out.println("Found Happy number for 23:"+ HappyNumber.find(23));
//        System.out.println("Found Happy number for 12:"+ HappyNumber.find(12));
//
//
//        //TripletSumToZero
//        System.out.println("Triplet Pairs founds:"+ TripletSumToZero.searchTriplet(new int[] {-3, 0, 1, 2, -1, 1, -2}));
//
//        //TripletSumToClosest
//        Vector<Integer> arr = new Vector<Integer>();
//        arr.add(-2);
//        arr.add(0);
//        arr.add(1);
//        arr.add(2);
//        System.out.println("Triplet Pairs founds at closest:"+ TripletSumCloseToTarget.searchTriplet(arr,2));
//
//        //TripletToSmallestSum
//        System.out.println("Triplet Pairs founds for smallest sum:"+ TripletWithSmallestSum.searchSmallestTriplet(new int[] {-1, 0, 2, 3}, 3));
//        System.out.println("Triplet Pairs founds for smallest sum:"+ TripletWithSmallestSum.searchSmallestTriplet(new int[] {-1, 4, 2, 1, 3}, 5));
//
//    }
}
