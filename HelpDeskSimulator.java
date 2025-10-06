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
       // Student newStudent = new Student();
       ArrayList<Student> students = new ArrayList<>();
       ArrayList<Integer> arrivals = new ArrayList<>();
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your Office Hours, Dr. Jack!");
        of_hrs = keyboard.nextInt();

        do
        {
            System.out.println("Enter student information");
            arrival_time = keyboard.nextInt();
            name = keyboard.next();
            course_number = keyboard.nextInt();

            workload_time = keyboard.nextInt();

            if(course_number==0) break;
            // newStudent.Student(arrival_time, name, course_number, workload_time);
            arrivals.add(arrival_time);
            students.add(new Student(name, course_number, workload_time));
           // Student newStudent = new Student(name, course_number, workload_time);

        } while  (course_number != 0);


        helpDesk help = new helpDesk();
        int nextIndex=0;

        for(int minute =0; minute< of_hrs; minute++){
            while(nextIndex<students.size()&& arrivals.get(nextIndex)== minute){
                Student s = students.get(nextIndex);
                help.addStudent(s.getName(), s.getCourse(), s.getWorkLoad());
                nextIndex++;
            }
            help.step(); 
            System.out.println(help.toString());
             
        }

        //output
        
        System.out.println("LOG:");
        System.out.println(help.getLog());
        
    }
}