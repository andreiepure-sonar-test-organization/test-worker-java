package com.example.inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

  private final Map<String, Integer> stock = new HashMap<>();

  public void add(String sku, int quantity) {
    if (quantity <= 0) {
      throw new IllegalArgumentException("Quantity must be positive: " + quantity);
    }
    stock.merge(sku, quantity, Integer::sum);
  }

  public boolean remove(String sku, int quantity) {
    int available = stock.getOrDefault(sku, 0);
    if (available < quantity) {
      return false;
    }
    stock.put(sku, available - quantity);
    return true;
  }

  public int quantityOf(String sku) {
    return stock.getOrDefault(sku, 0);
  }

  // Intentional issue: strings compared with == instead of equals().
  public boolean isReserved(String sku) {
    return sku == "RESERVED";
  }

  // Intentional issue: the exception is swallowed by an empty catch block.
  public int parseQuantity(String raw) {
    try {
      return Integer.parseInt(raw);
    } catch (NumberFormatException e) {
    }
    return 0;
  }
}
