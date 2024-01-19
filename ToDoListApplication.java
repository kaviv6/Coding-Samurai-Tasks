import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    String description;
    String dueDate;
    boolean isComplete;

    public Task(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = false; // New tasks are not complete by default
    }
}

public class ToDoListApplication {

    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    addTask(scanner, taskList);
                    break;
                case 2:
                    markTaskAsComplete(scanner, taskList);
                    break;
                case 3:
                    viewTasks(taskList);
                    break;
                case 4:
                    removeTask(scanner, taskList);
                    break;
                case 5:
                    System.out.println("Exiting the To-Do List Application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n----- To-Do List Menu -----");
        System.out.println("1. Add Task");
        System.out.println("2. Mark Task as Complete");
        System.out.println("3. View Tasks");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    private static void addTask(Scanner scanner, ArrayList<Task> taskList) {
        System.out.print("Enter task title: ");
        String title = scanner.next();
        System.out.print("Enter task description: ");
        String description = scanner.next();
        System.out.print("Enter due date: ");
        String dueDate = scanner.next();

        Task newTask = new Task(title, description, dueDate);
        taskList.add(newTask);

        System.out.println("Task added successfully!");
    }

    private static void markTaskAsComplete(Scanner scanner, ArrayList<Task> taskList) {
        viewTasks(taskList);

        System.out.print("Enter the index of the task to mark as complete: ");
        int index = getUserChoice(scanner);

        if (index >= 0 && index < taskList.size()) {
            Task task = taskList.get(index);
            task.isComplete = true;
            System.out.println("Task marked as complete: " + task.title);
        } else {
            System.out.println("Invalid index. No task marked as complete.");
        }
    }

    private static void viewTasks(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available. Add tasks to the list.");
        } else {
            System.out.println("\n----- Task List -----");
            for (int i = 0; i < taskList.size(); i++) {
                Task task = taskList.get(i);
                System.out.println("Index: " + i +
                                   ", Title: " + task.title +
                                   ", Description: " + task.description +
                                   ", Due Date: " + task.dueDate +
                                   ", Status: " + (task.isComplete ? "Complete" : "Incomplete"));
            }
        }
    }

    private static void removeTask(Scanner scanner, ArrayList<Task> taskList) {
        viewTasks(taskList);

        System.out.print("Enter the index of the task to remove: ");
        int index = getUserChoice(scanner);

        if (index >= 0 && index < taskList.size()) {
            Task removedTask = taskList.remove(index);
            System.out.println("Task removed: " + removedTask.title);
        } else {
            System.out.println("Invalid index. No task removed.");
        }
    }
}
