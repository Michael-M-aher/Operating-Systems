import java.util.ArrayList;

public class SRTFScheduler extends Scheduler {

    public SRTFScheduler(ArrayList<SchedulerProcess> processes, int contextSwitching, int quantum) {
        super(processes, contextSwitching, quantum);
    }

    SchedulerProcess getShortestRemainingTimeProcess() {
        SchedulerProcess shortestProcess = null;
        for (SchedulerProcess process : readyQueue) {
            if (shortestProcess == null) {
                shortestProcess = process;
            } else {
                if (process.getTempBurstTime() < shortestProcess.getTempBurstTime()) {
                    shortestProcess = process;
                }
            }
        }
        return shortestProcess;
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

    @Override
    void schedule() {
        int time = 0;
        do {
            addToReadyQueue(time);
            if (readyQueue.isEmpty()) {
                time++;
                continue;
            }
            SchedulerProcess process = getShortestRemainingTimeProcess();
            if (scheduledProcesses.isEmpty() || scheduledProcesses.get(scheduledProcesses.size() - 1) != process) {
                if (!scheduledProcesses.isEmpty()) {
                    time += getContextSwitching();
                    scheduledProcesses.get(scheduledProcesses.size() - 1).setEndTime(time);
                    addToReadyQueue(time);
                    process = getShortestRemainingTimeProcess();
                }
                process.setWaitingTime(getWaitTime(process, time));
                scheduledProcesses.add(process);
            }
            process.setTempBurstTime(process.getTempBurstTime() - 1);
            time++;
            if (process.getTempBurstTime() == 0) {
                readyQueue.remove(process);
            }
        } while (time < processes.get(processes.size() - 1).getArrivalTime() || !readyQueue.isEmpty());

    }

}
