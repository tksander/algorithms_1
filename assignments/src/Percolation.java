import edu.princeton.cs.algs4.*;

public class Percolation {
   private WeightedQuickUnionUF grid;
   private boolean[][] openSites;
   private int gridExtent;
   private int topIndex;
   private int bottomIndex;

    /**
     * Initializes grid, with all sites blocked
     * @param n-by-n the size of the grid (square)
     */
   public Percolation(int n)
   {
      int arraySize = n * n;
      int connectors = 2;
      int topIndex = arraySize  - 1 + 1;
      int bottomIndex = arraySize + 2;
      gridExtent = n - 1;

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
     * open site (row, col) if it is not open already
     * @param row
     * @param col
     */
   public void open(int row, int col)
   {
      int siteIndex = decodeNum(row, col);
      // connects site to adjacent 4 sites
      openSites[row][col] = true;

      // up
      if (row - 1 > 0 && isOpen(row - 1, col)) {
         grid.union(decodeNum(row - 1, col), siteIndex);
      }
      // down
      if (row + 1 < gridExtent && isOpen(row + 1, col)) {
         grid.union(decodeNum(row + 1, col), siteIndex);
      }
      // left
      if (col - 1 > 0 && isOpen(row, col - 1)) {
         grid.union(decodeNum(row - 1, col), siteIndex);
      }
      // right
      if (col + 1 < gridExtent && isOpen(row, col + 1)) {
         grid.union(decodeNum(row, col + 1), siteIndex);
      }
   }

    /**
     * Determines if site is open
     * @param row
     * @param col
     * @return
     */
   public boolean isOpen(int row, int col)  // is site (row, col) open?
   {
      return openSites[row][col];
   }

    /**
     * Determines if site is full
     * @param row
     * @param col
     * @return
     */
   public boolean isFull(int row, int col)  // is site (row, col) full?
   {
      return openSites[row][col];
   }

   /**
    *  Determines if the grid will percolate
    * @return
     */
   public boolean percolates() {
      return grid.connected(topIndex, bottomIndex);
   }
   
  // test client (optional)
   public static void main(String[] args) {

   }

   /**
    * Converts row/col to array index
    * @param row
    * @param col
    */
   private int decodeNum(int row, int col) {
      return (row == 0) ? col : ((row + 1) * col);
   }
}
