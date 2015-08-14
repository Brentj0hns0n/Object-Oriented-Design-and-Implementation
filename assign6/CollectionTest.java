package assign6;

import static org.junit.Assert.*;

import org.junit.Test;

public class CollectionTest {
	
	
	Boolean isThere = false;
	Collection myStuff = new Collection();
	
	Movie WhatAboutBob = new Movie(5, "what about bob", "55");
	Book StealThisBook = new Book(1, "Steal This Book", "12", "Hoffman");
	Movie WhatAboutBobBootleg = new Movie (5, "what about bob", "55");

	@Test //this method tests is a non-added resource is here
	public void test() {
		
		isThere = myStuff.addResource(WhatAboutBob);
		assertEquals("StealThisBook should not be here", null, myStuff.findResource(1));
	}
	@Test//this method tests is a movie can be added
	public void test1() {
		isThere = myStuff.addResource(WhatAboutBob);
		assertTrue("WhatAboutBob should be added", isThere);
	}
	@Test//this method tests if a movie can be added twice
	public void test2() {
		isThere = true;
		isThere = myStuff.addResource(WhatAboutBob);
		isThere = myStuff.addResource(WhatAboutBob);
		assertFalse("WhatAboutBob cannot be added twice", isThere);
		
	}
	@Test//this method tests is a duplicate ID number is allowed
	public void test3() {
		isThere = true;
		isThere = myStuff.addResource(WhatAboutBob);
		isThere = myStuff.addResource(WhatAboutBobBootleg);
		assertFalse("duplicate WhatAboutBobBootleg allowed", isThere);
	}
	@Test//this method tests is a book can be added
	public void test4() {
		isThere = false;
		isThere = myStuff.addResource(StealThisBook);
		assertTrue("StealThisBook was not added", isThere);
		
	}

	@Test//this method tests if a book can be added twice
	public void test5() {
		isThere = true;
		isThere = myStuff.addResource(StealThisBook);
		isThere = myStuff.addResource(StealThisBook);
		assertFalse("StealThisBook was added twice", isThere);
			
	}

}
