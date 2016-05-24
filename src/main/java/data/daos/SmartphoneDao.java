package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import data.entities.Smartphone;

public interface SmartphoneDao extends JpaRepository<Smartphone, Integer> {
    
    @Query("select smartphone from Smartphone smartphone where lower(smartphone.modelName) LIKE CONCAT('%',:modelOrBrand,'%') or lower(smartphone.brandName) LIKE CONCAT('%',:modelOrBrand,'%')")
    List<Smartphone> findSmartphoneByModelNameOrBrandName(@Param("modelOrBrand") String modelOrBrand);
    
    Smartphone findById(int id);
    
    @Query("select smartphone from Smartphone smartphone where lower(smartphone.modelName) = lower(?1) and lower(smartphone.brandName) = lower(?2)")
    Smartphone findSmartphoneByModelNameAndBrandName(String modelName, String brandName);
}