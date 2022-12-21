import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        // int prossesNum;
        // int partitionNum;
        ArrayList<MemProccess> processList = new ArrayList<MemProccess>();
        ArrayList<Partition> partitionList = new ArrayList<Partition>();
        partitionList.add(new Partition("Partition 0", 90));
        partitionList.add(new Partition("Partition 1", 20));
        partitionList.add(new Partition("Partition 2", 5));
        partitionList.add(new Partition("Partition 3", 30));
        partitionList.add(new Partition("Partition 4", 120));
        partitionList.add(new Partition("Partition 5", 80));

        processList.add(new MemProccess("Process 1", 15));
        processList.add(new MemProccess("Process 2", 90));
        processList.add(new MemProccess("Process 3", 30));
        processList.add(new MemProccess("Process 4", 100));

        System.out.println("First Fit:");
        MemoryManager fcfs = new FirstFit(processList, partitionList);
        fcfs.manageProcesses();
        fcfs.compact();
        fcfs.print();
        System.out.println("Best Fit:");
        fcfs = new BestFit(processList, partitionList);
        fcfs.manageProcesses();
        fcfs.compact();
        fcfs.print();
        System.out.println("Worst Fit:");
        fcfs = new WorstFit(processList, partitionList);
        fcfs.manageProcesses();
        fcfs.compact();
        fcfs.print();

    }
}
