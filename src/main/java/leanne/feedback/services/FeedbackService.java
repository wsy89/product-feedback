package leanne.feedback.services;

import leanne.feedback.models.Feedback;

/**
 * Created by leanne on 31/03/17.
 */
public interface FeedbackService {

    /**
     *
     * @param request
     */
    void submitFeedback(Feedback request);
}
