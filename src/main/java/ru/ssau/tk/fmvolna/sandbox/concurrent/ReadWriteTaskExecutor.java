package ru.ssau.tk.fmvolna.sandbox.concurrent;

import ru.ssau.tk.fmvolna.sandbox.functions.TabulatedFunction;
import ru.ssau.tk.fmvolna.sandbox.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.fmvolna.sandbox.functions.ZeroFunction;

import java.util.ArrayList;
import java.util.List;

public class ReadWriteTaskExecutor  extends Thread {
    public static void main(String[] args) throws InterruptedException {
        TabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(new ZeroFunction(), 1, 10, 10);
        List<Thread> listThread = new ArrayList<>();

        for (int i = 0; i != 20; i++) {
            listThread.add(new Thread(new ReadWriteTask(linkedListTabulatedFunction)));
        }
        for (Thread thread: listThread){
            thread.start();
        }
        Thread.sleep(2000);
        System.out.println(linkedListTabulatedFunction.toString());
    }
}
