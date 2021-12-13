package com.ironhack.lab108;

import java.util.Arrays;

/**
 * The first implementation is IntArrayList. IntArrayList should store numbers in an array with a length
 * of 10 by default. When the add method is called, you must first determine if the array is full. If it is,
 * create a new array that is 50% larger, move all elements over to the new array and add the new element.
 * (for example, an array of length 10 would be increased to 15)
 */
public class IntArrayList implements IntList {
    private int[] elements;
    private int size;

    public IntArrayList() {
        this.elements = new int[10];
        setSize(0);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getElements() {
        return elements;
    }

    public void setElements(int[] elements) {
        this.elements = elements;
    }

    @Override
    public void add(int newElement) {
        if (this.getSize() == this.elements.length) {
            int[] newArray = new int[this.elements.length + this.elements.length/2];
            if (this.getSize() >= 0) System.arraycopy(this.getElements(), 0, newArray, 0, this.getSize());
            newArray[this.getSize()] = newElement;
            setSize(this.getSize() + 1);
            setElements(newArray);
        } else {
            this.elements[size] = newElement;
            setSize(this.size + 1);
        }
    }

    @Override
    public int get(int id) {
        return this.elements[id];
    }

    @Override
    public String toString() {
        return "IntArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}
