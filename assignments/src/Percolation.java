import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF grid;
    private boolean[][] openSites;
    private int gridExtent;
    private int topIndex;
    private int bottomIndex;
    private int arraySizeIndex;
    private int gridN;

    /**
     * Initializes grid, with all sites blocked
     *
     * @param n-by-n the size of the grid (square)
     */
    public Percolation(int n) {

        int arraySize = n * n;
        arraySizeIndex = arraySize - 1;
        int connectors = 2;
        topIndex = arraySizeIndex + 1;
        bottomIndex = arraySizeIndex + 2;
        gridN = n;

        if (n < 0) throw new java.lang.IllegalArgumentException("Grid size must be positive");

        grid = new WeightedQuickUnionUF(arraySize + connectors);
        // connects bottom row and top row to single site
        for (int i = 0; i < n; i++) {
            // connect top row
            grid.union(topIndex, i);
            // connect bottom row
            grid.union(bottomIndex, (arraySize - 1) - i);
        }
        // Initiates sites to false
        openSites = new boolean[n][n];
    }

    /**
     * open site (row, col) if it is not open already.
     *
     * @param row
     * @param col
     */
    public void open(int row, int col) {
        int siteIndex = decodeNum(row, col);
        // connects site to adjacent 5 sites
        openSites[row - 1][col - 1] = true;

        // up
        if (row - 1 >= 1 && isOpen(row - 1, col)) {
            grid.union(decodeNum(row - 1, col), siteIndex);
        }
        // down
        if (row + 1 <= gridN && isOpen(row + 1, col)) {
            grid.union(decodeNum(row + 1, col), siteIndex);
        }
        // left
        if (col - 1 >= 1 && isOpen(row, col - 1)) {
            grid.union(decodeNum(row, col - 1), siteIndex);
        }
        // right
        if (col + 1 <= gridN && isOpen(row, col + 1)) {
            grid.union(decodeNum(row, col + 1), siteIndex);
        }
    }

    /**
     * Determines if site is open
     * NOTE: row and col are not indices
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col)  // is site (row, col) open?
    {
        return openSites[row - 1][col - 1];
    }

    /**
     * Determines if site is full
     * NOTE: row and col are not indices
     * @param row
     * @param col
     * @return
     */
    public boolean isFull(int row, int col)  // is site (row, col) full?
    {
        if (!isOpen(row, col)) {
           return false;
        }
        int index = decodeNum(row, col);
        return grid.connected(topIndex, index);
    }

    /**
     * Determines if the grid will percolate
     *
     * @return
     */
    public boolean percolates() {
        if (gridN == 1 && !isOpen(1,1)) return false;
        return grid.connected(topIndex, bottomIndex);
    }

    public static void main(String[] args) {
    }

    /**
     * Converts row/col to array index
     *
     * @param row
     * @param col
     */
    private int decodeNum(int row, int col) {
        return (row == 1) ? col - 1 : (((row - 1) * gridN) + col - 1);
    }
}
