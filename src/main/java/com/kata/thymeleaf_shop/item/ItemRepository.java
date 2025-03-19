package com.kata.thymeleaf_shop.item;

import com.kata.thymeleaf_shop.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
   List<Item> findItemByUser(User user);
}
