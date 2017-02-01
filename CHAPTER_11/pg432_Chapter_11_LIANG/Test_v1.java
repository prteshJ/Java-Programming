// This has incorrect overridden equals method of object class
// Here, we are overloading equals method & not overriding it
// Hence, our equals method gets ignored if we pass Object
// as parameter & equals in Object get invoked & we get
// incorrect output

public class Test_v1 {
	public static void main(String[] args) {
		Object circle1 = new Circle();
		Object circle2 = new Circle();
		System.out.println(circle1.equals(circle2));
	}
}

class Circle {
	double radius;

	public boolean equals(Circle circle) {
		return this.radius == circle.radius;
	}
}
