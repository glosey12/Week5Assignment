public class Student {
    //student class
    String name;
	int course;
	int workload;
    
	public Student(String n, int c, int w) {
		name = n;
		course = c;
		workload = w;
	}
	public int getLevel() {
		return course;
	}
	public String toString() {
		return name + " from CSC" + course;
	}
}
