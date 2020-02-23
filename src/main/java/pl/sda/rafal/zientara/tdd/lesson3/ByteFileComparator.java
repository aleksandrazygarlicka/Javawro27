package pl.sda.rafal.zientara.tdd.lesson3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ByteFileComparator {

    private final static int BUFFER_SIZE = 1024;

    private char[] buffer1 = new char[BUFFER_SIZE];
    private char[] buffer2 = new char[BUFFER_SIZE];

    private int read1;
    private int read2;
    private FileReader reader1;
    private FileReader reader2;
    private long startTime;

    public boolean compareByBytes(File png, File possibleDuplicate) {
            try {
                startTime = System.currentTimeMillis();
                reader1 = new FileReader(png);
                reader2 = new FileReader(possibleDuplicate);
                buffer1 = new char[BUFFER_SIZE];
                buffer2 = new char[BUFFER_SIZE];
                do  {
                    read1 = reader1.read(buffer1);
                    read2 = reader2.read(buffer2);
                    if (read1 != read2) {
                        System.out.println("Inne! " + read1 + "!=" + read2);
                        closeReaders(reader1, reader2);
                        printReport("Nie duplikat! Zmarnowałem [ms] ");
                        return false;
                    }
                    else {
                        for (int i = 0; i <buffer1.length; i++) {
                            char c1 = buffer1[i];
                            char c2 = buffer2[i];
                            if (c1!=c2) {
                                closeReaders(reader1, reader2);
                                reportWasteOfTime(read1, read2);
                                return false;
                            }
                        }
                    }
                } while (read1 != -1 && read2 != -1);
                //todo sprawdz jeszcze raz read1 i read2
                closeReaders(reader1, reader2);
                printReport("Duplikat! Znaleziono po [ms] ");

                return true;
            } catch (FileNotFoundException e) {
                System.out.println("Nie ma takiego pliku!");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Błąd odczytu!");
                e.printStackTrace();
            }
            return false;
    }

    private void closeReaders(FileReader reader1, FileReader reader2) throws IOException {
        reader1.close();
        reader2.close();
    }

    private void reportWasteOfTime(int read1, int read2) {
        System.out.println("Inne! " + read1 + "!=" + read2);
        String text = "Nie duplikat! Zmarnowałem [ms] ";
        printReport(text);
    }

    private void printReport(String text) {
        long diff = getTimeDiff();
        System.out.println(text + diff);
    }

    private long getTimeDiff() {
        long end = System.currentTimeMillis();
        return end - startTime;
    }
}