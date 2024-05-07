public class Inventory_Items extends Inventory {
    private String name;
    private String description;
    private int cost;
    private String type;

    public Inventory_Items(String name, String description, int cost, String type) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.type = type;

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

    public String getType() {
        return type;
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

    public void setType(String type) {
        this.type = type;
    }

    

}

