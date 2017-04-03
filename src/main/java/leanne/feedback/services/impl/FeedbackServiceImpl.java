package leanne.feedback.services.impl;

import leanne.feedback.models.Feedback;
import leanne.feedback.services.FeedbackService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Feedback service
 * This is where feedback form is sent to the admin.
 * However could not find a way to send an email with no auth smtp email server
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final String[] productList;
    private final String recipient;

    public FeedbackServiceImpl( @Value("${admin.email}") String recipient,
                                @Value("${liverton.products}") String products) {

        this.recipient = recipient;
        this.productList = products.split(",");
    }

    public void submitFeedback(Feedback request) {
        //send email to recipient
    }

    public List<String> getProductList() {
        return Arrays.asList(productList);
    }
}
