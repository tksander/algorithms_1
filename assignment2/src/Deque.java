/**
 * Created by tommysander on 12/12/16.
 * - Throw a java.lang.NullPointerException if the client attempts to add a null item;
 * - Throw a java.util.NoSuchElementException if the client attempts to remove an item from an empty deque;
 * - Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator;
 * - Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.
 */
public class Deque<Item> implements Iterable<Item> {

    /**
     * construct an empty deque
     */
    public Deque() {

    }

    /**
     * is the deque empty?
     *
     * @return
     */
    public boolean isEmpty() {

    }

    /**
     * return the number of items on the deque
     *
     * @return
     */
    public int size() {

    }

    /**
     * add the item to the front
     *
     * @param item
     */
    public void addFirst(Item item) {

    }

    /**
     * add the item to the end
     *
     * @param item
     */
    public void addLast(Item item) {

    }

    /**
     * remove and return the item from the front
     *
     * @return
     */
    public Item removeFirst() {

    }

    /**
     * remove and return the item from the end
     *
     * @return
     */
    public Item removeLast() {

    }

    /**
     * return an iterator over items in order from front to end
     *
     * @return
     */
    public Iterator<Item> iterator() {

    }

    /**
     * unit testing
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
