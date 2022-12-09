import java.util.ArrayList;

public class SRTFScheduler extends Scheduler {

    private ArrayList<SchedulerProcess> readyQueue = new ArrayList<SchedulerProcess>();

    public SRTFScheduler(ArrayList<SchedulerProcess> processes, int contextSwitching) {
        super(processes, contextSwitching);
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
        for (SchedulerProcess scheduledProcess : scheduledProcesses) {
            if (scheduledProcess == process) {
                waitTime = scheduledProcess.getWaitingTime() + (time - scheduledProcess.getEndTime());
                break;
            }
        }
        return waitTime;
    }

    @Override
    void schedule() {
        int time = 0;
        do {
            for (SchedulerProcess process : processes) {
                if (process.getArrivalTime() == time) {
                    readyQueue.add(process);
                }
            }
            if (readyQueue.isEmpty()) {
                time++;
                continue;
            }
            SchedulerProcess process = getShortestRemainingTimeProcess();
            process.setTempBurstTime(process.getTempBurstTime() - 1);
            if (scheduledProcesses.isEmpty() || scheduledProcesses.get(scheduledProcesses.size() - 1) != process) {
                if (!scheduledProcesses.isEmpty()) {
                    scheduledProcesses.get(scheduledProcesses.size() - 1).setEndTime(time);
                }
                if (scheduledProcesses.contains(process)) {
                    process.setWaitingTime(getWaitTime(process, time));
                } else {
                    process.setWaitingTime(time - process.getArrivalTime());
                }
                scheduledProcesses.add(process);
            }
            time++;
            if (process.getTempBurstTime() == 0) {
                readyQueue.remove(process);
            }
        } while (time < processes.get(processes.size() - 1).getArrivalTime() || !readyQueue.isEmpty());

    }

}
