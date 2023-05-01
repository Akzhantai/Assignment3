## Assignment3

## MyList Interface:
```
public interface MyList<T>{
    int size();
    // This method returns the number of elements in this list, i.e. list size.
    boolean contains(Object o);
    // This method is used to check whether the specific set of characters are part of the given list or not.
    void add(T item);
    // This method is used to add elements to the list.
    void add(T item, int index);
    // Inserts an element into the list at the given index.
    boolean remove(T item);
    T remove(int item);
    // Removes the element at the specified position in this list.
    void clear();
    // Removes all elements from the list.
    T get(int index);
    // Used to retrieve an element from a list.
    int indexOf(Object o);
    // This method returns the position of the first occurrence of specified character(s) in a list.
    int lastIndexOf(Object o);
    // This method to return the position of the last occurrence of specified character(s) in a list.
    void sort();
    // Method to sort the list.
    boolean isEmpty();
    // This method checks whether a list is empty or not.
    T getFirst();
    // Returns the first element of the current list.
    void addFirst(T element);
    // This method inserts the specified element at the beginning of the list.
    void addLast(T element);
    // This method inserts the specified element at the end of the list.
    T removeFirst();
    // Removes and returns the first element from the list.
}
```
From new I added isEmpty, getFirst, addFirst, addLast, removeFirst methods.

## MyArrayList Class:
```
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {

    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }
    // Constructor.
    @Override
    public int size() {
        return size;
    }
    // Returns the number of elements, size.
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
    // Checks whether a specified element is present in arraylist.
    @Override
    public void add(T item) {
        ensureCapacity(size + 1);
        elements[size] = item;
        size++;
    }
    // Adds a new element.
    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
    }
    // Adds new element at specified index.
    @Override
    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }
    //Removes the element.
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removed = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removed;
    }
    //Removes the element at the specified position.
    @Override
    public void clear() {
        elements = new Object[10];
        size = 0;
    }
    // Removes all elements.
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }
    // Returns an element at specified index.
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    // Returns the position of the first occurrence.
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    // Returns the position of the last occurrence.
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (((Comparable) elements[i]).compareTo(elements[j]) > 0) {
                    Object temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }
    // Sorts the list.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    // Checks whether a list is empty or not.
    @Override
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return (T) elements[0];
    }
    // Returns the first element.
    @Override
    public void addFirst(T item) {
        ensureCapacity(size + 1);
        for (int i = size; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = item;
        size++;
    }
    // Inserts the specified element at the beginning.
    @Override
    public void addLast(T item) {
        ensureCapacity(size + 1);
        elements[size] = item;
        size++;
    }
    // Inserts the specified element at the end.
    @Override
    public T removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T removed = (T) elements[0];
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removed;
    }
    // Removes and returns the first element.
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }
    // ensures that an array has enough capacity to hold a specified minimum number of elements.
    //  If the array does not have enough capacity, the method doubles its size.
}
```
My own ArrayList that I used to implement in this code.

