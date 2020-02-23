package pl.sda.rafal.zientara.tdd.homework.farm;

import pl.sda.rafal.zientara.tdd.homework.farm.animals.Cow;

public class MainCowFarm {

    public static void main(String[] args) {
        //todo 6. Stworz farme Donalda gdzie bedzie mozna wprowadzac tylko krowy i dodaj dowolna liczbe
        CowFarm cows = new CowFarm();
        double randomValue = Math.random();

        for (int i = 0; i <randomValue*10; i++) {
            cows.addAnimal(new Cow());
        }
        cows.printAllInfo();
        System.out.println("Ile mleka: "+cows.produceMilk());


        //todo 7. Wydrukuj zawartosc farmy przez printAllInfo()
    }
}
