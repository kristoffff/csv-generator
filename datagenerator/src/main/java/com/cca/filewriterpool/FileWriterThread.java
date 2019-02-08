package com.cca.filewriterpool;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterThread extends Thread {

    private FileWriter fileWriter;

    public FileWriterThread(Runnable r, String filePath) throws IOException {
        super(r);
        this.fileWriter = new FileWriter(filePath);
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    @Override
    public void finalize(){
        try {System.out.println("File writer closing");
            fileWriter.close();
            System.out.println("File writer closed");
        }
        catch (Exception e){

        }
    }

    public void closeFileWriter() throws IOException {
        this.fileWriter.close();
    }
}
