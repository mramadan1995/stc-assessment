package org.stc.assessment.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ExternalBeanInitialize {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
