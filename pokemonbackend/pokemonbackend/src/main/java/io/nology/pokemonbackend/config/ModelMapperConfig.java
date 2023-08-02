package io.nology.pokemonbackend.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.nology.pokemonbackend.converters.StringTrimConverter;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
	ModelMapper mapper = new ModelMapper();
//	Set up options here
//	trim strings
	mapper.typeMap(String.class, String.class).setConverter(new StringTrimConverter());

	mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT).setSkipNullEnabled(true);
	
	return mapper;
    }
}

