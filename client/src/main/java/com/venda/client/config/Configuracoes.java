package com.venda.client.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracoes {

    @Bean
    public ModelMapper obterModelMapper() {
        return new ModelMapper();

    }
}
