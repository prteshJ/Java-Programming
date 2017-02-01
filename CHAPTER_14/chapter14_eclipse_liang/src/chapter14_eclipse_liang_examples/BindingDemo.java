package chapter14_eclipse_liang_examples;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * 
 * @author PriteshJ
 * bind -> unidirectional binding -> target changes when source changes
 * bindBidirectional -> bidirectional binding -> both target & source
 * update each other when any one changes respectively
 *  
 * If the target and source are 
 * both binding properties and observable properties, 
 * they can be bound bidirectionally using the 
 * bindBidirectional method.
 */

public class BindingDemo {
	public static void main(String[] args) {
		DoubleProperty d1 = new SimpleDoubleProperty(1);
		DoubleProperty d2 = new SimpleDoubleProperty(2);
		d1.bind(d2);
		System.out.println("d1 is " + d1.getValue() + " and d2 is " + d2.getValue());
		d2.setValue(70.2);
		System.out.println("d1 is " + d1.getValue() + " and d2 is " + d2.getValue());
	}
}