import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Hello World");
        System.out.println("Please enter your name: ");
        String name = userInput.nextLine();

        System.out.println("Your name is: " + name);

        userInput.close();


    }
}
