package com.mikehelmick.lambda.model;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class Person {
  private String name;
  private int age;
  private List<Account> accounts = Lists.newArrayList();

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public List<Account> getAccounts() {
    return ImmutableList.copyOf(accounts);
  }

  public void addAccount(Account account) {
    accounts.add(account);
  }
  
  @Override
  public String toString() {
    StringBuffer buf = new StringBuffer();
    buf.append(name);
    buf.append(" : ");
    buf.append(age);
    buf.append("\n");
    for (Account acct : accounts) {
      buf.append(acct);
      buf.append("\n");
    }
    return buf.toString();
  }
  
  private static class SiteFilter implements Predicate<Account> {
    private final String site;
    
    SiteFilter(String site) {
      this.site = site;
    }
    
    @Override
    public boolean apply(Account account) {
      return !account.getWebSite().equals(site);
    }
  }

  public boolean removeAccounts(final String site) {
    final int oldSize = accounts.size();
    accounts = Lists.newArrayList(
        Iterables.filter(accounts,
            new SiteFilter(site)));
    return accounts.size() != oldSize;
  }

  public boolean removeAccounts(String site, String username) {
    final int oldSize = accounts.size();
    accounts = Lists.newArrayList(Iterables.filter(accounts,
        new Predicate<Account> () {
          @Override
          public boolean apply(Account account) {
            return !(account.getWebSite().equals(site) && account.getUsername().equals(username));
          }
        }));
    return accounts.size() != oldSize;    
  }
}
