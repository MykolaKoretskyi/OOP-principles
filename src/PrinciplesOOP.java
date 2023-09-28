import java.util.Scanner;

/**
 * The main class that receives data from the user and draws
 * a sandwich in the console using the ASCII-art method;
 */
public class PrinciplesOOP {

  private static final String RED_COLOR = "\u001B[31m";
  private static final String GREEN_COLOR = "\u001B[32m";
  private static final String RESET_COLOR = "\u001B[0m";

  /**
   * The main method that starts the program;
   */
  public static void main(String[] args) {

    Sandwich sandwich = new Sandwich();

    sandwich = getIngredients(sandwich);

    sandwich.prepareAndPrintSandwich();
  }

  /**
   * Requests, receives and processes data from the user and,
   * if necessary, overrides the sandwich object;
   *
   * @param sandwich A sandwich object that can be overridden depending
   *                 on the value entered by the user in the console;
   *
   * @return This same object, or overridden depending
   * on the value entered by the user in the console;
   */
  private static Sandwich getIngredients(Sandwich sandwich) {

    Scanner scanner = new Scanner(System.in);
    boolean prepare = false;

    while (!prepare) {

      printMessage();
      String userInput = scanner.nextLine();

      if (userInput.equals("classic")) {
        prepare = true;
      } else if (userInput.equals("salad")) {
        sandwich = new SandwichWithSalad();
        prepare = true;
      } else if (userInput.equals("sauce")) {
        sandwich = new SandwichWithSauce();
        prepare = true;
      } else if (userInput.isEmpty()) {
        System.out.println(
            RED_COLOR + "Please enter the sandwich type in the console!" + RESET_COLOR);
      } else {
        System.out.println("Please enter the correct value!");
      }
    }
    return sandwich;
  }

  /**
   * Prints a list of messages for the user to the console;
   */
  private static void printMessage() {

    System.out.print("If you want a plain classic sandwich, enter \"" +
        GREEN_COLOR + "classic" + RESET_COLOR + "\" in the console. \n"
        + "If you want a sandwich with salad, enter \"" +
        GREEN_COLOR + "salad" + RESET_COLOR + "\" in the console.\n"
        + "If you want a sandwich with sauce, enter \"" +
        GREEN_COLOR + "sauce" + RESET_COLOR + "\" in the console.\n"
        + "Enter which sandwich you want to make: "
    );
  }

}
