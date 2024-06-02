package com.nurs.repo;

import com.nurs.model.Plant;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PlantRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public Plant save(Plant plant) {
        if (plant.getPid() == 0) {
            entityManager.persist(plant);
        } else {
            entityManager.merge(plant);
        }
        return plant;
    }

    public Plant findById(int id) {
        return entityManager.find(Plant.class, id);
    }

    public List<Plant> findAll() {
        return entityManager.createQuery("SELECT p FROM Plant p", Plant.class)
                .getResultList();
    }

    public void deleteById(int id) {
        Plant plant = findById(id);
        if (plant != null) {
            entityManager.remove(plant);
        }
    }
}
