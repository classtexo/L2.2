package com.java.lessons.l2.abst.lib;

//Revize 20150426 1400

import java.util.Date;

/*Ukol:
Hlavni abstraktni trida: TaskAbstract
chranene atributy: id,description , length, due_to, name, isClosed
neimplementovana metoda: getIsSolved, close
Podtrida ProgrammersTask: dedi od TaskAbstract
atributy isSolved
*/

public abstract class TaskAbstract {
 protected int id ;
 protected String description;
 protected String length;
 protected Date dueTo;
 protected String name;
 protected boolean isClosed;
 static int taskIdIndex= 0;
 //ALT-SHIFT-S <<< menu Get& set
 //Atributy Private nebo Protected a nastavit Get/Set
 
 @Override
 public String toString() {
	 String sOut = "(" + this.id + ")" + description + "|" + this.length + "|" + this.dueTo + "|" + this.name + "|" + this.isClosed;
	 return sOut;
 }
 
 public abstract boolean getIsSolved();
 public abstract void close();
 // muzu sem uz vypsat i nejake implementace nebo to musi zustat prazdne jak u Iface?
 // musim si u sebe vsechny implementovat nebo jen nektere?
 
 public int getId() {
  	    return id; 
  	    }
 
/** Abstraktni trida - konstruktor 
 * @param description
 * @param length
 * @param due_to
 * @param name
 * id se generuje samo
 */
public TaskAbstract(String description, String length, Date due_to,
		String name) {  //konstruktor pro mnoho parm
	super();
	this.id = taskIdIndex;
	taskIdIndex ++;
	this.description = description;
	this.length = length;
	this.dueTo = due_to;
	this.name = name;
	this.isClosed = false;
}

/** Abstraktni trida - konstruktor 
 * @param description
 * id se generuje samo
 */
public TaskAbstract( String description) {
	super();           //konstruktor pro omezeny pocet parm
	this.id = taskIdIndex;
	taskIdIndex ++;
	this.description = description;
}


/**
 * @param id
 * Bacha - normalne se ale generuje samo pri instanciaci !!!
 */
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description; // Proc tady uz nepotrebuji this. ???
}
public void setDescription(String description) {
	this.description = description;
}
public String getLength() {
	return length;
}
public void setLength(String length) {
	this.length = length;
}
public Date getDue_to() {
	return dueTo;
}
public void setDue_to(Date due_to) {
	this.dueTo = due_to;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public boolean isClosed() {
	return isClosed;
}
public void setClosed(boolean isClosed) {
	this.isClosed = isClosed;
}


 
}


 
