import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PercolationTest {
    private static final int SIZE = 4;
    private Percolation grid;

    @Before
    public void setup() {
        grid = new Percolation(SIZE);
    }

    @Test
    public void shouldHaveAllClosedSites() {
        assertFalse(grid.isOpen(1, 1));
    }

    @Test
    public void shouldNotBeFullIfNotOpenSite() {
        assertFalse(grid.isFull(1, 1));
    }

    @Test
    public void shouldHaveFullSites() {
        grid.open(1, 1);
        grid.open(2, 1);
        grid.open(3, 1);
        grid.open(4, 1);
        assertTrue(grid.isFull(4, 1));
    }

    @Test
    public void shouldOpenASite() {
        grid.open(1, 1);
        assertTrue(grid.isOpen(1, 1));
        grid.open(1, 2);
        assertTrue(grid.isOpen(1, 2));
    }

    @Test
    public void shouldPercolateLinear() {
        grid.open(1, 1);
        grid.open(2, 1);
        grid.open(3, 1);
        grid.open(4, 1);
        assertTrue(grid.percolates());
    }

    @Test
    public void shouldPercolateSidePath() {
        grid.open(1, 1);
        grid.open(2, 1);
        grid.open(2, 2);
        grid.open(3, 2);
        grid.open(4, 2);
        assertTrue(grid.percolates());
    }
}