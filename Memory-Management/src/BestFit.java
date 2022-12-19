import java.util.ArrayList;

public class BestFit extends MemoryManager {

    public BestFit(ArrayList<MemProccess> processList, ArrayList<Partition> partitionList) {
        super(processList, partitionList);
    }

    @Override
    void manageProcesses() {
        int processIndex = 0;
        while(processIndex < processList.size()){
            MemProccess process = processList.get(processIndex);
            Partition bestPartition = new Partition("null", 800000);
            for (Partition partition : partitionList) {
                if(partition.getUsedSize() == 0 && partition.getSize()>=process.getSize()&&partition.getSize()<bestPartition.getSize()){
                    bestPartition = partition;
                }
            }
            if(bestPartition != null){
                bestPartition.setProcess(process);
                bestPartition.setUsedSize(process.getSize());
            }
            
            processIndex++;
        }
        
    }

}
