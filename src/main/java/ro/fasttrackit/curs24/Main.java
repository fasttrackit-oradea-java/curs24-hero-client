package ro.fasttrackit.curs24;

public class Main {
    public static void main(String[] args) {
        HeroService service = new HeroService("http://localhost:8080");
        HeroMenu heroMenu = new HeroMenu(service);
        heroMenu.run();
    }
}
