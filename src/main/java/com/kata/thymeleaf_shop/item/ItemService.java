package com.kata.thymeleaf_shop.item;

import com.kata.thymeleaf_shop.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> searchItemsForUser(User user){
        List<Item> itemByUser = itemRepository.findItemByUser(user);
        return itemByUser;
    }

    public void create(Item newItem) {
        itemRepository.save(newItem);
    }

    public void delete(Long id) {
        this.itemRepository.deleteById(id);
    }
}
