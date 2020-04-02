package türk.lira;

import java.util.Scanner;

public class PBank {

    Location location = Location.getInstance();
    Thief thief = Thief.getInstance();
    Peasant peasant = Peasant.getInstance();
    static PBank obj = new PBank();

    public static PBank getInstance() {
        return obj;
    }

    public void setLocation() {
        location.setLocations("PBank", 0, 0);
    }

    public void calculateLira() {
    }

    public static void main(String[] args) {
        String[] deployed_mines = new String[21];
        int deployed_mines_size = 0;
        int[] deploy_time_array = new int[21];
        int deploy_time_array_size = 0;
        int deploy_time;
        int choice = 1;
        int no_of_stolen_mines = 0;

        Scanner input = new Scanner(System.in);
        PBank bank = PBank.getInstance();
        Mines mines = Mines.getInstance();
        Peasant peasant = Peasant.getInstance();
        Thief thief = Thief.getInstance();
        bank.setLocation();
        mines.setMinesLocations();
        thief.setPersonLocation();
        peasant.getNearestMine();
        mines.print();

        while (choice != 2) {
            System.out.println("Choose one option\n(1) Collect Mine\n(2) Terminate");
            choice = input.nextInt();
            if (choice == 1) {
                if (deployed_mines_size == 20) {
                    System.out.println("There are 20 mine pieces inside the bank, choose another choice");
                } else {
                    System.out.println("Enter deploy hour");
                    deploy_time = input.nextInt();
                    if (Float.parseFloat(thief.thief_position) < Float.parseFloat(peasant.peasant_position)) {
                        System.out.println("The Thief is stealing " + deployed_mines[no_of_stolen_mines] + " with interests = " + deploy_time);
                        thief.setStolen_money(deployed_mines[no_of_stolen_mines++], deploy_time);
                    }
                    deployed_mines[deployed_mines_size++] = peasant.deployingMines();
                    deploy_time_array[deploy_time_array_size++] = deploy_time;
                }
            }
                    System.out.println("deployed mines by the peasant ");
        for (int i = 0; i < 21; i++) {
            System.out.println(deployed_mines[i]);
        }
        System.out.println("deploy time array");
        for (int i = 0; i < 21; i++) {
            System.out.println(deploy_time_array[i]);
        }

        
        }


    }
}
