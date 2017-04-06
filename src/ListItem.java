public class ListItem {
  private String task;
  private String status;

  public ListItem(String task, String status) {
    this.task = task;
    this.status = status;
  }

  @Override
  public String toString() {
    return "ListItem{" +
      "type='" + task + '\'' +
      ", status='" + status + '\'' +
      '}';
  }
}
