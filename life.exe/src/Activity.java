public class Activity extends Activity_managment {
    private String name;
    private String description;
    private int difficulty;
    private boolean positive;

    public Activity(String name, String description, int difficulty, boolean positive){
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.positive = positive;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public boolean getPositive() {
        return positive;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }
}
