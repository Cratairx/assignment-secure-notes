package org.example.UI;

import org.example.service.AuthService;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);
    private  final AuthService service = new AuthService();
    public void start(){
        boolean running = true;
        while(running){
            System.out.println("Starting secure notes");
            System.out.println("1. Register user");
            System.out.println("2. Exit");
            String choice = scanner.nextLine();

            switch (choice){
                case "1" -> register();
                case "2" -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }




    }

    private void register(){
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();

        String hashedPassword = BCrypt.hashpw(password,BCrypt.gensalt());

        boolean success = service.register(username,hashedPassword);
        if (success){
            System.out.println("User registrered sucessfully");
        }else{
            System.out.println("Username or password inccorect");
        }
    }

}
