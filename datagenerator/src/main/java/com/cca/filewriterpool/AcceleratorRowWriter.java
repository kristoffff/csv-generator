package com.cca.filewriterpool;

public class AcceleratorRowWriter implements Runnable {

    private String str;

    public AcceleratorRowWriter(String str) {
        this.str = str;
    }

    public void run() {
        try {
            ((FileWriterThread) Thread.currentThread()).getFileWriter().write(this.str);
        }
        catch (Exception e0){
            e0.printStackTrace();
        }
    }
}
