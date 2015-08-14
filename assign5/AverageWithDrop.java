package assign5;

public class AverageWithDrop implements AverageInterface{
	
	private Student student;
	public AverageWithDrop(Student stu){
		student = stu;
	} 
//	Student stu = new Student("bill");
	public double getAverage(){
		double examAverage =0, lowest = 0; 
		double HWAverage = 0;
		double totalAverage = 0;
		if (student.getNumberOfAssignments()>=2){
			lowest = student.getAssignmentScore(0);
			for (int i = 0; i < student.getNumberOfAssignments(); i++){
				if (lowest > student.getAssignmentScore(i))
					lowest = student.getAssignmentScore(i);
				}
		}


		for (int i = 0; i < student.getNumberOfAssignments(); i++)
			HWAverage = HWAverage + student.getAssignmentScore(i);
		if (student.getNumberOfAssignments()>= 2)
			HWAverage = (HWAverage-lowest)/(student.getNumberOfAssignments() - 1);
			
		for (int i = 0; i < student.getNumberOfExams(); i++)
			examAverage = examAverage + student.getExamScore(i);
		examAverage = examAverage / student.getNumberOfExams();
		
		
		return ((.4)*HWAverage + (.6)*examAverage);
	}
	
	
}