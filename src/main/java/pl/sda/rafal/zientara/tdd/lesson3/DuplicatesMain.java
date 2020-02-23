package pl.sda.rafal.zientara.tdd.lesson3;

import java.io.File;

public class DuplicatesMain {
    public static void main(String[] args) {
        String path1 = "C:\\program\\IO Date\\femaleNames.txt";
        String path2 = "C:\\program\\IO Date\\maleNames.txt";
        String path3 = "C:\\program\\edit.txt";

        File file1 = new File(path1);
        File file2 = new File(path2);
        File file3 = new File(path3);

        boolean duplicates = FileMain.isDuplicate(file1,file2);
        System.out.println(duplicates);

    }
}