## MyLinkedList Class:
```import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {

    private class Node {
        T element;
        // Stores the data of the node.
        Node next;
        // Stores a reference to the next node in the list.
        Node prev;
        // Stores a reference to the previous node in the list.
        public Node(T element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
        // Constructor.
    }

    private Node head;
    // Represent the first node in the list.
    private Node tail;
    // Represent the last node in the list.
    private int size;
    // Represent the number of elements in the list.
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    // Constructor.
    @Override
    public int size() {
        return size;
    }
    // Returns the number of elements, size.
    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.element.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    // Checks whether a specified element is present in arraylist.
    @Override
    public void add(T element) {
        Node newNode = new Node(element, null, tail);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }
    // Adds a new element.
    @Override
    public void add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
            return;
        }
        Node current = getNode(index);
        Node newNode = new Node(element, current, current.prev);
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }
    // Adds new element at specified index.
    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }
    //Removes the element.
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = getNode(index);
        if (node == head) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node == tail) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        size--;
        return node.element;
    }
    //Removes the element at the specified position.
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    // Removes all elements.
    @Override
    public T get(int index) {
        return getNode(index).element;
    }
    // Returns an element at specified index.
    @Override
    public int indexOf(Object o) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    // Returns the position of the first occurrence.
    @Override
    public int lastIndexOf(Object o) {
        Node current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }
    // Returns the position of the last occurrence.
    @Override
    public void sort() {
        // This implementation of sort is not efficient for linked lists,
        // so I'll just leave it unimplemented
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    // Checks whether a list is empty or not.
    @Override
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.element;
    }
    // Returns the first element.
    @Override
    public void addFirst(T element) {
        Node newNode = new Node(element, head, null);
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }
    // Inserts the specified element at the beginning.
    @Override
    public void addLast(T element) {
        Node newNode = new Node(element, null, tail);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }
    // Inserts the specified element at the end.
    @Override
    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T removedElement = head.element;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return removedElement;
    }
    // Removes and returns the first element.
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
    // Return the object at the specified index in the list.
}
```
My own LinkedList that I used to implement in this code.

## MyArrayListStack Class:
```
import java.util.EmptyStackException;

public class MyArrayListStack<T> {
        private MyArrayList<T> stack;
        //  Instance variable.
        public MyArrayListStack() {
            stack = new MyArrayList<>();
        }
        //Constructor.
    public void push(T element) {
        stack.add(element);
    }
    // Adds an element to the top of a stack.
    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    // Removes and returns the element at the top of a stack.
    public T peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getFirst();
    }
    // Returns the element at the top of a stack without removing it.
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    // Checks whether the stack data structure is empty or not.
    public int size() {
        return stack.size();
    }
    // returns the number of elements in the stack.
}
```
The code implements a stack data structure using an ArrayList as the underlying data storage mechanism. A stack is a data structure where elements are added and removed from only one end, typically referred to as the "top" of the stack.

The class is parameterized with type T, allowing for the stack to hold elements of any object type. The MyArrayListStack constructor creates a new MyArrayList object, which will be used to store the stack elements.

The push() method adds an element to the top of the stack by calling the add() method of the MyArrayList object.

The pop() method removes and returns the element at the top of the stack. If the stack is empty, an EmptyStackException is thrown.

The peek() method returns the element at the top of the stack without removing it. If the stack is empty, an EmptyStackException is thrown.

The isEmpty() method checks whether the stack is empty or not and returns a boolean value.

The size() method returns the number of elements currently in the stack.

Overall, this implementation of a stack using an ArrayList provides an efficient way to store and manipulate a collection of elements, while also providing the flexibility to handle elements of any object type.

## MyLinkedListStack Class:
```
import java.util.EmptyStackException;

public class MyLinkedListStack<T> {

    private MyLinkedList<T> stack;
    //  Instance variable.
    public MyLinkedListStack() {
        stack = new MyLinkedList<>();
    }
    //Constructor.
    public void push(T element) {
        stack.addFirst(element);
    }
    // Adds an element to the top of a stack.
    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    // Removes and returns the element at the top of a stack.
    public T peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getFirst();
    }
    // Returns the element at the top of a stack without removing it.
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    // Checks whether the stack is empty or not.
    public int size() {
        return stack.size();
    }
    // Returns the number of elements in the stack.
}
```
The code defines a stack data structure using a linked list as the underlying data storage mechanism. A stack is a data structure where elements are added and removed from only one end, typically referred to as the "top" of the stack.

The class is parameterized with type T, allowing for the stack to hold elements of any object type. The MyLinkedListStack constructor creates a new MyLinkedList object, which will be used to store the stack elements.

The push() method adds an element to the top of the stack by calling the addFirst() method of the MyLinkedList object.

The pop() method removes and returns the element at the top of the stack. If the stack is empty, an EmptyStackException is thrown.

The peek() method returns the element at the top of the stack without removing it. If the stack is empty, an EmptyStackException is thrown.

