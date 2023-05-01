import java.util.EmptyStackException;

public class MyArrayListStack<T> {
        private MyArrayList<T> stack;
        public MyArrayListStack() {
            stack = new MyArrayList<>();
        }
    public void push(T element) {
        stack.add(element);
    }
    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    public T peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getFirst();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public int size() {
        return stack.size();
    }
}