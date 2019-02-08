package com.cca.filewriterpool;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Filtewriterpool {

    static AtomicInteger compteur = new AtomicInteger(0);


    public static void main(String[] args) {
        final Set<FileWriterThread> poolSet = new HashSet<FileWriterThread>();

        ExecutorService pool = Executors.newFixedThreadPool(10, new ThreadFactory() {
            public Thread newThread(Runnable r) {
                try {
                    FileWriterThread thread = new FileWriterThread(r, "c:/temp/toto" + compteur.addAndGet(1));
                    poolSet.add(thread);
                    return thread;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

        for (int i = 0; i < 1000; i++) {
            pool.submit(new AcceleratorRowWriter("myRow" + i));
        }


        pool.shutdown();
        poolSet.stream().forEach(th -> {
            try {
                th.closeFileWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
