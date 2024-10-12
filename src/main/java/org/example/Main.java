package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ThreadPoolExample threadPoolExample = new ThreadPoolExample(10);
        threadPoolExample.executeTask(20);
        threadPoolExample.printTask();
        threadPoolExample.shutdownTask();
    }
}