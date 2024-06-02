package com.nurs.repo;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.nurs.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

;

@Repository
@Transactional
public class CustomerRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer save(Customer customer) {
        if (customer.getCid() == 0) {
            entityManager.persist(customer);
        } else {
            entityManager.merge(customer);
        }
        return customer;
    }

    public Customer findByEmail(String email) {
        return entityManager.createQuery("SELECT c FROM Customer c WHERE c.email = :email", Customer.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public Customer getUserData(int cid) {
        return entityManager.find(Customer.class, cid);
    }

	public void deleteById(int id) {
		
		 Customer customer = findById(id);
	        if (customer != null) {
	            entityManager.remove(customer);
	        }
	}

	public List<Customer> findAll() {
		
		
		 return entityManager.createQuery("SELECT c FROM Customer c", Customer.class)
	                .getResultList();
	
	}

	public Customer findById(int id) {

		 return entityManager.find(Customer.class, id);
	}
}
