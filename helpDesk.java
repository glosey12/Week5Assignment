public class helpDesk{
    private Student currentStudent;
    private int time;
    private int remainingWorkload;
    private StringBuilder log = new StringBuilder();

    // array bounded queue
    private arrayBoundedQueue<Student> q100;
    private arrayBoundedQueue<Student> q200;
    private arrayBoundedQueue<Student> q300;
    private arrayBoundedQueue<Student> q400;
    

/*  private Queue<Student> q100 = new LinkedList<>();
	private Queue<Student> q200 = new LinkedList<>();
	private Queue<Student> q300 = new LinkedList<>();
	private Queue<Student> q400 = new LinkedList<>();

*/  
     public helpDesk(){
        q100= new arrayBoundedQueue<>();
        q200= new arrayBoundedQueue<>();
        q300= new arrayBoundedQueue<>();
        q400= new arrayBoundedQueue<>();
        time=0;
        remainingWorkload=0;
        currentStudent=null;
        
    }

/* 
    public helpDesk(Integer arrival, String name, Integer course, Integer workload){
        //
        if(course/100 == 1){ // && q100 isFull /is notFull???
            //put in q1
        }
        else if(course/100 ==2){
            //put in q2
        }
        else if(course/100 ==3){
            //put in q3
        }
        else if(course/100 ==4){
            //put in q4
        }
        else { System.out.println("error");}
        
    }
        */
    public void step(){
    // Advance the simulation one minute.
        if(currentStudent !=null){
            remainingWorkload--;
            if(remainingWorkload==0){
                log.append(currentStudent.toString()).append("\n");
                currentStudent =null;
            }
        }
        else{
            if(!q100.isEmpty()) {
                currentStudent=q100.dequeue();
            }
            else if(!q200.isEmpty()){
                currentStudent=q200.dequeue();
            }
            else if(!q300.isEmpty()){
                currentStudent=q300.dequeue();
            }
            else if(!q400.isEmpty()){
                currentStudent=q400.dequeue();
            }
            if(currentStudent != null){
                remainingWorkload=currentStudent.workload;
            }
        }
        time++;
    }

    public void addStudent(Integer arrival, String name, int course, int workload){
    // Add an arriving student with the indicated name, course number, and mi
        Student s = new Student(arrival, name, course, workload);
        int level= s.getLevel();

        if(level==1) q100.enqueue(s);
        else if(level==2) q200.enqueue(s);
        else if(level==3) q300.enqueue(s);
        else if (level==4) q400.enqueue(s);
        else System.out.println("error");

       // if(!engueue(s,level)){
			//student was turned away
        //    System.out.println("error");
       // }
    }

    public int getTime(){
    // Get the current simulation time in minutes.
        return time;
    }

    public String toString(){
    // Return the status of the simulation. Example: "Time 2, Helping Jack fr
        if(currentStudent==null){
            return "Time " +time +", IDLE";
        }
        else{
            return "Time " +time+ ", Helping " + currentStudent.toString();
        }
    }

    public String getLog(){
    // Return the entire HelpDesk session log from beginning to end.
        return log.toString();
    }

}