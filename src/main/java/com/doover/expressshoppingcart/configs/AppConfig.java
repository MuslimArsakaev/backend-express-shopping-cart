package com.doover.expressshoppingcart.configs;

import com.doover.expressshoppingcart.models.dtos.Product;
import com.doover.expressshoppingcart.models.entities.ProductEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper simpleModelMapper(ObjectMapper objectMapper) {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        configureProductConverter(mapper);

        return mapper;
    }

    private void configureProductConverter(ModelMapper modelMapper) {

        Converter<ProductEntity, Product> pe2p =
                new AbstractConverter<ProductEntity, Product>() {
                    @Override
                    protected Product convert(ProductEntity src) {

                        Product product = new Product();

                        product.setProductId(src.getProductId());
                        product.setName(src.getName());
                        product.setDescription(src.getDescription());
                        product.setPrice(src.getPrice());
                        product.setAvailableQuantity(src.getAvailableQuantity());

                        return product;
                    }
                };
        modelMapper.addConverter(pe2p);

        Converter<Product, ProductEntity> p2pe =
                new AbstractConverter<Product, ProductEntity>() {
                    @Override
                    protected ProductEntity convert(Product src) {

                        ProductEntity productEntity = new ProductEntity();

                        productEntity.setProductId(src.getProductId());
                        productEntity.setName(src.getName());
                        productEntity.setDescription(src.getDescription());
                        productEntity.setPrice(src.getPrice());
                        productEntity.setAvailableQuantity(src.getAvailableQuantity());

                        return productEntity;
                    }
                };
        modelMapper.addConverter(p2pe);

    }

}
