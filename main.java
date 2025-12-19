import java.util.Scanner;
public class main{
    private static String[] taskTitles=new String[50];
    private static String[] taskDescriptions=new String[50];
    private static String[] taskStatuses=new String[50];
    private static String[] taskStudentName=new String[50];
    private static int taskCount=0;
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[]args)
    {
        printwelcome();
        boolean running=true;
        while(running){
                displayMenu();
                System.out.println("Enter your choice:");
                String input=scanner.nextLine();
                switch (input)
                {
                    case "1":
                    addTask();
                    break;
                    case "2":
                    viewTasks();
                    break;
                    case "3":
                    searchTasks();
                    break;
                    case "4":
                        UpdateTaskStatus();
                    break;
                    case "5":    
                        running=false;
                        System.out.println("Goodbye");
                        break;
                        default:
                        System.out.println("\n Invalid choice! please enter 1,2,3,4\n");
                    }
                }
                 scanner.close();
        }
            private static void printwelcome()
            {
                System.out.println("=============================================");
                System.out.println("Welcome to student task & progress Management");
                System.out.println("==============================================");
                System.out.println();
            }
            private static void displayMenu(){
                System.out.println("=======Task Management=======");
                System.out.println("1.Add Task");
                System.out.println("2.view Task");
                System.out.println("3.Exit");
                System.out.println("==============================");
            }
            private static String addTask(String title,String studentName){
                if(taskCount>=50){
                    return "Error:Task Storage is Full!";
                }
                taskTitles[taskCount]=title;
                taskDescriptions[taskCount]="No description";
                taskStatuses[taskCount]="pending";
                taskStudentName[taskCount]=studentName;
                taskCount++;
                return "Task added successfully!";
            }
            private static String addTask(String title,String description,String studentName){
                if(taskCount>=50){
                    return "Error:Task storage is full!";
                }
                taskTitles[taskCount]=title;
                taskDescriptions[taskCount]=description;
                taskStatuses[taskCount]="pending";
                taskStudentName[taskCount]=studentName;
                taskCount++;
                return "Task added successfully with description!";   
            }
            private static void addTask()
            {
                System.out.println("\n---Add new Task---");
                System.out.println("Enter stuedent Name:");
                String StudentName=scanner.nextLine();
                System.out.println("Enter task title");
                String TaskTitle=scanner.nextLine();
                System.out.println("Enter Description(or press Enter to skip):");
                String description=scanner.nextLine();
                String result;
                if(description.isEmpty()){
                result=addTask(TaskTitle,StudentName);
                }else{
                    result=addTask(TaskTitle,description,StudentName);
                }
                    System.out.println("\n"+result);
                    System.out.println();
                }
            private static void viewTasks(){
                System.out.println("\n---All Tasks---");
                if(taskCount==0){
                System.out.print("No tasks found.Add some tasks first!\n");
                return;
                }
                for(int i=0;i<taskCount;i++){
                StringBuilder sb=new StringBuilder();
                sb.append(i+1).append(".");
                sb.append("[").append(taskStatuses[i]).append("]");
                sb.append(taskTitles[i]);
                sb.append("-").append(taskStudentName[i]);
                System.out.println(sb.toString());
                if(!taskDescriptions[i].equals("No description")){
                    System.out.println("Description:"+ taskDescriptions[i]);
                }
                }
                System.out.println("\n Total Tasks:"+taskCount+"\n");
            }
            private static void searchTasks()
            {
                System.out.println("\n---Search Tasks---");
                System.out.print("Enter search keyword:");
                String keyword=scanner.nextLine().toLowerCase();
                System.out.println("---Search Results for'"+keyword+"'");
                int found=0;
                for(int i=0;i<taskCount;i++){
                    if(taskTitles[i].toLowerCase().contains(keyword)
                    || taskDescriptions[i].toLowerCase().contains(keyword) ||
                    taskStudentName[i].toLowerCase().contains(keyword)){
                        System.out.println((i+1)+".["+taskStatuses[i]+"]"+taskTitles[i]+"-"+taskStudentName[i]);
                        found++;
                    }
                }
                if(found==0){
                System.out.println("no tasks found matching'"+keyword+"'");
            }else{
                System.out.println("\n Found"+found+"task(s)");
           
            }
            }
            private static void UpdateTaskStatus(){
                System.out.println("\n---Update Task Status---");
                if(taskCount==0){
                    System.out.println("No tasks to update!\n");
                    return;
                }
                viewTasks();
                System.out.println("Enter task number to update:");
                String input=scanner.nextLine();
                try{
                    int taskNum=Integer.parseInt(input);
                    if(taskNum<1||taskNum>taskCount){
                        System.out.println("Invalid Task number!\n");
                        return;
                    }
                    System.out.println("\n Select new Staus");
                    System.out.println("1.Pending");
                    System.out.println("2.In Progress");
                    System.out.println("3.Completed");
                    System.out.println("Enter choice1");
                    String statusChoice=scanner.nextLine();
                    switch(statusChoice){
                        case "1":
                        taskStatuses[taskNum-1]="Pending";
                        break;
                        case "2":
                        taskStatuses[taskNum-1]="In Progress";
                        break;
                        case "3":
                        taskStatuses[taskNum-1]="Completed";
                        break;
                        default:
                            System.out.println("Invalid Choice! Status not Updated.");    
                            return;
                    }
                    System.out.println("Status Updated Successfully!\n");
                } catch (NumberFormatException e){
                    System.out.println("Please enter a valid number!\n");
                }
        }        
    }
    