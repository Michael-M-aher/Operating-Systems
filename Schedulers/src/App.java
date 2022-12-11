import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<SchedulerProcess> processes = new ArrayList<SchedulerProcess>();
        processes.add(new SchedulerProcess("P1", 0, 1, 1));
        processes.add(new SchedulerProcess("P2", 1, 7, 2));
        processes.add(new SchedulerProcess("P3", 2, 3, 3));
        processes.add(new SchedulerProcess("P4", 3, 6, 4));
        processes.add(new SchedulerProcess("P5", 4, 5, 5));
        processes.add(new SchedulerProcess("P6", 5, 15, 5));
        processes.add(new SchedulerProcess("P7", 15, 8, 5));
        Collections.sort(processes, new ProcessComparator());
        Scheduler s = new SRTFScheduler(processes, 2);
        System.out.println("Preemptive Shortest- Job First (SJF) Scheduling with context switching = 2");
        s.schedule();
        s.displayAllData();
        s = new RRScheduler(processes, 2, 5);
        // RR
        System.out.println("\nRound Robin (RR) with context switching = 2 and quantum = 5");
        s.schedule();
        s.displayAllData();
        // new test case
        processes.clear();
        processes.add(new SchedulerProcess("P1", 0, 3, 3));
        processes.add(new SchedulerProcess("P2", 1, 4, 2));
        processes.add(new SchedulerProcess("P3", 2, 6, 4));
        processes.add(new SchedulerProcess("P4", 3, 4, 6));
        processes.add(new SchedulerProcess("P5", 5, 2, 10));
        Collections.sort(processes, new ProcessComparator());
        s = new PriorityScheduler(processes);
        System.out.println("\nPreemptive Priority Scheduling (with the solving of starvation problem)");
        s.schedule();
        s.displayAllData();
    }
}
