

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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
