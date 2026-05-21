/* main class
 * Siyanda Shange
 * April 2026
 */
import java.util.*; 
 public class Menu {
   public static void main(String[] args) {
      TaskManager taskManager = new TaskManager();
      Scanner scanner = new Scanner(System.in);
      boolean running = true;

      while(running) {

         System.out.println("1. Add Task");
         System.out.println("2. View Tasks");
         System.out.println("3. Complete Task");
         System.out.println("4. Exit");

         int choice = scanner.nextInt();

      switch(choice) {

        case 1:
            scanner.nextLine(); // clear buffer

            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            System.out.print("Enter module: ");
            String module = scanner.nextLine();

            System.out.print("Enter due date (YYYY-MM-DD): ");
            String dueDate = scanner.nextLine();

            System.out.print("Enter difficulty (1-5): ");
            int difficulty = scanner.nextInt();

            System.out.print("Enter estimated hours: ");
            int hours = scanner.nextInt();

            Task newTask = new Task(title, module, dueDate, difficulty, hours);

            taskManager.addTask(newTask);

            System.out.println("Task added!");
            break;

        case 2:  

            taskManager.viewTask();

            break;

        case 3:
            scanner.nextLine(); // clear buffer

            System.out.print("Enter task title to mark complete: ");
            String title_ = scanner.nextLine();

            taskManager.markComplete(title_);

            System.out.println("Task marked as complete!");
            break;

        case 4:

            taskManager.saveTasks();

            running = false;

            System.out.println("Goodbye!");

            break;

        default:
            System.out.println("Invalid choice.");
    }
}
      
   }
 }