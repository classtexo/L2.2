package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Date;

import com.java.lessons.l2.abst.lib.PersonalTask;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 
 */

/**
 * @author grellenort
 * 
 */
public class TestPersonalTask {

	//>>>> K cemu toto???
	private final static String SOME_TEST_DESCR = "Pokusny description";

	
	//>>>> a) to rule je jen pro testovani, nebo i pro kod javy? Nejake nove pouziti asi co neznam
	//videl jsem : public void evaluate() throws Throwable { Je to neco extra?
	//@Before and @After. Using an ExternalResource
	
	// BACHA !!!! Testy v ramci tridy se provani v nahodnem poradi!!!!!
	
	// DU prostudovat testovani Exceptions !!! V kodu se dela Try{}
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	//zjistit kdy se zda pokazde/jednou se provadi kod v konstruktoru / @before @after
	// @ignore
	//tento konstruktor se provede vzdy kazdym testy
	public TestPersonalTask() {
		super();
	}

	private PersonalTask prepareAndTestSimpleObject() {
		// tady je chyba mas constructor na id, ale pak ho v predkovi nastavujes
		// pomoci static promenne :);
		
		//>> jen moje nepozornost?
		
		//>>>> Nechapu :-)
		//Jakto, ze v hlavni package neni MAIN?
		
		Date expectedDate = new Date(6000);
		String expectedName = "Pokusny personani ukol";
		Integer expectedId = 10;
		PersonalTask ptask = new PersonalTask(SOME_TEST_DESCR, "5",
				expectedDate, expectedName);

		assertNotNull(ptask);
		assertEquals(expectedDate, ptask.getDue_to());
		assertTrue(SOME_TEST_DESCR.equals(ptask.getDescription()));
		assertFalse(ptask.getIsSolved());
		// tady by to spadlo assertEquals(expectedId, new
		// Integer(ptask.getId()));
		
		//>>> Proc return? Komu to vracim?????
	    //BACHA!!! Tuto testovaci metodu ja muzu pak pripadne reuse pro dalsi
		//slozitejsi testovani podobne vytvorene instance...
		return ptask;
	}

	@Test
	public void testSettersGetters() {

	}

	@Ignore("Preskakuji, netestuje se")
	@Test
	public void testDateSolvedIsBeforeDueTo() {
		PersonalTask ptask = prepareAndTestSimpleObject();
		ptask.setDateSolved(new Date(5000));
		assertTrue(ptask.getIsSolved());
		assertTrue(ptask.isClosed());
	}

	@Test
	public void testDateSolvedIsAfterDueTo() {
		PersonalTask ptask = prepareAndTestSimpleObject();
		Date dateAfter = new Date(7000);
		ptask.setDateSolved(dateAfter);
		assertTrue(ptask.getIsSolved());
		assertFalse(ptask.isClosed());
		
		// reflexe je co? Ze class o sobe prozradi methody?
		// pomoci reflexe si otestuju jestli ma metodu
		// je to jen o tom tu methodu tam dopsat?
		
		Method[] methods = PersonalTask.class.getMethods();
		boolean found = false;
		for (Method method : methods) {
			if ("getDateSolved".equals(method.getName())) {
				found = true;
			}
		} // TODO úkol zprovoznit tento test. (tzn. ne, že ho smažeš, ale
		  // upravíš třídu PersonalTask tak, aby fungovala)
		assertTrue(found);

	}

	@Test
	public void testTryToCloseNonSolvedTask() throws Exception {

		thrown.expect(Exception.class);
		//thrown.expectMessage(PersonalTask.DEFAULT_ERROR_MSG);

		PersonalTask ptask = prepareAndTestSimpleObject();
		ptask.close();

	}

}
