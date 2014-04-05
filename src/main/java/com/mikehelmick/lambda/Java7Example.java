package com.mikehelmick.lambda;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.mikehelmick.lambda.model.Account;
import com.mikehelmick.lambda.model.Person;

public class Java7Example {
  
  public static List<Person> filterBySite(List<Person> data, final String site) {
    final List<Person> result = Lists.newArrayList(
        Iterables.filter(data,
            new Predicate<Person>() {
              @Override
              public boolean apply(Person person) {
                for (Account acct : person.getAccounts()) {
                  if (acct.getWebSite().equals(site)) {
                    return true;
                  }
                }
                return false;
              }
            }));
    return result;
  }
  
  public static void printList(final List<Person> people) {
    for (Person p : people) {
      System.out.println(p);
    }
  }
  
  public static void main(final String args[]) {
    List<Person> data = DataLoader.loadData();
    System.out.println("All people: ");
    printList(data);
    System.out.println("**********");
    
    List<Person> hasGoogleAcct = filterBySite(data, "google.com");
    System.out.println("Filtered: ");
    printList(hasGoogleAcct);
  }
}
