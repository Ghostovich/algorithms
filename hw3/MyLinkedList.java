import java.util.ArrayDeque;
import java.util.Deque;

public class MyLinkedList {

    /**
     * Реализовать следующие методы
     * 1. public int size() - получить размер списка
     * 2. public boolean contains(int value) - проверить наличие элемента в списке
     * 3.* public MyLinkedList reversed() - создать НОВЫЙ список с обратным порядком
     * 4.** Заменить все int значения на дженерик T
     * 5.* Любые другие доработки, которые захотите для тренировки
     */

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    public int add(int value) {
        int count = 0;
        if (head == null) {
            head = new Node(value);
            count += 1;
        } else {
            Node last = findLast();
            last.next = new Node(value);
            count += 1;
        }
        return count;
    }

    public void size(int count) {
        System.out.println(count);
    }

    public int getFirst() {
        return get(0);
    }

    public int get(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException(index);
        }

        Node current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        if (currentIndex == index && current != null) {
            return current.value;
        }
        throw new IndexOutOfBoundsException(index);
    }

    public int popFirst() {
        return pop(0);
    }

    public int pop(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index == 0) {
            int pop = head.value;
            head = head.next;
            return pop;
        }

        Node previous = head; // предыдущая от искомой
        int currentIndex = 1;
        while (previous.next != null) {
            if (currentIndex == index) {
                int pop = previous.next.value;
                previous.next = previous.next.next;
                return pop;
            }

            previous = previous.next;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException(index);
    }

    public MyLinkedList reversed() {
        MyLinkedList reversed = new MyLinkedList();
        if (head == null) {
            return reversed;
        }
        addReversedRecursive(head, reversed);
        return reversed;
    }

    private void addReversedRecursive(Node current, MyLinkedList result) {
        if (current.next != null) {
            addReversedRecursive(current.next, result);
        }
        result.add(current.value);
    }

    private Node findLast() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            result.append(current.value).append(" -> ");
            current = current.next;
        }

        int length = result.length();
        if (length > 4) {
            result.delete(length - 4, length);
        }

        result.append("]");
        return result.toString();
    }

    public void contains() {
        // if (value) {
        // System.out.println("True");
        // } else {
        // System.out.println("False");
        // }

        // проверить наличие элемента в списке

        // int indexM = myLinkedList.indexOf(value);

        // if(indexM == - 1) {
        // System.out.println("False");
        // } else {
        // System.out.println("True");
        // }
    }

}
