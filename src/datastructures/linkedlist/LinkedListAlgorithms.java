package datastructures.linkedlist;

public final class LinkedListAlgorithms {

	/**
	 * Prevents instantiation because this class only groups algorithms.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	private LinkedListAlgorithms() {
	}

	/**
	 * Reorders the list so that all even numbers appear before all odd numbers.
	 * 
	 * @param list The list that will be rearranged.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	public static void evenBeforeOdd(SinglyLinkedList<Integer> list) {

		if ((list == null) || (list.isEmpty())) {

			// There is nothing to reorder in a null or empty list.
			return;

		}

		/* Split the original nodes into two stable chains and join them at the end. */
		SinglyLinkedList.Node<Integer> current = list.getFrontNode();
		SinglyLinkedList.Node<Integer> evenHead = null;
		SinglyLinkedList.Node<Integer> evenTail = null;
		SinglyLinkedList.Node<Integer> oddHead = null;
		SinglyLinkedList.Node<Integer> oddTail = null;

		while (current != null) {

			SinglyLinkedList.Node<Integer> next = current.getNext();
			// Detach the node before moving it into one of the chains.
			current.setNext(null);

			if (current.getData() % 2 == 0) {

				// Even values are grouped in the first chain.
				if (evenHead == null) {

					evenHead = current;
					evenTail = current;

				} else {

					evenTail.setNext(current);
					evenTail = current;

				}
			} else {

				// Odd values are grouped in the second chain.
				if (oddHead == null) {

					oddHead = current;
					oddTail = current;

				} else {

					oddTail.setNext(current);
					oddTail = current;

				}

			}

			current = next;

		}

		if (evenTail != null) {

			// Connect the even chain to the odd chain.
			evenTail.setNext(oddHead);
			list.setFrontNode(evenHead);

		} else {

			// If there are no even values, the odd chain becomes the whole list.
			list.setFrontNode(oddHead);

		}

	}

	/**
	 * Reorders the list so that even numbers move in front of odd numbers without extra storage.
	 * 
	 * @param list The list that will be rearranged.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	public static void evenBeforeOdd2(SinglyLinkedList<Integer> list) {

		if ((list == null) || (list.isEmpty())) {

			// There is nothing to reorder in a null or empty list.
			return;

		}

		/* This version keeps the rearrangement linear by building two temporary chains. */
		SinglyLinkedList.Node<Integer> current = list.getFrontNode();
		SinglyLinkedList.Node<Integer> evenDummy = new SinglyLinkedList.Node<>(null, null);
		SinglyLinkedList.Node<Integer> oddDummy = new SinglyLinkedList.Node<>(null, null);
		SinglyLinkedList.Node<Integer> evenTail = evenDummy;
		SinglyLinkedList.Node<Integer> oddTail = oddDummy;

		while (current != null) {

			SinglyLinkedList.Node<Integer> next = current.getNext();
			current.setNext(null);

			if (current.getData() % 2 == 0) {

				/* Even values are kept in the first temporary chain. */
				evenTail.setNext(current);
				evenTail = current;

			} else {

				/* Odd values are kept in the second temporary chain. */
				oddTail.setNext(current);
				oddTail = current;

			}

			current = next;

		}

		if (evenDummy.getNext() != null) {

			evenTail.setNext(oddDummy.getNext());
			list.setFrontNode(evenDummy.getNext());

		} else {

			list.setFrontNode(oddDummy.getNext());

		}
        
	}

	/**
	 * Finds the first shared node between two lists, if one exists.
	 * 
	 * @param firstList The first list to compare.
	 * @param secondList The second list to compare.
	 * @return SinglyLinkedList.Node<Integer> => the shared node, or null when no merge point exists.
	 * 
	 * @since 2/7/2026
	 * @version 1.1
	 * @author Anastasis Zachariou
	 */
	public static SinglyLinkedList.Node<Integer> findMergePoint1(
		SinglyLinkedList<Integer> firstList,
		SinglyLinkedList<Integer> secondList) {

		if ((firstList == null) || (secondList == null)) {

			// A merge point cannot exist if one list reference is missing.
			return (null);

		}

		/* Measure both lists first so the longer one can be aligned with the shorter one. */
		SinglyLinkedList.Node<Integer> firstCurrent = firstList.getFrontNode();
		SinglyLinkedList.Node<Integer> secondCurrent = secondList.getFrontNode();

		int firstLength = 0;
		int secondLength = 0;

		while (firstCurrent != null) {

            // Count the first list one node at a time.
			firstLength++;
			firstCurrent = firstCurrent.getNext();
			
		}

		while (secondCurrent != null) {

			// Count the second list one node at a time.
			secondLength++;
			secondCurrent = secondCurrent.getNext();

		}

		firstCurrent = firstList.getFrontNode();
		secondCurrent = secondList.getFrontNode();

		if (firstLength > secondLength) {

			// Advance the longer list so both pointers have the same distance left.
			int difference = firstLength - secondLength;
			for (int i = 0; i < difference; i++) {

				firstCurrent = firstCurrent.getNext();

			}

		} else if (secondLength > firstLength) {

			// Advance the longer list so both pointers have the same distance left.
			int difference = secondLength - firstLength;
			for (int i = 0; i < difference; i++) {

				secondCurrent = secondCurrent.getNext();

			}

		}

		while (firstCurrent != null && secondCurrent != null) {

			// The first shared node is the merge point.
			if (firstCurrent == secondCurrent) {

				return (firstCurrent);

			}

			firstCurrent = firstCurrent.getNext();
			secondCurrent = secondCurrent.getNext();

		}

		return (null);

	}
    
}