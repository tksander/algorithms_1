import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PercolationTest {
    private static final int SIZE = 4;
    private Percolation percolation;

    @Before
    public void setup() {
        percolation = new Percolation(SIZE);
    }

    @Test
    public void shouldHaveAllOpenSites() {
        assertFalse(percolation.isOpen(1,1));
    }
}