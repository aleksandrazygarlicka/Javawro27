package pl.sda.rafal.zientara.tdd.homework.farm;


import pl.sda.rafal.zientara.tdd.homework.farm.animals.*;

public class MainFarm {

    public static void main(String[] args) {
        OldMcDonaldFarm<Animal> donaldFarm = new OldMcDonaldFarm<>();
        //todo 5. Dodaj zwierzeta do zoo - po 1 z kazdego
donaldFarm.addAnimal(new Cow());
donaldFarm.addAnimal(new Chicken());
donaldFarm.addAnimal(new Sparrow());
donaldFarm.addAnimal(new Dog());
        donaldFarm.printAllInfo();
        donaldFarm.printBirdsInfo();
        donaldFarm.printMammalsInfo();
    }
}
