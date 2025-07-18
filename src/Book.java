import java.util.ArrayList;

public class Book extends Material{
    private Person writer;
    private int numberOfPages;

    public Book(int id, String name, ArrayList<Integer> scores, int release_year, Category category, int price, String type, Person writer, int numberOfPages){
        super(id, name, scores, release_year, category, price, type);
        this.writer = writer;
        this.numberOfPages = numberOfPages;
    }

    public void setWriter(Person newWriter){
        this.writer = newWriter;
    }

    public Person getWriter(){
        return writer;
    }

    @Override
    public void showDetail() {
        System.out.println("Book:" + name +
                        " Writer:" + writer.getFirstName() + " " + writer.getLastName() +
                        " Avg Score:" + getAvgScore() +
                        " Pages:" + numberOfPages +
                        " Category:" + category.getCategoryName());
}
}
