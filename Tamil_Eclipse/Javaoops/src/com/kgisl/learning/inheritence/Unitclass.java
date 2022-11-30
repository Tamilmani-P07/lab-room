package com.kgisl.learning.inheritence;

public class Unitclass {

	public static void main(String[] args) {
		
		Shape o_Rectangle=new Rectangle();
		o_Rectangle.setBreadth(10);
		o_Rectangle.setLength(5);
		System.out.println(o_Rectangle.calcArea());
	}

}
