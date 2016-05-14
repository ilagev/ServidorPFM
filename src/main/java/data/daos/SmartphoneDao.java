package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Smartphone;

public interface SmartphoneDao extends JpaRepository<Smartphone, Integer> {
    
}