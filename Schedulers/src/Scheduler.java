import java.util.ArrayList;

// Create a class called Scheduler with the following attributes:, list of processes, average turnaroundTime and average waiting time.
public abstract class Scheduler {
    protected ArrayList<SchedulerProcess> processes;
    protected ArrayList<SchedulerProcess> scheduledProcesses;
    protected ArrayList<SchedulerProcess> readyQueue;
    protected int contextSwitching;
    protected int quantum;
    private double averageTurnaroundTime;
    private double averageWaitingTime;

    public Scheduler(ArrayList<SchedulerProcess> processes, int contextSwitching, int quantum) {
        this.processes = processes;
        this.scheduledProcesses = new ArrayList<SchedulerProcess>();
        this.readyQueue = new ArrayList<SchedulerProcess>();
        this.contextSwitching = contextSwitching;
        this.quantum = quantum;
        sortProcessesByArrivalTime();
    }

    void sortProcessesByArrivalTime() {
        for (int i = 0; i < processes.size(); i++) {
            for (int j = 0; j < processes.size() - 1; j++) {
                if (processes.get(j).getArrivalTime() > processes.get(j + 1).getArrivalTime()) {
                    SchedulerProcess temp = processes.get(j);
                    processes.set(j, processes.get(j + 1));
                    processes.set(j + 1, temp);
                }
            }
        }
    }

    protected void addToReadyQueue(int time) {
        for (SchedulerProcess process : processes) {
            if (!readyQueue.contains(process) && process.getTempBurstTime() != 0
                    && process.getArrivalTime() <= time) {
                readyQueue.add(process);
            }
        }
    }

    public int getContextSwitching() {
        return contextSwitching;
    }

    public ArrayList<SchedulerProcess> getProcesses() {
        return processes;
    }

    public void setProcesses(ArrayList<SchedulerProcess> processes) {
        this.processes = processes;
    }

    public double getAverageTurnaroundTime() {
        return averageTurnaroundTime;
    }

    public void setAverageTurnaroundTime(double averageTurnaroundTime) {
        this.averageTurnaroundTime = averageTurnaroundTime;
    }

    public double getAverageWaitingTime() {
        return averageWaitingTime;
    }

    public void setAverageWaitingTime(double averageWaitingTime) {
        this.averageWaitingTime = averageWaitingTime;
    }

    private void calculateAverageTurnaroundTime() {
        double sum = 0;
        for (SchedulerProcess process : processes) {
            sum += (process.getBurstTime() + process.getWaitingTime());
        }
        averageTurnaroundTime = sum / processes.size();
    }

    private void calculateAverageWaitingTime() {
        double sum = 0;
        for (SchedulerProcess process : processes) {
            sum += process.getWaitingTime();
        }
        averageWaitingTime = sum / processes.size();
    }

    public void displayAverageTurnaroundTime() {
        calculateAverageTurnaroundTime();
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);
    }

    public void displayAverageWaitingTime() {
        calculateAverageWaitingTime();
        System.out.println("Average Waiting Time: " + averageWaitingTime);
    }

    public void displayProcessessOrder() {
        System.out.println("Processes Order:");
        for (SchedulerProcess process : scheduledProcesses) {
            System.out.print(process.getProcessName() + " ");
        }
        System.out.println();
        System.out.println();
    }

    public void displayProcessesTable() {
        System.out.println("Processes Table:");
        System.out.println("Process Name\tArrival Time\tBurst Time\tWaitingTime\tTurnaround Time\t  Priority");
        for (SchedulerProcess process : processes) {
            System.out.println(process.getProcessName() + "\t\t" +
                    process.getArrivalTime() + "\t\t" + process.getBurstTime() + "\t\t" + process.getWaitingTime()
                    + "\t\t" + (process.getBurstTime() + process.getWaitingTime()) + "\t\t  " + process.getPriority());
        }
        System.out.println();

    }

    abstract void schedule();
}