public class SchedulerProcess {
    private String processName;
    private int arrivalTime;
    private int endTime;
    private int burstTime;
    private int tempBurstTime;
    private int priority;
    private int tempPriority;
    // for solving starvation in priority
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getTempPriority() {
        return tempPriority;
    }

    public void setTempPriority(int tempPriority) {
        this.tempPriority = tempPriority;
    }

    private int waitingTime;

    public SchedulerProcess(String processName, int arrivalTime, int burstTime, int priority) {
        this.processName = processName;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.tempBurstTime = burstTime;
        this.priority = priority;
        this.tempPriority = priority;
        this.counter = 0;
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
