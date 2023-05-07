import java.util.Comparator;

public class ProcessComparator implements Comparator<SchedulerProcess> {
    public int compare(SchedulerProcess p1, SchedulerProcess p2) {
        return p1.getArrivalTime() - p2.getArrivalTime();
    }
}
