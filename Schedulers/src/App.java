import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        ArrayList<SchedulerProcess> processes = new ArrayList<SchedulerProcess>();
        System.out.print("Enter number of processes: ");
        int num = sc.nextInt();
        System.out.print("Enter round robin Time Quantum: ");
        int RRQuantum = sc.nextInt();
        System.out.print("Enter context switching: ");
        int contextSwitching = sc.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.print("processes name: ");
            String PName = sc.next();
            System.out.print("arrival time: ");
            int arrivalTime = sc.nextInt();
            System.out.print("burst time: ");
            int burstTime = sc.nextInt();
            System.out.print("priority: ");
            int priority = sc.nextInt();
            processes.add(new SchedulerProcess(PName, arrivalTime, burstTime, priority));
        }

        System.out.println("Enter 1 for SRTFScheduler, 2 for RRScheduler, 3 for PriorityScheduler");
        int test = sc.nextInt();

        do {

            Collections.sort(processes, new ProcessComparator());
            Scheduler s;

            if (test == 1) {
                s = new SRTFScheduler(processes, contextSwitching);
                s.schedule();
                s.displayAllData();
            } else if (test == 2) {
                s = new RRScheduler(processes, contextSwitching, RRQuantum);
                s.schedule();
                s.displayAllData();
            } else {
                s = new PriorityScheduler(processes);
                s.schedule();
                s.displayAllData();
            }

            System.out.println("Enter 1 for SRTFScheduler, 2 for RRScheduler, 3 for PriorityScheduler");
            test = sc.nextInt();

        } while (test != -1);

        // ready test cases

        // ArrayList<SchedulerProcess> processes = new ArrayList<SchedulerProcess>();
        // processes.add(new SchedulerProcess("P1", 0, 1, 1));
        // processes.add(new SchedulerProcess("P2", 1, 7, 2));
        // processes.add(new SchedulerProcess("P3", 2, 3, 3));
        // processes.add(new SchedulerProcess("P4", 3, 6, 4));
        // processes.add(new SchedulerProcess("P5", 4, 5, 5));
        // processes.add(new SchedulerProcess("P6", 5, 15, 5));
        // processes.add(new SchedulerProcess("P7", 15, 8, 5));
        // Collections.sort(processes, new ProcessComparator());
        // Scheduler s = new SRTFScheduler(processes, 2);
        // System.out.println("Preemptive Shortest- Job First (SJF) Scheduling with
        // context switching = 2");
        // s.schedule();
        // s.displayAllData();
        // s = new RRScheduler(processes, 2, 5);
        // // RR
        // System.out.println("\nRound Robin (RR) with context switching = 2 and quantum
        // = 5");
        // s.schedule();
        // s.displayAllData();
        // // new test case
        // processes.clear();
        // processes.add(new SchedulerProcess("P1", 0, 3, 3));
        // processes.add(new SchedulerProcess("P2", 1, 4, 2));
        // processes.add(new SchedulerProcess("P3", 2, 6, 4));
        // processes.add(new SchedulerProcess("P4", 3, 4, 6));
        // processes.add(new SchedulerProcess("P5", 5, 2, 10));
        // Collections.sort(processes, new ProcessComparator());
        // s = new PriorityScheduler(processes);
        // System.out.println("\nPreemptive Priority Scheduling (with the solving of
        // starvation problem)");
        // s.schedule();
        // s.displayAllData();
        // processes.clear();
        // processes.add(new SchedulerProcess("P1", 0, 17, 4, 7));
        // processes.add(new SchedulerProcess("P2", 2, 6, 7, 9));
        // processes.add(new SchedulerProcess("P3", 5, 11, 3, 4));
        // processes.add(new SchedulerProcess("P4", 15, 4, 6, 6));
        // Collections.sort(processes, new ProcessComparator());
        // s = new AGScheduler(processes);
        // System.out.println("\nAG Scheduling");
        // s.schedule();
        // s.displayAllData();
    }
}
