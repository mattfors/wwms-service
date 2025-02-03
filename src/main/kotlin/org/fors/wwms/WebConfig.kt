package org.fors.wwms

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
/*
@Configuration
class WebConfig : WebMvcConfigurer {

    @Bean
    fun xmlMapper(): XmlMapper {
        return XmlMapper()
    }

    @Bean
    fun xmlHttpMessageConverter(xmlMapper: XmlMapper): HttpMessageConverter<*> {
        return MappingJackson2XmlHttpMessageConverter(xmlMapper)
    }

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(xmlHttpMessageConverter(xmlMapper()))
        super.configureMessageConverters(converters)
    }
}*/