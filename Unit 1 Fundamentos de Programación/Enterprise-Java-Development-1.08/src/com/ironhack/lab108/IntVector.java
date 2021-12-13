package com.ironhack.lab108;

import java.util.Arrays;

public class IntVector implements  IntList {
    private int[] elements;
    private int size;

    public IntVector() {
        this.elements = new int[20];
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
            int[] newArray = new int[this.elements.length * 2];
            if (this.getSize() >= 0) System.arraycopy(this.getElements(), 0, newArray, 0, this.getSize());
            newArray[this.getSize()] = newElement;
            setSize(this.getSize() + 1);
            setElements(newArray);
        } else {
            this.elements[this.getSize()] = newElement;
            setSize(this.getSize() + 1);
        }
    }

    @Override
    public int get(int id) {
        return this.elements[id];
    }

    @Override
    public String toString() {
        return "IntVector{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}
