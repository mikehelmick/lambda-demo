package com.mikehelmick.lambda.model;

public class Account {
  private final String webSite;
  private String username;
  private String password;

  public Account(String webSite, String username, String password) {
    this.webSite = webSite;
    this.username = username;
    this.password = password;
  }

  public String getWebSite() {
    return webSite;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return webSite + ":" + username;
  }
}
