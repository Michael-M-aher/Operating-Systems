import java.util.ArrayList;

public class SchedulerProcess {
    private String processName;
    private int arrivalTime;
    private int endTime;
    private int burstTime;
    private int tempBurstTime;
    private int priority;
    private int tempPriority;
    private int quantum;
    private int tempQuantum;
    // for solving starvation in priority
    private int counter;
    private int waitingTime;
    ArrayList<Integer> quantumHistory;

    public SchedulerProcess(String processName, int arrivalTime, int burstTime, int priority, int quantum) {
        this.processName = processName;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.tempBurstTime = burstTime;
        this.priority = priority;
        this.tempPriority = priority;
        this.counter = 0;
        this.quantum = quantum;
        this.tempQuantum = quantum;
        quantumHistory = new ArrayList<Integer>();
    }

    public SchedulerProcess(String processName, int arrivalTime, int burstTime, int priority) {
        this.processName = processName;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.tempBurstTime = burstTime;
        this.priority = priority;
        this.tempPriority = priority;
        this.counter = 0;
        this.quantum = 0;
        this.tempQuantum = 0;
        quantumHistory = new ArrayList<Integer>();
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getTempBurstTime() {
        return tempBurstTime;
    }

    public void setTempBurstTime(int tempBurstTime) {
        this.tempBurstTime = tempBurstTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTempPriority() {
        return tempPriority;
    }

    public void setTempPriority(int tempPriority) {
        this.tempPriority = tempPriority;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public int getTempQuantum() {
        return tempQuantum;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setTempQuantum(int tempQuantum) {
        this.tempQuantum = tempQuantum;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processName='" + processName + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", burstTime=" + burstTime +
                ", priority=" + priority +
                ", waitingTime=" + waitingTime +
                ", turnaroundTime=" + (burstTime + waitingTime) +
                '}';
    }
}
