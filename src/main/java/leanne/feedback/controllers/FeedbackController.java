package leanne.feedback.controllers;

import leanne.feedback.models.Feedback;
import leanne.feedback.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Feedback Controller.
 */
@Controller
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        List<String> productList = feedbackService.getProductList();

        Feedback feedback = new Feedback();
        model.addAttribute("productList", productList);
        model.addAttribute("feedback", feedback);
        return "index";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submitFeedback(@ModelAttribute(value="feedback") @Valid Feedback feedback,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            //when there is mandatory data error, go back to feedback form to display errors
            List<String> productList = feedbackService.getProductList();
            model.addAttribute("productList",  productList);
            model.addAttribute("feedback", feedback);
            return "index";

        }
        //process feedback if data is valid
        feedbackService.submitFeedback(feedback);

        System.out.println(feedback);
        return "result";
    }

}
