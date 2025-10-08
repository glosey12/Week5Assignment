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
        String input = ""; 
       // Student newStudent = new Student();
       ArrayList<Student> students = new ArrayList<>();
       ArrayList<Integer> arrivals = new ArrayList<>();
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your Office Hours, Dr. Jack!");
        of_hrs = keyboard.nextInt();
        input = keyboard.nextLine();


        System.out.println("Enter student information");
     /*    do
        {

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
*/
        do {
            input = keyboard.nextLine();
            int firstSpace = -1;
            int secondSpace = -1;
            int thirdSpace = -1;

            for (int i =0; i<input.length(); i++)
            {
                if ((input.substring(i, i+1)).equals(" "))
                {
                    if (firstSpace == -1)
                        firstSpace = i;

                    else if (secondSpace == -1)
                        secondSpace = i; 
                    else if (thirdSpace == -1)
                    {   
                        thirdSpace = i;
                        break;
                    }
                }
            }

            if (firstSpace == -1 ||secondSpace == -1 || thirdSpace == -1) {
                continue;
            }
                    
            arrival_time = Integer.parseInt(input.substring(0,firstSpace));
            
            name = input.substring(firstSpace+1, secondSpace);
            course_number = Integer.parseInt(input.substring(secondSpace+1, thirdSpace));
            workload_time = Integer.parseInt(input.substring(thirdSpace+1));

            Student newStudent = new Student(name, course_number, workload_time);
            students.add(newStudent);
            arrivals.add(arrival_time);


        } while (!input.equalsIgnoreCase("DONE"));

        

        helpDesk help = new helpDesk();



        for(int minute =0; minute< of_hrs; minute++){
             help.step();
            for (int i =0; i<students.size(); i++) {
                if (arrivals.get(i)==minute) {
                    Student s = students.get(i);
                    help.addStudent(s.getName(), s.getCourse(), s.getWorkLoad());
                }
            }
           
          
            System.out.println(help.toString());    
        }

        //output
        
        System.out.println("\nLOG:");
        System.out.println(help.getLog());
        
    }
}