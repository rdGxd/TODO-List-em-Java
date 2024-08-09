import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
  private List<Task> tasks = new ArrayList<>();

  public void addTask(Task task) {
    tasks.add(task);
    rebalanceTasks();
  }

  public void removeTask(String name) {
    tasks.removeIf(task -> task.getName().equals(name));
  }

  public List<Task> listTasks() {
    return new ArrayList<>(tasks);
  }

  public List<Task> listTasksByCategory(String category) {
    return tasks.stream()
            .filter(task -> task.getCategory().equals(category))
            .collect(Collectors.toList());
  }

  public List<Task> listTasksByPriority(int priority) {
    return tasks.stream()
            .filter(task -> task.getPriority() == priority)
            .collect(Collectors.toList());
  }

  public List<Task> listTasksByStatus(Task.Status status) {
    return tasks.stream()
            .filter(task -> task.getStatus() == status)
            .collect(Collectors.toList());
  }

  private void rebalanceTasks() {
    tasks.sort(Comparator.comparingInt(Task::getPriority).reversed());
  }
}
