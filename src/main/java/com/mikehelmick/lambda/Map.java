package com.mikehelmick.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.mikehelmick.lambda.model.Account;
import com.mikehelmick.lambda.model.Person;

public class Map {
  
  public static void print(List<Person> people) {
    for (Person p : people) {
      System.out.println(p);
    }
  }
  
  public static void preJava8() {
    System.out.println("Pre java-8 version");
    List<Person> data = DataLoader.loadData();
    print(data);
    
    // Pre-java 8
    List<Person> tList = new ArrayList<Person>();
    for (Person p : data) {
      Person newP = new Person(p);
      Iterator<Account> acctIter = newP.getAccounts().iterator();
      while (acctIter.hasNext()) {
        Account account = acctIter.next();
        if ("yahoo.com".equals(account.getWebSite())) {
          acctIter.remove();
        }
      }
      tList.add(newP);
    }
    
    print(tList);
  }
    
  public static void preJava8Guava() {
    System.out.println("Pre java-8 w/ Guava version");
    List<Person> data = DataLoader.loadData();
    print(data);
    
    List<Person> tList = Lists.transform(data,
        new Function<Person, Person>() {
          @Override
          public Person apply(Person oldPerson) {
            Person newP = new Person(oldPerson);
            newP.setAccounts(
                Lists.newArrayList(Collections2.filter(newP.getAccounts(),
                    new Predicate<Account>() {
                      @Override
                      public boolean apply(Account account) {
                        return !"yahoo.com".equals(account.getWebSite());
                      }
                    })));
            return newP;
          }
        });
    
    print(tList);
  }
  
  public static void lambdaJava8() {
    System.out.println("Pre java-8 w/ Guava version");
    List<Person> data = DataLoader.loadData();
    print(data);
    
    List<Person> tList = Lists.transform(data,
        (person) ->
            Person.builder().setName(person.getName()).setAge(person.getAge())
                .addAccounts(
                    Collections2.filter(person.getAccounts(),
                        (acct) -> !"yahoo.com".equals(acct.getWebSite())))
                .build());
    
    print(tList);
  }

  public static void main(String[] args) {
    preJava8();
    preJava8Guava();
    lambdaJava8();
  }

}
