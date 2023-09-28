/**
 * This class inherits the properties of the parent class and overrides its method;
 */
public class SandwichWithSauce extends Sandwich {

  private static final String RED_COLOR = "\u001B[31m";

  /**
   * The method overrides the parent class method of the same name and adds additional properties to
   * it; This method directly uses other methods of the parent class;
   */
  @Override
  public void prepareAndPrintSandwich() {

    System.out.print(getOrangeColor() + readProperty("bunTop")
        + getBrownColor() + readProperty("meat")
        + RED_COLOR + readProperty("sauce")
        + getOrangeColor() + readProperty("bunBottom")
        + getResetColor());
  }
}
