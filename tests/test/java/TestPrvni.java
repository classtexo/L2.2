package test.java;


import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.java.lessons.l2.abst.lib.SysTaskDate;

public class TestPrvni {

	@Test
	public void test() {
		
		// SysTaskDate tester = new SysTaskDate(); jak otestuji kdyz je konstruktor skryty?
		// jak se otestuje metoda, ktera pouziva nejake variables (private), kdyz je treba chci nastavit?
		
		assertEquals("10 x 0 must be 0", new Date().getTime() + (86400 * 1000), SysTaskDate.addDay(new Date()).getTime());
		
		fail("Not yet implemented");
	}

}
