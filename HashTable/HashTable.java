package HashTable;

public class HashTable {
    private Basket[] baskets;

    HashTable() {
        baskets = new Basket[10];
    }

    private int calculateBasketIndex(int key) {
        return ((Integer) key).hashCode() % baskets.length;
    }

    public Integer get(int key) {
        int index = calculateBasketIndex(key);
        Basket.Node current = baskets[index].head;
        while (current!=null) {
            if (current.entity.key.equals( key))
                return current.entity.value;
        }
        return null;
    }

    public boolean add(Entity entity) {
        return true;
    }

    public boolean remove(Integer key) {
        return true;
    }

    private class Basket {
        Node head;

        private class Node {
            Entity entity;
            Node next;
        }
    }

    private class Entity {
        Integer key;
        Integer value;
    }
}
