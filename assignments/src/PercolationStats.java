/**
 * Created by tommysander on 12/3/16.
 */
public class PercolationStats {

    /**
     *  perform trials independent experiments on an n-by-n grid
      * @param n
     * @param trials
     * @throws IndexOutOfBoundsException unless {@code 0 <= p < n}
     */
    public PercolationStats(int n, int trials) {
        /**
         * sample mean of percolation threshold
         */
        public double mean() {
            // todo
        }

        // sample standard deviation of percolation threshold
        public double stddev() {
            // todo
        }

        // low  endpoint of 95% confidence interval
        public double confidenceLo() {
            // todo
        }

        // high endpoint of 95% confidence interval
        public double confidenceHi() {
            // todo
        }

        // test client (described below)
        public static void main(String[] args) {
            // todo
            int N = StdIn.readInt();
            Percolation grid = new Percolation(N);
//            Also, include a main() method that takes two command-line
// arguments n and T, performs T independent computational experiments
// (discussed above) on an n-by-n grid, and prints the mean, standard deviation,
// and the 95% confidence interval for the percolation threshold. Use StdRandom
// to generate random numbers; use StdStats to compute the sample mean and standard deviation.


        }
}
