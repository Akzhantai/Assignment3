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