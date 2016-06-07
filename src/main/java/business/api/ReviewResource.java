package business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import business.controllers.ReviewController;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.REVIEWS)
public class ReviewResource {
    
    private ReviewController reviewController;

    @Autowired
    public void setResourceController(ReviewController reviewController) {
        this.reviewController = reviewController;
    }
    

}
