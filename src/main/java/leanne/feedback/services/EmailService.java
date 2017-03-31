package leanne.feedback.services;

import leanne.feedback.models.Feedback;

/**
 * Created by leanne on 1/04/17.
 */
public interface EmailService {


    public void sendEmail(Feedback feedback);
}
