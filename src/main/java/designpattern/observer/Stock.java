package designpattern.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public  class Stock implements Observable{

	
	private List<Observer> observerList;
	private String name;
	private int price;
	
	public Stock(){
		observerList=new ArrayList<>();
	}
	public List<Observer> getObserverList() {
		return observerList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void registerObserver(Observer observer){
		if (observer != null)
		observerList.add(observer);
		
	}
	public void removeObserver(Observer observer){
		if (observer != null)
		this.observerList.remove(observer);
	}
	
	public void notifyObservers(){
		Iterator<Observer> observerItr=observerList.iterator();
		while (observerItr.hasNext()){
			Observer o=observerItr.next();
			o.update(this);
		}
		
	}
	
	public void updateStockPrice(int updatedPrice){
		this.price=updatedPrice;
		this.notifyObservers();
	}
	
}
