package dz04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * • enqueue() — помещает элемент в конец очереди,
 * • dequeue() — возвращает первый элемент из очереди и удаляет его,
 * • first() — возвращает первый элемент из очереди, не удаляя.
 */
public class work02 {
    public static void enQueue(Queue<Integer> que) {
        Random random = new Random();
        que.add(random.nextInt(1, 100));
    }

    public static int deQueue(Queue<Integer> que) {
        return que.poll();
    }

    public static int first(Queue<Integer> que) {
        return que.peek();
    }

    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<Integer>();
        enQueue(que);
        enQueue(que);
        enQueue(que);
        enQueue(que);
        System.out.println("добавили несколько элементов в очередь: " + que);
        System.out.println("очередь после добавления: " + que);
        System.out.println("удалили элемент из очереди: " + deQueue(que));
        System.out.println("очередь после удаления: " + que);
        System.out.println("первый элемент в очереди: " + first(que));
    }
}
