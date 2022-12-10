import java.util.ArrayList;

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
        RRScheduler s = new RRScheduler(processes, 2, 5);
        s.schedule();
        s.displayProcessessOrder();
        s.displayProcessesTable();
        s.displayAverageWaitingTime();
        s.displayAverageTurnaroundTime();
    }
}
