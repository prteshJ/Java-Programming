package chapter15_eclipse_liang;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ObservablePropertyDemo {
	public static void main(String[] args) {
		DoubleProperty balance = new SimpleDoubleProperty();
		
		balance.addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				// TODO Auto-generated method stub
				System.out.println("The new value is " + balance.doubleValue() );
			}
		});
		
		/***** LAMBDA EXPRESSION ****/
	//	balance.addListener(ov -> System.out.println("The new value is " + balance.doubleValue()));
		
		balance.set(4.5);
	}
}
