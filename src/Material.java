import java.util.ArrayList;

public abstract class Material {
    protected int id;
    protected String name;
    protected ArrayList<Integer> scores;
    protected int release_year;
    protected Category category;
    protected int price;
    protected String type;

    public Material(int id, String name, ArrayList<Integer> scores, int release_year, Category category, int price, String type){
        this.id = id;
        this.name = name;
        this.scores = scores;
        this.release_year = release_year;
        this.category = category;
        this.price = price;
        this.type = type;
    }

    public void addScore (int score) {
        scores.add(score);
    }

    public double getAvgScore(){
        if (scores.isEmpty()) return 0;
        int sum = 0;
        for (int score : scores){
            sum += score;
        }
        return (double) sum / scores.size();
    }

    public abstract void showDetail();

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice(){
        return price;
    }
}

