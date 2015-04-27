package com.java.lessons.l2.abst.lib;

//Revize 20150426 1400

import java.util.Date;

public class SysTaskDate {
 private SysTaskDate(){
 }

 public Date dateToday;
 
 
 public static Date addWeek(Date initialDate) {
  return new Date(initialDate.getTime() + (86400 * 7 * 1000));
 }

 public static Date deductWeek(Date initialDate) {
	  return new Date(initialDate.getTime() - (86400 * 7 * 1000));
	 } 
 
 public static Date addDay(Date initialDate) {
	  return new Date(initialDate.getTime() + (86400 * 1000));
	 }

 public static Date deductDay(Date initialDate) {
	  return new Date(initialDate.getTime() - (86400 * 1000));
	 }
 
 
 public static Date inWeek() {
	  return new Date(new Date().getTime() + (86400 * 7 * 1000));
	 }

 public static Date inDay() {
		  return new Date(new Date().getTime() + (86400 * 1000));
		 } 

 public static Date dayToday() {
	  return new Date(new Date().getTime());
	 } 
 
}
