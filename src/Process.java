/*
Gian Membreno & Akena
CSCI 330 - Operating Systems
Professor Gass

 */

public class Process {

    private String processName;
    private int arrivalTime;
    private int burstTime;
    private int timeQuantum;
    private int contextSwitch;
    private int waitTime;
    private int turnAroundTime;
    private int initialArrivalTime;
    private int initialburstTime;

    public Process(String name, int arrival, int burst, int quantum) {
        processName = name;
        arrivalTime = arrival;
        burstTime = burst;
        timeQuantum = quantum;
        contextSwitch=0;
        waitTime = 0;
        turnAroundTime=0;
        initialArrivalTime =0;
        initialburstTime=0;
    }

    public String getProcessName(){
        return processName;
    }

    public void setInitialArrivalTime(){
        initialArrivalTime = arrivalTime;
    }

    public int getInitialArrivalTime(){
        return initialArrivalTime;
    }

    public int getProcessArrivalTime(){
        return arrivalTime;
    }

    public void updateArrivalTime(int cpuRunTime){
        arrivalTime = arrivalTime - cpuRunTime;
        if(arrivalTime<0)
        {
            arrivalTime = 0;
        }
    }

    public void setInitialBurstTime(){

        initialburstTime=burstTime;
    }

    public int getinitialBurstTime(){

        return initialburstTime;
    }

    public void setCurrentWaitTime(int cpuRunTime){

        waitTime = waitTime +cpuRunTime;
    }

    public int getTotalWaitTime(){

        return waitTime;
    }

    public void updateRemainingBurstTime(){

        burstTime=burstTime - timeQuantum;
        if(burstTime<0){

            burstTime=0;
        }
    }

    public int getRemainingBurstTime(){

        return burstTime;
    }

    public void updateContextSwitch(){
        contextSwitch++;
    }

    public int getContextSwitch(){

        return contextSwitch;
    }

    public void setTurnAroundTime(){

        turnAroundTime = this.getTotalWaitTime() + this.getinitialBurstTime();
    }

    public int getTurnAroundTime(){

        return turnAroundTime;
    }
    public void getCurrentProcessInfo() {
        System.out.println();
        System.out.println("The process Name:" + processName);
        System.out.println("The process remaining burst time:" + getRemainingBurstTime());
        System.out.println("The time until ready to enter ready queue:" + getProcessArrivalTime());
        System.out.println("The process ready to enter ready queue:" + checkIfReadytoExecute());
        System.out.println("The process of context switch:" + contextSwitch);
        System.out.println("The process total wait time:" + getTotalWaitTime());
        System.out.println("The process total turnaound time:" + getTurnAroundTime());
        System.out.println();
        System.out.println();
    }

    public int checkIfProcessFinished(){
        if(getRemainingBurstTime()==0){
            return 1;
        }
        else return 0;
    }

    public boolean checkIfReadytoExecute(){

        if (getProcessArrivalTime() == 0) {return true;}
        else return false;

    }


}