The isEmpty() method checks whether the stack is empty or not and returns a boolean value.

The size() method returns the number of elements currently in the stack.

Overall, this implementation of a stack using a linked list provides a flexible and efficient way to store and manipulate a collection of elements, while also providing the flexibility to handle elements of any object type. Linked lists allow for dynamic sizing, while also providing fast insertion and deletion of elements at the beginning of the list.

## MyArrayListQueue Class:
```
import java.util.NoSuchElementException;

public class MyArrayListQueue<T>{
    private MyArrayList<T> queue;
    // Instance variable.
    public MyArrayListQueue() {
        queue = new MyArrayList<>();
    }
    //Constructor.
    public void enqueue(T element) {
        queue.addLast(element);
    }
    // Adds an element to the end of the queue.
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removeFirst();
    }
    // Removes and returns the first element in the queue.
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.getFirst();
    }
    // Returns the first element in the queue.
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    // Checks whether the queue is empty or not.
    public int size() {
        return queue.size();
    }
    // Returns the number of elements in the queue.
}
```
The code implements a queue data structure using an ArrayList as the underlying data storage mechanism. A queue is a data structure where elements are added to one end (the "back" or "tail") and removed from the other end (the "front" or "head").

The class is parameterized with type T, allowing for the queue to hold elements of any object type. The MyArrayListQueue constructor creates a new MyArrayList object, which will be used to store the queue elements.

The enqueue() method adds an element to the end of the queue by calling the addLast() method of the MyArrayList object.

The dequeue() method removes and returns the first element in the queue. If the queue is empty, a NoSuchElementException is thrown.

The peek() method returns the first element in the queue without removing it. If the queue is empty, a NoSuchElementException is thrown.

The isEmpty() method checks whether the queue is empty or not and returns a boolean value.

The size() method returns the number of elements currently in the queue.

Overall, this implementation of a queue using an ArrayList provides an efficient way to store and manipulate a collection of elements, while also providing the flexibility to handle elements of any object type. However, it should be noted that when elements are removed from the beginning of the list, all subsequent elements must be shifted down to fill the gap, which can be inefficient for large lists.

## MyLinkedListQueue Class:
```
import java.util.NoSuchElementException;

public class MyLinkedListQueue<T> {
    private MyLinkedList<T> queue;
    // Instance variable.
    public MyLinkedListQueue() {
        queue = new MyLinkedList<>();
    }
    //Constructor.
    public void enqueue(T element) {
        queue.add(element);
    }
    // Adds an element to the end of the queue.
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removeFirst();
    }
    // Removes and returns the first element in the queue.
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.getFirst();
    }
    // Returns the first element in the queue.
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    // Checks whether the queue is empty or not.
    public int size() {
        return queue.size();
    }
    // Returns the number of elements in the queue.
}
```
The code implements a queue data structure using a linked list as the underlying data storage mechanism. A queue is a data structure where elements are added to one end (the "back" or "tail") and removed from the other end (the "front" or "head").

The class is parameterized with type T, allowing for the queue to hold elements of any object type. The MyLinkedListQueue constructor creates a new MyLinkedList object, which will be used to store the queue elements.

The enqueue() method adds an element to the end of the queue by calling the add() method of the MyLinkedList object.

The dequeue() method removes and returns the first element in the queue. If the queue is empty, a NoSuchElementException is thrown.

The peek() method returns the first element in the queue without removing it. If the queue is empty, a NoSuchElementException is thrown.

The isEmpty() method checks whether the queue is empty or not and returns a boolean value.

The size() method returns the number of elements currently in the queue.

Overall, this implementation of a queue using a linked list provides an efficient way to store and manipulate a collection of elements, while also allowing for elements to be added or removed from the queue without the need for expensive array operations. However, it should be noted that linked lists require more memory overhead than arrays due to the extra space required for each node, and traversal of the list can be slower than accessing elements in an array directly.
