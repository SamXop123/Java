
//! TO-DO LIST CREATED USING JAVA


import java.util.*;

public class ToDoList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("----YOUR ONE AND ONLY GO-TO TO-DO LIST----");

        System.out.println();
        System.out.println("Enter your total number of tasks: ");
        int size = sc.nextInt();
        sc.nextLine(); 

        String task[] = new String[size];
        String date[] = new String[size]; 

        
        for (int i = 0; i < size; i++) {
            System.out.print("Enter task " + (i + 1) + ": ");
            task[i] = sc.nextLine();

            System.out.print("Enter due date for task " + (i + 1) + ": ");
            date[i] = sc.nextLine(); 
        }

        
        System.out.println("\n----TO-DO LIST----");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". Task: " + task[i] + " | Due Date: " + date[i]);
        }

        System.out.println();

        //* ------------------------------------------------------ 

        System.out.println(
            "If you want to do any operations from the following, just press the button corresponding to the number."
            );
        System.out.println(
            "1. Delete a task \n2. Edit a task \n3. Add a task \n4. Mark Completed \n5. View tasks \n6. View Completed tasks \n7. Exit"
        );


        String[] completeArr = new String[size]; 
        String[] dueDateDone = new String[size]; 
        int completedTaskCount = 0;

        boolean running = true;
        while (running) {
            
            System.out.print("\nENTER YOUR OPERATION: ");
            int operate = sc.nextInt();
            sc.nextLine();
            System.out.println();
            

            switch(operate) {

                case 1 : 
                    System.out.println("Enter the task to delete: ");
                    int delTask = sc.nextInt() - 1;

                    if (delTask >= 0 && delTask < size) {
                        for (int i = delTask; i < size - 1; i++) {
                            task[i] = task[i + 1];
                            date[i] = date[i + 1];
                        }
                        size--; 
                        System.out.println("Task removed successfully!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 2 : 
                    System.out.println("Enter which task you want to edit:");
                    int edit = sc.nextInt() - 1;
                    sc.nextLine(); 

                    if (edit >= 0 && edit < size) {
                        System.out.print("Enter new task: ");
                        task[edit] = sc.nextLine();

                        System.out.print("Enter new due date: ");
                        date[edit] = sc.nextLine();

                        System.out.println("Task updated successfully!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 3 : 
                    
                    System.out.println("Enter your task to add: ");
                    String tasks = sc.nextLine();
                    String dates = sc.nextLine();
                    sc.nextLine();

                    size++;
                    task[task.length] = tasks;
                    date[date.length] = dates;


                case 4 : 
                
                    System.out.print("Enter the task number which is completed: ");
                    int completeIndex = sc.nextInt() - 1; 

                    if (completeIndex >= 0 && completeIndex < size) {
                        // Store the completed task and its due date
                        completeArr[completedTaskCount] = task[completeIndex];
                        dueDateDone[completedTaskCount] = date[completeIndex];
                        completedTaskCount++;

                        System.out.println("Task completed: " + task[completeIndex] + " | Due Date: " + date[completeIndex]);

                        // Shift tasks to remove the completed task
                        for (int i = completeIndex; i < size - 1; i++) {
                            task[i] = task[i + 1];
                            date[i] = date[i + 1];
                        }
                        size--; 
                    } 
                    else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                    
                case 5 :
                    System.out.println("\n----TO-DO LIST----");
                    for (int i = 0; i < size; i++) {
                        System.out.println((i + 1) + ". Task: " + task[i] + " | Due Date: " + date[i]);
                    }
                    break;

                case 6 :
                    System.out.println("\n----COMPLETED TASKS----");
                    for (int i = 0; i < completedTaskCount; i++) {
                        System.out.println((i + 1) + ". Task: " + completeArr[i] + " | Due Date: " + dueDateDone[i]);
                    }
                    break;

                case 7 :
                    running = false;
                    System.out.println("Exiting...");
                    System.out.println("Done!");
                    break;

                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        }



        sc.close();
    }
}
