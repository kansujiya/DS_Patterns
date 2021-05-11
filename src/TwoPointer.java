

/*
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6

Input: [2, 5, 9, 11], target=11
Output: [0, 2]
Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11

* */

import java.util.*;

import static java.lang.Math.abs;
import static java.util.Collections.sort;

class PairWIthTargetSumUsingTwoPointer {
    public static int[] search(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length  - 1;

        while (right > left) {
            int sum = arr[left] + arr[right];
            if (sum == targetSum) {
                return new int[] {left, right};
            } else if (sum >  targetSum) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] {-1, -1};
    }
}

class PairWIthTargetSumUsingHashMap {
    public  static int[] search(int[] arr, int targetSum) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if (indexMap.containsKey(targetSum - arr[i])) {
                return new int[] {indexMap.get(targetSum - arr[i]), i};
            } else {
                indexMap.put(arr[i], i);
            }
        }

        return new int[] {-1, -1};
    }
}

class HappyNumber {
    public static boolean find(int num) {
        int slow = num;
        int fast = slow;
        do {
            slow = getSquad(slow);
            System.out.println("Slow Pointer" + slow);
            fast = getSquad(getSquad(fast));
            System.out.println("Fast Pointer" + fast);
        } while(slow != fast);
        return slow==1;
    }

    private static int getSquad(int num) {
        int digit = 0;
        int sum = 0;
        while (num > 0) {
            digit = num%10; // to get last digit
            sum += (digit*digit);
            num = num/10; //to reduce main value
        }
        return sum;
    }
}


class ListNode {
    int value;
    ListNode next;
    public ListNode(int value) {
        this.value = value;
    }
}

class LinklistCycle {
    public static boolean hasCycle(ListNode node) {
        if (node.next.next == null) {
            return false;
        }
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                System.out.println("length of cycle is:" + length(slow));
                System.out.println("Loop start at node:" + slow.value);
                return true;
            }
        }
        return false;
    }

    private static int length(ListNode slow) {
        ListNode current = slow;
        int cycleCount = 0;
        do {
            current = current.next;
            cycleCount++;
        } while (current != slow);

        return cycleCount;
    }
}


/*
Problem Statement #
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.

Example 1:

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].

Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].
* */
class RemoveDuplicate {
    public static int remove(int[] arr) {
        int nextNonDuplicate = 1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        System.out.println("Final arr:" + Arrays.toString(arr));
        return nextNonDuplicate;
    }
}


/*
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Example 1:

Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.
Example 2:

Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.

* */

class TripletSumToZero {
    public  static List<List<Integer>> searchTriplet(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        List<List<Integer>> triplet = new ArrayList<>();

        for(int i = 0; i < arr.length - 2; i++) {
            System.out.println(-arr[i]);
            if(i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            searchPair(arr, -arr[i], i+1, triplet);
        }

        return triplet;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplet) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if(currentSum == targetSum) {
                triplet.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left-1]) {
                    left++;
                }
                while (left < right && arr[right] == arr[right+1]) {
                    right--;
                }
            } else if (targetSum > currentSum) {
                left++;
            } else {
                right--;
            }
        }
    }
}

/*
Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.

Example 1:

Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
Example 2:

Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
Example 3:

Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.
* */

class TripletSumCloseToTarget {
    public static int searchTriplet(Vector<Integer> arr, int targetSum) {
        sort(arr);
        int smallestDiff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.size() -2 ; i++) {
            int left = i+1;
            int right = arr.size() - 1;
            while (left < right) {
                int targetDiff = targetSum - arr.get(left) - arr.get(right) - arr.get(i);
                if(targetSum == 0) {
                    return targetSum-targetDiff;
                }
                if(abs(targetDiff) < abs(smallestDiff)) {
                    smallestDiff = targetDiff;
                }
                if(targetDiff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return smallestDiff;
    }
}

/*
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

Example 1:

Input: [-1, 0, 2, 3], target=3
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
Example 2:

Input: [-1, 4, 2, 1, 3], target=5
Output: 4
Explanation: There are four triplets whose sum is less than the target:
   [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
* */

class TripletWithSmallestSum {
    public static int searchSmallestTriplet(int[] arr, int target) {
        Arrays.sort(arr);
        System.out.println("input arr" + Arrays.toString(arr));
        int count = 0;
        for(int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target-arr[i], i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first + 1;
        int right = arr.length - 1;

        while(left < right) {
            int smallerSum = arr[left] + arr[right];
            System.out.println("smallerSum" + smallerSum + arr[left] + arr[right]);
            if(smallerSum < targetSum) {
                count += right-left;
                System.out.println("count" + count);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}