package data.structures.stack;

import java.util.ArrayList;

public class StackHandling<T> {
    protected ArrayList<T> stack = new ArrayList<>();

    public static void main(String[] args) {
        StackHandling<Integer> StackHandling = new StackHandling<>();
        StackHandling.push(1);
        StackHandling.push(2);
        System.out.println(StackHandling.pop());
        StackHandling.push(3);
        System.out.println(StackHandling.pop());
        System.out.println(StackHandling.pop());
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (this.isEmpty())
            return null;
        return stack.remove(stack.size() - 1);
    }

    private boolean isEmpty() {
        return stack.isEmpty();
    }
}
