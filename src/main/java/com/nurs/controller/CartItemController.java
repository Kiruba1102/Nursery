package com.nurs.controller;

import com.nurs.model.CartItem;
import com.nurs.repo.CartItemRepositoryImpl;
import com.nurs.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
@CrossOrigin("*")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartItemRepositoryImpl cartItemRepository;

    @PostMapping("")
    public ResponseEntity<?> createCartItem(@RequestBody CartItem cartItem, @RequestParam int cid, @RequestParam int pid) {
        return cartItemService.saveProductToCart(cartItem, cid, pid);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable int id) {
        CartItem cartItem = cartItemService.getCartItemById(id);
        if (cartItem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cartItem);
    }

    @GetMapping("cart/{cid}")
    public ResponseEntity<List<CartItem>> findByCustomerId(@PathVariable int cid) {
        List<CartItem> cartItem = cartItemRepository.findByCustomerId(cid);
        if (cartItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cartItem);
    }

    @DeleteMapping("user/{cid}")
    public ResponseEntity<Void> deleteCartItemByCustomerId(@PathVariable int cid) {
        List<CartItem> cartItems = cartItemRepository.findByCustomerId(cid);
        if (cartItems.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cartItems.forEach(cartItem -> cartItemService.deleteCartItem(cartItem.getCartId()));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("plant/{pid}")
    public ResponseEntity<Void> deleteCartItemByPlantId(@PathVariable int pid) {
        List<CartItem> cartItems = cartItemRepository.findByPlantId(pid);
        if (cartItems.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cartItems.forEach(cartItem -> cartItemService.deleteCartItem(cartItem.getCartId()));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get")
    public ResponseEntity<List<CartItem>> getAllCartItems() {
        List<CartItem> cartItems = cartItemService.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable("id") int id) {
        CartItem cartItem = cartItemService.getCartItemById(id);
        if (cartItem == null) {
            return ResponseEntity.notFound().build();
        }
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
    
   
    @DeleteMapping("/delCart/{id}")
    public boolean deleteCartId(@PathVariable("id") int id) {
    	boolean flag =cartItemRepository.deleteById(id);
        return flag;
    }
    
    
}
