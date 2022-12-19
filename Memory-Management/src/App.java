import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int prossesNum;
        int partitionNum;
        ArrayList<MemProccess> processList=new ArrayList<MemProccess>();
        ArrayList<Partition> partitionList=new ArrayList<Partition>();
        partitionList.add(new Partition("Partition0", 90));
        partitionList.add(new Partition("Partition1", 20));
        partitionList.add(new Partition("Partition2", 5));
        partitionList.add(new Partition("Partition3", 30));
        partitionList.add(new Partition("Partition4", 120));
        partitionList.add(new Partition("Partition5", 80));

        processList.add(new MemProccess("Process1", 15));
        processList.add(new MemProccess("Process2", 90));
        processList.add(new MemProccess("Process3", 30));
        processList.add(new MemProccess("Process4", 100));

        MemoryManager fcfs = new BestFit(processList, partitionList);
        fcfs.manageProcesses();
        fcfs.print();
        
    }
}
