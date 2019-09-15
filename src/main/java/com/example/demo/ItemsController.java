package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemsController {

    @PostMapping("/items")
    public Response<Item> createItem(@RequestBody Request<Item> request) {
        Item item = request.getData();
        ItemService itemService = new ItemService();
        itemService.createItem(item);
        Response<Item> response = new Response<>();
        response.setData(item);

        return response;
    }

    @GetMapping("/items/{id}")
    public Response<Item> getItem(@PathVariable final String id) {
        int itemId = Integer.parseInt(id);
        Response<Item> response = new Response<Item>();
        response.setData((new ItemService()).getItemById(itemId));

        return response;
    }

    @PatchMapping("/items/{id}")
    public Response<Item> updateItem(@RequestBody Request<Item> request, @PathVariable final String id) {
        ItemService itemService = new ItemService();
        int itemId = Integer.parseInt(id);
        Item item = itemService.getItemById(itemId);

        Item requestItem = request.getData();
        item.setActive(requestItem.isActive());

        itemService.updateItem(item);

        Response<Item> response = new Response<>();
        response.setData(item);

        return response;
    }

    @GetMapping("/items")
    public ResponseCollection<Item> getItems() {
        ResponseCollection<Item> response = new ResponseCollection<Item>();
        response.setData((new ItemService()).getItems());

        return response;
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity index(@PathVariable final String id) {
        ItemService itemService = new ItemService();
        int itemId = Integer.parseInt(id);
        Item item = itemService.getItemById(itemId);
        /* This method uses object and not an id because object can have children (some time later maybe)
         * and ORM would require object to delete it, and it would be better to get object _here_ and not magically inside
         * service (for decoupling and better testability)*/
        itemService.deleteItem(item);

        return new ResponseEntity(HttpStatus.NO_CONTENT);  // http code 204
    }
}