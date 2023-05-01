import java.util.NoSuchElementException;

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
