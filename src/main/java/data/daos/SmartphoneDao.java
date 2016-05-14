package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import data.entities.Smartphone;

public interface SmartphoneDao extends JpaRepository<Smartphone, Integer> {
    
    @Query("select smartphone from Smartphone smartphone where smartphone.modelName = ?1 or smartphone.brandName = ?1")
    List<Smartphone> findSmartphoneByModelNameOrBrandName(String modelOrBrand);
    
}