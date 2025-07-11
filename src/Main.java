import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person(1, "Ayşe", "Yılmaz", 10);
        Person p2 = new Person(2, "Fatma", "Çelik", 20);
        Person p3 = new Person(3, "Zeynep", "Demir", 30);
        Person d1 = new Person(4,"Mehmet", "Öztürk", 40);
        Person d2 = new Person(5,"Ahmet", "Korkmaz", 50);
        Person w1 = new Person(6,"Mustafa", "Yıldız", 60);
        Person w2 = new Person(7,"Sude", "Sönmez", 45);

        Category c1 = new Category(101, "Aksiyon", "Act");
        Category c2 = new Category(102, "Korku", "Hor");
        Category c3 = new Category(103, "Bilim Kurgu", "Sci");
        Category c4 = new Category(101, "Aksiyon", "Act");

        ArrayList<Integer> scores1 = new ArrayList<>();
        scores1.add(80);
        scores1.add(90);

        ArrayList<Person> actors1 = new ArrayList<>();
        actors1.add(p1);
        actors1.add(p2);

        Movie m1 = new Movie(1, "Hello", scores1, 2019, c1, 50, "Movie", actors1, d1);

        ArrayList<Integer> scores2 = new ArrayList<>();
        scores2.add(60);
        scores2.add(70);

        ArrayList<Person> actors2 = new ArrayList<>();
        actors2.add(p3);

        Movie m2 = new Movie(2, "World", scores2, 2020, c2, 60,  "Movie", actors2, d2);

        ArrayList<Integer> scores5 = new ArrayList<>();
        scores5.add(90);
        scores5.add(85);

        ArrayList<Person> actors3 = new ArrayList<>();
        actors3.add(p1);

        Movie m3 = new Movie(5, "Cars", scores5, 2021, c4, 55, "Movie", actors3, d2);

        ArrayList<Integer> scores3 = new ArrayList<>();
        scores3.add(95);
        scores3.add(85);

        Book b1 = new Book(3, "Böcekler", scores3, 2000, c2, 10, "Book", w1, 100);

        ArrayList<Integer> scores4 = new ArrayList<>();
        scores4.add(80);
        scores4.add(65);

        Book b2 = new Book(4, "Uzay", scores4, 2005, c3, 20, "Book", w2, 200);

        User user = new User("testUser", "123456",1,"Aslı", "Şahin",25);

        ArrayList<Material> materialList = new ArrayList<>();
        Netflix netflix = new Netflix(materialList);

        netflix.login(user);

        netflix.addMovie(m1);
        netflix.addMovie(m2);
        netflix.addMovie(m3);
        netflix.addBook(b1);
        netflix.addBook(b2);

        System.out.println("\n N1: En yüksek ortalama skorlu material: ");
        netflix.N1();

        System.out.println("\n N2: En düşük ortalama skorlu film: ");
        netflix.N2();

        System.out.println("\n N3: Belirli kategori ID'sindeki en pahalı material (Kategori: 101)");
        netflix.N3(101);

        System.out.println("\n N4: Belirli kişiye ait filmler (Kişi ID: 3)");
        netflix.N4(3);
    }
}