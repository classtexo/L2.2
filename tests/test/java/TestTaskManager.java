package test.java;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import com.java.lessons.l2.abst.lib.EnumStatus;
import com.java.lessons.l2.abst.lib.ExceptionClosingTask;
import com.java.lessons.l2.abst.lib.Issue;
import com.java.lessons.l2.abst.lib.PersonalTask;
import com.java.lessons.l2.abst.lib.ProgrammersTask;
import com.java.lessons.l2.abst.lib.SysTaskDate;
import com.java.lessons.l2.abst.lib.TaskAbstract;
import com.java.lessons.l2.abst.lib.TaskHelper;

import org.junit.Test;

public class TestTaskManager {
	
	//>>>> <<<????? Tady se ale nic netestuje!!!!!!!!

	/*
	 * Ukol: Hlavni abstraktni trida: TaskAbstract chranene atributy:
	 * id,description , length, due_to, name, isClosed neimplementovana metoda:
	 * getIsSolved, close
	 * 
	 * Podtrida ProgrammersTask: dedi od TaskAbstract atributy isSolved Issues -
	 * obsahuje vazby na Issue (agreguje do sebe Issues) ????? Jak implementovat
	 * "agregaco" - jakym mechanismem <List> ? Udelat nekolik instanci????
	 * metoda getIssuesCount
	 * 
	 * 
	 * Trida Issue: Id, Name, State, severenity
	 * 
	 * 
	 * Podtrida PersonalTask: dedi od TaskAbstract attributy: timeSolved
	 * datesolved() //if <due_to tak getissolved vyreseno.
	 * 
	 * pro ciselne typy pouzivej primitivni datove typy.
	 */
	/*
	 * Prezvykani: TaskAbstract bude obsahovat vse spolecne co se da pouzit v
	 * dalsich classech ProgrammerTask je seznam issues a soucasne re
	 * 
	 * 
	 * 
	 * Now you may be wondering why not declare an abstract class as an
	 * interface, and have the Dog and Cow implement the interface. Sure you
	 * could - but you'd also need to implement the eat and sleep methods. By
	 * using abstract classes, you can inherit the implementation of other
	 * (non-abstract) methods. You can't do that with interfaces - an interface
	 * cannot provide any method implementations. => Abstract udelam zaklad a
	 * dle potrebnych nuanci dolepuji k extend tridam funkcionality! =>
	 * Interface, zavazny predpis co vse se ma implementovat a to se musi udelat
	 * cele!
	 */
	/*
	 * // Zadani rozvest vice ENUM - Equals StatusVa.FINISHED.equals(prom); //
	 * compareTo.
	 * 
	 * // Zkompilovat pustit spustit z Windows konzole // pridat argumenty,
	 * pocet argument stav ukolu a vypisou se ty ukoly // a navic je spocita
	 */

	public List<TaskAbstract> collectionTasks;

	
	//>>>> Jaky vyznam ma fail, k cemu se to pouziva? Aby to explicitne failnulo?
	
	@Test
	public void test() {
		
		// tohle se pouziva kdyz to dojde k bodu kde to nemelo 
		// dojit!
		fail("Not yet implemented");
	}

	@Test
	public void main() throws ExceptionClosingTask {

		List<TaskAbstract> collectionTasks = new ArrayList<TaskAbstract>();

		TaskHelper.printIssuesCount();

		TaskAbstract taskTemp = new PersonalTask( "Prvni ukol",
				"Tyden.length", SysTaskDate.inWeek(), "Jmeno ukolu");
		collectionTasks.add(taskTemp);
		collectionTasks.add(new PersonalTask( "Druhy ukol", "den.length",
				SysTaskDate.inDay(), "Jmeno ukolu2"));
		collectionTasks.add(new PersonalTask( "Treti ukol", "mesic.length",
				SysTaskDate.dayToday(), "Jmeno ukolu3"));

		Issue[] programmersTaskIssues = { new Issue("SYS3 Exc.error", 1),
				new Issue("Throw error", 2) };
		TaskAbstract ptaskTemp = new ProgrammersTask( "Modul 5 - errors",
				"Week", SysTaskDate.inWeek(), "SunDance Application",
				programmersTaskIssues);
		collectionTasks.add(ptaskTemp);

		programmersTaskIssues[0] = new Issue("BufferOverflow.error", 3);
		programmersTaskIssues[1] = new Issue("Enexceptional call error", 4);
		ptaskTemp = new ProgrammersTask("Modul 1 - fix", "Week",
				SysTaskDate.inWeek(), "Support Apps", programmersTaskIssues);
		collectionTasks.add(ptaskTemp);


		// Jen pro overeni funkcnosti:
		PersonalTask taskPers = (PersonalTask) collectionTasks.get(0);
		taskPers.setDateSolved(SysTaskDate.dayToday());

		ProgrammersTask taskProg = (ProgrammersTask) collectionTasks.get(4);
		taskProg.closeIssues();

		// BACHA ByRef poznamka!!!!!
		collectionTasks.get(2).setDescription("nova hodnota"); // << tento
																// zpusob
																// nepreferovat
		TaskAbstract taskToEdit = collectionTasks.get(2); // << tento zpusob je
															// preferofan
		taskToEdit.setDescription("newval"); // <<<< A tady uz je to rovnou
												// aktualizovane v prislusne
												// polozce collekce.

		TaskHelper.printCollection(collectionTasks);
		TaskHelper.printIssuesCount();
		System.out.println("Finished");

		System.out.println(EnumStatus.ACCEPTED);
		System.out.println(EnumStatus.ACCEPTED.getStatus());
		System.out.println(EnumStatus.valueOf("ACCEPTED"));
		System.out.println(EnumStatus.ACCEPTED.ordinal());
		System.out.println(EnumStatus.ACCEPTED.name());

	}

}
