package org.example.bk.config;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public OpenAIClient openAIClient() {
        return OpenAIOkHttpClient.builder()
                .apiKey("sk-t0yv1VPpAH115Zre4Aozox4clFL36Ddf3FlCiljP8qcI18n4")
                .baseUrl("https://bobdong.cn/v1")
                .build();
    }

}