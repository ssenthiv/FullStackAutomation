/**
 * 
 */
package designpattern.observer;

/**
 * @author shunmugam
 *
 */
public interface Observable {

	public void registerObserver(Observer observer);
	public void notifyObservers();
	public void removeObserver(Observer observer);
}
