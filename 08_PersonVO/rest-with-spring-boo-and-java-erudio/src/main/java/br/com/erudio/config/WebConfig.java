package br.com.erudio.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import br.com.erudio.serialization.converter.YamlJackson2HttpMesageConverter;
// A annotation configuration diz ao spring boot, que ao iniciar a aplicação ele tem que
// rodar esta classe configuration e aplicar as configurações.
@Configuration
public class WebConfig implements WebMvcConfigurer {

	private static final MediaType MEDIA_TYPE_APPLICATTION_YML = MediaType.valueOf("application/x-yaml");

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMesageConverter());
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

//		Via QUERY PARAM. http://localhost:8080/api/person/v1?mediaType=xml

		configurer.favorParameter(false).ignoreAcceptHeader(false).useRegisteredExtensionsOnly(false)
				.defaultContentType(MediaType.APPLICATION_JSON).mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML).mediaType("x-yaml", MEDIA_TYPE_APPLICATTION_YML);

	}

}
