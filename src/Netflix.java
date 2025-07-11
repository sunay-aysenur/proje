import java.util.ArrayList;

public class Netflix {
    private ArrayList<Material> materials;
    private User credential;
    private boolean isLogin;

    public Netflix(ArrayList<Material> materials){
        this.materials = materials;
        this.credential = credential;
        this.isLogin = false;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void login (User user){
        if (user.getUserName().equals("testUser") && user.getPassword().equals("123456")) {
            this.isLogin = true;
            this.credential = user;
        }
    }

    public void addMovie(Movie m1) {
        if (isLogin) materials.add(m1);
    }

    public void addBook(Book b1) {
        if (isLogin) materials.add(b1);
    }

    public void addMaterial(Material m2) {
        if (isLogin) materials.add(m2);
    }

    public void N1(){
        Material highest = materials.get(0);
        for (Material m : materials) {
            if (m.getAvgScore() > highest.getAvgScore()) {
                highest = m;
            }
        }
        System.out.println("Highest Avg Score Material: ");
        highest.showDetail();
    }

    public void N2(){
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
    }

    public void N3(int categoryId){
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
    }

    public void N4(int personId){
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
    }



}
