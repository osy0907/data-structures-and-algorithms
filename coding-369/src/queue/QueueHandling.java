package queue;

import java.util.ArrayList;
import java.util.Scanner;

public class QueueHandling<T> {
    protected ArrayList<T> queue = new ArrayList<>();

    public static void main(String[] args) {
        QueueHandling<Integer> queueHandling = new QueueHandling<>();
        queueHandling.enqueue(getNextInt());
        queueHandling.enqueue(getNextInt());
        queueHandling.enqueue(getNextInt());
        System.out.println(queueHandling.dequeue());
        System.out.println(queueHandling.dequeue());
        System.out.println(queueHandling.dequeue());
    }

    private static int getNextInt() {
        return new Scanner(System.in).nextInt();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (this.isEmpty())
            return null;
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
