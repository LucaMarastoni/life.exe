import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Activity_managment {

    Scanner scanner = new Scanner(System.in);

    private int difficulty;
    private String condition_String;
    private int position;
    private String description;

    private ArrayList<Activity> contents = new ArrayList<Activity>();

    public boolean checkActivity() { // Controlla se l'utente ha attività da completare

        if ( contents.isEmpty() ) {
            
            return true;

        } else {

            return false;

        }
    }

    public void create_activity() {

        System.out.print("Inserisci il nome dell'attività: ");
        String name = scanner.nextLine();
        
        while (true) { // Il while serve affinché l'utente inserisca una descrizione valida
            System.out.print("Inserisci la descrizione dell'attività ( non deve essere superiore a 50 caratteri ): ");
            description = scanner.nextLine();

            if (description.length() > 50) { // Controlla che la descrizione non sia superiore a 50 caratteri

                System.out.println("\n\u001B[41m!!! Errore: la descrizione non deve essere superiore a 50 caratteri. !!!\u001B[0m\n");
            
            } else {

                break;

            }
        }

        while (true) {

            try {
                System.out.print("Inserisci la difficoltà dell'attività ( 1 = facile, 2 = media, 3 = difficile ): ");
                difficulty = scanner.nextInt();
                scanner.nextLine();
            
                if (difficulty < 1 || difficulty > 3) {

                    System.out.println("\n\u001B[41m!!! Errore: la difficoltà deve essere compresa tra 1 e 3. !!!\u001B[0m\n");
                    scanner.reset();
                    continue;

                }
            
            } catch (Exception e) {
            
                System.out.println("\n\u001B[41m!!! Errore: la difficoltà deve essere un numero intero. !!!\u001B[0m\n");
                scanner.next(); // Senza il programma va in loop, per l'amor di Dio non togliere
                continue;
            }

            break;
        }
        
        boolean positive;

         while (true) {
            System.out.print("Inserisci se l'attività è positiva o negativa: ");
            condition_String = scanner.nextLine();
            if (condition_String.equalsIgnoreCase("positiva")) {

                positive = true;
                break;

            } else if (condition_String.equalsIgnoreCase("negativa")) {

                positive = false;
                break;

            } else {

                System.out.println("\n\u001B[41m!!! Errore: l'attività deve essere positiva o negativa. !!!\u001B[0m\n");
            
            }
        }

        Activity new_Activity = new Activity(name, description, difficulty, positive);
        contents.add(new_Activity);

        }


    public void remove_activity() {
        
        while (true) {
        
            try {
                System.out.print("Inserisci l'indice dell'attività da eliminare: ");
                position = scanner.nextInt();
                scanner.nextLine();
                
                if (position >= 1 && position <= contents.size()) {
                    contents.remove(position -1);
                    break;

                } else {

                    System.out.println("\n\u001B[41m!!! Errore: l'indice deve essere compreso tra 1 e " + contents.size() + ". !!!\u001B[0m\n");
                
                }
                
            } catch (Exception e) {

                System.out.println("\n\u001B[41m!!! Errore: l'indice deve essere un numero intero. !!!\u001B[0m\n");
                scanner.next();

            }
        }
    }


    public int heal_damage(int position) {

        Activity activity = contents.get(position);

        if (activity.getPositive() == true) {

            return 1;

        } else {

            return -2;

        }
    }


    public void print_activity() {

        int i = 0;

        if (contents.isEmpty()) {
            
            System.out.println("\u001B[41m!!! Non ci sono attività da completare. !!!\u001B[0m");

        } else {
        
            for (Activity activity : contents) {

                i++;

                if (activity.getPositive() == true) {

                    System.out.print("\u001B[32m"); // Colore verde
                
                } else {

                    System.out.print("\u001B[41m"); // Colore rosso
                }

                System.out.println( i + ") " + activity.getName() + ": " + activity.getDescription() + "\u001B[0m");

            }

        }
    }


    public void save_list(File file_name) throws IOException {

        FileWriter writer = new FileWriter(file_name, true);

        for (Activity activity : contents) {

            writer.write(activity.getName() + ";" + activity.getDescription() + ";" + activity.getDifficulty() + ";" + activity.getPositive() + "\n");

        }

        writer.close();
        
    }


    public void load_list(File file_name) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(file_name);
        // Salta le prime tre righe
        fileScanner.nextLine();
        fileScanner.nextLine();
        fileScanner.nextLine();

        // Continua finché il file ha una riga nuova
        while (fileScanner.hasNextLine()) { 

            // salva la riga in una variabile
            String line = fileScanner.nextLine();

            // divide la riga in un array di stringhe

            String[] splitted_line = line.split(";");

            String name = splitted_line[0];
            String description = splitted_line[1];
            int difficulty = Integer.parseInt(splitted_line[2]);
            boolean positive = Boolean.parseBoolean(splitted_line[3]);

            Activity new_Activity = new Activity(name, description, difficulty, positive);
            contents.add(new_Activity);

        }

        fileScanner.close();
    }

    public ArrayList<Activity> getContents() {

        return contents;

    }

    public void setContents(ArrayList<Activity> contents) {

        this.contents = contents;

    }

    public int getActivityDifficulty(int position) {

        return contents.get(position).getDifficulty();

    }

}