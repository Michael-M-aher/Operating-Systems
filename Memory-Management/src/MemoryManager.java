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
            if(partition.getUsedSize() ==0){
                System.out.println("Partition "+i + "(" + (partition.getSize()-partition.getUsedSize()) + " KB => External fragment");
            }else{
                System.out.println("Partition "+i + "(" + partition.getUsedSize() + " KB => "+ partition.getProcess().getName());

            }
            if(partition.getUsedSize() !=0 && partition.getSize() != partition.getUsedSize()){
                System.out.println("Partition "+j + "(" + (partition.getSize()-partition.getUsedSize()) + " KB => External fragment");
                j++;
            }
            i++;
        }
    }
}
