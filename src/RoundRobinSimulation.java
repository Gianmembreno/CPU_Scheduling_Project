/*
Gian Membreno & Akena
CSCI 330 - Operating Systems
Professor Gass

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RoundRobinSimulation
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the time quantum for processes: ");
        int timeQuantum = in.nextInt();
        System.out.println("Enter the config file name: ");
        ArrayList<Process> p = new ArrayList<Process>();

        try
        {
            String filename = in.next();
            File inputFile = new File(filename);
            Scanner fileIn = new Scanner(inputFile);
            while(fileIn.hasNextLine())
            {
                String processLine = fileIn.nextLine();
                int i = 0;
                while (!Character.isDigit(processLine.charAt(i))) { i++; }
                String processName = processLine.substring(0,i);
                String processArrival = processLine.substring(i,i+2).trim();
                String processBurst = processLine.substring(i+2).trim();
                int processArrivalTime = Integer.parseInt(processArrival);
                int processBurstTime = Integer.parseInt(processBurst);
                p.add(new Process(processName,processArrivalTime,processBurstTime,timeQuantum));
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        Simulation s = new Simulation(p,timeQuantum);
        s.runRoundRobinSimulation();
        System.out.println("FINISHED");
    }
}