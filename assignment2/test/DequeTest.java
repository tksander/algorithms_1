import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by tommysander on 12/21/16.
 */
public class DequeTest {
    private Deque<Integer> deque;

    @Before
    public void setUp() throws Exception {
        deque = new Deque<Integer>();
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        Integer aNumber = Integer.valueOf(3);
        assertSame("should be same", deque.size(), aNumber);
    }


    @Test
    public void testAddFirst() throws Exception {
        deque.addFirst(1);
        Integer first = deque.removeFirst();
        assertSame("should be same", 1, first);
    }

    @Test
    public void testAddLast() throws Exception {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        Integer last = deque.removeLast();
        assertSame("should be same", 3, last);
    }

    @Test
    public void testRemoveFirst() throws Exception {
        deque.addFirst(1);
        deque.addFirst(2);
        Integer first = deque.removeFirst();
        assertSame("should be same", 2, first);
    }

    @Test
    public void testRemoveLast() throws Exception {
        deque.addLast(1);
        Integer last = deque.removeLast();
        assertSame("should be same", 1, last);
    }

    @Test
    public void testIterator() throws Exception {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        Iterator<Integer> it = deque.iterator();
        assertTrue(it.hasNext());
        it.next();
        it.next();
        Integer thirdItem = it.next();
        assertSame("should be same", 3, thirdItem);

    }
}