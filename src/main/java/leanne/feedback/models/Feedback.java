package leanne.feedback.models;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by leanne on 31/03/17.
 */
public class Feedback {

    @NotEmpty
    private String name;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String email;
    @NotEmpty
    private String feedback;
    @NotEmpty
    private String product;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", feedback='" + feedback + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
