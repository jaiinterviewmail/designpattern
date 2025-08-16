package com.jai.bp;

import java.util.ArrayList;
import java.util.List;

//Observer interface
interface Observer {
 void update(String news);
}

//Subject interface
interface Subject {
 void registerObserver(Observer o);
 void removeObserver(Observer o);
 void notifyObservers();
}

//Concrete Subject
class NewsAgency implements Subject {
 private List<Observer> observers = new ArrayList<>();
 private String latestNews;

 public void registerObserver(Observer o) {
     observers.add(o);
 }

 public void removeObserver(Observer o) {
     observers.remove(o);
 }

 public void setNews(String news) {
     this.latestNews = news;
     notifyObservers();
 }

 public void notifyObservers() {
     for (Observer o : observers) {
         o.update(latestNews);
     }
 }
}

//Concrete Observer: Newspaper
class Newspaper implements Observer {
 public void update(String news) {
     System.out.println("Newspaper received: " + news);
 }
}

//Concrete Observer: TV Channel
class TVChannel implements Observer {
 public void update(String news) {
     System.out.println("TV Channel broadcasting: " + news);
 }
}

//Demo
public class ObserverableDesignPattern2 {
 public static void main(String[] args) {
     NewsAgency agency = new NewsAgency();
     Observer paper = new Newspaper();
     Observer tv = new TVChannel();

     agency.registerObserver(paper);
     agency.registerObserver(tv);

     agency.setNews("Breaking: Observer Pattern Explained!");
 }
}