package com.example.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class InventoryTest {

  @Test
  void addsAndRemovesStock() {
    Inventory inventory = new Inventory();
    inventory.add("APPLE", 10);

    assertTrue(inventory.remove("APPLE", 4));
    assertEquals(6, inventory.quantityOf("APPLE"));
  }

  @Test
  void refusesToRemoveMoreThanAvailable() {
    Inventory inventory = new Inventory();
    inventory.add("APPLE", 1);

    assertFalse(inventory.remove("APPLE", 2));
  }

  @Test
  void rejectsNonPositiveQuantities() {
    Inventory inventory = new Inventory();

    assertThrows(IllegalArgumentException.class, () -> inventory.add("APPLE", 0));
  }
}
