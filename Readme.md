# Thread Pool Executor Example

This project demonstrates how to create and manage threads using a custom thread pool executor with Java's `ThreadPoolExecutor`, `ExecutorService`, and `ThreadFactory`. It also showcases task submission and proper shutdown of the thread pool.

## Project Structure

The project consists of the following classes:

1. **ThreadPoolExecutorExample**:
    - Creates and manages a `ThreadPoolExecutor` with configurable pool sizes, queue size, and keep-alive time.
    - Submits tasks to the executor and prints the name of the executing thread.
    - Handles thread pool shutdown after task completion.

2. **ThreadPoolExample**:
    - Utilizes an `ExecutorService` to manage a fixed thread pool.
    - Submits tasks and stores results using `Future`.
    - Prints the results of completed tasks.
    - Ensures proper shutdown of the thread pool.

3. **ThreadFactory**:
    - Custom implementation of `java.util.concurrent.ThreadFactory`.
    - Assigns unique names to threads in the pool.

## Getting Started

### Prerequisites

- Java 8 or higher
- IDE (e.g., IntelliJ, Eclipse)
- Maven or Gradle (optional)

### Installation

1. Clone this repository to your local machine.
   ```bash
   git clone https://github.com/yourusername/thread-pool-example.git
   ```

2. Open the project in your preferred IDE.

3. Ensure that the project is set up with a valid Java SDK.

### Usage

#### 1. **ThreadPoolExecutorExample**

This class allows you to create and manage a thread pool executor with configurable parameters.

```java
ThreadPoolExecutorExample executorExample = new ThreadPoolExecutorExample();
ThreadPoolExecutor threadPoolExecutor = executorExample.createThreadPool(4, 10, 5000, TimeUnit.MILLISECONDS, 100);
executorExample.submitTask(threadPoolExecutor, 5);
executorExample.shutdown(threadPoolExecutor);
```

- **createThreadPool**: Initializes a `ThreadPoolExecutor` with a core pool size, maximum pool size, keep-alive time, and a queue size.
- **submitTask**: Submits tasks that simulate work using `Thread.sleep` and prints the current thread name.
- **shutdown**: Shuts down the thread pool after the tasks are completed.

#### 2. **ThreadPoolExample**

This class demonstrates the use of `ExecutorService` to manage a fixed thread pool and submit tasks that return results via `Future`.

```java
ThreadPoolExample example = new ThreadPoolExample(5);
example.executeTask(3);
example.printTask();
example.shutdownTask();
```

- **executeTask**: Submits tasks that simulate work with `Thread.sleep` and returns a task identifier.
- **printTask**: Prints the result of the submitted tasks after completion.
- **shutdownTask**: Shuts down the executor service after task execution.

#### 3. **ThreadFactory**

This class creates threads with unique names. Each thread is named using an incrementing number prefixed by "@".

```java
ThreadFactory customThreadFactory = new ThreadFactory();
Thread thread = customThreadFactory.newThread(() -> System.out.println("Task running"));
thread.start();
```

## Examples

Below is a basic example that shows how to use the classes:

### ThreadPoolExecutorExample

```java
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutorExample executorExample = new ThreadPoolExecutorExample();
        ThreadPoolExecutor threadPoolExecutor = executorExample.createThreadPool(4, 10, 5000, TimeUnit.MILLISECONDS, 100);
        executorExample.submitTask(threadPoolExecutor, 5);
        executorExample.shutdown(threadPoolExecutor);
    }
}
```

### ThreadPoolExample

```java
public class Main {
    public static void main(String[] args) {
        ThreadPoolExample example = new ThreadPoolExample(5);
        example.executeTask(3);
        example.printTask();
        example.shutdownTask();
    }
}
```

## Thread Management

- `ThreadPoolExecutorExample` uses a custom `ThreadFactory` to ensure each thread has a unique name for easier identification during execution.
- Both `ThreadPoolExecutorExample` and `ThreadPoolExample` manage proper thread pool shutdown using the `shutdown()` method, ensuring that tasks are gracefully completed before shutting down the thread pool.

## Logging

The project uses `java.util.logging.Logger` to log exceptions that may occur during task execution.

## Conclusion

This project serves as a basic example of managing threads using Java's `ThreadPoolExecutor` and `ExecutorService`, as well as demonstrating the customization of thread pools using a custom `ThreadFactory`. You can extend or modify these examples to meet your application's needs for concurrent task execution.


