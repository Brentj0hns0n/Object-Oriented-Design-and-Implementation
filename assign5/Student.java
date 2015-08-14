package assign5;

import java.util.ArrayList;
import java.util.Observable;
//import java.util.*;

/**
 * Represents a student and their scores in a class.
 * Stores the name, assignment scores and exam scores.
 * @author Jill Seaman
 *
 */
public class Student extends Observable implements Iterator{
    
    private String name;                   // Students full name
    private Context context = new Context(new AverageWODrop(this));
    private ArrayList<Double> assignments  // scores for the assignments
    = new ArrayList<Double>();
    private ArrayList<Double> exams        // scores for the exams
    = new ArrayList<Double>();
    
    
  
    public void setContext (AverageInterface avg){
    	this.context = new Context(new AverageWithDrop(this));
    }
    /**
     * Constructs the student from their name
     * @param name  full name of the student.
     */
    public Student(String name) {
        this.name = name;
    }
    
    /**
     * @return the student's full name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Adds an assignment score to the collection of assignment scores for the student.
     * @param as the assignment score to add
     */
    public void addAssignmentScore (double as) {
        assignments.add(as);
     //   setChanged();
     //   notifyObservers();
    }
    /**
     * Adds an exam score to the collection of exam scores for the student.
     * @param es the exam score to add
     */
    public void addExamScore (double es) {
        
    	exams.add(es);
    	Double grade = this.getAverage();
        setChanged();
        notifyObservers(grade);
    }
    
    /**
     * @return the average for the student
     */
   public double getAverage() {

	   return context.findAvg();
   }
    
    /**
     * @return the number of assignments in the list
     */
    public int getNumberOfAssignments() {
        return assignments.size();
    }
    
    /**
     * @param i the index of the assignment to return
     * @return the assignment at position i
     */
    public Double getAssignmentScore(int i) {
        return assignments.get(i);
    }
    
    /**
     * @return the number of exams in the list
     */
    public int getNumberOfExams() {
        return exams.size();
    }
    
    /**
     * @param i the index of the exam to return
     * @return the exam at position i
     */
    public Double getExamScore(int i) {
        return exams.get(i);
    }
    
}