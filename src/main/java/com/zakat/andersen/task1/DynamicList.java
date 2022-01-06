package com.zakat.andersen.task1;

import java.util.*;
import java.util.function.Consumer;

/**
 * DynamicList(DL): Alternative realization of ArrayList based in Arrays
 */

public class DynamicList<E> implements Iterable<E> {
    /**
     * Field @BASE_SIZE set start capacity of DynamicList with empty constructor
     */
    private final int BASE_SIZE = 5;
    /**
     * Field @size contains current capacity of DL
     */
    private int size;
    /**
     * Field @counterOfElements - quantity not null elements in DL
     */
    private int counterOfElements;
    /**
     * Field @objects - base array to this DL
     */
    private Object[] objects;

    /**
     * Default constructor DL with base size=5
     */
    public DynamicList() {
        this.size = BASE_SIZE;
        this.objects = new Object[BASE_SIZE];
    }

    /**
     * Alt constructor DL
     *
     * @param capacity - set capacity created DL
     */
    public DynamicList(int capacity) {
        this.size = capacity;
        this.objects = new Object[capacity];
    }

    /**
     * Add new element to DL. Increase capacity if necessary.
     *
     * @param obj given object added to DL
     * @return if given object add to DL successfully return true else return false if element == null
     */
    public boolean add(E obj) {
        if (obj == null)
            return false;
        if ((objects.length - 1) == (counterOfElements - 1)) {
            objects = weNeedMoreSpace(objects);
            size = objects.length;
        }
        objects[counterOfElements] = obj;
        counterOfElements++;
        return true;
    }

    /**
     * Add elements from given DL to end of this DL. Increase capacity if necessary.
     *
     * @param collection parametrized argument
     * @return true is DL collection added sucseccfully or false if collection== null
     */

    public boolean addFromDynamicList(DynamicList<E> collection) {
        if (collection.isEmpty())
            return false;
        if ((size - counterOfElements) < collection.counterOfElements) {
            increaseCapacity(size + (collection.size - (size - counterOfElements)));
        }
        for (Object element : collection) {
            if (element == null)
                continue;
            add((E) element);
        }
        return true;
    }

    /**
     * Sorting DL use given Comparator
     * @param comparator
     */
    public void sort(Comparator<E> comparator){
        Quicksort.quicksortWithComparator(this, 0, this.getNumberOfElements()-1, comparator);
    }

    /**
     * Delete all element from this DL. Capacity of DL is not change
     */
    public void deleteAllElements() {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null)
                counterOfElements--;
            objects[i] = null;
        }
    }

    /**
     * Check this elements in DL. If given elements is null return false.
     *
     * @param obj parametrize
     * @return true if DL have given elements or return false
     */
    public boolean isContainsElement(E obj) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null)
                continue;
            if (obj == null)
                return false;
            if (objects[i].equals(obj))
                return true;
        }
        return false;
    }

    /**
     * Add given parametrized elements to specify position.  Increase capacity if necessary.
     *
     * @param index to this DL.
     * @param obj
     * @return Is index <0 or more than count elements on this collection - return false.
     */
    public boolean addToPosition(int index, E obj) {
        if (index < 0)
            return false;
        if (index > counterOfElements)
            return false;
        if ((objects.length) <= counterOfElements + 1) {
            objects = weNeedMoreSpace(objects);
            size = objects.length;
        }
        for (int i = counterOfElements; i >= index; i--) {
            objects[i + 1] = objects[i];
        }
        objects[index] = obj;
        counterOfElements++;
        return true;
    }

    /**
     * Remove specified element to index. Throw Exception DL not have this index
     *
     * @param index of removed elements
     */
    public void removeElementToIndex(int index) {
        if (index > counterOfElements - 1 || index < 0) {
            System.out.println("Size of DynamicList is " + counterOfElements + ". Requested index is " + index);
            throw new ArrayIndexOutOfBoundsException();
        }
        objects[index] = null;
        for (int i = index; i < objects.length - 1; i++) {
            objects[i] = objects[i + 1];

        }
        objects[counterOfElements - 1] = null;
        counterOfElements--;

    }

    /**
     * Remove specified parametrized object if object exist in DL
     *
     * @param obj
     * @return true if object has been removed or return fals if object == null or not included to DL
     */
    public boolean removeElement(E obj) {
        if (obj == null)
            return false;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null)
                continue;
            if (objects[i].equals(obj)) {
                removeElementToIndex(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Return element of DL to specified index
     *
     * @param index
     * @return
     */
    public Object getElementToIndex(int index) {
        if (index >= objects.length || index < 0) {
            System.out.println("Size of DynamicList is " + size + ". Requested index is " + index);
            throw new ArrayIndexOutOfBoundsException();
        }
        return objects[index];
    }

    /**
     * Return quantity not null element on DL
     *
     * @return
     */
    public int getNumberOfElements() {
        return counterOfElements;
    }

    /**
     * Return total capacity of DL
     *
     * @return
     */
    public int getCapacity() {
        return size;
    }

    /**
     * Set parametrized element to specified position.
     *
     * @param index Throw exception if index not included to DL
     * @param obj
     */
    public void setElement(int index, E obj) {
        if (index > counterOfElements || index < 0) {
            System.out.println("Size of DynamicList is " + size + ". Requested index is " + index);
            throw new ArrayIndexOutOfBoundsException();
        }
        objects[index] = obj;
    }

    /**
     * Increase capacity of this DL
     *
     * @param capacity
     */
    public void increaseCapacity(int capacity) {
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < objects.length; i++) {
            newArray[i] = objects[i];
            objects[i] = null;
        }
        objects = newArray;
        size = capacity;
    }


    /**
     * Increase capacity of this DL when other methods add new elements.
     *
     * @param oldArray
     * @return Return new Object array to call method
     */
    private Object[] weNeedMoreSpace(Object[] oldArray) {
        size = oldArray.length + (oldArray.length / 2);
        return Arrays.copyOf(oldArray, size);
    }


    /**
     * Return index to given object
     *
     * @param obj
     * @return index or return -1 if object not found. If DL have null object return index first null elements
     */
    public int getIndexOfObject(E obj) {
        if (obj == null) {
            for (int i = 0; i < counterOfElements; i++) {
                if (objects[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < counterOfElements; i++) {
                if (objects[i].equals(obj))
                    return i;
            }
        }
        return -1;
    }


    /**
     * If this DL no added object return true
     *
     * @return
     */
    public boolean isEmpty() {
        if (objects.length == 0)
            return true;
        if (counterOfElements == 0)
            return true;
        return false;
    }

    /**
     * Trim size to this DL to counterElements size
     */
    public void cutToSize() {
        objects = Arrays.copyOf(objects, counterOfElements);
        size = counterOfElements;
    }

    public Object[] arrayFromDynamicList() {
        return objects;
    }


    @Override
    public String toString() {
        return "DynamicList{" +
                "size=" + size +
                ", counterOfElements=" + counterOfElements +
                ", objects=" + Arrays.toString(objects) +
                '}';
    }


    /**
     * Return iretator for this DL
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int currentIndex;

            @Override
            public boolean hasNext() {
                return currentIndex < counterOfElements && objects[currentIndex] != null;
            }

            @Override
            public E next() {
                return (E) objects[currentIndex++];
            }
        };
        return iterator;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicList<?> that = (DynamicList<?>) o;
        return BASE_SIZE == that.BASE_SIZE && size == that.size && counterOfElements == that.counterOfElements && Arrays.equals(objects, that.objects);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(BASE_SIZE, size, counterOfElements);
        result = 31 * result + Arrays.hashCode(objects);
        return result;
    }
}
