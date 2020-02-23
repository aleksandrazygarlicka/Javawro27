package pl.sda.rafal.zientara.tdd.programowanie2.lesson4;

import java.io.*;

public class NamesMain {

    private static String[] femaleNames;
    private static String[] maleNames;



    public static void main(String[] args) throws IOException {

        String path1 = "C:\\Users\\matni\\IdeaProjects\\JAVAWROtest\\src\\main\\resources\\maleNames.txt";
        String path2 = "C:\\Users\\matni\\IdeaProjects\\JAVAWROtest\\src\\main\\resources\\femaleNames.txt";

            maleNames = getArray(path1);
            femaleNames = getArray(path2);

            printArray(maleNames);
            printArray(femaleNames);
        StringBuilder builder = new StringBuilder();
        builder.append(lettersRaport("Male names",maleNames));
        builder.append(lettersRaport("Female names",femaleNames));
        builder.append(wihichNamesAreMorePerLetter(maleNames,femaleNames));
        System.out.println(builder);
        writeToFile(builder.toString());


    }

    static void writeToFile(String string){
        File file = new File("C:\\Users\\matni\\IdeaProjects\\JAVAWROtest\\src\\main\\resources\\namesReport.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(string);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String wihichNamesAreMorePerLetter(String[] maleNames, String[] femaleNames){
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;
        for(char i = 'A'; i <= 'Z'; i++){
            if(numberOfNamesOnLetter(String.valueOf(i),femaleNames) > numberOfNamesOnLetter(String.valueOf(i),maleNames))
            {
                stringBuilder.append("Wiêcej imion ¿eñskich na '").append(i).append("'");
                stringBuilder.append(System.lineSeparator());
            }
            else {
                stringBuilder.append("Wiêcej imion mêskich na '").append(i).append("'");
                stringBuilder.append(System.lineSeparator());            }
        }
        return  stringBuilder.toString();
    }

    static String lettersRaport(String arrayName, String[] array){
        StringBuilder temp = new StringBuilder();
        for(char i = 'A'; i <= 'Z'; i++){
            temp.append(arrayName).append(" number of names on '").append(i).append("' :").append(numberOfNamesOnLetter(String.valueOf(i), array));
            temp.append(System.lineSeparator());
        }
        return temp.toString();
    }

    static int numberOfNamesOnLetter (String letter, String[] inNamesArray){
        int counter = 0;
        for(String el: inNamesArray){
            if(String.valueOf(el.trim().charAt(0)).equalsIgnoreCase(letter) ) counter++;
        }
        return counter;
    }

    static void printArray(String[] array){
        for (String el:array) {
            if (!el.equals(array[array.length-1]))
                System.out.print(el+";");
            else
                System.out.println(el);
        }
    }


    private static String[] getArray(String path) {
        String[] array = new String[0];
        try {
            File file = new File(path);
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String data  = bufferedReader.readLine();
            array = data.split(",");
            for(int i=0;i<array.length;i++){
                array[i] = array[i].trim();
            }
        }catch(FileNotFoundException ex){
            ex.getStackTrace();
        }catch(IOException ex){
            ex.getStackTrace();
        }
        return array;
    }
}
