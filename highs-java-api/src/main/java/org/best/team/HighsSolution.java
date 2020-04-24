package org.best.team;

import java.util.Arrays;

public class HighsSolution {

    public double[] colvalue;
    public double[] coldual;
    public double[] rowvalue;
    public double[] rowdual;

    public HighsSolution(int numcol, int numrow) {
        this.colvalue = new double[numcol];
        this.coldual = new double[numcol];
        this.rowvalue = new double[numrow];
        this.rowdual = new double[numrow];
    }

    public HighsSolution(double[] colvalue, double[] coldual, double[] rowvalue, double[] rowdual) {
        this.colvalue = colvalue;
        this.coldual = coldual;
        this.rowvalue = rowvalue;
        this.rowdual = rowdual;
    }

    public double[] getColvalue() {
        return colvalue;
    }

    public double[] getColdual() {
        return coldual;
    }

    public double[] getRowvalue() {
        return rowvalue;
    }

    public double[] getRowdual() {
        return rowdual;
    }

    @Override
    public String toString() {
        return "HighsSolution{" +
                "colvalue=" + Arrays.toString(colvalue) +
                ", coldual=" + Arrays.toString(coldual) +
                ", rowvalue=" + Arrays.toString(rowvalue) +
                ", rowdual=" + Arrays.toString(rowdual) +
                '}';
    }
}
