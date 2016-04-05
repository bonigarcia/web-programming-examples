package io.github.web.angularjs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemRestController {

    @Autowired
    private ItemRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> findItems() {
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        item.setId(null);
        Item newItem = repo.saveAndFlush(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Item> updateItem(@RequestBody Item updatedItem,
            @PathVariable Integer id) {

        updatedItem.setId(id);
        Item item = repo.saveAndFlush(updatedItem);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable Integer id) {
        repo.delete(id);
    }
}
