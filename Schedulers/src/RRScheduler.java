import java.util.ArrayList;

public class RRScheduler extends Scheduler {

    public RRScheduler(ArrayList<SchedulerProcess> processes, int contextSwitching, int quantum) {
        super(processes, contextSwitching, quantum);
    }

    @Override
    void schedule() {
        int time = 0;
        do {
            addToReadyQueue(time);
            if (!readyQueue.isEmpty()) {
                SchedulerProcess process = readyQueue.get(0);
                if (process.getTempBurstTime() > quantum) {
                    process.setTempBurstTime(process.getTempBurstTime() - quantum);
                    time += quantum;
                    scheduledProcesses.add(process);
                    time += contextSwitching;
                    addToReadyQueue(time);
                    readyQueue.remove(process);
                    readyQueue.add(process);
                } else {
                    time += process.getTempBurstTime();
                    scheduledProcesses.add(process);
                    process.setTempBurstTime(0);
                    time += contextSwitching;
                    process.setEndTime(time);
                    process.setWaitingTime(time - process.getArrivalTime() - process.getBurstTime());
                    readyQueue.remove(process);
                }
            } else {
                time++;
            }
        } while (time < processes.get(processes.size() - 1).getArrivalTime() || !readyQueue.isEmpty());

    }

}
