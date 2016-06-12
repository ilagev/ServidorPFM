package business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.controllers.ReviewController;
import business.wrappers.ReviewWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.REVIEWS)
public class ReviewResource {
    
    private ReviewController reviewController;

    @Autowired
    public void setResourceController(ReviewController reviewController) {
        this.reviewController = reviewController;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ReviewWrapper create(@RequestBody ReviewWrapper review, @AuthenticationPrincipal User activeUser) {
        return reviewController.create(review, activeUser.getUsername());
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = Uris.ID)
    public void delete(@PathVariable int id) {
        reviewController.delete(id);
    }

}
