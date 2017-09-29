import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        //Intro text to user writing their name.
        System.out.println("Hello World");
        System.out.println("Please enter your name: ");

        //User input for their name.
        String name = userInput.nextLine();

        //Displays user name input.
        System.out.println("Your name is: " + name);

        userInput.close();


    }
}
