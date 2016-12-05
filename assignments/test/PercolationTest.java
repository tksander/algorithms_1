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
        assertFalse(grid.isOpen(0,0));
    }

    @Test
    public void shouldNotHaveOpenSites() {
        assertTrue(grid.isFull(0,0));
    }

    @Test
    public void shouldOpenASite() {
        grid.open(0,0);
        assertTrue(grid.isOpen(0,0));
        grid.open(0,1);
        assertTrue(grid.isOpen(0,1));
    }

    @Test
    public void shouldPercolateLinear() {
        grid.open(0,0);
        grid.open(1,0);
        grid.open(2,0);
        grid.open(3,0);
        assertTrue(grid.percolates());
    }

    @Test
    public void shouldPercolateSidePath() {
        grid.open(0,0);
        grid.open(1,0);
        grid.open(1,1);
        grid.open(2,1);
        grid.open(3,1);
        assertTrue(grid.percolates());
    }
}