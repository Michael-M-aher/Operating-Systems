import java.util.ArrayList;
import java.util.Scanner;

public class MemoryManagement {
    public static void main(String[] args) throws Exception {
        int prossesNum;
        int partitionNum;
        Scanner sc = new Scanner(System.in);
        MemoryManager mem;
        ArrayList<MemProccess> processList = new ArrayList<MemProccess>();
        ArrayList<Partition> partitionList = new ArrayList<Partition>();
        System.out.println("Enter number of pertition:");
        partitionNum =  sc.nextInt();
        for (int i = 0; i < partitionNum; i++) {
            String partitionName;
            int size;
            System.out.println("Enter partition name ,partition size: ");
            partitionName =  sc.next();
            size = sc.nextInt();
            partitionList.add(new Partition(partitionName, size));
        }


        System.out.println("Enter number of processes:");
        prossesNum =  sc.nextInt();
        for (int i = 0; i < prossesNum; i++) {
            String processName;
            int size;
            System.out.println("Enter processes name ,processes size: ");
            processName =  sc.next();
            size = sc.nextInt();
            processList.add(new MemProccess(processName, size));
        }
        int choice=99;
        do {
            System.out.println("Select the policy you want to apply\n1.First fit\n2.Best fit\n3.Worst fit");
            System.out.println("Select policy:");
            choice  = sc.nextInt();
            switch (choice) {
                case 1:
                    mem = new FirstFit(processList, partitionList);
                    mem.manageProcesses();
                    mem.print();
                    break;
                case 2:
                    mem = new BestFit(processList, partitionList);
                    mem.manageProcesses();
                    mem.print();
                    break;
                case 3:
                    mem = new WorstFit(processList, partitionList);
                    mem.manageProcesses();
                    mem.print();
                    break;
                default:
                    System.out.println("Wrong choice");
                    continue;
            }
            System.out.println("Do you want to compact? 1.yes 2.no");
            Scanner sc2 = new Scanner(System.in);
            int comp = sc2.nextInt();
            if (comp == 1) {
                mem.compact();
                mem.print();
            } else {
                continue;
            }
            
        } while (choice != 0);

        
        //Test Cases
        // ArrayList<MemProccess> processList = new ArrayList<MemProccess>();
        // ArrayList<Partition> partitionList = new ArrayList<Partition>();
        // partitionList.add(new Partition("Partition 0", 90));
        // partitionList.add(new Partition("Partition 1", 20));
        // partitionList.add(new Partition("Partition 2", 5));
        // partitionList.add(new Partition("Partition 3", 30));
        // partitionList.add(new Partition("Partition 4", 120));
        // partitionList.add(new Partition("Partition 5", 80));

        // processList.add(new MemProccess("Process 1", 15));
        // processList.add(new MemProccess("Process 2", 90));
        // processList.add(new MemProccess("Process 3", 30));
        // processList.add(new MemProccess("Process 4", 100));

        // System.out.println("First Fit:");
        // MemoryManager fcfs = new FirstFit(processList, partitionList);
        // fcfs.manageProcesses();
        // fcfs.compact();
        // fcfs.print();
        // System.out.println("Best Fit:");
        // fcfs = new BestFit(processList, partitionList);
        // fcfs.manageProcesses();
        // fcfs.compact();
        // fcfs.print();
        // System.out.println("Worst Fit:");
        // fcfs = new WorstFit(processList, partitionList);
        // fcfs.manageProcesses();
        // fcfs.compact();
        // fcfs.print();

    }
}
