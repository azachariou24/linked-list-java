<div align="center">

# Singly Linked List in Java

### Generic linked list implementation and linked-list algorithms

**Java • Data Structures • Algorithms • Generics**

</div>

---

## Overview

This repository provides a generic implementation of a **Singly Linked List** in Java together with several linked-list algorithms.

The implementation focuses on clean object-oriented design, generic programming, and algorithmic correctness. In addition to the core linked list operations, the project includes several algorithms commonly studied in Data Structures and Algorithms courses.

The project was developed as part of my study of **Data Structures and Algorithms**, with emphasis on algorithmic correctness, clean object-oriented design, and code readability.

---

## Features

- Generic implementation using **Java Generics**
- Clean object-oriented design
- Core linked list operations
- Classical linked-list algorithms
- Separation between data structure and algorithms
- Demonstration program
- Well-documented source code

---

## Complexity Analysis

- **insertFirst()** → **O(1)**
- **insertLast()** → **O(n)**
- **insertSorted()** → **O(n)**
- **remove()** → **O(n)**
- **contains()** → **O(n)**
- **getFirst()** → **O(1)**
- **getLast()** → **O(n)**
- **peekFirst()** → **O(1)**
- **peekLast()** → **O(n)**
- **removeFirst()** → **O(1)**
- **removeLast()** → **O(n)**
- **get(index)** → **O(n)**
- **indexOf()** → **O(n)**
- **removeAt()** → **O(n)**
- **reverse()** → **O(n)**
- **isPalindrome()** → **O(n)**

---

## Implemented Algorithms

### Even Before Odd

Reorders the linked list so that all even values appear before odd values while preserving their relative order.

### Even Before Odd (In-Place)

Partitions the linked list by rearranging node links without creating additional list nodes.

### Merge Point Detection

Finds the first common node shared by two singly linked lists.

### Reverse Linked List

Reverses the linked list using the classical iterative three-pointer algorithm.

### Palindrome Detection

Determines whether a linked list is a palindrome while restoring the original list structure after the comparison.

---

## Project Structure

```text
src/
└── datastructures/
    └── linkedlist/
        ├── SinglyLinkedList.java
        ├── LinkedListAlgorithms.java
        └── Main.java
```

---

## Running the Project

Compile

```bash
javac src/datastructures/linkedlist/*.java
```

Run

```bash
java -cp src datastructures.linkedlist.Main
```

---

## Educational Objectives

This project demonstrates:

- Generic programming in Java
- Implementation of Abstract Data Types (ADTs)
- Pointer manipulation
- Dynamic memory organization
- Linked-list algorithm design
- Algorithm complexity analysis
- Object-oriented software design

---

## Future Improvements

Potential future extensions include:

- Doubly Linked List implementation
- Circular Linked List implementation
- Iterator support
- JUnit test suite
- Javadoc documentation
- Additional linked-list algorithms
- Performance benchmarking
- Maven/Gradle support

---

## License

This project is licensed under the **MIT License**.

---

<div align="center">

**Developed by Anastasis Zachariou**

</div>