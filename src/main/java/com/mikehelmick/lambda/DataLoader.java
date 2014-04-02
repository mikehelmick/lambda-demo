package com.mikehelmick.lambda;

import java.util.List;

import com.google.common.collect.Lists;
import com.mikehelmick.lambda.model.Account;
import com.mikehelmick.lambda.model.Person;

public class DataLoader {

  public static List<Person> loadData() {
    
    final Person p1 = new Person("Alice", 25);
    p1.addAccount(new Account("google.com", "alice", "password"));
    p1.addAccount(new Account("yahoo.com", "aliceY", "password"));

    final Person p2 = new Person("Bob", 27);
    p2.addAccount(new Account("google.com", "mrbob", "password"));
    p2.addAccount(new Account("yahoo.com", "fakebob", "password"));
    p2.addAccount(new Account("yahoo.com", "realbob", "password"));
    
    final Person p3 = new Person("Jim", 29);
    p3.addAccount(new Account("facebook.com", "jim.ismyname@gmail.com", "password"));
    
    return Lists.newArrayList(p1, p2, p3);
  }
}
