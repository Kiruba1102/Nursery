package com.nurs.repo;

import com.nurs.model.CartItem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@jakarta.transaction.Transactional
public class CartItemRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public CartItem save(CartItem cartItem) {
        if (cartItem.getCartId() == 0) {
            entityManager.persist(cartItem);
        } else {
            entityManager.merge(cartItem);
        }
        return cartItem;
    }

    public List<CartItem> findByCustomerId(int cid) {
        return entityManager.createQuery("SELECT c FROM CartItem c WHERE c.customer.cid = :cid", CartItem.class)
                .setParameter("cid", cid)
                .getResultList();
    }

    public List<CartItem> findByPlantId(int pid) {
        return entityManager.createQuery("SELECT c FROM CartItem c WHERE c.plant.pid = :pid", CartItem.class)
                .setParameter("pid", pid)
                .getResultList();
    }
    
    public List<CartItem> findAll() {
        return entityManager.createQuery("SELECT c FROM CartItem c", CartItem.class)
                .getResultList();
    }

	public Optional<CartItem> findById(int id) {
		 TypedQuery<CartItem> query = entityManager.createQuery(
			        "SELECT c FROM CartItem c WHERE c.cartId = :id", CartItem.class);
			    query.setParameter("id", id);
			    CartItem cartItem = query.getSingleResult();
			    return Optional.ofNullable(cartItem);
	}

	public boolean deleteById(int cartId) {
         try {
			CartItem cartItem = (CartItem) entityManager
					.createQuery("select c from CartItem c where c.cartId = :cartId ").setParameter("cartId", cartId)
					.getSingleResult();
			entityManager.remove(cartItem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
         
		
	}
}
