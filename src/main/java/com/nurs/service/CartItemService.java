package com.nurs.service;

import com.nurs.model.CartItem;
import com.nurs.model.Customer;
import com.nurs.model.Plant;
import com.nurs.repo.CartItemRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartItemService {

    @Autowired
    private CartItemRepositoryImpl cartItemRepository;

    @jakarta.persistence.PersistenceContext
    private jakarta.persistence.EntityManager entityManager;

    public ResponseEntity<?> saveProductToCart(CartItem cartItem, int cid, int pid) {
        Customer customer = entityManager.find(Customer.class, cid);
        Plant plant = entityManager.find(Plant.class, pid);
        cartItem.setCustomer(customer);
        cartItem.setPlant(plant);
        cartItemRepository.save(cartItem);
        return ResponseEntity.ok().body("Saved to cart");
    }

    public CartItem getCartItemById(int id) {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(id);
        return cartItemOptional.orElse(null);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public void deleteCartItem(int id) {
        cartItemRepository.deleteById(id);
    }

    public CartItem updateCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
}
