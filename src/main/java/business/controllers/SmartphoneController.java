package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import business.wrappers.ReviewWrapper;
import business.wrappers.SmartphoneWrapper;
import data.daos.ReviewDao;
import data.daos.SmartphoneDao;
import data.daos.UserDao;
import data.entities.Review;
import data.entities.Role;
import data.entities.Smartphone;
import data.entities.User;

@Transactional
@Controller
public class SmartphoneController {
    
    public static final int POST_STEP = 20;
    public static final int EDIT_STEP = 10;
    public static final int REVIEW_STEP = 5;
    
    public static final int MAX_KARMA = 100;
    
    public static final int BARRIER_MOD = 10;
    public static final int BARRIER_ADMIN = 50;
    
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
    
    private ReviewController reviewController;
    
    @Autowired
    public void setReviewController(ReviewController reviewController) {
        this.reviewController = reviewController;
    }
    
    public SmartphoneWrapper create(SmartphoneWrapper smartphoneWrapper, String username) {
        Smartphone smartphoneEntity = this.getSmartphoneEntity(smartphoneWrapper);
        User user = userDao.findByNick(username);
        this.reward(user, POST_STEP);
        userDao.save(user);
        smartphoneEntity.setCreator(user);
        return this.getSmartphoneWrapper(smartphoneDao.save(smartphoneEntity));
    }

    public SmartphoneWrapper getSmartphone(int id) {
        return this.getSmartphoneWrapper(smartphoneDao.findOne(id));
    }

    public List<SmartphoneWrapper> findSmartphones(String modelOrBrand) {
        List<SmartphoneWrapper> swl = new ArrayList<SmartphoneWrapper>();
        List<Smartphone> sl = new ArrayList<Smartphone>();
        String[] keywords = modelOrBrand.split(" ");
        for (String key : keywords) {
            sl.addAll(smartphoneDao.findSmartphoneByModelNameOrBrandName(key));
        }
        for (Smartphone s : sl) {
            swl.add(this.getSmartphoneWrapper(s));
        }
        return swl;
    }
    
    public SmartphoneWrapper getSmartphoneWrapper (Smartphone smartphoneEntity) {
        return new SmartphoneWrapper(
                smartphoneEntity.getId(),
                smartphoneEntity.getModelName(),
                smartphoneEntity.getBrandName(),
                smartphoneEntity.getReleaseDate(),
                smartphoneEntity.getScreenSize(),
                smartphoneEntity.getResolutionX(),
                smartphoneEntity.getResolutionY(),
                smartphoneEntity.getRam(),
                smartphoneEntity.getRom(),
                smartphoneEntity.getBattery(),
                smartphoneEntity.getWeight(),
                smartphoneEntity.getHeight(),
                smartphoneEntity.getWidth(),
                smartphoneEntity.getThickness(),
                smartphoneEntity.isGps(),
                smartphoneEntity.isNfc(),
                smartphoneEntity.isBluetooth(),
                smartphoneEntity.getCreator().getId(),
                smartphoneEntity.getCreator().getNick());
    }
    
    private Smartphone getSmartphoneEntity (SmartphoneWrapper smartphoneWrapper) {
        return new Smartphone(
                smartphoneWrapper.getModelName(),
                smartphoneWrapper.getBrandName(),
                smartphoneWrapper.getReleaseDate(),
                smartphoneWrapper.getScreenSize(),
                smartphoneWrapper.getResolutionX(),
                smartphoneWrapper.getResolutionY(),
                smartphoneWrapper.getRam(),
                smartphoneWrapper.getRom(),
                smartphoneWrapper.getBattery(),
                smartphoneWrapper.getWeight(),
                smartphoneWrapper.getHeight(),
                smartphoneWrapper.getWidth(),
                smartphoneWrapper.getThickness(),
                smartphoneWrapper.isGps(),
                smartphoneWrapper.isNfc(),
                smartphoneWrapper.isBluetooth());
    }

