package com.logicbig.config;


import com.logicbig.views.StationsMarkersView;
import com.logicbig.service.BusService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public BusService getBusService() {
        return new BusService();
    }

    @Bean
    public StationsMarkersView getMarkersView() {
        return new StationsMarkersView();
    }

}
