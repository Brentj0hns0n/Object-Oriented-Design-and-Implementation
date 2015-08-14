package assign5;

public class AverageWODrop implements AverageInterface{
	
	private Student student;
	public AverageWODrop(Student stu){
		student = stu;
	} 
	
	public double getAverage(){
		double examAverage =0; 
		double HWAverage = 0;
		double totalAverage = 0;
		for (int i = 0; i < student.getNumberOfAssignments(); i++)
			HWAverage = HWAverage +student.getAssignmentScore(i);
		HWAverage = HWAverage/student.getNumberOfAssignments();
			
		for (int i = 0; i < student.getNumberOfExams(); i++)
			examAverage = examAverage + student.getExamScore(i);
		examAverage = examAverage / student.getNumberOfExams();
		
		return ((.4)*HWAverage + (.6)*examAverage);
		}
	
}