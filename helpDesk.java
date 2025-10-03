public class helpDesk()
    private Student current;
    private int time;
    private int remainingWorkload;

    // array bounded queue
    private Queue<Student> q100 = new LinkedList<>();
	private Queue<Student> q200 = new LinkedList<>();
	private Queue<Student> q300 = new LinkedList<>();
	private Queue<Student> q400 = new LinkedList<>();


    public void step(){
    // Advance the simulation one minute.
        if(current !=null){
            remainingWorkload--;
            if(remainingWorkload==0){
                log.append(currentStudent.toString()).append("\n");
                currentStudent =null;
            }
        }
        else{
            if(!q100.isEmpty()) {
                currentStudent=q100.poll();
            }
            else if(!q200.isEmpty()){
                currentStudent=q200.poll();
            }
            else if(!q300.isEmpty()){
                currentStudent=q300.poll;
            }
            else if(!q400.isEmpty()){
                currentStudent=q400.poll;
            }
            if(currentStudent != null){
                remainingWorkload=currentStudent.workload;
            }
        }
        time++;
    }

    public void addStudent(String name, int course, int workload){
    // Add an arriving student with the indicated name, course number, and mi
        Student s = new Student(name, course, workload);
        int level= s.getLevel();
        if(!engueue(s,level)){
			//student was turned away
            System.out.println("error");
        }
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
    }

