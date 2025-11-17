package utlis;

import modals.Address;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Helper {
    // Assign random address
    Random random = new Random();
    public Object randomObject(List<Object> lst){
        int randomIndex = random.nextInt(lst.size());
        return lst.get(randomIndex);
    }
}
