package main.java.com.magicvet;

import main.java.com.magicvet.component.ApplicationRunner;

import java.util.Scanner;

public class VetApp {

    public static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        ApplicationRunner applicationRunner = new ApplicationRunner();
        applicationRunner.run();
    }
}