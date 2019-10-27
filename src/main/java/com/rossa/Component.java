package com.rossa;

@org.springframework.stereotype.Component
public class Component {
  protected Integer someIntProtec = 3;

  public Integer getSomeIntProtec() {
    return someIntProtec;
  }
}
