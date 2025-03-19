package com.kata.thymeleaf_shop.shoppinglist;

import com.kata.thymeleaf_shop.item.Item;
import com.kata.thymeleaf_shop.item.ItemService;
import com.kata.thymeleaf_shop.user.User;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shopping-list")
public class ShoppingListController {

    ItemService itemService;

    public ShoppingListController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String shoppingList(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("item", new Item());
        model.addAttribute("items", itemService.searchItemsForUser(user));
        return "shopping-list";
    }

    @GetMapping("/add")
    public String shoppingListAdd(Model model, @AuthenticationPrincipal User user) {
        return "redirect:/shopping-list";
    }


    @PostMapping("/add")
    public String add(@AuthenticationPrincipal User user, @Valid @ModelAttribute Item item,BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("items", itemService.searchItemsForUser(user));
            return "shopping-list";
        }

        itemService.create(item);
        return "redirect:/shopping-list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        itemService.delete(id);
        return "redirect:/shopping-list";
    }


}
