package pl.sda.rafal.zientara.tdd.homework.farm;

import pl.sda.rafal.zientara.tdd.homework.farm.animals.Cow;

public class CowFarm extends OldMcDonaldFarm<Cow> {
    public int produceMilk(){
        int allMilk=0;
        for(Cow cows: animals) {
            allMilk+=cows.getMilk();
        }
        return allMilk;
    }
}
