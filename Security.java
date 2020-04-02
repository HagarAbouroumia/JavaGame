package türk.lira;

public class Security extends Person {

    Location location = Location.getInstance();

    @Override
    public void setPersonLocation() {
        int range = 20;
        int checker = 1;
        int random1, random2;
        while (checker == 1) {
            random1 = (int) (Math.random() * range) + 0;
            random2 = (int) (Math.random() * range) + 0;
            checker = location.setLocations("peasant", random1, random2);
        }
    }
}
