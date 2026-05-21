/* program that manages tasks
 * Siyanda Shange
 * April 2026
 */ 
 
 import java.io.*;
 import java.util.*;
 
 public class TaskManager {
   private ArrayList<Task> tasks;
      
   public TaskManager() {
      tasks = new ArrayList<>();
            loadTask();
   }
   
   public void addTask(Task task){
      tasks.add(task);
   }
   
   public void removeTask(Task task){
      tasks.remove(task);
   
   }
   
   public void viewTask(){
      sortTask(); //sort before displaying
      for (Task task:tasks){
         task.displayTask();
         System.out.println();
      }
   }
   
   public void sortTask(){
   
      Collections.sort(tasks,
            (t1, t2) ->
                    t2.calculateUrgency()
                    - t1.calculateUrgency());   
   }
   
   public void saveTasks() {
      //convert Task object into text and writes to a file

    try {

        PrintWriter writer =
                new PrintWriter(new FileWriter("tasks.txt")); //writes to the file

        for(Task task : tasks) {
            writer.println(task.toFileString()); //each task as one line
        }

        writer.close();

        System.out.println("Tasks saved successfully.");

    }
    catch(IOException e) {
        System.out.println("Error saving tasks.");
    }
}
   public void loadTask(){
      /* a method that reads text file line by line and reconstructs Task objects*/
   
   try {

        File file = new File("tasks.txt");

        Scanner reader = new Scanner(file);

        while(reader.hasNextLine()) {

            String line = reader.nextLine();

            String[] parts = line.split(",");

            String title = parts[0];
            String module = parts[1];
            String dueDate = parts[2];
            int difficulty = Integer.parseInt(parts[3]);
            int estimatedHours = Integer.parseInt(parts[4]);
            boolean completed = Boolean.parseBoolean(parts[5]);

            Task task = new Task(
                    title,
                    module,
                    dueDate,
                    difficulty,
                    estimatedHours
            );

            if(completed) {
                task.markComplete();
            }

            tasks.add(task);
        }

        reader.close();

        System.out.println("Tasks loaded successfully.");

    }
    catch(FileNotFoundException e) {
        System.out.println("No saved tasks found.");
    }
   
   }
   
   public void markComplete(String title) {

    for (Task task : tasks) {

        if (task.getTitle().equalsIgnoreCase(title)) {
            task.markComplete();
            return;
        }
    }

    System.out.println("Task not found.");
   }
   
   

 }