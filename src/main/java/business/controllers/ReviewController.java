package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrappers.ReviewWrapper;
import data.daos.ReviewDao;
import data.daos.SmartphoneDao;
import data.daos.UserDao;
import data.entities.Review;
import data.entities.Smartphone;
import data.entities.User;

@Controller
public class ReviewController {
    
    private SmartphoneDao smartphoneDao;
    
    @Autowired
    public void setSmartphoneDao(SmartphoneDao smartphoneDao) {
        this.smartphoneDao = smartphoneDao;
    }
    
    private UserDao userDao;
    
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    private ReviewDao reviewDao;
    
    @Autowired
    public void setReviewDao(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    public ReviewWrapper getReviewWrapper(Review r) {
        return new ReviewWrapper(
            r.getId(),
            r.getDate(),
            r.getText(),
            r.getMark(),
            r.getUser().getNick(),
            r.getSmartphone().getId(),
            r.getUser().getId()
        );
    }

    public ReviewWrapper create(ReviewWrapper review, String username) {
        User user = userDao.findByNick(username);
        Smartphone smartphone = smartphoneDao.findById(review.getSmartphoneId());
        Review reviewEntity = new Review(review.getText(), review.getMark(), smartphone, user);
        reviewEntity = reviewDao.save(reviewEntity);
        return this.getReviewWrapper(reviewEntity);
    }

    public void delete(int id) {
        reviewDao.delete(id);
    }

}
