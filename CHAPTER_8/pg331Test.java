class pg331Test {
	public static void main(String[] args) {
		Student student = new Student();
		System.out.println("name? " + student.name);
		System.out.println("age? " + student.age);
		System.out.println("isScienceMajor? " + student.isScienceMajor);
		System.out.println("gender? " + student.gender);
	}
}

class Student {
                String name;
                int age;
                boolean isScienceMajor;
                char gender;
}
