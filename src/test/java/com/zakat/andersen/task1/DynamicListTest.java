package com.zakat.andersen.task1;


import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DynamicListTest {


    String str1 = "A";
    String str2 = "B";
    String str3 = "C";
    String str4 = "D";
    String str5 = "E";
    String str6 = "F";
    String nullString = null;

    Student s1 = new Student("A", 7);
    Student s2 = new Student("B", 8);
    Student s3 = new Student("C", 3);
    Student s10 = new Student("A", 1);
    Student s4 = new Student("D", 4);
    Student s5 = new Student("E", 5);
    Student s6 = new Student("F", 6);
    Student s7 = new Student("G", 2);



    @Test
    void add() {
        String testString1 = "A";
        DynamicList<String> testList = new DynamicList<>();
        DynamicList<String> testList1 = new DynamicList<>();
        testList.add(testString1);
        testList1.add(nullString);
        int expectedCounter = 1;
        boolean expectedTrue = true;
        boolean expectedFalse = false;
        assertEquals(expectedCounter, testList.getNumberOfElements());
        assertEquals(expectedTrue, testList.add(testString1));
        assertEquals(expectedFalse, testList1.add(nullString));
    }

    @Test
    void sort(){
        DynamicList<Student> list = new DynamicList<>();
        DynamicList<Student> expectedList = new DynamicList<>();

        Student s1 = new Student("A", 7);
        Student s2 = new Student("B", 8);
        Student s3 = new Student("C", 3);
        Student s10 = new Student("AA", 1);
        Student s4 = new Student("D", 4);
        Student s5 = new Student("E", 5);
        Student s6 = new Student("F", 6);
        Student s7 = new Student("G", 2);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
        list.add(s10);
        expectedList.add(s10);
        expectedList.add(s7);
        expectedList.add(s3);
        expectedList.add(s4);
        expectedList.add(s5);
        expectedList.add(s6);
        expectedList.add(s1);
        expectedList.add(s2);
        Quicksort.quicksortWithComparator(list, 0, list.getNumberOfElements()-1, new StudentComparator());
        assertEquals(expectedList, list);

    }

    @Test
    void addFromDynamicList() {
        DynamicList<String> testList = new DynamicList<>();
        DynamicList<String> testList1 = new DynamicList<>();
        DynamicList<String> testList2 = new DynamicList<>();

        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        testList1.add(str4);
        testList1.add(str5);
        testList1.add(str6);
        assertTrue(testList.addFromDynamicList(testList1));
        assertFalse(testList.addFromDynamicList(testList2));
    }

    @Test
    void deleteAllElements() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        int counterOfElements = 0;
        testList.deleteAllElements();
        assertEquals(counterOfElements, testList.getNumberOfElements());

    }

    @Test
    void isContainsElement() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        assertTrue(testList.isContainsElement(str2));
        assertFalse(testList.isContainsElement(str4));
    }

    @Test
    void addToPosition() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        testList.add(str4);
        testList.add(str5);
        int indexAdd = 4;
        assertTrue(testList.addToPosition(3, str6));
        assertFalse(testList.addToPosition(-5, str2));
        assertFalse(testList.addToPosition(10, str2));
        assertEquals(indexAdd, testList.getIndexOfObject(str4));
    }

    @Test
    void removeElementToIndex() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        int counterOfElements = 2;
        testList.removeElementToIndex(1);
        assertEquals(counterOfElements, testList.getNumberOfElements());
        int wrongIndex1 = 7;
        int wrongIndex2 = -7;
        ArrayIndexOutOfBoundsException thrown1 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            testList.removeElementToIndex(wrongIndex1);
        });
        ArrayIndexOutOfBoundsException thrown2 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            testList.removeElementToIndex(wrongIndex2);
        });

    }

    @Test
    void removeElement() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        int counterOfElements = 2;
        assertFalse(testList.removeElement(nullString));
        assertTrue(testList.removeElement(str2));
        assertEquals(counterOfElements, testList.getNumberOfElements());
    }

    @Test
    void getElementToIndex() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        assertEquals(str2, testList.getElementToIndex(1));
        int wrongIndex1 = 7;
        int wrongIndex2 = -7;
        ArrayIndexOutOfBoundsException thrown1 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            testList.getElementToIndex(wrongIndex1);
        });
        ArrayIndexOutOfBoundsException thrown2 = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            testList.getElementToIndex(wrongIndex2);
        });
    }

    @Test
    void getNumberOfElements() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        assertEquals(3, testList.getNumberOfElements());

    }

    @Test
    void getCapacity() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        testList.add(str4);
        testList.add(str5);
        testList.add(str6);
        assertEquals(7, testList.getCapacity());
    }

    @Test
    void setElement() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        testList.add(str4);
        testList.add(str5);
        testList.setElement(2, str6);
        assertEquals(str6, testList.getElementToIndex(2));
        assertEquals(str4, testList.getElementToIndex(3));
    }

    @Test
    void increaseCapacity() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        testList.add(str4);
        testList.add(str5);

        assertEquals(5, testList.getCapacity());
        testList.increaseCapacity(100);
        assertEquals(100, testList.getCapacity());
    }

    @Test
    void getIndexOfObject() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        assertEquals(2, testList.getIndexOfObject(str3));
        assertEquals(-1, testList.getIndexOfObject(str6));
        assertEquals(-1, testList.getIndexOfObject(nullString));
    }

    @Test
    void isEmpty() {
        DynamicList<String> testList = new DynamicList<>();
        DynamicList<String> testList1 = new DynamicList<>();
        testList1.add(str3);
        assertTrue(testList.isEmpty());
        assertFalse(testList1.isEmpty());
    }

    @Test
    void cutToSize() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        testList.cutToSize();
        assertEquals(3, testList.getCapacity());
    }

    @Test
    void arrayFromDynamicList() {
        DynamicList<String> testList = new DynamicList<>();
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        testList.add(str4);
        testList.add(str5);

        String[] expectedArray = new String[]{"A", "B", "C", "D", "E"};
        assertEquals(Arrays.toString(expectedArray), Arrays.toString(testList.arrayFromDynamicList()));
    }


}