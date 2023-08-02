package io.nology.portfoliobackend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.nology.portfoliobackend.converters.StringTrimConverter;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
	ModelMapper mapper = new ModelMapper();
//	Set up options here
//	trim strings
	mapper.typeMap(String.class, String.class).setConverter(new StringTrimConverter());

	mapper.getConfiguration().setSkipNullEnabled(true);
	
	return mapper;
    }
}
