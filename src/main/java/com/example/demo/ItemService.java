/* ideally this service would fetch data from ORM */

package com.example.demo;

import java.util.ArrayList;

class ItemService {

    ArrayList<Item> getItems() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(getMockItem(666, "Orange juice", true, -1));
        return list;
    }

    Item getItemById(int id) {
        return getMockItem(id, "Marshmallow Gunter", false, 30);
    }

    private Item getMockItem(int id, String name, boolean active, int qty) {
        Item item = new Item();
        item.setId(id);
        item.setActive(active);
        item.setName(name);
        item.setQty(qty);
        return item;
    }

    void createItem(Item item) {
        /* generating fake id */
        item.setId((int)Math.floor(Math.random() * 1000));
    }

    boolean updateItem(Item item) {
        return true;
    }

    boolean deleteItem(Item item) {
        return true;
    }

}
