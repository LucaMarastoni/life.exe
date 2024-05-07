import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private int position;
    private String name;
    private String description;
    private int cost;



    Scanner scanner = new Scanner(System.in);
    private ArrayList<Items> contents = new ArrayList<>();


    public Shop() {
        contents.add(new Items("Pozione di cura piccola", "Una pozione che cura 15 punti salute", 50, "Potion"));
        contents.add(new Items("Pozione di cura media", "Una pozione che cura 30 punti salute", 100, "Potion"));
        contents.add(new Items("Pozione di cura grande", "Una pozione che cura 50 punti salute", 150, "Potion"));
        contents.add(new Items("Scudo di legno", "Un scudo di legno che protegge da 10 punti di danno", 100, "Shield"));
        contents.add(new Items("Scudo di ferro", "Un scudo di ferro che protegge da 20 punti di danno", 200, "Shield"));
        contents.add(new Items("Scudo d'acciaio", "Uno scudo d'acciaio che protegge da 30 punti di danno", 300, "Shield"));
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int buy(int coins) {

        position = 0;
        System.out.println("\nEcco i prodotti che puoi acquistare:\n");

        for (Items item : contents) {

            position++;
            System.out.print( position + ") " + item.getName() + " - " + item.getDescription() );
            
            if (contents.get(position -1).getCost() > coins) {

                System.out.print("\u001B[41m");

            } else if (contents.get(position -1).getCost() == coins) {

                System.out.print("\u001B[33m");

            } else if (contents.get(position -1).getCost() < coins) {

                System.out.print("\u001B[32m");

            } else {

                System.out.println("È stato causato un errore non previsto. Complimenti!");
                return coins;
            
            }

            System.out.println( " - " + item.getCost() + " monete\u001B[0m" );

        }

        System.out.println("0) Esci dal negozio");

        while (true) {

            System.out.print("\nInserisci l'indice del prodotto che vuoi acquistare: ");

            try {
                
                position = scanner.nextInt();

                if (position == 0) {
                    
                    return coins;

                } else if (position > contents.size() || position < 1) {

                    System.out.println("\n\u001B[41m!!! Errore: l'indice del prodotto deve essere un numero compreso tra 1 e " + contents.size() +". !!!\u001B[0m\n");
                    scanner.reset();
                    continue;

                } else {

                    if (contents.get(position -1).getCost() > coins) {
                        
                        System.out.println("\n\u001B[41m!!! Non hai abbastanza monete per acquistare questo prodotto.!!! \u001B[0m\n");
                        scanner.reset();
                        continue;

                    } else {

                        Inventory.add_item(contents.get(position - 1).getName());
                        coins -= contents.get(position - 1).getCost();
                        scanner.reset();
                        break;

                    }
                    
                }

            } catch (Exception e) {

                System.out.println("Devi inserire un numero!");
                scanner.reset();
                continue;

            }
        }

        return coins;
    }

}