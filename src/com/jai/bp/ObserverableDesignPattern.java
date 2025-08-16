package com.jai.bp;

import java.util.ArrayList;
import java.util.List;

//Observer interface
interface Observer {
 void update(int newState);
}

//Subject class
class Subject {
 private List<Observer> observers = new ArrayList<>();
 private int state;

 public void attach(Observer o) {
     observers.add(o);
 }

 public void setState(int state) {
     this.state = state;
     notifyAllObservers();
 }

 private void notifyAllObservers() {
     for (Observer o : observers) {
         o.update(state);
     }
 }
}

//Concrete Observer
class HexObserver implements Observer {
 public void update(int state) {
	 
     System.out.println("Hex: " + Integer.toHexString(state).toUpperCase());
 }
}
public class ObserverableDesignPattern {
 public static void main(String[] args) {
	 Observer Observer=new HexObserver();
	 Observer.update(100);
	 
}
}
