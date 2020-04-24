package org.best.team;

import java.util.Arrays;

public class HighsBasis {

    public int[] colbasisstatus;
    public int[] rowbasisstatus;

    public HighsBasis(int numcol, int numrow) {
        this.colbasisstatus = new int[numcol];
        this.rowbasisstatus = new int[numrow];
    }

    public HighsBasis(int[] colbasisstatus, int[] rowbasisstatus) {
        this.colbasisstatus = colbasisstatus;
        this.rowbasisstatus = rowbasisstatus;
    }

    public int[] getColbasisstatus() {
        return colbasisstatus;
    }

    public int[] getRowbasisstatus() {
        return rowbasisstatus;
    }

    @Override
    public String toString() {
        return "HighsBasis{" +
                "colbasisstatus=" + Arrays.toString(colbasisstatus) +
                ", rowbasisstatus=" + Arrays.toString(rowbasisstatus) +
                '}';
    }
}
