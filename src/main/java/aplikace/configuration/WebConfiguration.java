package aplikace.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    public void addCorsMapping(CorsRegistry registry){
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/")
                .allowedMethods("HEAD","GET","POST","PUT","DELETE","OPTIONS")
                .allowedOriginPatterns("**")
                .allowCredentials(true);
    }
}
