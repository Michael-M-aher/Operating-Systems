import java.util.ArrayList;

public abstract class MemoryManager {
    protected ArrayList<MemProccess> processList;
    protected ArrayList<MemProccess> notAllocated;
    protected ArrayList<Partition> partitionList;

    public MemoryManager(ArrayList<MemProccess> processList, ArrayList<Partition> partitionList) {
        this.processList = processList;
        this.partitionList = new ArrayList<Partition>();
        for (Partition partition : partitionList) {
            this.partitionList.add(new Partition(partition.getName(), partition.getSize()));
        }

        this.notAllocated = new ArrayList<MemProccess>();
    }

    abstract void manageProcesses();

    void compact() {
        int i = 0;
        int total = 0;
        int size = partitionList.size();
        while (i < partitionList.size()) {
            if (partitionList.get(i).getUsedSize() == 0) {
                System.out.println("Compacting " + partitionList.get(i).getName());
                total += partitionList.get(i).getSize();
                partitionList.remove(i);
                continue;
            }
            i++;
        }
        if (total > 0) {
            partitionList.add(new Partition("Partition " + size, total));
        }
        System.out.println("Compaction done" + total);
    }

    void print() {

        for (Partition partition : partitionList) {
            System.out.println(
                    partition.getName() + " (" + partition.getSize() + " KB) => " + partition.getProcess().getName());
        }
    }
}
