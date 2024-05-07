import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void tutorial(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Benvenuto nel tutorial. Qui ti spiegherò ad utilizzare la nostra applicazione !!");
        System.out.println("La nostra applicazione ha come obbiettivo quello di rendere la tua vita più attiva e salutare !!");
        System.out.println("Ora ti spiegherò come iniziare.");
        System.out.print("(Premi invio per continuare)");
        scanner.nextLine();
        System.out.println("Cominciamo a parlare del Menù.");
        System.out.println("Ti spiegherò tasto per tasto come funziona.");
        System.out.println("");
        System.out.println("1 - Visualizza lista attività   Da qui puoi visualizzare tutte le attività che hai inserito.Guarda quante attività divertenti che puoi fare");
        System.out.println("2 - Aggiungi attività           Qui potrai aggiungere nuove attività.Aggiungendo nuove attività renderai la tua esperienza migliore!");
        System.out.println("3 - Rimuovi attività            Se vuoi eliminare delle attività sei nel posto giusto! Spero che siano soltanto quelle negative...");
        System.out.println("4 - Esegui attività             Le attività che completi devono essere registrate qua. Forza completa attività positive ed evita quelle negative!");
        System.out.println("5 - Visualizza personaggio      Se sei curioso di vedere le statistiche del tuo personaggio clicca qui.");
        System.out.println("6 - Visualizza profilo          Qui troverai tutti i tuoi dati personali");
        System.out.println("7 - Shop                        Guarda cosa vende il nostro venditore di tappeti Esteban.");
        System.out.println("8 - Usa strumento               Hai poca vita? Schiaccia questo pulsante per usare le tue pozioni. ");
        System.out.println("9 - Tutorial                    Non servono tante spiegazioni è quello che stai facendo");
        System.out.println("10 - Salva                      Questo tasto serve per salvare tutte le modifiche che hai fatto. Non dimenticarti di salvare mi raccomando!");
        System.out.println("0 - Chiudi                      Questo brutto tasto arresta l' applicazione. NOOOOO non schiacciarlo");
        System.out.println("");
        System.out.println("Se hai capito possiamo andare avanti");
        System.out.print("(Premi invio per continuare)");
        scanner.nextLine();
        System.out.println("Il prossimo passo è quello di spiegarti come funziona il cuore dell'applicazione");
        System.out.println("Ogni utente ha un personaggio con una barra della "+"\u001B[31mvita\u001B[37m"+ " e una barra dell'"+"\u001B[32mesperienza\u001B[37m.");
        System.out.println("Ogni attività che inserirai avrà la caratteristica di essere " + "\u001B[32mpositiva\u001B[37m " + "o " + "\u001B[31mnegativa\u001B[37m.");
        System.out.println("Inoltre ogni attività avrà anche una difficoltà. La difficoltà dipenderà da quanto è per te facile o difficile fare questa azione.");
        System.out.println("Sarai tu a decidere se una attività è " + "\u001B[32mpositiva\u001B[37m " +"o " + "\u001B[31mnegativa\u001B[37m." + "Deciderai anche la difficoltà.");
        System.out.println("Ogni attività " + "\u001B[32mpositiva\u001B[37m " + "aumenterà la tua barra della " + "\u001B[31mvita\u001B[37m" + ",ti darà dell'"+ "\u001B[32mesperienza\u001B[37m e delle monete da usare. ");
        System.out.println("Ogni attività " + "\u001B[31mnegativa\u001B[37m" + " invece ti toglierà soltanto della "+ "\u001B[31mvita\u001B[37m.");
        System.out.println("Ricorda più un attività " + "\u001B[32mpositiva\u001B[37m " + "completata è difficile più " + "\u001B[31mvita\u001B[37m" + " e " + "\u001B[32mesperienza\u001B[37m" + " aumenterai.");
        System.out.println("Al contrario se completerai un attività " + "\u001B[31mnegativa\u001B[37m" + " difficile perderai più " + "\u001B[31mnegativa\u001B[37m.");
        System.out.println("Ogni volta che riuscirai a riempire la tua barra dell'" + "\u001B[32mesperienza\u001B[37m" + " salirai di livello.");
        System.out.println("Ogni volta che salirai di livello la tua barra della " + "\u001B[31mvita\u001B[37m" + " aumenterà e di conseguenza anche quella dell'"+ "\u001B[32mesperienza\u001B[37m.");
        System.out.print("(Premi invio per continuare)");
        scanner.nextLine();
        System.out.println("L'obbiettivo del gioco è quello di non far morire il tuo personaggio.");
        System.out.println("Anche se il vero scopo è ancora più profondo: è quello di rendere la tua vita più attiva.");
        System.out.println("Frase d' effetto per farti usare l' applicazione. Grazie per aver letto il tutorial fino a qui. Buona continuazione.");
        System.out.print("(Premi invio per tornare nel menù)");
        scanner.nextLine();
    }

    public static void main(String[] args) throws Exception {

        // creo un arrayList dove sono contenuti tutti i profili con .txt per raccogliere i dati dopo
        ArrayList<String> user = new ArrayList<String>();
        String db = "";

        // mi salvo tutti i profili precedentemente salvati su ArrayList user
        try {
            File myObj = new File("./lib/profile_list.txt");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            user.add(data);

            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                user.add(data);
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        boolean death = false;

        Profile profile = new Profile();
        Pg pg = new Pg("");

        System.out.println("\n\n\u001B[38;2;255;0;0mB\u001B[38;2;255;165;0me\u001B[38;2;255;255;0mn\u001B[38;2;0;255;0mv\u001B[38;2;0;0;255me\u001B[38;2;75;0;130mn\u001B[38;2;238;130;238mu\u001B[38;2;255;0;0mt\u001B[38;2;255;165;0mo\u001B[38;2;255;255;0m/\u001B[38;2;0;255;0ma\u001B[0m \u001B[38;2;0;0;255mn\u001B[38;2;75;0;130me\u001B[38;2;238;130;238ml\u001B[0m \u001B[38;2;255;0;0mn\u001B[38;2;255;165;0mo\u001B[38;2;255;255;0ms\u001B[38;2;0;255;0mt\u001B[38;2;0;0;255mr\u001B[38;2;75;0;130mo\u001B[0m \u001B[38;2;238;130;238mg\u001B[38;2;255;0;0mi\u001B[38;2;255;165;0mo\u001B[38;2;255;255;0mc\u001B[38;2;0;255;0mo\u001B[38;2;0;0;255m!\u001B[0m");

        
        // Menu di registrazione e login
        while (true) {
            
            System.out.println("\nEcco la lista degli utenti registrati: ");
            System.out.println(user.toString().replace("[", "").replace(".txt", "").replace("]", ""));
            Scanner scan = new Scanner(System.in);
            String choice;
            System.out.println("\n1 - Login");
            System.out.println("2 - Registrati");
            System.out.print("\nScegli un'opzione: ");
            choice = scan.nextLine();

            if (choice.equals("1")) {
                String name;
                System.out.print("Inserisci il tuo nome: ");
                name = scan.nextLine() + ".txt";
                int flag = 0;

                if (!user.toString().contains(name)) {
                    System.out.println("\n\u001B[41m!!!Utente non trovato!!!\u001B[0m");
                    continue;
                }

                for (String string : user) {
                    if (string.equals(name)) {
                        db = string;
                        flag++;
                    }
                }

                if (flag >= 1) {
                    break;
                }
                
            } else if (choice.equals("2")) {
                String name;
                System.out.print("Inserisci il tuo nome: ");
                name = scan.nextLine();
                int flag=0;
                for (String string : user) {
                    if (string.equals(name + ".txt")) {
                        flag++;
                    }
                }
                if (flag >= 1) {
                    System.out.println("Utente gia registrato");
                } else {
                    profile.setName(name);
                    System.out.print("Inseriti la tua mail: ");
                    profile.setMail(scan.nextLine());
                    System.out.print("Inserisci la tua data di nascita (gg/mm/aaaa): ");
                    profile.setBirth_day(scan.nextLine());
                    System.out.println("\nUtente registrato!\n");
                    
                    System.out.print("Inserisci il nome del tuo personaggio: ");
                    pg.setName(scan.nextLine());
                    
                    user.add(name + ".txt");
                    
                    try {
                        File myObj = new File("./lib/" + name + ".txt");
                        FileWriter myWriter = new FileWriter(myObj);
                        myWriter.close();

                      } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                      }

                      try {
                        FileWriter myDelWriter;
                        myDelWriter = new FileWriter("./lib/" + name + ".txt");
                        myDelWriter.write("");
                        myDelWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    try {
                        FileWriter myWriter;
                        myWriter = new FileWriter("./lib/" + name + ".txt", true);
                        myWriter.write(profile.getName() + ";" + profile.getMail() + ";" + profile.getBirth_day() + "\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    try {
                        FileWriter myWriter;
                        myWriter = new FileWriter("./lib/" + name + ".txt", true);
                        myWriter.write(pg.getName() + ";" + pg.getLife() + ";" + pg.getLife_max() + ";" + pg.getXp() + ";" + pg.getXp_max() + ";" + pg.getLevel() + "\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    try {
                        FileWriter myWriter;
                        myWriter = new FileWriter("./lib/" + name + ".txt", true);
                        myWriter.write("10;0;\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        }

        profile.load(db);

        File myFile = new File("./lib/" + db);
        Scanner myReader = new Scanner(myFile);
        String[] row;
        String data;

        myReader.nextLine();
        row = new String[6];
        data = myReader.nextLine();
        row = data.split(";");
        pg.setName(row[0]);
        pg.setLife(Integer.parseInt(row[1]));
        pg.setLife_max(Integer.parseInt(row[2]));
        pg.setXp(Integer.parseInt(row[3]));
        pg.setXp_max(Integer.parseInt(row[4]));
        pg.setLevel(Integer.parseInt(row[5]));

        Shop shop = new Shop();
        Inventory inventory = new Inventory();

        inventory.load_inventory(myFile);
    
        Activity_managment attivita = new Activity_managment();
        attivita.load_list(myFile);

        myReader.close();

        while (true) {
            
            Scanner scan = new Scanner(System.in);
            String choice;

            if (death) {
                break;
            }

            System.out.println();
            System.out.println("|   MENU    |");
            System.out.println("1 - Visualizza lista attività");
            System.out.println("2 - Aggiungi attività");
            System.out.println("3 - Rimuovi attività");
            System.out.println("4 - Esegui attività");
            System.out.println("5 - Visualizza personaggio");
            System.out.println("6 - Visualizza profilo");
            System.out.println("7 - Shop");
            System.out.println("8 - Usa oggetto");
            System.out.println("9 - Tutorial");
            System.out.println("10 - Salva");
            System.out.println("0 - Chiudi");
            System.out.print("\nInserisci la scelta: ");
            choice = scan.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    attivita.print_activity();
                    break;
                case "2":
                    attivita.create_activity();
                    break;
                case "3":
                    if (attivita.checkActivity()) {
                        
                        System.out.println("\u001B[41m!!!Non hai attività da poter eliminare!!!\u001b[0m");

                    } else {
                        
                        attivita.print_activity();
                        attivita.remove_activity();
                    }
                    break;
                case "4":
                    if (attivita.checkActivity()) {
                        
                        System.out.println("\u001B[41m!!!Non hai attività da completare!!!\u001b[0m");
                        break;

                    } else {

                    attivita.print_activity();
                    System.out.println("0 - Nessuna");
                    System.out.println("Quale attività hai completato?");
                    
                    int activity = scan.nextInt();
                    if (activity == 0) {
                        
                        break;
                        
                    } else {
                    int value = attivita.heal_damage(activity-1)*attivita.getActivityDifficulty(activity-1);
                    if (value < 0) {
                        death = pg.damage(inventory.use_shield(value*-1));
                    } else {
                        pg.heal(value);
                        inventory.setCoins(inventory.getCoins() + (value));
                    }
                }
            }
                    break;
                case "5":
                    pg.stamp();
                    inventory.print_items();
                    break;
                case "6":
                    profile.stamp();
                    break;
                case "7":
                    inventory.setCoins(shop.buy(inventory.getCoins()));
                    break;
                case "8":
                    if (inventory.checkInventory()) {

                        System.out.println("\u001B[41m!!!Non hai oggetti da poter usare!!!\u001b[0m");
                        
                    } else {

                        pg.drinkPotion(inventory.use_item());

                    }
                    break;
                case "9":
                    tutorial();
                case "10":

                    try {
                        FileWriter myDelWriter;
                        myDelWriter = new FileWriter("./lib/profile_list.txt");
                        myDelWriter.write("");
                        myDelWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    try {
                        FileWriter myWriter;
                        myWriter = new FileWriter("./lib/profile_list.txt", true);
                        for (String string : user) {
                            myWriter.write(string + "\n");
                        }
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }



                    try {
                        FileWriter myDelWriter;
                        myDelWriter = new FileWriter("./lib/" + db);
                        myDelWriter.write("");
                        myDelWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    try {
                        FileWriter myWriter;
                        myWriter = new FileWriter("./lib/" + db, true);
                        myWriter.write(profile.getName() + ";" + profile.getMail() + ";" + profile.getBirth_day() + "\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    try {
                        FileWriter myWriter;
                        myWriter = new FileWriter("./lib/" + db, true);
                        myWriter.write(pg.getName() + ";" + pg.getLife() + ";" + pg.getLife_max() + ";" + pg.getXp() + ";" + pg.getXp_max() + ";" + pg.getLevel() + "\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    inventory.save_inventory(myFile);
                    attivita.save_list(myFile);
                    System.out.println("\u001B[42mSalvataggio completato!\u001B[0m");

                    break;
                default:
                    break;
            }

            if (death == true) {
                for (String string : user) {
                    if (string.equals(db)) {
                        user.remove(string);
                    }
                }

                try {
                    FileWriter myDelWriter;
                    myDelWriter = new FileWriter("./lib/profile_list.txt");
                    myDelWriter.write("");
                    myDelWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                try {
                    FileWriter myWriter;
                    myWriter = new FileWriter("./lib/profile_list.txt", true);
                    for (String string : user) {
                        myWriter.write(string + "\n");
                    }
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;
            }

            if (choice.equals("0")) {
                scan.close();
                break;
            }

            
        }
        
    }




}
