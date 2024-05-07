import java.io.File;
import java.util.Scanner;

public class Profile {
    private String name;
    private String mail;
    private String birth_day;


public String getBirth_day() {
    return birth_day;
}
public String getMail() {
    return mail;
}
public String getName() {
    return name;
}
public void setBirth_day(String birth_day) {
    this.birth_day = birth_day;
}
public void setMail(String mail) {
    this.mail = mail;
}
public void setName(String name) {
    this.name = name;
}

public void stamp(){
    System.out.println("Nome: " + name);
    System.out.println("Anno di nascita: " + birth_day);
    System.out.println("Email: " + mail);
}
public void load(String db){
    try {
        File myFile = new File("./lib/" + db);
        Scanner scan = new Scanner(myFile);
        String stringa = scan.nextLine();
        String[] dati = new String[3];
        dati = stringa.split(";");
        name = dati[0];
        mail = dati[1];
        birth_day = dati[2];
        scan.close();
    }catch (Exception e) {
        // TODO: handle exception
        System.out.println("Errore");
        e.printStackTrace();
    }
}


}