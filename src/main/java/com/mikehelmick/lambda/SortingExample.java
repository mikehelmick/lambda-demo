package com.mikehelmick.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;
import com.mikehelmick.lambda.model.Person;

public class SortingExample {

  public static void main(String[] args) {
    List<Person> data1 = DataLoader.loadData();
    // Create a copy, so we can sort both.
    List<Person> data2 = DataLoader.loadData();

    System.out.println("Old school sorting");
    // Sorting w/o lambdas
    Collections.sort(data1,
        new Comparator<Person>() {
          @Override
          public int compare(Person o1, Person o2) {
            int res = o1.getName().compareTo(o2.getName());
            if (res != 0) {
              return res;
            }
            return Integer.compare(o1.getAge(), o2.getAge());
          }
        });
    for (Person p : data1) {
      System.out.println(p);
    }

    // Sorting with lambdas
    // Still kind of ugly becuase the comparison condition isn't straight foward.
    Collections.sort(data2,
        (p1, p2) ->
            {
              int res = p1.getName().compareTo(p2.getName());
              if (res != 0) {
                return res;
              } else {
                return Integer.compare(p1.getAge(), p2.getAge());
              }
            });
    for (Person p : data1) {
      System.out.println(p);
    }
  }
}
