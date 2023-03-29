package org.bigjoe.demo.config;

import org.bigjoe.demo.service.AdminApiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration

public class AminApiClientConfig {

	private static String BASE_URL = "http://xta198.superads.cn/xmp-admin-api";

	@Bean
	AdminApiService AminApiClient() throws Exception {

		WebClient webClient = WebClient.builder().baseUrl(BASE_URL).build();

		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
				.build();

		return factory.createClient(AdminApiService.class);
	}
}
