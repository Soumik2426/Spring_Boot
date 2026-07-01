package com.codingshuttle.Module1.Chapter2.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper getmodelMapper(){
        return new ModelMapper();
    }
}
