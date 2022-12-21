import java.util.Vector;

public class WorstFit {

    public static Vector<Partitions> partitionList =new Vector<>();
    public static Vector<Processes> processList = new Vector<>();

    public static Partitions getLargestPartition()
    {
        int maxSize = 0;
        int idx = 0;
        for(int i=0; i<partitionList.size(); i++)
        {
            if(partitionList.get(i).size > maxSize && !partitionList.get(i).status)
            {
                maxSize = partitionList.get(i).size;
                idx = i;
            }
        }
        return partitionList.get(idx);
    }

    public static void main(String[] args) {
        Processes p1 = new Processes("p1", 15);
        Processes p2 = new Processes("p2", 90);
        Processes p3 = new Processes("p3", 30);
        Processes p4 = new Processes("p4", 100);

        Partitions part0 = new Partitions("part0", 90);
        Partitions part1 = new Partitions("part1", 20);
        Partitions part2 = new Partitions("part2", 5);
        Partitions part3 = new Partitions("part3", 30);
        Partitions part4 = new Partitions("part4", 120);
        Partitions part5 = new Partitions("part5", 80);

        processList.add(p1);
        processList.add(p2);
        processList.add(p3);
        processList.add(p4);

        partitionList.add(part0);
        partitionList.add(part1);
        partitionList.add(part2);
        partitionList.add(part3);
        partitionList.add(part4);
        partitionList.add(part5);

        int size = 6;

        for(int i=0; i<processList.size(); i++)
        {
            Partitions largest = getLargestPartition();
            if(processList.get(i).size > largest.size)
                System.out.println("Process " + processList.get(i).name + " can not be allocated");
            else if(processList.get(i).size == largest.size)
            {
                largest.status = true;
                largest.occupation = processList.get(i).name;
            }
            else
            {
                int newSize = largest.size - processList.get(i).size;
                Partitions newPart = new Partitions("part" + size, newSize);
                size++;
                largest.size = processList.get(i).size;
                largest.occupation = processList.get(i).name;
                largest.status = true;
                partitionList.add(newPart);
            }
        }

        for(int i=0; i<partitionList.size(); i++)
        {
            System.out.print(partitionList.get(i).name + " ");
            System.out.print(partitionList.get(i).size + " ");
            System.out.print(partitionList.get(i).occupation + " ");
            System.out.println();
        }

    }
}
