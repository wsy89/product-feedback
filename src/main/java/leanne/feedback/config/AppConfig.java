package leanne.feedback.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Application configuration class
 */
@Configuration
@ComponentScan(basePackages = "leanne.feedback.*")
@Import({WebMvcConfig.class, PropertiesConfig.class, SecurityConfig.class})
public class AppConfig {
}
