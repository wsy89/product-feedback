package leanne.feedback.controllers;

import leanne.feedback.services.FeedbackService;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by leanne on 3/04/17.
 */
public class FeedbackControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    FeedbackController controller;

    @Mock
    FeedbackService feedbackService;

    @BeforeTest
    public void init(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new FeedbackController(feedbackService))
                .build();
    }


    @Test()
    public void givenValidFeedbackRequest_whenFeedbackSubmitted_thenSubmitFeedback() throws Exception {

        String request = EntityUtils.toString(new UrlEncodedFormEntity(asList(
                new BasicNameValuePair("name", "name"),
                new BasicNameValuePair("phoneNumber", "091231231"),
                new BasicNameValuePair("email", "wonleanne@gmail.com"),
                new BasicNameValuePair("product", "SmartCheck"),
                new BasicNameValuePair("feedback", "test description")
        )));

        mockMvc.perform(post("/submit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk())
                .andReturn();

    }
}