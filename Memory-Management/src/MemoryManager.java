import java.util.ArrayList;

public abstract class MemoryManager {
    protected ArrayList<MemProccess> processList;
    protected ArrayList<MemProccess> notAllocated;
    protected ArrayList<Partition> partitionList;
    protected int maxPartition;

    public MemoryManager(ArrayList<MemProccess> processList, ArrayList<Partition> partitionList) {
        this.processList = processList;
        this.partitionList = new ArrayList<Partition>();
        for (Partition partition : partitionList) {
            this.partitionList.add(new Partition(partition.getName(), partition.getSize()));
        }
        this.notAllocated = new ArrayList<MemProccess>();
        this.maxPartition = partitionList.size();
    }

    abstract void manageProcesses();

    void compact() {
        int i = 0;
        int total = 0;
        while (i < partitionList.size()) {
            if (partitionList.get(i).getUsedSize() == 0) {
                total += partitionList.get(i).getSize();
                partitionList.remove(i);
                continue;
            }
            i++;
        }
        if (total > 0) {
            partitionList.add(new Partition("Partition" + maxPartition, total));
            maxPartition++;
        }
        ArrayList<MemProccess> temp = processList;
        processList = notAllocated;
        manageProcesses();
        processList = temp;
    }

    void print() {

        for (Partition partition : partitionList) {
            System.out.println(
                    partition.getName() + " (" + partition.getSize() + " KB) => " + partition.getProcess().getName());
        }
        System.out.println("");
        for (MemProccess process : notAllocated) {
            System.out.println(process.getName() + " can not be allocated");
        }
        System.out.println("");
    }
}
