import java.util.ArrayList;

public class ListItem {
  private String task;
  private String status;
  static int counter = 0;
  public int id = 0;


  public ListItem(String task, String status) {
    this.task = task;
    this.status = status;
    this.counter  = counter + 1;
    this.id = this.counter;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String toFile() {

    return task + ";" + status;
  }

  @Override
  public String toString() {
    String result = "";
    // 1 - Walk the dog
    result = (this.id + " - " + task );
    return result;
  }
}
