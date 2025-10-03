import java.util.*;
public class HelpDeskSimulator{
//main driver program that reads input and runs the simulation
//ask user to type in information
    public static void main(String[] args){
        Integer of_hrs = 0;
        Integer arrival_time = 0;
        String name = "";
        Integer course_number = 0;
        Integer workload_time = 0;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your Office Hours, Dr. Jack!");
        of_hrs = keyboard.nextInt();

        System.out.println("Enter student information");
        arrival_time = keyboard.nextInt();
        name = keyboard.nextLine();
        course_number = keyboard.nextInt();
        workload_time = keyboard.nextInt();
        


        
    }
}