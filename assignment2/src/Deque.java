import java.util.Iterator;

/**
 * Created by tommysander on 12/12/16.
 * Implments a doubly-linked list to enable O(n(1)) removal of last node
 *
 * - Throw a java.lang.NullPointerException if the client attempts to add a null item;
 * - Throw a java.util.NoSuchElementException if the client attempts to remove an item from an empty deque;
 * - Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator;
 * - Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int numberItems;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    /**
     * Construct an empty deque
     */
    public Deque() {
        first = null;
        last = null;
    }

    /**
     * Determines if Deque is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of items on the deque
     *
     * @return int
     */
    public int size() {
        return numberItems;
    }

    /**
     * Add the item to the front
     *
     * @param item
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("Cannot add null item");
        }
        Node newFirst = new Node();
        newFirst.prev = null;
        newFirst.item = item;

        if (this.isEmpty()) {
            newFirst.next = null;
            last = newFirst;
        } else {
            newFirst.next = first;
            first.prev = newFirst;
        }
        first = newFirst;
        numberItems++;
    }

    /**
     * Add the item to the end
     *
     * @param item
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("Cannot add null item");
        }
        Node newLast = new Node();
        newLast.next = null;
        newLast.item = item;

        if (this.isEmpty()) {
           newLast.prev = null;
            first = newLast;
        } else {
            newLast.prev = last;
            last.next = newLast;
        }

        last = newLast;
        numberItems++;
    }

    /**
     * remove and return the item from the front
     *
     * @return
     */
    public Item removeFirst() {
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException("No elements in Deque, cannot remove");
        }
        Node oldFirst = first;
        first = oldFirst.next;
        first.prev = null;
        numberItems--;
        return oldFirst.item;
    }

    /**
     * remove and return the item from the end
     *
     * @return
     */
    public Item removeLast() {
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException("No elements in Deque, cannot remove");
        }
        Item lastItem = last.item;
        Node oldLast = last;
        last.prev = last;
        last.next = null;
        oldLast = null;
        return lastItem;
    }

    /**
     * return an iterator over items in order from front to end
     *
     * @return
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {}

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * unit testing
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
