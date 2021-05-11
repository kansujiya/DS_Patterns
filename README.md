# Data Structure | Problem solving | Patterns

## Table of contents
* [Sliding Window](#SlidingWindow)
* [Two Pointer](#TwoPointer)
* [Slow Fast Pointer](#SlowFastPointer)

## Sliding Window
In many problems dealing with an array (or a LinkedList), we are asked to find or calculate something among all the contiguous subarrays (or sublists) of a given size
Examples: [SlidingWindow](https://github.com/kansujiya/DS_Patterns/blob/master/src/SlidingWindow.java)

## Two Pointer
In problems where we deal with sorted arrays (or LinkedLists) and need to find a set of elements that fulfill certain constraints, the Two Pointers approach becomes quite useful. The set of elements could be a pair, a triplet or even a subarray.
Examples: [TwoPointer](https://github.com/kansujiya/DS_Patterns/blob/master/src/TwoPointer.java)

## Slow Fast Pointer
The Fast & Slow pointer approach, also known as the Hare & Tortoise algorithm, is a pointer algorithm that uses two pointers which move through the array (or sequence/LinkedList) at different speeds. This approach is quite useful when dealing with cyclic LinkedLists or arrays.
By moving at different speeds (say, in a cyclic LinkedList), the algorithm proves that the two pointers are bound to meet. The fast pointer should catch the slow pointer once both the pointers are in a cyclic loop.
One of the famous problems solved using this technique was Finding a cycle in a LinkedList. Let’s jump onto this problem to understand the Fast & Slow pattern.
Examples: [SlowFast](https://github.com/kansujiya/DS_Patterns/blob/master/src/TwoPointer.java)
