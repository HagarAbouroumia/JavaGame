package türk.lira;

public class Thief extends Person {

    Location location = Location.getInstance();
    static Thief obj = new Thief();
    String thief_position;
    int stolen_money = 0;

    public static Thief getInstance() {
        return obj;
    }

    @Override
    public void setPersonLocation() {
        int range = 20;
        int checker = 1;
        int random1, random2;
        while (checker == 1) {
            random1 = (int) (Math.random() * range) + 0;
            random2 = (int) (Math.random() * range) + 0;
            checker = location.setLocations("thief", random1, random2);
            thief_position = String.valueOf(random1) + "." + String.valueOf(random2);

        }
    }

    public String getThief_position() {
        return thief_position;
    }

    public int getStolen_money() {
        return stolen_money;
    }

    public void setStolen_money(String mine, int deploy_time) {
        switch (mine) {
            case "silver":
                this.stolen_money = this.stolen_money + 1 + (deploy_time);
                break;
            case "gold":
                this.stolen_money = this.stolen_money + 2 + 2 * (deploy_time);
                break;
            case "diamond":
                this.stolen_money = this.stolen_money + 3 + 3 * (deploy_time);
                break;

        }

    }

}
