public class Student {
    //student class
	Integer arrival;
    String name;
	Integer course;
	Integer workload;
    
	public Student(Integer a, String n, Integer c, Integer w) {
		this.arrival = a;
		this.name = n;
		this.course = c;
		this.workload = w;
		//helpDesk help = new helpDesk(arrival, name, course, workload);
	}
	public Integer getLevel() {
		return course/100;
	}
	public Integer getArrival(){
		return arrival; 
	}
	public Integer getWorkLoad(){
		return workload;
	}
	public String getName() {
    	return name;
	}
	public int getCourse() {
    	return course;
	}
	public String toString() {
		return name + " from CSC" + course;
	}
}
