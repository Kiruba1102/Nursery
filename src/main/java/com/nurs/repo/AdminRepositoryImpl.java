package com.nurs.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nurs.model.Admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class AdminRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Admin save(Admin admin) {
        if (admin.getAdminId() == 0) {
            entityManager.persist(admin);
        } else {
            entityManager.merge(admin);
        }
        return admin;
    }

    public List<Admin> findAll() {
        return entityManager.createQuery("SELECT a FROM Admin a", Admin.class).getResultList();
    }
}
