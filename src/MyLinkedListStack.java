import java.util.EmptyStackException;


public class MyLinkedListStack<T> {
    private MyLinkedList<T> stack;

    public MyLinkedListStack() {
        stack = new MyLinkedList<>();
    }

    public void push(T element) {
        stack.addFirst(element);
    }
    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
}