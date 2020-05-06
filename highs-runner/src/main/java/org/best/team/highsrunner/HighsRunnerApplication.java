package org.best.team.highsrunner;

import org.best.team.Highs;
import org.best.team.HighsModelStatus;
import org.best.team.HighsStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

@SpringBootApplication
public class HighsRunnerApplication {

    public static void main(String[] args) {

        Highs highs = new Highs();
        if(highs.itWorks()){
            System.out.println("It works");
            highs.setOnCompleteHandler(status->{
                System.out.println("Complete with  Model status "+
                        HighsModelStatus.values()[status]);
            });

           // statusMonitor(highs); // to test async status update from cpp code

            int numcol = 2;
            int numrow = 3;
            int nnz = 5;

            double[] cc = {-4, -6};
            double[] cl = {0, 0};
            double[] cu = {POSITIVE_INFINITY, POSITIVE_INFINITY};
            double[] rl = {NEGATIVE_INFINITY, NEGATIVE_INFINITY, NEGATIVE_INFINITY};
            double[] ru = {64, 72, 20};
            int[] astart = {0, 2};
            int[] aindex = {0, 1, 0, 1, 2}; // starts from 0 !!!
            double[] avalue = {2, 1, 1, 3, 1};

            highs.invokeLpOptimization(
                   numcol, numrow, nnz,
                   cc, cl, cu, rl, ru, astart, aindex, avalue
                   );
        }

        try {
            SpringApplication.run(HighsRunnerApplication.class, args);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    private static void statusMonitor(Highs highs) {
        Thread newThread = new Thread(() -> {
            while (highs.getStatus()!=100){ //value which stop monitoring
                System.out.println(highs.getStatus());
                printStatus(highs.getStatus());
            }
        });
        newThread.start();
    }

    private static void printStatus(int status) {
        try{
            System.out.println(HighsStatus.values()[status]);
        } catch (Exception e){
            System.out.println("Unexpected status value");
        }
    }

}
