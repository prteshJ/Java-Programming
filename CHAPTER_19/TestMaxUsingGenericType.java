/***********************************************************************************
	COMMENT FOR MaxUsingGenericType.java

		PG 747

 The two arguments of the max method in MaxUsingGenericType must have the same type
(e.g., two strings or two integer objects).
Furthermore, the type E must be a subtype of Comparable<E>.
***********************************************************************************/

public class TestMaxUsingGenericType {
	public static void main(String[] args) {
		// 23 is autoboxed into new Integer(23)
		MaxUsingGenericType.max("Welcome", 23);
	}
}
