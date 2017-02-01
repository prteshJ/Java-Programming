/*
	CONSTRUCTOR CHAINING EXAMPLE
	PG 417
	LIANG JAVA BOOK
*/
	public class Faculty extends Employee {
		/* Main Method */
		public static void main(String[] args) {
			new Faculty(); 
		}

		/* Constructor */
		public Faculty() {
			System.out.println("(4) Performs Faculty's tasks");
		}
	} /* Faculty class definition over */

		class Employee extends Person {
			/* Constructor */
			public Employee() {
				this("(2) Invoke Employee's overloaded constructor"); // Calls Employee's parameterized constructor
				System.out.println("(3) Performs Employee's tasks ");
			}

			/* Parameterized Constructor */
			public Employee(String s) {
				System.out.println(s);
			}
		} /* Employee class defnition over */

		class Person {
			/* Constructor */
			public Person() {
				System.out.println("(1) Performs Person's tasks");
			}
		} /* Person class definition over */
