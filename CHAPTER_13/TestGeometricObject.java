/***************************************************************************
 NOTICE HERE that in Geometric Class , I have defined 2 abstract methods :-
 	NAMELY , (i) getArea() & (ii) getPerimeter().
 I HAD TO DEFINE THESE AS abstract for 2 REASONS :-
	(I)  These methods are true for any concrete geometric object.
	(II) It is impossible to provide implementation logic for all
	     concrete geometric objects which extend Geometric Object base
       	     class since al these subclasses may not be partially related
	     to each other or not at all. Morever, it breaks OOP's design
             principles of Encapsulation , Abstraction and hence, it is
	     not practical to do that.
 THE BEAUTY OF ABSTRACT CLASSES :-
	(i)    It is incomplete but it specifies a contract that it's
	       concrete subclasses must fulfill.
	(ii)   It encourages inheritance and supports polymorphism and
	       is making use of OOP design principle of Abstraction
	       without breaking Encapsulation principle.
	(iii)  It is more flexible compared to interfaces since it has
       	       allowance of cocnrete methods & non final variables
	       though it should be used for STRONG IS-A relationships
	       whereas INTERFACES are more suitable for WEAK IS-A
	       relationships where some comman behaviour is expected from
	       classes that are related or maybe UNRELATED to each other.
***************************************************************************/

public class TestGeometricObject {
  /** Main method */
  public static void main(String[] args) {
    // Declare and initialize two geometric objects
    GeometricObject geoObject1 = new Circle(5);
    GeometricObject geoObject2 = new Rectangle(5, 3);

    System.out.println("The two objects have the same area? " +
      equalArea(geoObject1, geoObject2));

    // Display circle
    displayGeometricObject(geoObject1);

    // Display rectangle
    displayGeometricObject(geoObject2);
  }

  /** A method for comparing the areas of two geometric objects */
  public static boolean equalArea(GeometricObject object1,
      GeometricObject object2) {
    return object1.getArea() == object2.getArea();
  }

  /** A method for displaying a geometric object */
  public static void displayGeometricObject(GeometricObject object) {
    System.out.println();
    System.out.println("The area is " + object.getArea());
    System.out.println("The perimeter is " + object.getPerimeter());
  }
}
