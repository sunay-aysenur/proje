import java.util.ArrayList;
import java.util.Optional;
import java.util.Comparator;

public class Netflix extends LoginSystem {
    private ArrayList<Material> materials;
    private ArrayList<Writer> writers;
    private User credential;
    private boolean isLogin;

    public Netflix(ArrayList<Material> materials){
        this.materials = materials;
        this.writers = new ArrayList<>();
        this.isLogin = false;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    @Override
    public void login(User user) {
        if (user.getUserName().equals("testUser") && user.getPassword().equals("123456")) {
            this.credential = user;
            this.isLogin = true;
        }
    }

    public void addWriter(Writer writer) {
        writers.add(writer);
    }

    public void addMovie(Movie m1) {
        if (isLogin) materials.add(m1);
    }

    public void addBook(Book b1) {
        if (isLogin) materials.add(b1);

        if (b1.getWriter() instanceof Writer) {
            ((Writer) b1.getWriter()).addBook(b1);
        }
    }

    public void addMaterial(Material m2) {
        if (isLogin) materials.add(m2);
    }

    /*public void N1(){
        Material highest = materials.get(0);
        for (Material m : materials) {
            if (m.getAvgScore() > highest.getAvgScore()) {
                highest = m;
            }
        }
        System.out.println("Highest Avg Score Material: ");
        highest.showDetail();
    }
     */

    public void N1(){
        Optional<Material> highest = materials.stream()
                .max(Comparator.comparingDouble(Material::getAvgScore));

        highest.ifPresent(m -> {
            System.out.println("Highest Avg Score Material:");
            m.showDetail();
        });
    }

   /* public void N2(){
        Movie lowestMovie = null;

        for (Material m : materials) {
            if (m instanceof Movie){
                Movie movie = (Movie) m;
                if (lowestMovie == null || movie.getAvgScore() < lowestMovie.getAvgScore()) {
                    lowestMovie = movie;
                }
            }
        }

        if (lowestMovie != null) {
            System.out.println("Lowest Avg Score Movie: ");
            lowestMovie.showDetail();
        }
    } */

    public void N2() {
        Optional<Material> lowestMovie = materials.stream()
                .filter(m -> m instanceof Movie)
                .min(Comparator.comparingDouble(Material::getAvgScore));

        lowestMovie.ifPresent(m -> {
            System.out.println("Lowest Avg Score Movie:");
            m.showDetail();
        });
    }

    /*public void N3(int categoryId){
        Material mostExpensive = null;

        for (Material m : materials) {
            if (m.getCategory().getId() == categoryId) {
                if (mostExpensive == null || m.getPrice() > mostExpensive.getPrice()) {
                    mostExpensive = m;
                }
            }
        }
        if (mostExpensive != null) {
            System.out.println("Most Expensive Material in Category: " + categoryId);
            mostExpensive.showDetail();
        }
    } */

    public void N3(int categoryId) {
        Optional<Material> mostExpensive = materials.stream()
                .filter(m -> m.getCategory().getId() == categoryId)
                .max(Comparator.comparingInt(Material::getPrice));

        mostExpensive.ifPresent(m -> {
            System.out.println("Most Expensive Material:" + categoryId);
            m.showDetail();
        });
    }

    /*public void N4(int personId){
        for (Material m : materials) {
            if (m instanceof Movie) {
                Movie movie = (Movie) m;
                for (Person actor : movie.getActors()) {
                    if (actor.getId() == personId) {
                        movie.showDetail();
                        break;
                    }
                }
            }
        }
    } */

    public void N4(int personId) {
        materials.stream()
                .filter(m -> m instanceof Movie)
                .map(m -> (Movie) m)
                .filter(m -> m.getActors().stream().anyMatch(p -> p.getId() == personId))
                .forEach(Movie::showDetail);
    }

    /*public void N5() {
        System.out.println("85 ve üzeri ortalama skora sahip kitap yazmış yazarlar:");
        for (Writer writer : writers) {
            for (Book book : writer.getBooks()) {
                if (book.getAvgScore() >= 85) {
                    System.out.println(" - " + writer.getFirstName() + " " + writer.getLastName());
                    break;

                }
            }
        }
    } */

    public void N5() {
        System.out.println("85 ve üzeri ortalama skora sahip kitap yazmış yazarlar:");
        writers.stream()
                .filter(writer -> writer.getBooks().stream()
                        .anyMatch(book -> book.getAvgScore() >= 85))
                .forEach(writer -> System.out.println(writer.getFirstName() + " " + writer.getLastName()));
    }

}
