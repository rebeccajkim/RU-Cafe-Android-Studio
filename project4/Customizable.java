package project4;

/**
This interface has methods to add and remove objects and other classes implement it since they
commonly need add and remove methods. 
@author mayeesha, rebecca
*/
public interface Customizable {
	
	/**
	This method would add an object.
	@param object
	*/
	boolean add(Object obj);
	
	/**
	This method would remove an object.
	@param object
	*/
	boolean remove(Object obj);

}