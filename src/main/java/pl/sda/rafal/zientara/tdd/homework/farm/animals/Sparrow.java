package pl.sda.rafal.zientara.tdd.homework.farm.animals;

public class Sparrow extends BirdAnimal{
    public Sparrow(String skin, String name) {
        super(skin, name);
    }
    public Sparrow(String name) {
        super("piora", name);
    }
    public Sparrow() {
        super("piora","Captain Jack Sparrow");
    }

    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    String getSound() {
        return "CWIR";
    }
}
