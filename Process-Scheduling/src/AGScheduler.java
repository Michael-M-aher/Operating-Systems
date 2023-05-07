import java.util.ArrayList;

public class AGScheduler extends Scheduler {

    public AGScheduler(ArrayList<SchedulerProcess> processes) {
        super(processes, 0, 0);
    }

    @Override
    void schedule() {
        int time = 0;
        int numFinished = 0;
        SchedulerProcess current = null;
        SchedulerProcess sub;

        while (numFinished != processes.size()) {
            addToReadyQueue(time);

            if (readyQueue.size() == 0)
                time++;

            while (readyQueue.size() != 0) {
                if (current == null) {
                    current = readyQueue.get(0);
                }

                boolean check;
                check = false;

                int quarter = (int) Math.ceil((double) current.getTempQuantum() / 4);
                scheduledProcesses.add(current);
                current.quantumHistory.add(current.getQuantum());
                int remining = current.getQuantum();
                remining -= quarter;

                while (true) {
                    if (current.getTempBurstTime() <= quarter) {
                        numFinished++;
                        time += current.getTempBurstTime();
                        current.setEndTime(time);
                        addToReadyQueue(time);
                        current.setQuantum(0);
                        current.quantumHistory.add(current.getQuantum());
                        current.setTempBurstTime(0);
                        int waitingTime = (current.getEndTime() - current.getArrivalTime()) - current.getBurstTime();
                        current.setWaitingTime(waitingTime);
                        readyQueue.remove(current);
                        current = null;
                        break;
                    }
                    current.setTempBurstTime(current.getTempBurstTime() - quarter);
                    current.setTempQuantum(current.getTempQuantum() - quarter);
                    time += quarter;

                    addToReadyQueue(time);

                    if (current.getTempQuantum() == 0 && current.getTempBurstTime() != 0) {
                        current.setQuantum(current.getQuantum() + 2);
                        current.setTempQuantum(current.getQuantum());
                        readyQueue.remove(current);
                        readyQueue.add(current);
                        break;
                    }

                    if (check) {
                        sub = getShortestRemainingTimeProcess();
                        check = false;
                        if (current != sub) {
                            current.setQuantum(current.getQuantum() + current.getTempQuantum());
                            current.setTempQuantum(current.getQuantum());
                            readyQueue.remove(current);
                            readyQueue.add(current);
                            current = sub;
                            break;
                        } else {
                            while (remining != 0) {
                                time++;
                                addToReadyQueue(time);
                                remining--;
                                current.setTempBurstTime(current.getTempBurstTime() - 1);
                                if (current.getTempBurstTime() == 0) {
                                    numFinished++;
                                    current.setEndTime(time);
                                    current.setQuantum(0);
                                    current.quantumHistory.add(current.getQuantum());
                                    int waitingTime = (current.getEndTime() - current.getArrivalTime())
                                            - current.getBurstTime();
                                    current.setWaitingTime(waitingTime);
                                    readyQueue.remove(current);
                                    current = null;
                                    break;
                                }

                            }
                            break;
                        }
                    }

                    if (readyQueue.size() > 1) {
                        sub = getGreatestPriority();
                        check = true;
                        if (current != sub) {
                            int hQuantum = (int) Math.ceil((double) current.getTempQuantum() / 2);
                            current.setQuantum(current.getQuantum() + hQuantum);
                            current.setTempQuantum(current.getQuantum());
                            readyQueue.remove(current);
                            readyQueue.add(current);
                            current = sub;
                            break;
                        } else {
                            quarter = ((int) Math.ceil((double) current.getQuantum() / 2))
                                    - ((int) Math.ceil((double) current.getQuantum() / 4));
                            remining -= quarter;
                        }

                    }

                }
            }
        }
    }

}
