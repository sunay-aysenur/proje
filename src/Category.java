public class Category {
    private int id;
    private String categoryCode;
    private String categoryName;

    public Category(int id, String categoryName, String categoryCode){
        this.id = id;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public String getCategoryName(){
        return categoryName;
    }

    public String getCategoryCode(){
        return categoryCode;
    }

}
