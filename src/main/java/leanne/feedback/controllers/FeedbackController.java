package leanne.feedback.controllers;

import leanne.feedback.models.Feedback;
import leanne.feedback.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by leanne on 31/03/17.
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
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);
        return "index";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submitFeedback(@ModelAttribute(value="feedback") Feedback feedback) {
        feedbackService.submitFeedback(feedback);

        return "result";
    }

}
