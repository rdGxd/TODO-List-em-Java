import java.time.LocalDate;

public class Task {
  private String name;
  private String description;
  private LocalDate dueDate;
  private int priority;
  private String category;
  private Status status;

  public enum Status {
    TODO, DOING, DONE
  }

  public Task(String name, String description, LocalDate dueDate, int priority, String category, Status status) {
    this.name = name;
    this.description = description;
    this.dueDate = dueDate;
    this.priority = priority;
    this.category = category;
    this.status = status;
  }

  // Getters and Setters
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public LocalDate getDueDate() { return dueDate; }
  public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

  public int getPriority() { return priority; }
  public void setPriority(int priority) { this.priority = priority; }

  public String getCategory() { return category; }
  public void setCategory(String category) { this.category = category; }

  public Status getStatus() { return status; }
  public void setStatus(Status status) { this.status = status; }

  @Override
  public String toString() {
    return String.format("Task{name='%s', description='%s', dueDate=%s, priority=%d, category='%s', status=%s}",
            name, description, dueDate, priority, category, status);
  }
}
