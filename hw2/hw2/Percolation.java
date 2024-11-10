package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] map;
    private int size = 0;
    public WeightedQuickUnionUF uf;
    private int openSite = 0;
    private int top;
    private int bottom;
    public Percolation(int n){
        this.size = n;
        int num = n * n;
        this.top = size * size;
        this.bottom = top + 1;
        map = new boolean[num];
        uf = new WeightedQuickUnionUF(num + 2);
    }

    public void open(int row, int col){
        if(row < 0 || row > size - 1 || col < 0 || col > size - 1){
            throw new IllegalArgumentException();
        }
        int num = xyTo1D(row,col);
        map[num] = true;
        openSite++;

        if(row > 0 &&  isOpen(row - 1,col)){
            uf.union(xyTo1D(row -1 ,col),num);
        }

        if(row < size - 1 && isOpen(row + 1, col)){
            uf.union(xyTo1D(row + 1,col),num);
        }

        if(col > 0 && isOpen(row, col - 1)){
            uf.union(xyTo1D(row,col -1) , num);
        }

        if(col < size - 1 && isOpen(row, col + 1)){
            uf.union(xyTo1D(row,col + 1),num);
        }

        if(row == 0){
            uf.union(num,top);
        }

        if(row == size - 1){
            uf.union(bottom,num);
        }
    }

    public boolean isOpen(int row , int col){
         int num = xyTo1D(row,col);
        return map[num];
    }

    public boolean isFull(int row, int col){
        return uf.connected(xyTo1D(row,col),top);
    }

    public int numberOfOpenSites(){
        return openSite;
    }

    public boolean percolates(){
        return uf.connected(top,bottom);
    }


    public static void main(String[] args){

    }

    private int xyTo1D(int row, int col){
        return row * size+ col;
    }


}
