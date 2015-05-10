package com.fasfsfgs.entity;

public class Entity01 {

  private Integer id;

  private String description;

  private boolean active;

  public Entity01() {
    super();
  }

  public Entity01(Integer id, String description, boolean active) {
    this.id = id;
    this.description = description;
    this.active = active;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

}
