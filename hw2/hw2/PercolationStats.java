package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] threshold;
    private int numOfExperiment;

    /** perform T independent experiments on an N-by-N grid.
     *
     * @param N: N-by-N size;
     * @param T: Compute T times. (or another Percolation object);
     * **/
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0)
            throw new java.lang.IllegalArgumentException();
        Percolation p = new Percolation(N);
        this.threshold = new double[T];
        this.numOfExperiment = T;
        for (int i = 0; i < T; i++) {
            while (! p.percolates())
                p.open(StdRandom.uniform(N), StdRandom.uniform(N));
            this.threshold[i] = (double) p.numberOfOpenSites() / N*N;
        }
    }


    /** sample mean of percolation threshold. */
    public double mean() {
        return StdStats.mean(threshold);
    }


    /** sample standard deviation of percolation threshold. **/
    public double stddev() {
        return StdStats.stddev(threshold);
    }


    /** low endpoint of 95% confidence interval. */
    public double confidentLow() {
        return mean() - 1.96 * Math.sqrt(stddev()) / Math.sqrt(numOfExperiment) ;
    }


    /** high endpoint of 95% confidence interval. **/
    public double confidentHigh() {
        return mean() + 1.96 * Math.sqrt(stddev()) / Math.sqrt(numOfExperiment);
    }


}
