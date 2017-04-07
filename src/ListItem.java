public class ListItem {
  private String task;
  private String status;
  static int counter = 0;
  public int id = 0;

  public static void setCounter(int counter) {
    ListItem.counter = counter;
  }

  public String getStatus() {
    return status;
  }

  public static int getCounter() {
    return counter;
  }

  public ListItem(String task, String status) {

    this.task = task;
    this.status = status;
    this.counter  = counter + 1;
    this.id = this.counter;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String toFile() {
    return task + ";" + status;
  }

  @Override
  public String toString() {
    if (status.equals("0")) {
      status = " ";
    }
    String result = (this.id + " - " + "[" + status + "] " + task );
    return result;
  }
}
