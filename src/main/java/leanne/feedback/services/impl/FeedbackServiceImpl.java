package leanne.feedback.services.impl;

import leanne.feedback.models.Feedback;
import leanne.feedback.services.FeedbackService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * Created by leanne on 31/03/17.
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    public static final String HOST = "localhost";
    private final String recipient;
    private Session mailSession;

    public FeedbackServiceImpl() {
        this.recipient = "wonleanne@gmail.com";
    }

    public void submitFeedback(Feedback request) {
        try {
            setMailServerProperties();
            sendEmail();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    private void setMailServerProperties()
    {
        Properties emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", "586");
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
        mailSession = Session.getDefaultInstance(emailProperties, null);
    }

    private MimeMessage draftEmailMessage() throws AddressException, MessagingException
    {
        String[] toEmails = { "wonleanne@gmail.com" };
        String emailSubject = "Test email subject";
        String emailBody = "This is an email sent by http://www.computerbuzz.in.";
        MimeMessage emailMessage = new MimeMessage(mailSession);
        /**
         * Set the mail recipients
         * */
        for (int i = 0; i < toEmails.length; i++)
        {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
        }
        emailMessage.setSubject(emailSubject);
        /**
         * If sending HTML mail
         * */
        emailMessage.setContent(emailBody, "text/html");
        /**
         * If sending only text mail
         * */
        //emailMessage.setText(emailBody);// for a text email
        return emailMessage;
    }

    private void sendEmail() throws AddressException, MessagingException
    {
        /**
         * Sender's credentials
         * */
        String fromUser = "user-email@gmail.com";
        String fromUserEmailPassword = "*******";

        String emailHost = "smtp.gmail.com";
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserEmailPassword);
        /**
         * Draft the message
         * */
        MimeMessage emailMessage = draftEmailMessage();
        /**
         * Send the mail
         * */
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }
//
//    private void sendEmail() {
//        // Set up the SMTP server.
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "false");
//        props.put("mail.smtp.host", HOST);
//        props.put("mail.smtp.port", "8080");
//
//        Session session = Session.getDefaultInstance(props, null);
//
//        // Construct the message
//        String to = recipient;
//        String from = "me@me.com";
//        String subject = "Hello";
//        Message msg = new MimeMessage(session);
//        try {
//            msg.setFrom(new InternetAddress(from));
//            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            msg.setSubject(subject);
//            msg.setText("Hi,\n\nHow are you?");
//
//            // Send the message.
//            Transport.send(msg);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
}
