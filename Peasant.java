package türk.lira;

public class Peasant extends Person {

    Location location = Location.getInstance();
    Mines mines = Mines.getInstance();
    Thief thief = Thief.getInstance();
    static Peasant obj = new Peasant();
    String peasant_position;

    public static Peasant getInstance() {
        return obj;
    }

    public String getPeasant_position() {
        return peasant_position;
    }   // the peasant position is with the nearest mine

    public void setPeasant_position(String peasant_position) {
        this.peasant_position = peasant_position;
    }

    @Override
    public void setPersonLocation() {

    } 
    public void getNearestMine() {
        float nearest = Float.parseFloat(String.valueOf(mines.get_from_mines_array(0)) + "." + String.valueOf(mines.get_from_mines_array(1)));
        for (int i = 0; i < 41; i = i + 2) {
            float checker = Float.parseFloat(String.valueOf(mines.get_from_mines_array(i)) + "." + String.valueOf(mines.get_from_mines_array(i + 1)));
            if (nearest > checker) {
                nearest = checker;
            }
        }
        setPeasant_position(String.valueOf(nearest));
    }

    public String deployingMines() {
        getNearestMine();
        String[] parts = peasant_position.split("\\.", -1);
        int i = Integer.parseInt(parts[0]);
        int j = Integer.parseInt(parts[1]);
        String deployed_mine = location.get_remove_from_locations_array(i, j);
        return deployed_mine;
    }

}
