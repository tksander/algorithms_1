import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom.*;

/**
 * Created by tommysander on 12/12/16.
 * The order of two or more iterators to the same randomized queue must be mutually independent; each iterator must maintain its own random order.
 * Throw a java.lang.NullPointerException if the client attempts to add a null item;
 * throw a java.util.NoSuchElementException if the client attempts to sample or dequeue an item from an empty randomized queue;
 * throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator;
 * throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.
 */

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int size;

    /**
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
        queue = (Item[]) new Object[2];
        size = 0;
    }

    /**
     * is the queue empty?
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the number of items on the queue
     */
    public int size() {
        return size;
    }

    /**
     * add the item
     */
    public void enqueue(Item item) {
        if (size == queue.length) { this.resize(2 * queue.length);}
        // Shuffle on each enqueu
        // Uses Knuth shuffle with O(n())
            queue[size++] = item;
        StdRandom.shuffle(queue);
    }

    /**
     * remove and return a random item
     */
    public Item dequeue() {
        if(this.isEmpty()) { throw new java.util.NoSuchElementException("No items in queue");}
        // shrink size of array if necessary
    }

    /**
     *  return (but do not remove) a random item
     */
    public Item sample() {
    }

    /**
     *  return an independent iterator over items in random order
     */
    public Iterator<Item> iterator() {
    }

    /**
     * unit testing
     */
    public static void main(String[] args) {
    }
    private void resize(int capacity) {
       Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }
}

