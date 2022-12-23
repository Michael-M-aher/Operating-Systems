import java.util.ArrayList;

public class WorstFit extends MemoryManager {

    public WorstFit(ArrayList<MemProccess> processList, ArrayList<Partition> partitionList) {
        super(processList, partitionList);
    }

    @Override
    void manageProcesses() {
        int processIndex = 0;
        while (processIndex < processList.size()) {
            MemProccess process = processList.get(processIndex);
            Partition worstPartition = new Partition("null", 0);
            int bestPartitionIdx = -1;
            int i = 0;
            for (Partition partition : partitionList) {
                if (partition.getUsedSize() == 0 && partition.getSize() >= process.getSize()
                        && partition.getSize() > worstPartition.getSize()) {
                    worstPartition = partition;
                    bestPartitionIdx = i;
                }
                i++;
            }
            if (bestPartitionIdx == -1) {
                notAllocated.add(process);
                processIndex++;
                continue;
            }

            worstPartition.setProcess(process);
            notAllocated.remove(process);
            if (partitionList.get(bestPartitionIdx).getSize() != process.getSize()) {
                partitionList.add(bestPartitionIdx + 1, new Partition("Partition " + maxPartition,
                        partitionList.get(bestPartitionIdx).getSize() - process.getSize()));
                maxPartition++;
            }
            worstPartition.setSize(process.getSize());
            worstPartition.setUsedSize(process.getSize());

            processIndex++;
        }

    }

}
