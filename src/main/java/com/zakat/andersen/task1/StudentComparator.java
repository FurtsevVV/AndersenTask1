package com.zakat.andersen.task1;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if(student1.course == student2.course)
            return 0;
        if(student1.course < student2.course)
            return -1;
        else return 1;
    }


}
