package ro.fasttrackit.curs24;

import ro.fasttrackit.curs24.domain.Hero;

import java.util.List;
import java.util.Scanner;

public class HeroMenu {
    private final HeroService heroService;

    public HeroMenu(HeroService service) {
        this.heroService = service;
    }

    public void run() {
        int option;
        Scanner scanner = new Scanner(System.in);
        do {
            printMenu();
            option = readOption(scanner);
            processOption(option);
        } while (option != 0);
    }

    private int readOption(Scanner scanner) {
        System.out.print("Select option: ");
        return scanner.nextInt();
    }

    private void processOption(int option) {
        switch (option) {
            case 1:
                printAllHeroes();
                break;
            case 2:
                addHero();
                break;
        }
    }

    private void addHero() {
        Hero newHero = readNewHero();
        Hero addedHero = heroService.addHero(newHero);
        System.out.println("Added  " + addedHero);
    }

    private Hero readNewHero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Skill: ");
        int skill = scanner.nextInt();

        return new Hero(name, skill);
    }

    private void printAllHeroes() {
        List<Hero> heroes = heroService.getAll();
        System.out.println(heroes);

    }

    private void printMenu() {
        System.out.println("1) Print all heroes");
        System.out.println("2) Add hero");
        System.out.println("0) Exit");
        System.out.println("-------------------");
    }
}
