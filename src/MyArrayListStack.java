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