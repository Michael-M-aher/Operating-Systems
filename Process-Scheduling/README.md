# Scheduler Simulation Program

<img src="https://media.geeksforgeeks.org/wp-content/uploads/20220526113439/CPUSchedulingAlgorithmsinOperatingSystems3.jpg">

## Brief

This program simulates four scheduling algorithms: preemptive Shortest-Job-First (SJF) scheduling with context switching, Round Robin (RR) with context switching, preemptive Priority Scheduling (with the solving of starvation problem), and AG Scheduling.


## Usage

1. Clone the repository or download the ZIP file.
2. Open the project in your preferred Java IDE (e.g. Eclipse, IntelliJ, NetBeans).
3. Build and run the project.
4. The program will prompt you to enter the number of processes you want to simulate, as well as the quantum time for each process.
5. The program will output the generated scheduling.

## Requirements

- Java Development Kit (JDK) 8 or later
- Java IDE (e.g. Eclipse, IntelliJ, NetBeans)


## Schedulers
### Preemptive Shortest-Job-First (SJF) Scheduling with Context Switching
This scheduler prioritizes processes based on their remaining execution time. It uses context switching to allow multiple processes to run concurrently. If a process with a shorter execution time arrives while a process is currently running, the current process is preempted and the shorter process is run.

### Round Robin (RR) with Context Switching
This scheduler assigns a fixed time quantum to each process, allowing each process to run for a specified amount of time before being preempted and placed back in the ready queue. If a process finishes before its quantum is up, it is placed back in the ready queue.

### Preemptive Priority Scheduling (with the Solving of Starvation Problem)
This scheduler assigns priorities to processes, with higher priority processes being run first. If a process with a higher priority arrives while a lower priority process is currently running, the lower priority process is preempted and the higher priority process is run. To solve the starvation problem, this scheduler changes the priority of a process after a certain amount of time has passed.

### AG Scheduling
This scheduler assigns a static time quantum to each process. After a process has been running for a certain percentage of its quantum time, it is switched to non-preemptive priority scheduling. After a certain amount of time has passed, it is switched to preemptive SJF scheduling.
