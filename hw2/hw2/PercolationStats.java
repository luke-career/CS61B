package hw2;

import edu.princeton.cs.introcs.StdStats;
import org.junit.Test;
import  edu.princeton.cs.introcs.StdRandom;

public class PercolationStats {

    private double mean;
    private double[] threshold;
    private double stddev;


    public PercolationStats(int N, int T, PercolationFactory pf){
        threshold  = new double[T];
        for(int i = 0; i < T; i++){
            Percolation p = pf.make(N);
            while(!p.percolates()){
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                p.open(row,col);
            }
            int num =  p.numberOfOpenSites();
            threshold[i] =(double) num / (N * N);
        }
        mean  = StdStats.mean(threshold);
        stddev = StdStats.stddev(threshold);
    }

    public double mean(){
        return mean;
    }

    public double stddev(){
        return stddev;
    }

    public double confidenceLow(){
        return  mean - 1.96 * stddev / Math.sqrt(threshold.length);
    }
    public double confidenceHigh(){
        return mean + 1.96 * stddev / Math.sqrt(threshold.length);
    }

   public static void main(String[] args){
        PercolationStats pf =  new PercolationStats(20,100,new PercolationFactory());
        System.out.println("mean = " + pf.mean());
        System.out.println("stddev = " + pf.stddev());
   }
}
