package List;

/*
 * Класс двухсвязного списка
 */
public class LinkedList {
    private Node head;  // Голова
    private Node tail;  // Хвост

    /*
        Разворот списка
    */
    public void revert() {
        Node current = head;
        while (current != null) {
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        }
        current = head;
        head = tail;
        tail = current;
    }

    /*
        Вывод списка на печать
    */
    public void print() {
        Node current = head;
        if (head == null)
            System.out.println("List is empty");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }



    /*
        Добавление в начало списка
    */
    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        node.prev = null;
        if (head == null) {
            head = tail = node;
        }
        head.prev = node;
        head = node;
    }

    /*
        Удаление начального узла списка
    */
    public void removeFirst() {
        if (head != null && head.next != null) {
            head.next.prev = null;
            head = head.next;
        } else {
            head = tail = null;
        }
    }

    /*
        Добавление в конец списка
    */
    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        node.next = null;
        node.prev = tail;
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    /*
        Удаление конечного узла списка
     */
    public void removeLast() {
        if (tail == null)
            return;

        if (tail.prev == null) {
            head = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }
    }

    /*
        Проверка содержания в списке значения
    */
    public boolean contains(int searchValue) {
        Node node = head;
        while (node != null) {
            if (node.value == searchValue)
                return true;
            node = node.next;
        }
        return false;
    }

    public void sort() {

    }

    /*
            Внутренний класс узла списка
    */
    private class Node {
        int value;  // Значение
        Node next;  // Ссылка на следующий узел
        Node prev;  // Ссылка на предыдущий узел
    }
}

