import java.util.ArrayList;

public class FirstFit extends MemoryManager {

    public FirstFit(ArrayList<MemProccess> processList, ArrayList<Partition> partitionList) {
        super(processList, partitionList);
    }

    @Override
    void manageProcesses() {
        // error in printing
        int processIndex = 0;
        while (processIndex < processList.size()) {
            MemProccess process = processList.get(processIndex);
            int partitionIdx = -1;
            for (int i = 0; i < partitionList.size(); i++) {
                if (partitionList.get(i).getUsedSize() == 0 && partitionList.get(i).getSize() >= process.getSize()) {
                    partitionIdx = i;
                    break;
                }
            }
            if (partitionIdx == -1) {
                notAllocated.add(process);
                processIndex++;
                continue;
            }
            partitionList.get(partitionIdx).setProcess(process);
            if (partitionList.get(partitionIdx).getSize() != process.getSize()) {
                partitionList.add(partitionIdx + 1, new Partition("Partition " + maxPartition,
                        partitionList.get(partitionIdx).getSize() - process.getSize()));
                maxPartition++;
            }
            partitionList.get(partitionIdx).setSize(process.getSize());
            partitionList.get(partitionIdx).setUsedSize(process.getSize());
            processIndex++;
        }
    }

}
