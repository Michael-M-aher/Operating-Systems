# Memory Allocation Simulator


## Brief

This program simulates memory management with segmentation using three different algorithms: First Fit, Best Fit, and Worst Fit. It asks the user to input processes and then choose one of the segmentation algorithms. The program then prints the processes and asks the user if they want to compact the memory.

## How to Run the Program

- Make sure you have Java installed on your computer.
- Download the source code for the program.
- Open a terminal or command prompt and navigate to the directory where the source code is located.
- Compile the program by running the command: javac MemoryManagement.java
- Run the program by running the command: java MemoryManagement

## Using the Program

1. Once you run the program, you will be prompted to enter the number of processes you want to simulate.
2. Enter the number of processes and press enter.
For each process, you will be prompted to enter the process size and process name.
3. After you have entered all the processes, you will be prompted to choose a segmentation algorithm. 
    - Enter 1 for First Fit
    - Enter 2 for Best Fit
    - Enter 3 for Worst Fit and press enter.
4. The program will then print the processes and the memory map showing which segments of memory are allocated to each process.
5. You will then be prompted to enter '1.yes' or '2.no'
<br>
to indicate whether you want to compact the memory.
6. If you enter '1', the program will compact the memory and print the updated memory map.
7. If you enter '2', the program will exit.

## Segmentation Algorithms

### First Fit
The First Fit algorithm starts at the beginning of memory and allocates the first available segment that is large enough to accommodate the process. This algorithm is fast, but it can result in fragmentation.

### Best Fit
The Best Fit algorithm searches for the smallest available segment that is large enough to accommodate the process. This algorithm can minimize fragmentation, but it can be slower than First Fit.

### Worst Fit
The Worst Fit algorithm searches for the largest available segment and allocates the process to that segment. This algorithm can result in the most fragmentation, but it can be faster than Best Fit.

## Memory Compaction

Memory compaction is the process of moving processes around in memory to eliminate fragmentation and create larger contiguous blocks of free memory. When you choose to compact the memory in this program, the program will move all the processes to the beginning of memory and then move all the free memory to the end of memory. This can take some time, especially if there are many processes or a large amount of free memory.

## Conclusion
This program provides a simple simulation of memory allocation using three different algorithms. It can be useful for understanding how these algorithms work and how memory compaction can help reduce fragmentation.
