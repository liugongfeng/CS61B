package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] status;
    private int N;
    private int numOfOpenSites;
    private WeightedQuickUnionUF WQU;
    private WeightedQuickUnionUF noBackWashWQU;


    /**  create N-by-N grid, with all sites initial blocked. */
    public Percolation(int N) {
        if (N < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.status = new boolean[N][N];
        this.N = N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                this.status[i][j] = false;
            }
        }
        this.numOfOpenSites = 0;
        this.WQU = new WeightedQuickUnionUF(N * N + 2);          // two virtual node: top and down.
        this.noBackWashWQU = new WeightedQuickUnionUF(N * N + 1);    // one virtual node: top.
    }

    private int xyTo1D(int r, int c) {
        return r * N + c;
    }

    /**  open the site(row,col) if it is not open already.**/
    public void open(int row, int col) {
        if (row < 0 || row > N-1 || col < 0 || col > N - 1)
            throw new IndexOutOfBoundsException();
        if (status[row][col])  return;     // if opened already.
        else {
            status[row][col] = true;
            numOfOpenSites++;
            /** First line. **/
            if (row == 0) {
                WQU.union(xyTo1D(row, col), N * N);
                noBackWashWQU.union(xyTo1D(row, col), N * N);
            }
            /** ATTENTION: noBackWashWQU do not need union last line.
             * Last line. ↓ **/
            if (row == N - 1) {
                WQU.union(xyTo1D(row, col), N * N + 1);
            }
        }

        /** if any left, right, up and down site is open, then union together. ↓ */
        /** union Right site.**/
        if (col + 1 < N  &&  isOpen(row, col + 1) ) {
            WQU.union(xyTo1D(row, col), xyTo1D(row, col+1));
            noBackWashWQU.union(xyTo1D(row, col), xyTo1D(row, col+1));
        }

        /** union Left site. **/
        if (col - 1 >= 0 &&  isOpen(row, col - 1)) {
            WQU.union(xyTo1D(row, col), xyTo1D(row, col-1));
            noBackWashWQU.union(xyTo1D(row, col), xyTo1D(row, col-1));
        }

        /** union Down site. **/
        if (row + 1 < N  &&  isOpen(row + 1, col)) {
            WQU.union(xyTo1D(row, col), xyTo1D(row + 1, col));
            noBackWashWQU.union(xyTo1D(row + 1, col), xyTo1D(row, col));
        }

        /** union Up site. */
        if (row - 1 >= 0  &&  isOpen(row - 1, col)) {
            WQU.union(xyTo1D(row, col), xyTo1D(row - 1, col));
            noBackWashWQU.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        }
    }


    /** Is the site(row,col) open ? **/
    public boolean isOpen(int row, int col) {
        if (row < 0 || row > N - 1 || col < 0 || col > N - 1)
            throw new IndexOutOfBoundsException();
        return status[row][col];
    }


    /**  Is the site(row,col) full of water? (or connected to top.)  **/
    public boolean isFull(int row, int col) {
        if (row < 0 || row > N - 1 || col < 0 || col > N - 1)
            throw new IndexOutOfBoundsException();
        else
            return noBackWashWQU.connected(N * N, xyTo1D(row, col));
    }


    /**  number of open sites. */
    public int numberOfOpenSites() {
        return numOfOpenSites;
    }


    /**  does the system percolate ?  */
    public boolean percolates() {
        return WQU.connected(N * N, N * N + 1);
    }


    public static void main(String[] args) {

    }



}
