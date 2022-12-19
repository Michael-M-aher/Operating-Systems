import java.util.ArrayList;

public abstract class MemoryManager {
    protected ArrayList<MemProccess> processList;
    protected ArrayList<Partition> partitionList;
    public MemoryManager(ArrayList<MemProccess> processList, ArrayList<Partition> partitionList) {
        this.processList = processList;
        this.partitionList = partitionList;
    }
    abstract void manageProcesses();
    void print(){
        int i = 0;
        int j=partitionList.size();
        for (Partition partition : partitionList) {
            System.out.println(partition.getName() + "(" + partition.getSize() + " KB => "+ partition.getProcess().getName());
        }
    }
}
