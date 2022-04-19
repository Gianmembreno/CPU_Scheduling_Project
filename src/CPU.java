/*
Gian Membreno & Akena
CSCI 330 - Operating Systems
Professor Gass

 */

public class CPU {
    public CPU(int quantum) {
        timeQuantum = quantum;
        numberOfCompletedProcesses = 0;
    }

    public int run(Process p) {
        if(p.getRemainingBurstTime()>timeQuantum) {
            p.updateRemainingBurstTime();
            return timeQuantum;

        }
        else if(p.getRemainingBurstTime()<timeQuantum) {
            int run = p.getRemainingBurstTime();
            p.updateRemainingBurstTime();
            numberOfCompletedProcesses++;
            return run;
        }
        else {
            p.updateRemainingBurstTime();
            numberOfCompletedProcesses++;
            return timeQuantum;
        }
    }

    public int getNumberOfCompletedProcesses(){
        return numberOfCompletedProcesses;
    }
    private int timeQuantum;
    private int numberOfCompletedProcesses;
}