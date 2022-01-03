package com.zakat.andersen.task1;

import java.util.Arrays;
import java.util.Objects;

public class TestArray {
    public static void main(String[] args) {


DynamicList<Student> list = new DynamicList<>();
DynamicList<Student> list2 = new DynamicList<>();
//        DynamicList<String> list = new DynamicList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//        list.add("E");


Student s1 = new Student("A", 1);
Student s2 = new Student("B", 2);
Student s3 = new Student("C", 3);
Student s10 = new Student("A", 1);
Student s4 = new Student("D", 4);
Student s5 = new Student("E", 5);
Student s6 = new Student("F", 2);
//Student s7 = new Student("G", 3);
//Student s8 = null;
//Student s9 = null;



list.add(s1);
list.add(s2);
list.add(s3);

list2.add(s4);
list2.add(s5);
list2.add(s6);
//list.add(s5);
//list.add(s6);
//list.add(s7);
        System.out.println(list);
        Object[] obj = list.arrayFromDynamicList();
        System.out.println(Arrays.toString(obj));

    }


}

class Student {
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course);
    }
}
