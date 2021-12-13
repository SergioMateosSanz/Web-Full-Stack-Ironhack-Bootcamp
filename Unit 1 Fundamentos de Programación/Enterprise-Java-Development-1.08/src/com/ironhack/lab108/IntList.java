package com.ironhack.lab108;

/**
 * Create an IntList Interface. An IntList is simply a way to store an ordered list of integers.
 *
 * All IntLists should have an add method by which a user can a new number to the list.
 * All IntLists should have a get method by which users can retrieve an element by id.
 */
public interface IntList {

    void add (int newElement);
    int get (int id);
}
