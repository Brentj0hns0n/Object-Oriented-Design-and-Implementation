package assign5;


import java.util.Observable;
import java.util.Observer;

public class GradeTracker implements Observer {
	
	private Student stu;
	private Double grade;
	
	public GradeTracker(Student stu){
		grade = stu.getAverage();
		
	}
	public Character getLetterGrade(){
		System.out.println(grade);
		if (grade >= 90)
			return 'A';
		else if (grade >= 80)
			return 'B';
		else if (grade >= 70)
			return 'C';
		else if (grade >= 60)
			return 'D';
		else return 'F';
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if ( arg1 instanceof Double)
			grade = ((Student) arg0).getAverage();
			System.out.println("Grade has changed");
		
	}
}
