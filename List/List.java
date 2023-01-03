package List;

public class List {

    private Node head;

    public void print() {
        Node current=head;
        if (head==null)
            System.out.println("List is empty");
        while(current!=null) {
            System.out.print(current.value+" ");
            current=current.next;
        }
        System.out.println();
    }

    public void revert() {
        if (head != null && head.next!=null) {
            Node temp=head;
            revert(head, head.next);
            temp.next=null;
        }
    }

    private void revert(Node curNode, Node nextNode) {
        if (nextNode.next == null) {
            nextNode.next=curNode;
            head=nextNode;
        } else {
            revert(nextNode,nextNode.next);
            nextNode.next=curNode;
        }

    }

    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public boolean contains(int searchValue) {
        Node node = head;
        while (node != null) {
            if (node.value == searchValue)
                return true;
            node = node.next;
        }
        return false;
    }

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        Node current = head;
        if (current == null) {
            head = node;
        } else {
            while (current.next != null)
                current = current.next;
            current.next = node;
        }

    }

    public void removeLast() {
        Node current = head;
        Node previous = head;

        if (current == null) {
            return;
        } else {
            while (current.next != null) {
                if (current.next.next == null) {
                    current.next = null;
                    return;
                }
                current = current.next;
            }
            head = null;

        }
    }

    public void add(int value) {

    }

    public int delete() {
        return 0;
    }


    private class Node {
        int value;
        Node next;
    }
}
