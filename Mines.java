package türk.lira;

public class Mines {

    Location location = Location.getInstance();
    static Mines obj = new Mines();
    int[] mines_positions_inLocations = new int[42];
    public static Mines getInstance() {
        return obj;
    }
    public void setMinesLocations() {
        int range = 20; // max - min +1 for the array[20][20]
        int range2 = 3; // for the 3 types of the mines
        int random, random1, random2, checker;

        for (int counter = 0; counter < 41; counter = counter + 2) {
            random = (int) (Math.random() * range2) + 1;
            random1 = (int) (Math.random() * range) + 0;
            random2 = (int) (Math.random() * range) + 0;
            switch (random) {
                case 1:

                    checker = location.setLocations("silver", random1, random2);
                    counter = (checker == 1) ? counter - 2 : counter;
                    if (checker == 0) {
                        mines_positions_inLocations[counter] = random1;
                        mines_positions_inLocations[counter + 1] = random2;
                    }

                    break;
                case 2:
                    checker = location.setLocations("gold", random1, random2);
                    counter = (checker == 1) ? counter - 2 : counter;
                    if (checker == 0) {
                        mines_positions_inLocations[counter] = random1;
                        mines_positions_inLocations[counter + 1] = random2;
                    }

                    break;
                case 3:
                    checker = location.setLocations("diamond", random1, random2);
                    counter = (checker == 1) ? counter - 20 : counter;
                    if (checker == 0) {
                        mines_positions_inLocations[counter] = random1;
                        mines_positions_inLocations[counter + 1] = random2;
                    }
                    break;
            }
        }
    }
    public int get_from_mines_array(int i) { // when u take from thw array check what happens ?       
        int temp = mines_positions_inLocations[i];
  
        return temp;
    } 
    public void print() {
        int count = 0;
        System.out.println("hereeeeeeeee");
        for (int i = 0; i < 41; i = i + 2) {
            count = count + 1;
            System.out.println(location.get_remove_from_locations_array(mines_positions_inLocations[i], mines_positions_inLocations[i + 1]));
            count++;

        }
        System.out.println(count/2);
    }
    
    

}
