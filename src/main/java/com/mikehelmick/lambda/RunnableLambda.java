package com.mikehelmick.lambda;

public class RunnableLambda {

  public static void main(final String args[]) {
    
    // As an anonymous class
    Runnable oldR =
        new Runnable() {
          @Override
          public void run() {
            System.out.println("Anonymous class runnable");
          }
        };
        
    Runnable newR = () -> System.out.println("Lambda runnable");

    oldR.run();
    newR.run();
  }
}
