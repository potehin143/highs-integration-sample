package org.best.team.highsrunner;

import org.best.team.Highs;
import org.best.team.HighsModelStatus;
import org.best.team.HighsStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
            int numrow = 2;
            int nnz = 4;

            double[] cc = {1, -2};
            double[] cl = {0, 0};
            double[] cu = {1000, 1000};
            double[] rl = {0,0};
            double[] ru = {10, 10};
            int[] astart = {0, 2};
            int[] aindex = {0, 1, 0, 1};
            double[] avalue = {1, -1, 3, 0.2};

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
