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