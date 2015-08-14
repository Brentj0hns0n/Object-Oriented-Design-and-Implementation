package assign6;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class ResourceTest1 {
	
	Faculty bob = new Faculty(123123123);
	Movie WhatAboutBob = new Movie(5, "what about bob", "55");
	Book StealThisBook = new Book(1, "Steal This Book", "12", "Hoffman");
	Student Abbie = new Student(1970);
	double fine1 = .00;
	double fine2 = .25;
	Calendar now = Calendar.getInstance();
	Calendar then = (Calendar) (now).clone();


	@Test //this method tests one day late movie
	public void testCalculateFine() {
		
		then.add(Calendar.DATE, 8);
		WhatAboutBob.calculateNewDueDate(now, bob);		
		fine1 = WhatAboutBob.calculateFine(then);
		assertEquals("one day late fine should be .25", fine2, fine1, .00005);
		
		
	}
	@Test//this method tests one day late book
	public void testCalculateFine1() {

		then.add(Calendar.MONTH, 3);
		then.add(Calendar.DATE, 1);
		
		StealThisBook.calculateNewDueDate(now, bob);
		fine1 = StealThisBook.calculateFine(then);
		assertEquals("one day late fine should be .25", fine2, fine1, .00005);
		
	}
	
	@Test//this method tests maximum fines
	public void testCalculateFine2() {
		then.add(Calendar.DATE, 800);
		fine1=0;
		fine2=5.00;
		WhatAboutBob.calculateNewDueDate(now, Abbie);
		fine1=WhatAboutBob.calculateFine(then);
		assertEquals("fines should max out at 5.00", fine2, fine1, .00005);
		
	}
	
	@Test//this method tests exactly 5 days late for a movie
	public void testCalculateFine3(){
		then.add(Calendar.DATE, 12);
		fine1=0;
		fine2=1.25;
		WhatAboutBob.calculateNewDueDate(now, Abbie);
		fine1=WhatAboutBob.calculateFine(then);
		assertEquals("five days late should be 1.25", fine2, fine1, .00005);
	}
}
	
	



