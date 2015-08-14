package assign5;

import java.text.DecimalFormat;
import java.util.Iterator;

public class Driver {
    
    public static void uiMethod (Iterator<Double> i) {
        DecimalFormat df = new DecimalFormat("0.0");
        while (i.hasNext()) {
            System.out.println(df.format(i.next()));
        }
    }

	public static void main(String[] args) {

        Student student = new Student("Harry Potter");
        student.addAssignmentScore(98.5);
        student.addAssignmentScore(90.1);
        student.addAssignmentScore(78.3);
        student.addExamScore(95);
        student.addExamScore(87);

        DecimalFormat df = new DecimalFormat("0.0");
        // should use algorithm A by default:
        System.out.println(student.getName() + "  " +
                           df.format(student.getAverage()));

        // switch to algorithm B:

        student.setContext( new AverageWithDrop(student));
        System.out.println(student.getName() + "  " +
                           df.format(student.getAverage()));
        
        //test the StudentIterator using uiMethod
        // <<create an instance to pass to the uiMethod>>
        Iterator<Double> si;
   //     uiMethod(si);
    
        //test the GradeTracker
        GradeTracker gt = new GradeTracker(student);
        student.addObserver(gt);
       System.out.println("letter grade: " + gt.getLetterGrade());
        //student.addExamScore(0);
        student.addExamScore(0);
        
        System.out.println("Added an exam score.");
        System.out.println("letter grade: " + gt.getLetterGrade());
        
    }
}