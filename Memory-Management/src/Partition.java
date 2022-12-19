
public class Partition {
    String name;
    int size;
    int usedSize;
    MemProccess process;
    
    public Partition(String name, int size) {
        this.name = name;
        this.size = size;
        this.usedSize = 0;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getUsedSize() {
        return usedSize;
    }
    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
    public MemProccess getProcess() {
        return process;
    }
    public void setProcess(MemProccess process) {
        this.process = process;
    }
}
