package com.java.lessons.l2.abst.lib;

//Revize 20150426 1400

import java.util.List;
/* tato trida nepujde instanciovat (nepujde mi zavolat konstruktor) 
*/

public class TaskHelper {
	
private TaskHelper() {
}

public static void printCollection(List<TaskAbstract> tasks) {
		for ( TaskAbstract task : tasks ) {
			  if (task instanceof PersonalTask) System.out.println("Personal task    : ") ;
			  if (task instanceof ProgrammersTask) System.out.println("Programmers task : ") ; 
			  System.out.println(task.toString() + "\n\n");
		} 
 }

public static boolean clovseSolvedTasks() {
	 // closeSolvedTasks(list<TasksAbstract> tasks)
		System.out.println("");
		return true;
	/*	 // vezme list tech tasku a co jsou vyresene tak je uzavre
		 // staticke metody tridy << nastudovat a aplikovat zde
	*/ 
}


public static boolean closeSolvedTasks() {
 // closeSolvedTasks(list<TasksAbstract> tasks)
	System.out.println("");
	return true;
/*	 // vezme list tech tasku a co jsou vyresene tak je uzavre
	 // staticke metody tridy << nastudovat a aplikovat zde
*/ 
}


/**
 * Vytiskne pocet issues u vsech programatoru (je to ve static counteru)
 */
public static void printIssuesCount(){
  if (Issue.getIssuesCount()>=0) {
	  System.out.println("Issues count : " + (int) ( Issue.getIssuesCount() + 1)  ); 
  } else {
	  System.out.println("No any issue found");  
  }
}
 
 public static void printCokolivJineho() {
	 //neco jineho nez se tiskne v main()
	 System.out.println("");
}
 
 // jeste osefovat konstruktor, figl je, ze toto je neinstancovane, normalni konstruktor nefunguje
 // hint je private, JINAK TO BERE ZE SUPER konstruktor.
 // delame to aby to slo volat pres tu tecku! Nechceme aby to nekto vytvarel
 // Kdyz schovam konstruktor ze to nikdo neinstancuje a pouzije jen staticke metody.
 //?? kdyztak co napadne tak doplnit.
}
