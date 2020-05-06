package org.best.team;

import java.util.function.Consumer;

public class Highs {

    static {

           // System.out.println(System.getProperty("java.library.path"));
           // System.setProperty("java.library.path", "/lib");
           // System.out.println(System.getProperty("java.library.path"));
            //TODO разобраться с загрузкой по имени библиотеки
           // System.loadLibrary("highs");


        try {
            System.load("/lib/libhighs.so.1.0.0");
        }catch (Throwable e){
            e.printStackTrace();
        }

    }

    private volatile int status = 0;
    private volatile Consumer<Integer> onCompleteHandler;
    private volatile HighsSolution solution;
    private volatile HighsBasis basis;

    public int getStatus() {
        return status;
    }

    public void setOnCompleteHandler(Consumer<Integer> onCompleteHandler) {
        this.onCompleteHandler = onCompleteHandler;
    }

    public HighsSolution getSolution() {
        return solution;
    }


    public HighsBasis getBasis() {
        return basis;
    }


    public boolean  itWorks(){
        return true;
    }


    public native int multiply(int a, int b);

    public native void invokeLpOptimization(
            int numcol,        //!< number of columns
            int numrow,        //!< number of rows
            int numnz,         //!< number of entries in the constraint matrix
            double[] colcost,   //!< array of length [numcol] with column costs
            double[] collower,  //!< array of length [numcol] with lower column bounds
            double[] colupper,  //!< array of length [numcol] with upper column bounds
            double[] rowlower,  //!< array of length [numrow] with lower row bounds
            double[] rowupper,  //!< array of length [numrow] with upper row bounds
            int[] astart,       //!< array of length [numcol+1] with column start indices
            int[] aindex,  //!< array of length [numnz] with row indices of matrix entries
            double[] avalue  //!< array of length [numnz] with value of matrix entries

    );

    public void onComplete(int status, int modelStatus, HighsSolution solution, HighsBasis basis){
        this.status = status;
        this.solution = solution;
        this.basis = basis;
        System.out.println("Computation was complete");
        if(onCompleteHandler != null){
            onCompleteHandler.accept(modelStatus);
        }

        System.out.println(solution);
        System.out.println(basis);
    }

}
