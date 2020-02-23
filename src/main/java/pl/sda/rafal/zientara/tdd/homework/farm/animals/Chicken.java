package pl.sda.rafal.zientara.tdd.homework.farm.animals;

public class Chicken extends BirdAnimal{
    public Chicken(String skin, String name) {
        super(skin, name);
    }
    public Chicken(String name) {
        super("piora", name);
    }

    public Chicken() {
        super("Pióra", "KFC");
    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    String getSound() {
        return "KOKO euro spoko";
    }
}
