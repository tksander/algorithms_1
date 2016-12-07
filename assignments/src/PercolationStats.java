import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by tommysander on 12/3/16.
 */
public class PercolationStats {
    private double mean;
    private double stddev;
    private double confidenceLo;
    private double confidenceHi;

    /**
     * perform trials independent experiments on an n-by-n grid
     *
     * @param n
     * @param trials
     * @throws IndexOutOfBoundsException unless {@code 0 <= p < n}
     */
    public PercolationStats(int n, int trials) {
        double[] thresholds = new double[trials];

        if (n < 0) throw new java.lang.IllegalArgumentException("n must be greater than 0");
        if (trials < 0) throw new java.lang.IllegalArgumentException("There must be at least one trial");

        for (int trial = 0; trial < trials; trial++) {
            Percolation grid = new Percolation(n);

            int col;
            int row;
            int runs = 0;

            while (!grid.percolates()) {
                do {
                    col = StdRandom.uniform(1, n);
                    row = StdRandom.uniform(1, n);
                    System.out.println("col: " + col);
                    System.out.println("row: " + row);
                    System.out.println("check: " + grid.isOpen(row, col));

                } while (!grid.isOpen(row, col));
                System.out.println("WE OPENING MOTHA");
                grid.open(row, col);
                runs++;
            }

           double percolationThreslhold = runs / (double) (n * n);
            thresholds[trial] = percolationThreslhold;
        }
        mean = StdStats.mean(thresholds);
        stddev = StdStats.stddev(thresholds);
        confidenceLo = mean - (1.96 * stddev / Math.sqrt(trials));
        confidenceHi = mean + (1.96 * stddev / Math.sqrt(trials));
    }

    /**
     * sample mean of percolation threshold
     */
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return confidenceHi;
    }

    // test client (described below)
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int t = StdIn.readInt();
        PercolationStats stats = new PercolationStats(n, t);

        System.out.println("Mean                    = " + stats.mean());
        System.out.println("Standard Deviation      = " + stats.stddev());
        System.out.println("95% Confidence Interval = " + stats.confidenceLo() + "," + stats.confidenceHi());
    }
}
