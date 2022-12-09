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
        SRTFScheduler s = new SRTFScheduler(processes, 2);
        s.schedule();
        s.displayProcessessOrder();
        s.displayProcessesTable();

        s.displayAverageWaitingTime();
        s.displayAverageTurnaroundTime();
        // Write a java program to simulate preemptive Shortest- Job First (SJF)
        // Scheduling with context switching

        // Create a class called Main

        // In the main method, create a list of processes and add 5 processes to the
        // list.

        // Create a scheduler object and pass the list of

        // processes to the scheduler object.

        // Call the method to calculate the average waiting time.

        // Call the method to calculate the average turnaround time.

        // Call the method to display the average waiting time.

        // Call the method to display the average turnaround time.

        // Call the method to display the average completion time.

        // Call the method to display the Gantt chart.

        // Call the method to display the table of processes.

        // Call the method to display the table of processes sorted by arrival time.

        // Call the method to display the table of processes sorted by burst time.

        // Call the method to display the table of processes sorted by completion time.

        // Call the method to display the table of processes sorted by turnaround time.

        // Call the method to display the table of processes sorted by waiting time.

        // Call the method to display the table of processes sorted by process name.

    }
}
