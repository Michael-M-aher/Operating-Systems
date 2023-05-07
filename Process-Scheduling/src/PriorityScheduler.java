import java.util.ArrayList;

public class PriorityScheduler extends Scheduler {
    private int agingNumber;

    public int getAgingNumber() {
        return agingNumber;
    }

    public PriorityScheduler(ArrayList<SchedulerProcess> processes) {
        super(processes, 0, 0);
        this.agingNumber = 5;
    }

    int getWaitTime(SchedulerProcess process, int time) {
        int waitTime = 0;
        if (scheduledProcesses.contains(process)) {
            waitTime = process.getWaitingTime() + (time - process.getEndTime());
        } else {
            waitTime = time - process.getArrivalTime();
        }
        return waitTime + getContextSwitching();
    }

    void Aging(SchedulerProcess process, int time) {
        for (SchedulerProcess p : readyQueue) {
            if (p == process) {
                continue;
            }
            p.setCounter(p.getCounter() + time);
            p.setTempPriority(p.getTempPriority() - (p.getCounter() / getAgingNumber()));
            p.setCounter((p.getCounter() % getAgingNumber()));
        }
    }

    @Override
    void schedule() {
        int time = 0;
        int numFinished = 0;
        while (numFinished != processes.size()) {
            addToReadyQueue(time);
            if (readyQueue.isEmpty()) {
                time++;
                continue;
            }
            SchedulerProcess process = getGreatestPriority();
            if (scheduledProcesses.isEmpty() || scheduledProcesses.get(scheduledProcesses.size() - 1) != process) {
                if (!scheduledProcesses.isEmpty()) {
                    SchedulerProcess pastProcess = scheduledProcesses.get(scheduledProcesses.size() - 1);
                    process.setCounter(0);
                    time += getContextSwitching();
                    Aging(pastProcess, getContextSwitching());
                    pastProcess.setEndTime(time);
                    addToReadyQueue(time);
                    process = getGreatestPriority();
                    process.setCounter(0);
                }
                process.setWaitingTime(getWaitTime(process, time));
                scheduledProcesses.add(process);
            }
            process.setTempBurstTime(process.getTempBurstTime() - 1);
            time++;
            Aging(process, 1);
            if (process.getTempBurstTime() == 0) {
                readyQueue.remove(process);
                numFinished++;
            }
        }
    }

}
