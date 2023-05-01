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
