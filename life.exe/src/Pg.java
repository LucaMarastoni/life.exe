public class Pg {
    private String name = "" ;
    private int life = 0 ;
    private int life_max = 0 ;
    private int xp = 0 ;
    private int xp_max = 0 ;
    private int level = 0 ;

    Pg(String nameString){
        this.name = nameString ;
        this.life = 10 ;
        this.life_max = 10 ;
        this.xp = 0 ;
        this.xp_max = 10 ;
        this.level = 1 ;
    }

    boolean damage(int value_damage) {
        life -= value_damage;
        boolean death = false ;
        if (life <= 0) {
            death = death();
        }

        return death;
    }

    void heal (int heal) {
        life += heal ;
        if (life > life_max) {
            life = life_max ;
            
        }
        earn_xp(heal);
    }

    void drinkPotion(int heal) {

        life += heal ;
        if (life > life_max) {
            life = life_max ;

        }

    }

    void earn_xp (int xp) {
        this.xp += xp ;
        if (this.xp >= xp_max) {
            level_up() ;
        }
    }

    // Andrea a detto che non è difficile

    void level_up() {
        System.out.println("Congratulazioni sei salito di livello!");
        xp = 0 ;
        life_max += 5 ;
        xp_max += 10 ;
        life = life_max ;
        level++ ;
    }
    
    void stamp() {
        System.out.println("NAME: " + name);
        System.out.println("LEVEL " + level);
        System.out.println("LIFE");
        int life_bar = (life * 25) / life_max;
        int life_bar_empty = 25 - life_bar;
        for (int i = 0; i < life_bar; i++) {
            System.out.print("\u001B[41m█\u001B[0m");
        }
        for (int i = 0; i < life_bar_empty; i++) {
            System.out.print("\u001B[37m█\u001B[0m");
        }
        System.out.println("");
        System.out.println("XP");
        int xp_bar = (xp * 25) / xp_max ;
        int xp_bar_empty = 25 - xp_bar ;

        for (int i = 0; i < xp_bar; i++) {
            System.out.print("\u001B[32m█\u001B[0m");
        }
        for (int i = 0; i < xp_bar_empty; i++) {
            System.out.print("\u001B[37m█\u001B[0m");
        }
        System.out.println();
        System.out.println();
    }

    

    boolean death() {
        if (life <= 0) {
         System.out.println("Questa attività ti ha fatto più male del solito....SEI MORTO !!!!!");
        System.out.println("Il tuo account verrà cancellato tra...");
        try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        System.out.println("3..");
        try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        System.out.println("2..");
        try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        System.out.println("1..");
        try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }


          System.out.println("                                                              ▄▄▄,                                                                       ");
          System.out.println("                                                        ,,,▄▄█   ╙▀▓▄▄,                                                                  ");
          System.out.println("                                                ▄▄▌  ,▄▀▀  ╙╙         ▀█                                                            ");
          System.out.println("                                               ▓▌╙▀▀▀`        ▄▄        ▀▄,                                                          ");
          System.out.println("                                               █▌     ▄▀▀▀▀▀▀▀▀▀█▄   ,▄▄, ▀█⌐                                                        ");
          System.out.println("                                               ██▄,▄▄▀           `▀▀▀▀'▀█▌ └█                                                        ");
          System.out.println("                                               █ ▄█╚Ñ          ▀▄      ╔█`  █▌                                                        ");
          System.out.println("                                               ▐█▀                     █▌   █▌                                                        ");
          System.out.println("                                               ▐▌  ▄█   ,Æ   Æ█▄▄      ▀▓█▄╓█▌                                                        ");
          System.out.println("                     ▄▄▄,                     ,█   ╙▀  ██       ▀      ▐▓████                                                         ");
          System.out.println("                   ▓▀  ▐█                     ▐█      ▐█              ╔▄\"███                                                        ");
          System.out.println("                  █    j█                     ▐█       ▀\"    ╓            █▌                                                        ");
          System.out.println("                  █    ▐⌐                     \"█U █▄▄▄,,╓▄▄▄▀███          ██                                                        ");
          System.out.println("                  █▄    █µ                     ██ ▀▀▓▄,,,,▄▄▓▀▀▀       ▄▄█▀                                                        ");
          System.out.println("              ▄▄▄▓███▄g  ▀█▄                    ██     ▄▄`          ╓██▀                                                           ");
          System.out.println("             ██        ▀█µ ▀█▄µ                  ▀█▄              ╓███▄▄                                                           ");
          System.out.println("             ▀▌▄▄▄▄▄,,  ▐▌   ██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▓███▄,          ╙▀█`  ▀██▌▄                                                   ");
          System.out.println("             ▐█▀     ╙▀▀█Ü  ▐██⌐                   ▐█ ▀▀█▄▄▄▄  ,▄█▀    █▀   ╙▀▄,                                                 ");
          System.out.println("             ▐█,,,       █  █D▐▌                    █,   ╙▀▀▀▀▀▀    ,▄█▀       ╙▀▄,                                               ");
          System.out.println("              ▐█▀╙  ╙▀▀███  ▌ ▓`                     █▌          ╓▄██▀            ▀█▄                                             ");
          System.out.println("              ▐█▄      ▄█▌,▓ ▄▀             ╓▓       █       ▄██▀▀                  ╙█▄                                           ");
          System.out.println("                ▀▀██▌▄▄▄▄█▀▄█`     ,,▄▄▄▄▌▀▀▀█      ▐▌       █                        ╙▀▄                                         ");
          System.out.println("                        ╙▀▀▀▀▀▀▀▀▀▀       ]█      ▓M      ▐█                          \"█▌                                       ");
          System.out.println("                                            j█      █       █▌         ███▄,              ██w                                      ");
          System.out.println("                                             █      █       █          ███████▌▄µ        ▄███                                     ");
          System.out.println("                                             █      █      j█         ▓██████   █▀      ▄███╩                                    ");

          return true;
        } 

        return false;
    }
    


    
    
    
    public String getName(){
        return name;
    }

    public int getLevel() {
        return level;
    }
    
    public int getLife_max() {
        return life_max;
    }

    public int getLife() {
        return life;
    }

    public int getXp() {
        return xp;
    }
    
    public int getXp_max() {
        return xp_max;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setLife_max(int life_max) {
        this.life_max = life_max;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setXp_max(int xp_max) {
        this.xp_max = xp_max;
        
    }
    
}
