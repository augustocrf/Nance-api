package br.com.acrf.nance.adapter.config;

import br.com.acrf.nance.adapter.interceptor.Interceptor;
import br.com.acrf.nance.adapter.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class ConfigInterceptor implements WebMvcConfigurer {

    public ConfigInterceptor() {
        super();
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor());
        registry.addInterceptor(new LoggerInterceptor());
    }

}