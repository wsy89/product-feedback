package leanne.feedback.controllers;

import leanne.feedback.models.Feedback;
import leanne.feedback.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leanne on 31/03/17.
 */
@Controller
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final String products;

    @Autowired
    public FeedbackController(FeedbackService feedbackService,
                              @Value("${liverton.products}") String products) {
        this.feedbackService = feedbackService;
        this.products = products;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        String[] productList = products.split(",");
        Feedback feedback = new Feedback();
        model.addAttribute("productList",  Arrays.asList(productList));
        model.addAttribute("feedback", feedback);
        return "index";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submitFeedback(@ModelAttribute(value="feedback") Feedback feedback) {
//        feedbackService.submitFeedback(feedback);

        System.out.println(feedback);
        return "result";
    }

}
