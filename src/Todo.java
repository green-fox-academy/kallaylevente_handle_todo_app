import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Todo {
  private final static String FILE_NAME = "todo.csv";

  public static void main(String[] args) {
    List<String> rawLines;
    rawLines = readInput();
    //System.out.println(rawLines);
    List<ListItem> listItems = new ArrayList<>();
    listItems = extractListItem(rawLines);
    // System.out.println(listItems);

    if (args.length == 0) {
      emptyCase();
    } else if ((args[0].equals("-l") && (args.length == 1))) {
      if (listItems.size() == 0) {
        System.out.println("No todos for today! :)");
      } else {
        sout(listItems);
      }
    } else if (args[0].equals("-a") && (args.length == 2)) {
      ListItem addedItem = new ListItem(args[1], "0");
      listItems.add(addedItem);
      sout(listItems);
      writeToFile(listItems);
    } else if (args[0].equals("-c") && (args.length == 2) && (Integer.parseInt(args[1]) < (listItems.size() + 1))) {
      listItems.get(Integer.parseInt(args[1]) - 1).setStatus("x");
      sout(listItems);
      writeToFile(listItems);
    } else if (args[0].equals("-r") && (args.length == 2) && (Integer.parseInt(args[1]) < (listItems.size() + 1))) {
      listItems.remove(Integer.parseInt(args[1]) - 1);
      writeToFile(listItems);
      ListItem.setCounter(0);
      rawLines = readInput();
      listItems = extractListItem(rawLines);
      sout(listItems);
    } else if (isValidArgument(args[0])) {
      System.out.println("Unsupported argument");
      sout(listItems);
    } else if (args[0].equals("-a") && (args.length == 1)) {
      System.out.println("Unable to add: no task provided");
    } else if (args[0].equals("-r") && (args.length == 1)) {
      System.out.println("Unable to remove: no index provided");
    } else if (args[0].equals("-r") && (Integer.parseInt(args[1]) > (listItems.size() ))) {
      System.out.println("Unable to remove: index is out of bound");
    }
  }

  public static void emptyCase() {
    System.out.println("Java Todo application\n" +
      "=======================\n" +
      "\n" +
      "Command line arguments:\n" +
      " -l   Lists all the tasks\n" +
      " -a   Adds a new task\n" +
      " -r   Removes an task\n" +
      " -c   Completes an task");
  }

  public static List<ListItem> extractListItem(List<String> rawLines) {
    List<ListItem> listItems = new ArrayList<>();
    for (String lines : rawLines) {
      String[] splittedLines = lines.split(";");
      String task = new String();
      String status = new String();
      task = splittedLines[0];
      status = splittedLines[1];
      listItems.add(new ListItem(task, status));
    }
    return listItems;
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

  private static void writeToFile(List<ListItem> listItems) {
    List<String> data = new ArrayList<>();
    for (ListItem item : listItems) {
      data.add(item.toFile());
    }
    Path path = Paths.get(FILE_NAME);
    try {
      Files.write(path, data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void sout(List<ListItem> listItems) {
    for (int i = 0; i < listItems.size(); i++) {
      System.out.println(listItems.get(i));
    }
  }

  public static boolean isValidArgument(String argument) {
    String[] arguments = {"-l", "-r", "-a", "-c"};
    int isvalid = 0;
    for (String arg : arguments) {
      if (arg.equals(argument)) {
        isvalid = 1;
      }

    }
    if (isvalid == 1) {
      return false;
    }
    return true;

  }
}
