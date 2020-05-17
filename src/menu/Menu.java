package menu;

import java.util.Scanner;

public class Menu {
    private String[] menuItems;

    public Menu(String[] menuItems) {
        this.menuItems = menuItems;
    }

    public int displayMenu() {
        System.out.println("\n");
        for(String it: menuItems){
            System.out.println(it);
        }

        Scanner scanner = new Scanner(System.in);
        int chosenMenuItem = -1;
        while(chosenMenuItem < 0 || chosenMenuItem > menuItems.length){
            chosenMenuItem = scanner.nextInt();
        }

        return chosenMenuItem;
    }
}
