package leanne.feedback.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by leanne on 31/03/17.
 */
@Configuration
@ComponentScan(basePackages = "leanne.feedback.*")
@Import(WebMvcConfig.class)
public class AppConfig {
}
