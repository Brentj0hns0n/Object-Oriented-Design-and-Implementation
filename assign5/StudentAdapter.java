package assign5;

import java.util.Iterator;

public class StudentAdapter extends Student implements Iterator {
	
	Student stu;
	
	public StudentAdapter(Student student){
		stu = student;
	}
	
	public boolean hasNext() {
		stu.hasNext();
	} //Returns true if the iteration has more elems
	public Student next()
	{
		return stu.next();
	} //Returns the next element in the iteration
	
	public void remove(){
		
	}

}
