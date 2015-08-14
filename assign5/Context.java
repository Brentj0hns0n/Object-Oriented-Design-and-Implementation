package assign5;

public class Context {
	private AverageInterface avg;
	
	public Context (AverageInterface avgI){
		this.avg = avgI;
	}
	
	public double findAvg ()	{
		return avg.getAverage();
	}
	
	public void  setAvg(AverageInterface avgI){
		this.avg = avgI;
	}
}
