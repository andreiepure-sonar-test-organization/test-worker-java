package com.example.inventory;

public class Main {

  public static void main(String[] args) {
    Inventory inventory = new Inventory();
    inventory.add("APPLE", 10);
    inventory.remove("APPLE", 3);
    System.out.println("APPLE in stock: " + inventory.quantityOf("APPLE"));
  }
}
