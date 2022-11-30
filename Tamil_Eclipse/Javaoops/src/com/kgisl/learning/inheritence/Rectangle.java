/**
 * 
 */
package com.kgisl.learning.inheritence;

/**
 * @author tamilmani.p
 *
 */
public class Rectangle extends Shape{

	/**
	 * @param length
	 * @param breadth
	 */
	public Rectangle() {
		super();
	
	}
	public int calcArea() { 

		return getLength()*getBreadth(); 

		} 

		public int calcPerimeter() { 

		return 2*(getLength()+getBreadth()); 

		} 

}
