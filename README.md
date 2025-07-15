# Producer Consumer Implementation

This project is a small demonstration of the producer/consumer pattern written in Java. A `Producer` thread assigns work items (`Task`s) to a custom queue while multiple consumer threads pull those items and execute them. Each task simply sleeps for a configurable amount of time to emulate work being done.

## Project layout

- `CustomQueue` and `CustomQueueImpl` – simple synchronized queue used to store tasks
- `Task` and `TaskImpl` – abstraction of a unit of work
- `Producer` and `ProducerImpl` – creates tasks and places them on the queue
- `Consumer` and `ConsumerImpl` – three worker threads that wait on the queue and execute tasks
- `Main` – sample entry point that builds the queue, producer and consumers and enqueues several sample tasks

## Requirements

A Java Development Kit (JDK) version 8 or higher is required to compile and run the example.

## Building and running

1. Compile all sources:
   ```bash
   javac *.java
   ```
2. Run the example:
   ```bash
   java Main
   ```
   The program will print messages as tasks are produced and executed by the consumer threads.

The demonstration in `Main` produces 25 tasks with random execution times. Two delays are introduced during production to show that the consumers correctly wait on the queue. The consumer threads continue processing until the program is terminated (for example with `Ctrl-C`).

## Example output

```
Task: task0 is added to the queue.
Task: task1 is added to the queue.
current ThreadThread1
current ThreadThread0
Thread1 executing the task: task0
Task executed in 6 seconds
```

This output shows producers adding tasks and multiple worker threads executing them in parallel.

