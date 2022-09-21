import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

	@Test
	public void testStudentInstance() {
		Student stud = new Student();
		assertNotNull("ctor returned null", stud);
		assertNull("Name should be null by default", stud.getName());
		
		stud.setName("pankaj");
		assertEquals("set name failed to set expected value", "pankaj", stud.getName());
		
		assertNotEquals("", "pankajs", stud.getName());
		
		stud.learn("Java");
		
		//assertFalse(msg, cond);
		//assertTrue(msg, cond);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testInvalidPsp() {
		assertNull("Error thrown for invalid psp", new Student("", "", "", 200));
	}

}
