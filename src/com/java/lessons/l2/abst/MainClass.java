package com.java.lessons.l2.abst;

// Revize 20150426 1400

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.java.lessons.l2.abst.lib.EnumStatus;
import com.java.lessons.l2.abst.lib.ExceptionClosingTask;
import com.java.lessons.l2.abst.lib.TaskHelper;
import com.java.lessons.l2.abst.lib.SysTaskDate;
import com.java.lessons.l2.abst.lib.Issue;
import com.java.lessons.l2.abst.lib.TaskAbstract;
import com.java.lessons.l2.abst.lib.PersonalTask;
import com.java.lessons.l2.abst.lib.ProgrammersTask;
import com.java.lessons.l2.abst.lib.Issue;

/*Ukol:
Hlavni abstraktni trida: TaskAbstract
     chranene atributy: id,description , length, due_to, name, isClosed
     neimplementovana metoda: getIsSolved, close

Podtrida ProgrammersTask: dedi od TaskAbstract
     atributy isSolved
     Issues - obsahuje vazby na Issue (agreguje do sebe Issues)
                ????? Jak implementovat "agregaco" - jakym mechanismem <List> ?
                      Udelat nekolik instanci????
     metoda getIssuesCount


Trida Issue: 
      Id, Name, State, severenity


Podtrida PersonalTask: dedi od TaskAbstract
      attributy: timeSolved
      datesolved() //if <due_to tak getissolved vyreseno.

pro ciselne typy pouzivej primitivni datove typy.*/
/*Prezvykani: TaskAbstract bude obsahovat vse spolecne co se da pouzit v dalsich classech
 * ProgrammerTask je seznam issues a soucasne re
   
    	
    	
   Now you may be wondering why not declare an abstract class as an interface, and have the Dog 
   and Cow implement the interface. Sure you could - but you'd also need to implement the eat 
   and sleep methods. By using abstract classes, you can inherit the implementation of other (non-abstract) 
   methods. You can't do that with interfaces - an interface cannot provide any method implementations.
   => Abstract udelam zaklad a dle potrebnych nuanci dolepuji k extend tridam funkcionality!
   => Interface, zavazny predpis co vse se ma implementovat a to se musi udelat cele!

*/
/*// Zadani rozvest vice ENUM - Equals StatusVa.FINISHED.equals(prom);
// compareTo.

// Zkompilovat pustit spustit z Windows konzole
// pridat argumenty, pocet argument stav ukolu a vypisou se ty ukoly
// a navic je spocita
*/


//Proc to nefunguje?


//Test z Javy, proc nefunguje
//float sf= 12.3;

/* OBA DVA VRATI TRUE?? Jakto == je stejny object a ja mam 2 stringy
 * String sLeft = "john";
String sRight = "jo" + "hn";
if ("john"=="john")  System.out.println("john=john");
if (sLeft == sRight) System.out.println("Left john= Right john");*/



/*18) 	What class must an inner class extend:
	The top level class
	The Object class  << odpoved blba
	Any class or interface << OK
	It must extend an interface*/
 

public class MainClass {
	public List<TaskAbstract> collectionTasks;
	public static void main(String[] args) {
		
		// DODELAT!!!!!
		// vypisu stav ukolu (jestli je uzavreny) a nazev // "instanceOf"
		// !! Nepouzivej toString ale metodama z abstraktni tridy
		// u issue udelat "enum" vyctovy typ
		
		List<TaskAbstract> collectionTasks = new ArrayList<TaskAbstract>(); 
		
		TaskHelper.printIssuesCount();
		
		// Pozn David z jeho SRC
		// tady je chyba mas constructor na id, ale pak ho v predkovi nastavujes
		// pomoci static promenne :);
		
		
		
		TaskAbstract taskTemp = new PersonalTask("Prvni ukol","Tyden.length", SysTaskDate.inWeek() ,"Jmeno ukolu");
		collectionTasks.add( taskTemp);
		collectionTasks.add( new PersonalTask("Druhy ukol","den.length",SysTaskDate.inDay(),"Jmeno ukolu2"));
		collectionTasks.add( new PersonalTask("Treti ukol","mesic.length",SysTaskDate.dayToday(),"Jmeno ukolu3"));

		
		Issue[] programmersTaskIssues = {  new Issue("SYS3 Exc.error",1),  new Issue("Throw error",2)}; 
		TaskAbstract ptaskTemp = new ProgrammersTask("Modul 5 - errors","Week",SysTaskDate.inWeek(),"SunDance Application", programmersTaskIssues);
		collectionTasks.add( ptaskTemp);
		programmersTaskIssues = null;
		
	//  DU - vytvorit vlastni exception TaskException prevod cisel, invalid number format
	//  obalit to, zachytit vyjimku dat, zachytit ji, zabalit a poslu ji 
	//  predam ji do konstruktoru meho.

	//  DU Seznamit se JUNIT !!	
		
		
		programmersTaskIssues = new Issue[3];
		programmersTaskIssues[0]= new Issue("BufferOverflow.error",3);
		programmersTaskIssues[1]= new Issue("Enexceptional call error",4);	
		programmersTaskIssues[2]= new Issue("Doplnek",4);	
		
		ptaskTemp = new ProgrammersTask("Modul 1 - fix","Week",SysTaskDate.inWeek(),"Support Apps", programmersTaskIssues);
		collectionTasks.add( ptaskTemp);		
		
		
	//  Jen pro overeni funkcnosti:	
		PersonalTask taskPers = (PersonalTask) collectionTasks.get(0);
		taskPers.setDateSolved(SysTaskDate.dayToday());

		ProgrammersTask taskProg = (ProgrammersTask) collectionTasks.get(4);
		
		try {
			taskProg.closeIssues();
		} catch (ExceptionClosingTask e) {
			System.out.println("a toto je uz v main class");
			e.printStackTrace();
		}		
		
	//  BACHA ByRef poznamka!!!!!	
		collectionTasks.get(2).setDescription("nova hodnota"); //<< tento zpusob nepreferovat
		TaskAbstract taskToEdit = collectionTasks.get(2);      //<< tento zpusob je preferofan
		taskToEdit.setDescription("newval"); // <<<< A tady uz je to rovnou aktualizovane v prislusne polozce collekce.
		
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
