package datastructures.linkedlist;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T extends Comparable<? super T>> {

	static final class Node<T> {

		private final T data;
		private Node<T> next;

		/**
		 * Constructor to create a node with a value and a link to the next node.
		 * 
		 * @param data The value stored in the node.
		 * @param next The next node in the list.
		 * @since 14/10/2024
		 * @version 1.0
		 * @author Anastasis Zachariou
		 */
		Node(T data, Node<T> next) {

			this.data = data;
			this.next = next;

		}

		/**
		 * Returns the value stored in this node.
		 * 
		 * @return T => the data stored in the node.
		 * 
		 * @since 14/10/2024
		 * @version 1.0
		 * @author Anastasis Zachariou
		 */
		public T getData() {

			return (this.data);
            
		}

		/**
		 * Returns the next node in the chain.
		 * 
		 * @return Node<T> => the next node, or null if this is the last node.
		 * 
		 * @since 14/10/2024
		 * @version 1.0
		 * @author Anastasis Zachariou
		 */
		public Node<T> getNext() {

			return (this.next);

		}

		/**
		 * Updates the next link of this node.
		 * 
		 * @param next The node that should follow this node.
		 * 
		 * @since 14/10/2024
		 * @version 1.0
		 * @author Anastasis Zachariou
		 */
		void setNext(Node<T> next) {

			this.next = next;

		}

		/**
		 * Returns a text version of the node value.
		 * 
		 * @return String => the string form of the stored value.
		 * 
		 * @since 14/10/2024
		 * @version 1.0
		 * @author Anastasis Zachariou
		 */
		@Override
		public String toString() {

			return (String.valueOf(this.data));

		}
	}

	private Node<T> head;
	private int size;

	/**
	 * Constructor to initialize an empty singly linked list.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public SinglyLinkedList() {

		this.head = null;
		this.size = 0;

	}

	/**
	 * Removes every element from the list.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public void clear() {

		/* Reset both the head pointer and the stored size. */
		this.head = null;
		this.size = 0;

	}

	/**
	 * Checks if the list is empty.
	 * 
	 * @return boolean => true if the list is empty, false otherwise.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public boolean isEmpty() {

		/* The list is empty when the stored size reaches zero. */
		return (this.size == 0);

	}

	/**
	 * Returns the current number of stored elements.
	 * 
	 * @return int => the number of elements in the list.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public int size() {

		/* Return the maintained element count directly. */
		return (this.size);
            
	}

	/**
	 * Inserts a new value at the front of the list.
	 * 
	 * @param data The value to insert at the front of the list.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public void insertFirst(T data) {

		/* The new node becomes the head and points to the old front. */
		this.head = new Node<>(data, this.head);
		this.size++;
        
	}

	/**
	 * Inserts a new value at the end of the list.
	 * 
	 * @param data The value to insert at the end of the list.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public void insertLast(T data) {

		Node<T> newNode = new Node<>(data, null);

		if (this.head == null) {

			/* An empty list only needs the newly created node. */
			this.head = newNode;

		} else {

			/* Walk to the tail so the new node can be attached at the end. */
			Node<T> current = this.head;
			while (current.next != null) {

				current = current.next;

			}

			current.next = newNode;

		}

		this.size++;

	}

	/**
	 * Inserts a value while keeping the list sorted in ascending order.
	 * 
	 * @param data The value to insert in sorted position.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public void insertSorted(T data) {

		if (this.head == null || data.compareTo(this.head.data) <= 0) {

			/* Smallest values are inserted at the front. */
			insertFirst(data);

			return;

		}

		/* Find the first node whose next value is larger than the new value. */
		Node<T> current = this.head;
		while (current.next != null && current.next.data.compareTo(data) < 0) {

			current = current.next;

		}

		current.next = new Node<>(data, current.next);

		this.size++;

	}

	/**
	 * Removes the first matching value from the list.
	 * 
	 * @param data The value to remove from the list.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public void remove(T data) {

		if (this.head == null) {

			/* Nothing to remove from an empty list. */
			return;

		}

		if (Objects.equals(this.head.data, data)) {

			/* Removing the first node is a special case. */
			this.head = this.head.next;
			this.size--;

			return;

		}

		/* Search for the node immediately before the one we want to unlink. */
		Node<T> current = this.head;
		while (current.next != null) {

			if (Objects.equals(current.next.data, data)) {

				current.next = current.next.next;
				this.size--;

				return;

			}

			current = current.next;

		}

	}

	/**
	 * Finds the first node that stores the provided value.
	 * 
	 * @param data The value to search for.
	 * @return Node<T> => the first matching node, or null if no match exists.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public Node<T> findNode(T data) {

		/* Traverse the list once and stop as soon as a match is found. */
		Node<T> current = this.head;
		while (current != null) {

			if (Objects.equals(current.data, data)) {

				return current;

			}

			current = current.next;

		}

		return (null);

	}

	/**
	 * Checks whether the list contains the provided value.
	 * 
	 * @param data The value to search for.
	 * @return boolean => true if the value exists in the list, false otherwise.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public boolean contains(T data) {

		/* Existence is determined by whether findNode returns a match. */
		return (findNode(data) != null);

	}

	/**
	 * Returns the first value stored in the list.
	 * 
	 * @return T => the value stored at the front of the list.
	 * 
	 * @throws NoSuchElementException if the list is empty.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public T getFirst() {

		if (this.isEmpty()) {

			throw new NoSuchElementException("The list is empty! Cannot access the first element.");

		}

		/* The head node always stores the first value. */
		return (this.head.data);

	}

	/**
	 * Returns the last value stored in the list.
	 * 
	 * @return T => the value stored at the end of the list.
	 * 
	 * @throws NoSuchElementException if the list is empty.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public T getLast() {

		if (this.isEmpty()) {

			throw new NoSuchElementException("The list is empty! Cannot access the last element.");

		}

		/* The tail node holds the last value. */
		return (this.lastNode().data);

	}

	/**
	 * Returns the first value stored in the list without removing it.
	 * 
	 * @return T => the value stored at the front of the list, or null if empty.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public T peekFirst() {

		if (this.isEmpty()) {

			return (null);

		}

		return (this.head.data);

	}

	/**
	 * Returns the last value stored in the list without removing it.
	 * 
	 * @return T => the value stored at the end of the list, or null if empty.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public T peekLast() {

		if (this.isEmpty()) {

			return (null);

		}

		return (this.lastNode().data);

	}

	/**
	 * Removes and returns the first value in the list.
	 * 
	 * @return T => the removed first value.
	 * 
	 * @throws NoSuchElementException if the list is empty.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	public T removeFirst() {

		if (this.isEmpty()) {

			throw new NoSuchElementException("The list is empty! Cannot remove the first element.");

		}

		/* Save the first value before updating the head pointer. */
		T removedValue = this.head.data;
		this.head = this.head.next;
		this.size--;

		return (removedValue);

	}

	/**
	 * Removes and returns the last value in the list.
	 * 
	 * @return T => the removed last value.
	 * 
	 * @throws NoSuchElementException if the list is empty.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	public T removeLast() {

		if (this.isEmpty()) {

			throw new NoSuchElementException("The list is empty! Cannot remove the last element.");

		}

		if (this.size == 1) {

			return (this.removeFirst());

		}

		/* Keep track of the node before the tail so the tail can be detached. */
		Node<T> previous = this.head;
		Node<T> current = this.head.next;

		while (current.next != null) {

			previous = current;
			current = current.next;

		}

		previous.next = null;
		this.size--;

		return (current.data);

	}

	/**
	 * Returns the value stored at the requested position.
	 * 
	 * @param index The zero-based position to access.
	 * @return T => the value stored at the requested position.
	 * 
	 * @throws IndexOutOfBoundsException if the index is invalid.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	public T get(int index) {

		/* Validate the index before walking through the list. */
		Node<T> target = this.nodeAt(index);

		return (target.data);

	}

	/**
	 * Finds the first index where the requested value appears.
	 * 
	 * @param value The value to search for.
	 * @return int => the index of the first match, or -1 if not found.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	public int indexOf(T value) {

		/* Search linearly from the front because the list does not support random access. */
		Node<T> current = this.head;
		int index = 0;

		while (current != null) {

			if (Objects.equals(current.data, value)) {

				return (index);

			}

			current = current.next;
			index++;

		}

		return (-1);

	}

	/**
	 * Removes and returns the value at the requested position.
	 * 
	 * @param index The zero-based position to remove.
	 * @return T => the removed value.
	 * 
	 * @throws IndexOutOfBoundsException if the index is invalid.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	public T removeAt(int index) {

		if (index == 0) {

			return (this.removeFirst());

		}

		if (index == (this.size - 1)) {

			return (this.removeLast());

		}

		/* Find the node before the target so the link can be updated safely. */
		Node<T> previous = this.nodeAt(index - 1);
		Node<T> target = previous.next;
		previous.next = target.next;
		this.size--;

		return (target.data);

	}

	/**
	 * Locates the node stored at the requested index.
	 * 
	 * @param index The zero-based position to access.
	 * @return Node<T> => the node stored at the requested index.
	 * 
	 * @throws IndexOutOfBoundsException if the index is invalid.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	private Node<T> nodeAt(int index) {

		if ((index < 0) || (index >= this.size)) {

			throw new IndexOutOfBoundsException("Invalid index: " + index);

		}

		/* Walk forward until the requested position is reached. */
		Node<T> current = this.head;
		for (int i = 0; i < index; i++) {

			current = current.next;

		}

		return (current);

	}

	/**
	 * Returns the last node of the list.
	 * 
	 * @return Node<T> => the last node in the list.
	 * 
	 * @throws NoSuchElementException if the list is empty.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	private Node<T> lastNode() {

		if (this.isEmpty()) {

			throw new NoSuchElementException("The list is empty! Cannot access the last node.");

		}

		/* Traverse once until the tail is found. */
		Node<T> current = this.head;
		while (current.next != null) {

			current = current.next;

		}

		return (current);

	}

	/**
	 * Reverses a chain of nodes and returns the new front node.
	 * 
	 * @param start The first node in the chain to reverse.
	 * @return Node<T> => the new front node of the reversed chain.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	private Node<T> reverseNodes(Node<T> start) {

		/* This is the standard three-pointer reversal pattern applied to a sublist. */
		Node<T> previous = null;
		Node<T> current = start;

		while (current != null) {

			Node<T> next = current.next;
			current.next = previous;
			previous = current;
			current = next;

		}

		return (previous);

	}

	/**
	 * Reverses the list in place.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	public void reverse() {

		/* This is the standard three-pointer reversal pattern. */
		Node<T> previous = null;
		Node<T> current = this.head;

		while (current != null) {

			/* Save the next link before rewiring the current node. */
			Node<T> next = current.next;
			current.next = previous;
			previous = current;
			current = next;

		}

		this.head = previous;

	}

	/**
	 * Checks whether the list reads the same from left to right and right to left.
	 * 
	 * @return boolean => true if the list is a palindrome, false otherwise.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	public boolean isPalindrome() {

		if (this.size < 2) {

			/* Empty lists and single-element lists are palindromes by definition. */
			return (true);

		}

		/* Use the fast and slow pointer strategy to find the middle of the list. */
		Node<T> slow = this.head;
		Node<T> fast = this.head;
		Node<T> previousSlow = null;

		while ((fast != null) && (fast.next != null)) {

			previousSlow = slow;
			slow = slow.next;
			fast = fast.next.next;

		}

		Node<T> middleNode = null;
		Node<T> secondHalfStart;

		if (fast != null) {

			/* Odd-length lists keep the middle element out of the comparison. */
			middleNode = slow;
			secondHalfStart = slow.next;

		} else {

			secondHalfStart = slow;

		}

		/* Reverse only the second half, then compare it against the first half. */
		Node<T> reversedSecondHalf = this.reverseNodes(secondHalfStart);

		if (middleNode != null) {

			middleNode.next = reversedSecondHalf;

		} else {

			previousSlow.next = reversedSecondHalf;

		}

		Node<T> firstPointer = this.head;
		Node<T> secondPointer = reversedSecondHalf;
		boolean palindrome = true;

		while (secondPointer != null) {

			/* Compare the mirrored positions one pair at a time. */
			if (!Objects.equals(firstPointer.data, secondPointer.data)) {

				palindrome = false;
				break;

			}

			firstPointer = firstPointer.next;
			secondPointer = secondPointer.next;

		}

		Node<T> restoredSecondHalf = this.reverseNodes(reversedSecondHalf);

		if (middleNode != null) {

			middleNode.next = restoredSecondHalf;

		} else {

			previousSlow.next = restoredSecondHalf;

		}

		return (palindrome);

	}

	/**
	 * Appends a shared suffix to the current list by reusing the suffix nodes.
	 * 
	 * This helper is package-private so the demo can build a merge point without
	 * exposing node details as part of the public API.
	 * 
	 * @param suffix The list whose nodes will be shared as the suffix.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
    void appendSharedSuffix(SinglyLinkedList<T> suffix) {

		if ((suffix == null) || (suffix.isEmpty())) {

			return;

		}

		if (this.isEmpty()) {

			this.head = suffix.head;
			this.size = suffix.size;

			return;

		}

		/* Move to the current tail and attach the shared suffix there. */
		Node<T> current = this.head;
		while (current.next != null) {

			current = current.next;

		}

		current.next = suffix.head;
		this.size += suffix.size;

	}

	/**
	 * Returns the first node of the list.
	 * 
	 * @return Node<T> => the current head node.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	Node<T> getFrontNode() {

		/* Helper algorithms use this to inspect the current front node. */
		return (this.head);

	}

	/**
	 * Updates the first node of the list.
	 * 
	 * @param node The node that should become the new head.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	void setFrontNode(Node<T> node) {

		/* Algorithm helpers call this after rearranging the node order. */
		this.head = node;

	}

	/**
	 * Returns a string representation of the list contents.
	 * 
	 * @return String => the formatted list values.
	 * 
	 * @since 14/10/2024
	 * @version 1.0
	 * @author Anastasis Zachariou
	 */
	@Override
	public String toString() {

		/* Build a compact view that is easy to print in the demo class. */
		StringBuilder builder = new StringBuilder("[");
		Node<T> current = this.head;

		while (current != null) {

			builder.append(current.data);
			current = current.next;

			if (current != null) {

				builder.append(", ");

			}

		}

		builder.append("]");

		return (builder.toString());

	}
    
}