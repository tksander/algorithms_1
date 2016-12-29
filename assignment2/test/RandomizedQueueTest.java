import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by tommysander on 12/24/16.
 */
public class RandomizedQueueTest {
    private RandomizedQueue<Integer> queue;


    @Before
    public void setUp() throws Exception {
        queue = new RandomizedQueue<Integer>();
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        int size = queue.size();
        assertSame(size, 3);
    }

    @Test
    public void testEnqueue() throws Exception {

    }

    @Test
    public void testDequeue() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        int item = queue.dequeue();
        System.out.println(item);
        assertNotSame(item, 1);
        assertSame(queue.size(), 4);
    }

    @Test
    public void testSample() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        int item = queue.sample();
        System.out.println(item);
        assertNotSame(item, 1);
    }

    @Test
    public void testIterator() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        Iterator<Integer> it = queue.iterator();
        Iterator<Integer> it2 = queue.iterator();
        assertTrue(it.hasNext());
        assertTrue(it2.hasNext());
        int itItem = it.next();
        int itItem2 = it2.next();
        assertNotSame(itItem, itItem2);
    }
}