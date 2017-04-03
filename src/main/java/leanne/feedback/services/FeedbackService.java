package leanne.feedback.services;

import leanne.feedback.models.Feedback;

import java.util.List;

/**
 * Created by leanne on 31/03/17.
 */
public interface FeedbackService {

    /**
     * submit feedback form request
     * @param request
     */
    void submitFeedback(Feedback request);

    /**
     * Load product list from properties
     * @return
     */
    List<String> getProductList();
}
