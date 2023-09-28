import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * A base class that creates a sandwich object;
 */
public class Sandwich {

  private static final String ORANGE_COLOR = "\u001B[38;5;208m";
  private static final String BROWN_COLOR = "\u001B[38;5;130m";
  private static final String RESET_COLOR = "\u001B[0m";
  private static final String FILE_NAME = "sandwich.properties";

  /**
   * The method assembles a sandwich from parts and outputs it to the console;
   */
  public void prepareAndPrintSandwich() {

    System.out.print(
        ORANGE_COLOR + readProperty("bunTop")
            + BROWN_COLOR + readProperty("meat")
            + ORANGE_COLOR + readProperty("bunBottom")
            + RESET_COLOR);
  }

  /**
   * Reads the specified property from the file;
   *
   * @param property The property whose value is to be read;
   * @return Property value;
   */
  public String readProperty(String property) {

    Properties properties = new Properties();

    try (FileReader reader = new FileReader("resources\\" + FILE_NAME, UTF_8)) {
      properties.load(reader);
      return properties.getProperty(property);
    } catch (IOException e) {
      System.out.println("Error reading file: " + e);
      System.exit(1);
    }
    return null;
  }

  public String getOrangeColor() {
    return ORANGE_COLOR;
  }

  public String getBrownColor() {
    return BROWN_COLOR;
  }

  public String getResetColor() {
    return RESET_COLOR;
  }

}
