import java.util.ArrayList;

public class FirstFit extends MemoryManager{

    public FirstFit(ArrayList<MemProccess> processList, ArrayList<Partition> partitionList) {
        super(processList, partitionList);
    }

    @Override
    void manageProcesses() {
        //error in printing
        int processIndex = 0;
        while(processIndex < processList.size()){
            MemProccess process = processList.get(processIndex);
            for (Partition partition : partitionList) {
                if(partition.getUsedSize() == 0 && partition.getSize()>= process.getSize()){
                    partition.setProcess(process);
                    partition.setUsedSize(process.getSize());
                    break;
                }
            }
            processIndex++;
        }
    }
    


}
