package core.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.maxed.photocleaner.core.entities.CheckedFile;

import java.io.File;
import java.io.IOException;

public class  Directory {
    static String testPath = "TestingDir";
    static int originFileCount = 0;
    static int processedFilesCount = 0;
    static  int filesCount =0;
    static String absolutePath;
    static void create(){
        File dir = new File(testPath);
        dir.mkdir();
        absolutePath=dir.getAbsolutePath();
        for (int i = 0; i < 100; i++) {
            File file = new File(testPath+"/Test"+i+".png");
            try {
                file.createNewFile();
                originFileCount++;
                filesCount++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 100; i+=2) {
            File file = new File(testPath+"/Test"+i+".bMp");
            try {
                file.createNewFile();
                filesCount++;
                processedFilesCount++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 11; i+=2) {
            File file = new File(testPath+"/Test"+i+".dox.bMp");
            try {
                file.createNewFile();
                filesCount++;
                processedFilesCount++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File secondaryDir = new File(testPath+"/Something");
        secondaryDir.mkdir();
        for (int i = 100; i < 200; i+=4) {
            File file = new File(testPath+"/Something/Test"+i+".bmp");
            try {
                file.createNewFile();
                filesCount++;
                processedFilesCount++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 100; i < 200; i+=4) {
            File file = new File(testPath+"/Something/Test"+i+".dox");
            try {
                file.createNewFile();
                filesCount++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 100; i < 200; i+=3) {
            File file = new File(testPath+"/Something/Test"+i+".bmp.dox");
            try {
                file.createNewFile();
                filesCount++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void recusiveDelete(File file){
        if (!file.exists()) return;
        if (file.isDirectory()){
            for (File f :
                    file.listFiles()) {
                recusiveDelete(f);
            }
        }
        file.delete();
    }
    public static void clean(){
        File dir = new File(testPath);
        recusiveDelete(dir);
        originFileCount = 0;
        processedFilesCount = 0;
        filesCount =0;
    }
}