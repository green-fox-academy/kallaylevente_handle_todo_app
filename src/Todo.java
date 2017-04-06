import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Todo {
  private final static String FILE_NAME = "todo.csv";

  public static void main(String[] args) {
    List<String> rawLines;
    rawLines = readInput();
    System.out.println(rawLines);


  }






  public static List<String> readInput() {
    List<String> rawLines;
    Path path = Paths.get("todo.csv");
    try {
      rawLines = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
      rawLines = new ArrayList<>();
    }
  return rawLines;
  }
}
