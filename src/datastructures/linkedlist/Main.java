package datastructures.linkedlist;

public class Main {

	/**
	 * Runs the main console demo for the linked list project.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public static void main(String[] args) {

		runBasicOperations();
		runPalindromeExample();
		runAlgorithms();
		runMergePointExample();
		runExtendedApiExample();

	}

	/**
	 * Demonstrates the basic list operations.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	private static void runBasicOperations() {

		/* Basic list operations. */
		SinglyLinkedList<Integer> numbers = new SinglyLinkedList<>();
		numbers.insertFirst(3);
		numbers.insertFirst(2);
		numbers.insertFirst(1);
		numbers.insertLast(4);
		numbers.insertLast(5);

		System.out.println("Numbers: " + numbers);
		System.out.println("Contains 3: " + numbers.contains(3));
		System.out.println("Contains 9: " + numbers.contains(9));

		numbers.insertSorted(0);
		numbers.insertSorted(6);
		System.out.println("Sorted inserts: " + numbers);

		numbers.remove(4);
		System.out.println("After remove: " + numbers);

		numbers.reverse();
		System.out.println("After reverse: " + numbers);

	}

	/**
	 * Demonstrates the palindrome check.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	private static void runPalindromeExample() {

		/* Palindrome check uses the current list implementation. */
		SinglyLinkedList<Integer> palindrome = new SinglyLinkedList<>();
		palindrome.insertLast(1);
		palindrome.insertLast(2);
		palindrome.insertLast(3);
		palindrome.insertLast(2);
		palindrome.insertLast(1);
		System.out.println("Palindrome list: " + palindrome);
		System.out.println("Is palindrome: " + palindrome.isPalindrome());

	}

	/**
	 * Demonstrates the linked list algorithms.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	private static void runAlgorithms() {

		/* The helper class contains algorithms that belong outside the core list type. */
		SinglyLinkedList<Integer> parity = new SinglyLinkedList<>();
		parity.insertLast(1);
		parity.insertLast(2);
		parity.insertLast(3);
		parity.insertLast(4);
		parity.insertLast(5);
		parity.insertLast(6);
		System.out.println("Parity original: " + parity);
		LinkedListAlgorithms.evenBeforeOdd(parity);
		System.out.println("Parity reordered: " + parity);

		/* This second version performs the same idea with in-place relinking. */
		SinglyLinkedList<Integer> parity2 = new SinglyLinkedList<>();
		parity2.insertLast(1);
		parity2.insertLast(2);
		parity2.insertLast(3);
		parity2.insertLast(4);
		parity2.insertLast(5);
		parity2.insertLast(6);
		LinkedListAlgorithms.evenBeforeOdd2(parity2);
		System.out.println("Parity reordered again: " + parity2);

	}

	/**
	 * Demonstrates merge-point detection.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	private static void runMergePointExample() {

		/* Merge-point detection returns null here because the lists do not share nodes. */
		SinglyLinkedList<Integer> firstList = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> sharedSuffix = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> secondList = new SinglyLinkedList<>();

		sharedSuffix.insertLast(7);
		sharedSuffix.insertLast(8);
		sharedSuffix.insertLast(9);

		secondList.insertLast(1);
		secondList.insertLast(2);
		secondList.appendSharedSuffix(sharedSuffix);
		firstList.appendSharedSuffix(sharedSuffix);

		System.out.println("First list: " + firstList);
		System.out.println("Second list: " + secondList);
		System.out.println("Merge point: " + LinkedListAlgorithms.findMergePoint1(firstList, secondList));

	}

	/**
	 * Demonstrates the extended list API.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	private static void runExtendedApiExample() {

		SinglyLinkedList<Integer> api = new SinglyLinkedList<>();
		api.insertLast(10);
		api.insertLast(20);
		api.insertLast(30);

		System.out.println("First value: " + api.getFirst());
		System.out.println("Last value: " + api.getLast());
		System.out.println("Peek first: " + api.peekFirst());
		System.out.println("Peek last: " + api.peekLast());
		System.out.println("Value at index 1: " + api.get(1));
		System.out.println("Index of 20: " + api.indexOf(20));

		System.out.println("Removed first: " + api.removeFirst());
		System.out.println("Removed last: " + api.removeLast());
		api.insertLast(40);
		api.insertLast(50);
		System.out.println("Removed at index 1: " + api.removeAt(1));
		System.out.println("Extended API demo: " + api);

	}

}