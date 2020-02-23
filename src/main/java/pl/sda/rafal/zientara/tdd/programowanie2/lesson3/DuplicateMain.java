package pl.sda.rafal.zientara.tdd.programowanie2.lesson3;

import java.io.File;

public class DuplicateMain {
    public static void main(String[] args) {

        String path1 = "C:\\Users\\matni\\IdeaProjects\\JAVAWROtest\\src\\main\\resources\\DATA\\20200217_160826 — kopia (2).png";
        String path2 = "C:\\Users\\matni\\IdeaProjects\\JAVAWROtest\\src\\main\\resources\\DATA\\folder\\20200217_160826.png";
        File file1 = new File(path1);
        File file2 = new File(path1);

        boolean dup = FilesMMain.isDuplicate(file1, file2);

            System.out.println(dup);

    }

}
