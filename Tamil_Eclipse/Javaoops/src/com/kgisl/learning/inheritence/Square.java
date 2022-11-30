package com.kgisl.learning.inheritence;

public class Square extends Shape {

	/**
	 * @param length
	 * @param breadth
	 */
	public Square() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int calcArea() { 

		return getLength()*getLength(); 

		} 

		public int calcPerimeter() { 

		return 4*(getLength()); 

		} 
}
