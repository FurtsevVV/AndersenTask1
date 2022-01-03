package com.zakat.andersen.task1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DynamicList<E> implements Iterable<E> {

    private final int BASE_SIZE = 5;
    /**
     * Current Size of Base Array Dynamiclist, equals array.length
     */
    private int size;
    /**
     * Current Size of Dynamiclist
     */
    private int counterOfElements;
    private Object[] objects;

    public DynamicList(){
        this.size = BASE_SIZE;
        this.objects = new Object[BASE_SIZE];
    }

    public DynamicList(int capacity){
        this.size = capacity;
        this.objects = new Object[capacity];
    }


public void add(E obj){
if((objects.length-1) == (counterOfElements-1)){
   objects =  weNeedMoreSpace(objects);
   size = objects.length;
}
        objects[counterOfElements] = obj;
        counterOfElements++;
}

public boolean addFromDynamicList(DynamicList collection){
        if(collection.isEmpty())
            return false;
if(collection==null)
    return false;
if((size-counterOfElements)< collection.counterOfElements){
    increaseCapacity(size + (collection.size - (size-counterOfElements)));
}
for (Object element: collection){
    if(element==null)
        continue;

        add((E) element);


}
return true;}


public void deleteAllElements(){
        for(int i =0; i< objects.length; i++){
            if(objects[i]!=null)
                counterOfElements--;
            objects[i] = null;

        }
}

public boolean isContainsElement(E obj){
    for(int i =0; i< objects.length; i++){
        if(objects[i]==null)
            continue;
        if(objects[i].equals(obj))
            return true;
    }
    return false;
}


public boolean addToPosition(int index, E obj){
        if(index< 0)
            return false;
        if(index>counterOfElements)
            return false;
    if((objects.length) <= counterOfElements+1){
        objects =  weNeedMoreSpace(objects);
        size = objects.length;
    }
    for(int i = counterOfElements; i >= index; i--) {
        objects[i + 1] = objects[i];
    }
    objects[index] = obj;
    counterOfElements++;
return true;
}

public void removeElementToIndex(int index){
    if(index>counterOfElements-1) {
        System.out.println("Size of DynamicList is " + counterOfElements + ". Requested index is " + index);
        throw new ArrayIndexOutOfBoundsException();
    }
    objects[index] = null;
    for(int i = index; i < objects.length -1; i++){
        objects[i] = objects[i + 1];

    }
    objects[counterOfElements-1] = null;
counterOfElements--;

}

public boolean removeElement(E obj){
        if(obj==null)
            return false;
        for(int i=0; i<objects.length; i++){
            if(objects[i] == null)
                continue;
            if(objects[i].equals(obj)){
                removeElementToIndex(i);
            return true;
                        }
}
    return false;
}


//задокументировать исключение
public Object getElementToIndex(int index){
        if(index>=objects.length){
            System.out.println("Size of DynamicList is " + size + ". Requested index is " + index);
            throw new ArrayIndexOutOfBoundsException();
        }
        return objects[index];
}

public int getNumberOfElements(){
        return counterOfElements;
}

public int getCapacity(){
        return size;
}

public void setElement(int index, E obj){
        objects[index] = obj;
}


    public void increaseCapacity(int capacity) {
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < objects.length; i++) {
            newArray[i] = objects[i];
            objects[i] = null;
        }
        objects = newArray;
        size = capacity;
    }

private Object[] weNeedMoreSpace(Object[] oldArray){
        size = oldArray.length+(oldArray.length/2);
return Arrays.copyOf(oldArray, size);
}



public int indexOfObject(E obj){
        if(obj == null){
            for(int i = 0; i< counterOfElements; i++){
                if(objects[i] == null)
                    return i;
            }
        } else {
            for(int i = 0; i< counterOfElements; i++){
                if(objects[i].equals(obj))
                    return i;
        }
} return -1;
    }



    public boolean isEmpty(){
        if(objects.length==0)
            return true;
        if(counterOfElements==0)
            return true;
        return false;
    }

    public void cutToSize(){
        Object[] newObjects = new Object[counterOfElements];
      objects =  Arrays.copyOf(objects, counterOfElements);
      size=counterOfElements;
}

public Object[] arrayFromDynamicList(){
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


    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            private int currentIndex;
            @Override
            public boolean hasNext() {
                return currentIndex<counterOfElements && objects[currentIndex]!=null;
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
}
