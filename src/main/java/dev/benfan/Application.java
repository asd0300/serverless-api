package dev.benfan;

//import dev.benfan.Post.JsonPlaceHolderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@SpringBootApplication
@ComponentScan(basePackages = { "dev.benfan" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//    @Bean
//    JsonPlaceHolderService jsonPlaceholderService() {
//        WebClient client = WebClient.builder()
//                .baseUrl("https://jsonplaceholder.typicode.com")
//                .build();
//        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
//        return factory.createClient(JsonPlaceHolderService.class);
//    }
}