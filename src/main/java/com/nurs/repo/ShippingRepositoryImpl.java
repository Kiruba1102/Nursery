package com.nurs.repo;

import com.nurs.model.CartItem;
import com.nurs.model.Shipping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ShippingRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Shipping save(Shipping shipping) {
        if (shipping.getShipId() == 0) {
            entityManager.persist(shipping);
        } else {
            entityManager.merge(shipping);
        }
        return shipping;
    }

    public Shipping findById(int id) {
        return entityManager.find(Shipping.class, id);
    }

    public List<Shipping> findAll() {
        return entityManager.createQuery("SELECT s FROM Shipping s", Shipping.class)
                .getResultList();
    }

    public void deleteById(int id) {
        Shipping shipping = findById(id);
        if (shipping != null) {
            entityManager.remove(shipping);
        }
    }
    
    
    public boolean afterShipping(int shippingId) {
    	
    	try {
			Shipping shipping = (Shipping) entityManager
					.createQuery("select s from Shipping s where s.shipId = :shipId").setParameter("shipId", shippingId)
					.getSingleResult();

			List<CartItem> cartItem = shipping.getCartItem();

			entityManager.remove(shipping);
			entityManager.remove(cartItem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    	
         
    	
    }
}
