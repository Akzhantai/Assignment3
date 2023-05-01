import java.util.NoSuchElementException;
public class MyArrayListQueue<T>{
    private MyArrayList<T> queue;
    public MyArrayListQueue() {
        queue = new MyArrayList<>();
    }
    public void enqueue(T element) {
        queue.addLast(element);
    }public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

}
