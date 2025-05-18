public class ArrayOfObject {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s1.name = "Rahul";
        s1.marks = 98;

        s2.name = "Manisha";
        s2.marks = 95;

        s3.name = "Srinibash";
        s3.marks = 93;

        Student students[] = new Student[3];
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].name + " : " + students[i].marks);
        }
    }
}

class Student {
    // instance variables
    String name;
    int marks;
}
