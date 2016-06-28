package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import data.entities.Review;;

public interface ReviewDao extends JpaRepository<Review, Integer> {

    @Query("select review from Review review where review.smartphone.id = ?1")
    List<Review> findBySmartphoneId(int id);

    @Modifying
    @Query("delete from Review r where r.smartphone.id = ?1")
    void deleteReviewsForSmartphone(int id);

}
