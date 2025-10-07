public class helpDesk{
    private Student currentStudent=null;
    private int time=0;
    private int remainingWorkload;
    private String log ="";
    int finishStTime;

    // array bounded queue
    private arrayBoundedQueue<Student>[] queues;
    

/*  private Queue<Student> q100 = new LinkedList<>();
	private Queue<Student> q200 = new LinkedList<>();
	private Queue<Student> q300 = new LinkedList<>();
	private Queue<Student> q400 = new LinkedList<>();

*/  
     public helpDesk(){
        queues = (arrayBoundedQueue<Student>[]) new arrayBoundedQueue[4]; // array size 4 - since we have level 1, 2, 3, 4
        // populate the array -> put chairs at each waiting room
        for (int i = 0; i<4; i++) {
            queues[i] = new arrayBoundedQueue<>(3); // send our capacity to ArrayBoundedQueue class -> be able to work with every lvl independantly
        }
        this.time=0;
        this.remainingWorkload=0;
        this.currentStudent=null;
        this.log="";
        
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
        //addStudent(s.getName(), s.getCourse(), s.getWorkLoad());

        
        if(currentStudent !=null){
            remainingWorkload--;
            if(remainingWorkload==0){
                log+="\nTime " +time +", Finished helping " +currentStudent.toString();
                currentStudent=null;  
                finishStTime = time;          
            }
        }
        if(currentStudent==null){
            if(!queues[0].isEmpty()) {
                currentStudent = queues[0].dequeue();
            }
            else if(!queues[1].isEmpty()){
                currentStudent = queues[1].dequeue();
            }
            else if(!queues[2].isEmpty()){
                currentStudent = queues[2].dequeue();
            }
            else // assume: (!queues[3].isEmpty())
            {
                currentStudent=queues[3].dequeue();
            }
            if(currentStudent!=null){
                remainingWorkload = currentStudent.getWorkLoad();
                if (time == finishStTime)
                    log += "\n";
                log += "Time " + time +", Started helping "+ currentStudent.toString();
            }
        }
        time++;
    }

    public void addStudent(String name, int course, int workload){
    // Add an arriving student with the indicated name, course number, and mi
        Student s = new Student(name, course, workload);
        int level= s.getLevel();

        if (level == 100){            
            for (int i = 0; i<4; i++)
            {
                if (!queues[i].isFull())
                {   
                    queues[i].enqueue(s);
                    if(currentStudent!=null){
                        log +="\nTime " +(time) + ", Queued "  + name + " from " + course;
                    }
                    else
                        log +="\n";
                    break;
                }
                
                if (i==3 && queues[i].isFull())
                    log += "\nTurned away " +name+" from CSC " + course;
            }
        }
        else if (level == 200){
            for (int i = 1; i<4; i++)
            {
                if (!queues[i].isFull())
                {   
                    queues[i].enqueue(s);
                   if(currentStudent!=null){
                        log +="\nTime " +(time) + ", Queued " + name + " from " + course; //currentStudent.toString();
                    }
                    else
                        log +="\n";
                    break;
                }
                
                if (i==3 && queues[i].isFull())
                    log += "\nTurned away " +name+" from CSC " + course;
            }
        }

        else if (level == 300){
            for (int i = 2; i<4; i++)
            {
                if (!queues[i].isFull())
                {   
                    queues[i].enqueue(s);
                    if(currentStudent!=null){
                        log +="\nTime " +(time) + ", Queued "  + name + " from " + course;
                    }
                    else
                        log +="\n"; // in theory 2 cases -> start helping or queued
                    break;
                }
                
                if (i==3 && queues[i].isFull())
                    log += "\nTurned away " +name+" from CSC " + course;
            }               
        
        }

        else if (level == 400){
            if (queues[3].isFull())
                log += "\nTurned away " +name+" from CSC " + course;
            else{
                queues[3].enqueue(s);
                if(currentStudent!=null){
                        log +="\nTime " +(time) + ", Queued "  + name + " from " + course;
                }
                else
                    log +="\n";
                }
        }
        else 
            System.out.println("You are in a wrong place, go to SI");
    }


    public int getTime(){
    // Get the current simulation time in minutes.
        return time;
    }

    public String toString(){
    // Return the status of the simulation. Example: "Time 2, Helping Jack fr
        if(currentStudent==null){
            return "Time " +(time-1) +", IDLE";
        }
        else{
            return "Time " +(time-1)+ ", Helping " + currentStudent.toString();
        }
    }

    public String getLog(){
    // Return the entire HelpDesk session log from beginning to end.
        return log;
    }
}