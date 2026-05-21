/* A lightweight task management system
 * Siyanda Shange
 * April 2026
 */
 
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Task {
   private String title;
   private String module;
   private LocalDate dueDate;
   private int difficulty;
   private int estimatedHours;
   private boolean completed;
   
   public Task(String title,String module,String dueDate,int difficulty,int estimatedHours){
      this.title=title;
      this.module=module;
      this.dueDate=LocalDate.parse(dueDate);
      this.difficulty=difficulty;
      this.estimatedHours=estimatedHours;
      this.completed=false;
   }
   
   public String getTitle() {
    return title;
   }

   public boolean isCompleted() {
    return completed;
   }

   public int getDifficulty() {
    return difficulty;
   }
   
   public int calculateUrgency(){
      int urgency = difficulty+estimatedHours;
      return urgency;
   
   }
   
   public boolean isDueSoon() { //warning method

    long hoursLeft = ChronoUnit.HOURS.between(
            LocalDate.now().atStartOfDay(),
            dueDate.atStartOfDay()
    );

    return hoursLeft <= 48 && hoursLeft >= 0;
   }
   
   public void markComplete(){
      completed = true;
   }
   public String toFileString(){

    return title + "," +
           module + "," +
           dueDate + "," +
           difficulty + "," +
           estimatedHours + "," +
           completed;
   }
   
   public void displayTask(){
   
    System.out.println("Title: " + title);
    System.out.println("Module: " + module);
    System.out.println("Due Date: " + dueDate);
    System.out.println("Difficulty: " + difficulty);
    System.out.println("Estimated Hours: " + estimatedHours);
    System.out.println("Completed: " + completed);
    System.out.println("Urgency Score: " + calculateUrgency());
    System.out.println("------------------------");
    
    if (isDueSoon() && !completed) {
        System.out.println("WARNING: Due within 48 hours!");
    }

    System.out.println("-------------------");
   }

}