    public SmartphoneWrapper updateSmartphone(SmartphoneWrapper smartphoneWrapper, int id) {
        Smartphone smartphoneEntity = this.smartphoneDao.findById(id);
        smartphoneEntity.setModelName(smartphoneWrapper.getModelName());
        smartphoneEntity.setBrandName(smartphoneWrapper.getBrandName());
        smartphoneEntity.setReleaseDate(smartphoneWrapper.getReleaseDate());
        smartphoneEntity.setScreenSize(smartphoneWrapper.getScreenSize());
        smartphoneEntity.setResolutionX(smartphoneWrapper.getResolutionX());
        smartphoneEntity.setResolutionY(smartphoneWrapper.getResolutionY());
        smartphoneEntity.setRam(smartphoneWrapper.getRam());
        smartphoneEntity.setRom(smartphoneWrapper.getRom());
        smartphoneEntity.setBattery(smartphoneWrapper.getBattery());
        smartphoneEntity.setWeight(smartphoneWrapper.getWeight());
        smartphoneEntity.setHeight(smartphoneWrapper.getHeight());
        smartphoneEntity.setWidth(smartphoneWrapper.getWidth());
        smartphoneEntity.setThickness(smartphoneWrapper.getThickness());
        smartphoneEntity.setGps(smartphoneWrapper.isGps());
        smartphoneEntity.setNfc(smartphoneWrapper.isNfc());
        smartphoneEntity.setBluetooth(smartphoneWrapper.isBluetooth());
        
        this.smartphoneDao.save(smartphoneEntity);
        
        User user = smartphoneEntity.getCreator();
        this.reward(user, EDIT_STEP);
        userDao.save(user);
        return this.getSmartphoneWrapper(smartphoneEntity);
    }

    public void removeSmartphone(int id) {
        this.smartphoneDao.delete(smartphoneDao.findById(id));
        reviewDao.deleteReviewsForSmartphone(id);
        List<User> owners = userDao.findBySmartphoneOwnedId(id);
        for (User user : owners) {
            user.setSmartphone(null);
            userDao.save(user);
        }
    }

    public boolean existsSmartphone(String brandName, String modelName, Integer id) {
        if (id == null) {
            return this.smartphoneDao.findSmartphoneByModelNameAndBrandName(modelName, brandName) != null;
        } else if (this.hasModelOrBrandChanged(brandName, modelName, id)) {
            return this.smartphoneDao.findSmartphoneByModelNameAndBrandName(modelName, brandName) != null;
        } else {
            return false;
        }
    }

    private boolean hasModelOrBrandChanged(String brandName, String modelName, Integer id) {
        Smartphone smartphoneFromForm = this.smartphoneDao.findSmartphoneByModelNameAndBrandName(modelName, brandName);
        return smartphoneFromForm == null || smartphoneFromForm.getId() != id;
    }

    public boolean existsSmartphone(int id) {
        return this.smartphoneDao.findById(id) != null;
    }

    public List<ReviewWrapper> getReviews(int id) {
        List<ReviewWrapper> rl = new ArrayList<ReviewWrapper>();
        List<Review> reviews = reviewDao.findBySmartphoneId(id);
        for (Review r : reviews) {
            rl.add(reviewController.getReviewWrapper(r));
        }
        return rl;
    }
    
    public void reward (User user, int reward) {
        int userKarma = user.getKarma();
        int userLevel = user.getLevel();
        
        if (userKarma + reward > MAX_KARMA) { // next level
            userLevel++;
            user.setLevel(userLevel);
            if (userLevel == BARRIER_MOD) {
                user.setRole(Role.MODERATOR);
            } else if (userLevel == BARRIER_ADMIN) {
                user.setRole(Role.ADMIN);
            }
        }
        userKarma += reward % MAX_KARMA;
        
        user.setKarma(userKarma);
        user.setLevel(userLevel);
    }

}
