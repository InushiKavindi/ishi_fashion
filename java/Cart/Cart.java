package Cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Items.Item;

public class Cart {
    private Map<Item, Integer> itemQuantities; // Map to store item and its quantity

    public Cart() {
        this.itemQuantities = new HashMap<>();
    }

    public void addItem(Item item) {
        itemQuantities.put(item, itemQuantities.getOrDefault(item, 0) + 1);
    }

    public void updateItemQuantity(int itemId, int quantity) {
        for (Item item : itemQuantities.keySet()) {
            if (item.getId() == itemId) {
                if (quantity > 0) {
                    itemQuantities.put(item, quantity);
                } else {
                    itemQuantities.remove(item); // Remove if quantity is zero
                }
                break;
            }
        }
    }

    public void removeItem(int itemId) {
        itemQuantities.entrySet().removeIf(entry -> entry.getKey().getId() == itemId);
    }

    public List<Item> getItems() {
        return new ArrayList<>(itemQuantities.keySet());
    }

    public int getItemQuantity(Item item) {
        return itemQuantities.getOrDefault(item, 0);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<Item, Integer> entry : itemQuantities.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
