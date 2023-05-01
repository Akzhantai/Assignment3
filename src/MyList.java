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
