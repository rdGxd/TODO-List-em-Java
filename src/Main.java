import java.time.LocalDate;
import java.util.Scanner;

public class Main {
  private static TaskManager taskManager = new TaskManager();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      System.out.println("Menu:");
      System.out.println("1. Add Task");
      System.out.println("2. Remove Task");
      System.out.println("3. List All Tasks");
      System.out.println("4. List Tasks by Category");
      System.out.println("5. List Tasks by Priority");
      System.out.println("6. List Tasks by Status");
      System.out.println("7. Exit");

      int choice = scanner.nextInt();
      scanner.nextLine();  // Consume newline

      switch (choice) {
        case 1:
          addTask();
          break;
        case 2:
          removeTask();
          break;
        case 3:
          listAllTasks();
          break;
        case 4:
          listTasksByCategory();
          break;
        case 5:
          listTasksByPriority();
          break;
        case 6:
          listTasksByStatus();
          break;
        case 7:
          System.out.println("Exiting...");
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private static void addTask() {
    System.out.println("Enter task name:");
    String name = scanner.nextLine();
    System.out.println("Enter description:");
    String description = scanner.nextLine();
    System.out.println("Enter due date (YYYY-MM-DD):");
    LocalDate dueDate = LocalDate.parse(scanner.nextLine());
    System.out.println("Enter priority (1-5):");
    int priority = scanner.nextInt();
    scanner.nextLine();  // Consume newline
    System.out.println("Enter category:");
    String category = scanner.nextLine();
    System.out.println("Enter status (TODO, DOING, DONE):");
    Task.Status status = Task.Status.valueOf(scanner.nextLine().toUpperCase());

    Task task = new Task(name, description, dueDate, priority, category, status);
    taskManager.addTask(task);
    System.out.println("Task added successfully.");
  }

  private static void removeTask() {
    System.out.println("Enter task name to remove:");
    String name = scanner.nextLine();
    taskManager.removeTask(name);
    System.out.println("Task removed successfully.");
  }

  private static void listAllTasks() {
    System.out.println("All Tasks:");
    taskManager.listTasks().forEach(System.out::println);
  }

  private static void listTasksByCategory() {
    System.out.println("Enter category:");
    String category = scanner.nextLine();
    System.out.println("Tasks in category " + category + ":");
    taskManager.listTasksByCategory(category).forEach(System.out::println);
  }

  private static void listTasksByPriority() {
    System.out.println("Enter priority (1-5):");
    int priority = scanner.nextInt();
    scanner.nextLine();  // Consume newline
    System.out.println("Tasks with priority " + priority + ":");
    taskManager.listTasksByPriority(priority).forEach(System.out::println);
  }

  private static void listTasksByStatus() {
    System.out.println("Enter status (TODO, DOING, DONE):");
    Task.Status status = Task.Status.valueOf(scanner.nextLine().toUpperCase());
    System.out.println("Tasks with status " + status + ":");
    taskManager.listTasksByStatus(status).forEach(System.out::println);
  }
}