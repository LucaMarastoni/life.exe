import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Inventory {

    private int coins;
    private int active_Shield = 0;
    private String type;
    private String name;
    private String description;
    private int cost;
    private int i;

    
    Scanner scanner = new Scanner(System.in);
    
    private static ArrayList<Inventory_Items> contents  = new ArrayList<Inventory_Items>();

    public Inventory() {

        coins = 0;

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

    public int getCoins() {

        return coins;

    }

    public int getActive_Shield() {
        return active_Shield;
    }

    public String getType() {
        return type;
    }

    public void setCoins(int coins) {
        
        this.coins = coins;

    }

    public void setType(String type) {
        this.type = type;
    }

    public void setActive_Shield(int active_Shield) {
        this.active_Shield = active_Shield;
    }

    public static void sortByName() {
        
        Collections.sort(contents, new Comparator<Inventory_Items>() {
            
            @Override
            
            public int compare(Inventory_Items i1, Inventory_Items i2) {
                String name1 = i1.getName();
                String name2 = i2.getName();
                
                if (name1.equals("Pozione di cura piccola")) {
                    return -1;
                } else if (name2.equals("Pozione di cura piccola")) {
                    return 1;
                } else if (name1.equals("Pozione di cura media")) {
                    return -1;
                } else if (name2.equals("Pozione di cura media")) {
                    return 1;
                } else if (name1.equals("Pozione di cura grande")) {
                    return -1;
                } else if (name2.equals("Pozione di cura grande")) {
                    return 1;
                } else if (name1.equals("Scudo di legno")) {
                    return -1;
                } else if (name2.equals("Scudo di legno")) {
                    return 1;
                } else if (name1.equals("Scudo di ferro")) {
                    return -1;
                } else if (name2.equals("Scudo di ferro")) {
                    return 1;
                } else if (name1.equals("Scudo d'acciaio")) {
                    return -1;
                } else if (name2.equals("Scudo d'acciaio")) {
                    return 1;
                } else {
                    return name1.compareTo(name2);
                }
            }
        });
    }
    
    public static void add_item(String item) {
    
        if (item.equals("Pozione di cura piccola")) {

            contents.add(new Inventory_Items("Pozione di cura piccola", "Una pozione che cura 15 punti salute", 50, "Potion"));

        } else if (item.equals("Pozione di cura media")) {

            contents.add(new Inventory_Items("Pozione di cura media", "Una pozione che cura 30 punti salute", 100, "Potion"));

        } else if (item.equals("Pozione di cura grande")) {

            contents.add(new Inventory_Items("Pozione di cura grande", "Una pozione che cura 50 punti salute", 150, "Potion"));
    
        } else if (item.equals("Scudo di legno")) {

            contents.add(new Inventory_Items("Scudo di legno", "Un scudo di legno che protegge da 10 punti di danno", 100, "Shield"));

        } else if (item.equals("Scudo di ferro")) {

            contents.add(new Inventory_Items("Scudo di ferro", "Un scudo di ferro che protegge da 20 punti di danno", 200, "Shield"));
    
        } else if (item.equals("Scudo d'acciaio")) {

            contents.add(new Inventory_Items("Scudo d'acciaio", "Uno scudo d'acciaio che protegge da 30 punti di danno", 300, "Shield"));
    
        } else {

            System.out.println("Si è verificato un errore durante l'aggiunta di un oggetto all'inventario!");
            
            return;

        }

        if (contents.size()>= 2) {

            sortByName();

        }

    }

    public static void remove_item(int position) {
        
        contents.remove(position);

    }


    public boolean checkInventory() {
        if (contents.isEmpty()) {

            return true;
        
        } else {

            return false;

        }
    }


    public void print_items() {

        System.out.println("Hai " + coins + " monete.");

        if (checkInventory()) {

            System.out.println("\nL'inventario è vuoto!");

            return;

        } else {

            i = 1;
            
            for (Inventory_Items item : contents) {
                System.out.println(i + ") " + item.getName() + " - " + item.getDescription() + " - " + item.getCost() + " monete");
                i++;

            }
        }
    }

    public int use_item() {

        while (true) {

            System.out.println("\nQuale oggetto desideri utilizzare?");
            
            print_items();
            System.out.println("0) Esci dall'inventario");

            try {

                System.out.print("Inserisci il numero dell'oggetto che desideri usare: ");
                
                int position = Integer.parseInt(System.console().readLine());

                if (position == 0) {
                    
                    return 0;

                } else if (position > contents.size()) {
                    
                    System.out.println("\u001B[41m!!!Devi inserire un numero compreso tra 0 e " + contents.size() + ". !!!\u001B[0m");
                    scanner.reset();
                    continue;
                
                } else {

                    if (contents.get(position - 1).getType().equals("Shield")) {
                        
                        if (getActive_Shield() == 0) {
                            
                            switch (contents.get(position - 1).getName()) {
                                case "Scudo di legno":

                                    System.out.println("Hai usato lo scudo di legno, che ti proteggerà da 10 punti di danno.");
                                
                                    setActive_Shield(10);

                                    remove_item(position - 1);

                                    return 0;
                            
                                case "Scudo di ferro":

                                    System.out.println("Hai usato lo scudo di ferro, che ti proteggerà da 20 punti di danno.");

                                    setActive_Shield(20);

                                    remove_item(position - 1);

                                    return 0;

                                case "Scudo d'acciaio":

                                    System.out.println("Hai usato lo scudo d'acciaio, che ti proteggerà da 30 punti di danno.");

                                    setActive_Shield(30);

                                    remove_item(position - 1);

                                    return 0;

                                default:

                                System.out.println("Si è verificato un errore durante l'uso di uno scudo!");

                                    break;
                            }

                        } else {

                            System.out.println("Un altro scudo è già attivo, con " + getActive_Shield() + " punti di protezione rimasti!");

                        }

                    } else if (contents.get(position - 1).getType().equals("Potion")) {

                        switch (contents.get(position - 1).getName()) {
                            case "Pozione di cura piccola":
                            
                                System.out.println("\nHai bevuto tutta la pozione, e recuperi 10 punti salute!\n");
                                remove_item(position - 1);
                                return 10;

                            case "Pozione di cura media":

                                System.out.println("\nHai bevuto tutta la pozione, e recuperi 20 punti salute!\n");
                                remove_item(position - 1);
                                return 20;
                        
                            case "Pozione di cura grande":

                                System.out.println("\nHai bevuto tutta la pozione, e recuperi 30 punti salute!\n");
                                remove_item(position - 1);
                                return 30;

                            default:

                                System.out.println("Si è verificato un errore durante l'uso di una pozione!");

                                break;
                        }

                        scanner.reset();
                        return 0;

                    }

                } 
            }

            catch (Exception e) {

                System.out.println("\u001B[41mDevi inserire un numero intero!\u001B[0m");
                scanner.reset();
                continue;

            }
        }
    }

    public int use_shield(int danno) {

        if (getActive_Shield() == 0) {

            return danno;
        
        } else {
            
            if (danno > getActive_Shield()) {

                System.out.println("\nIl tuo scudo non è abbastanza forte per proteggerti da questo danno, subisci " + (danno - getActive_Shield()) + " punti di danno!\n");    
                setActive_Shield(0);
                return danno - getActive_Shield();
            
            } else {

                System.out.println("Il tuo scudo protegge da " + danno + " punti di danno!");
                setActive_Shield(getActive_Shield() - danno);
                return 0;
            }
        }
    }

    public void save_inventory(File file_name) throws IOException {
        
        FileWriter writer = new FileWriter(file_name, true);

        writer.write(coins + ";" + getActive_Shield() + ";");

        for (Inventory activity : contents) {

            writer.write(activity.getName() + ";");

        }

        writer.write("\n");

        writer.close();
    }

    public void load_inventory(File file_name) throws IOException {
        Scanner fileScanner = new Scanner(file_name);
        
        // Legge e ignora le prime 2 righe (se necessario)
        if (fileScanner.hasNextLine()) {
            fileScanner.nextLine();
            fileScanner.nextLine();
        }
        
        // Legge i dati dal file
        if (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(";");
    
            try {
                // Carica coins e activeShieldIndex
                int saved_coins = Integer.parseInt(parts[0].trim());
                coins = saved_coins;
                
                int activeShieldIndex = Integer.parseInt(parts[1].trim());
                setActive_Shield(activeShieldIndex);
                
                // Carica gli oggetti successivi
                for (int i = 2; i < parts.length; i++) {
                    String itemName = parts[i].trim();
                    add_item(itemName);
                }
                
            } catch (NumberFormatException e) {
                System.out.println("\u001B[41mu!!!Errore durante il caricamento dell'inventario!!!\u001B[0m");
            }
        } else {

            System.out.println("Il file è vuoto o non contiene dati.");

        }
    
        fileScanner.close();
    }
    
}
