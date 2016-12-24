import java.util.Iterator;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdRandom.*;

/**
 * Created by tommysander on 12/12/16.
 * The order of two or more iterators to the same randomized queue must be mutually independent; each iterator must maintain its own random order.
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
        if (item == null) throw new java.lang.NullPointerException();
        if (size == queue.length) { this.resize(2 * queue.length);}
            queue[size++] = item;
    }

    /**
     * remove and return a random item
     */
    public Item dequeue() {
        if(this.isEmpty()) { throw new java.util.NoSuchElementException("No items in queue");}
        int randomIndex = StdRandom.uniform(size);
        Item temp = queue[randomIndex];
        queue[randomIndex] = queue[size - 1];
        queue[size - 1] = null;
        size--;
        // shrink size of array if necessary
        if (size > 0 && size < (queue.length / 4)) this.resize(queue.length / 2);
        return temp;
    }

    /**
     *  return (but do not remove) a random item
     */
    public Item sample() {
        if(this.isEmpty()) { throw new java.util.NoSuchElementException("No items in queue");}
        int index = StdRandom.uniform(0, size);
        return queue[index];
    }

    /**
     *  return an independent iterator over items in random order
     */
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int i;
        private int iteratorSize;
        private Item[] iteratorQueue;


        public void RadomizeQueueIterator() {
            iteratorQueue = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                iteratorQueue[i] = queue[i];
            }
            iteratorSize = size;
        }

        public boolean hasNext() {
            return i < iteratorSize;
        }
        public Item next() {
            if(!this.hasNext()) { throw new java.util.NoSuchElementException("No more items");}
            int randomIndex = StdRandom.uniform(iteratorSize);
            Item temp = iteratorQueue[randomIndex];
            iteratorQueue[randomIndex] = iteratorQueue[iteratorSize - 1];
            iteratorQueue[iteratorSize - 1] = null;
            iteratorSize--;
            return temp;
        }
        public void remove() {
            throw new java.lang.UnsupportedOperationException("Remove not available");
        }
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

