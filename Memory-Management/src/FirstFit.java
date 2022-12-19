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
            for (int i = 0; i < partitionList.size(); i++) {
                if(partitionList.get(i).getUsedSize() == 0 && partitionList.get(i).getSize()>= process.getSize()){
                    partitionList.get(i).setProcess(process);
                    if(partitionList.get(i).getSize() != process.getSize()){
                        partitionList.add(i+1 ,new Partition("Partition" + partitionList.size(), partitionList.get(i).getSize()-process.getSize()));    
                    }
                    partitionList.get(i).setSize(process.getSize());
                    break;
                }
            }
            processIndex++;
        }
    }
    


}
