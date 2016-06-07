package business.controllers;

import org.springframework.stereotype.Controller;

import business.wrappers.ReviewWrapper;
import data.entities.Review;

@Controller
public class ReviewController {

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

}
