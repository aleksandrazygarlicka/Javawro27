package pl.sda.rafal.zientara.tdd.homework.farm.animals;

public class Dog extends MammalAnimal{

    public Dog(String skin, String name) {
        super(skin, name);
    }
    public Dog(String skin) {
        super(skin, "Burek");
    }
    public Dog() {super("fur","Burek");}

    @Override
    String getSound() {
        return "HAU";
    }
}
