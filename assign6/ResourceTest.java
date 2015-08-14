package assign6;


import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;


public class ResourceTest {

	Faculty bob = new Faculty(123123123);
	Movie WhatAboutBob = new Movie(5, "what about bob", "55");
	Book StealThisBook = new Book(1, "Steal This Book", "12", "Hoffman");
	Student Abbie = new Student(1970);
	
	
	Calendar now = Calendar.getInstance();
	Calendar then = (Calendar) (now).clone();
	
@Test//this method tests movie due date for Faculty
public void testCalculateNewDueDate() {


	then.add(Calendar.DATE, 7);
	WhatAboutBob.calculateNewDueDate(now, bob);
	assertEquals ("new due date for movie should be one week from today", now, then );
	}
@Test //this method tests movie due date for student
public void testCalculateNewDueDate1() {
	then.add(Calendar.DATE, 7);
	WhatAboutBob.calculateNewDueDate(now, Abbie);
	assertEquals ("new due date for movie should be one week from today", now, then );
}

@Test //this method tests book due date for Faculty
public void testCalculateNewDueDate2() {
	StealThisBook.calculateNewDueDate(now, bob);
	then.add(Calendar.MONTH, 3); 
	assertEquals ("new due date for book for faculty should be 3 months from today", now, then );
	
}

@Test  //this method tests book due date for Faculty
public void testCalculateNewDueDate3() {
	StealThisBook.calculateNewDueDate(now, Abbie);
	then.add(Calendar.DATE, 28);  

	assertEquals ("new due date for book for student should be four week from today", now, then );
}}

