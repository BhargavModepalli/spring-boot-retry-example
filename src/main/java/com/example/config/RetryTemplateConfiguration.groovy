package com.example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.retry.backoff.ExponentialRandomBackOffPolicy
import org.springframework.retry.policy.SimpleRetryPolicy
import org.springframework.retry.support.RetryTemplate

@Configuration
class RetryTemplateConfiguration {

    @Bean
    RetryTemplate retryTemplate(){
        RetryTemplate retryTemplate = new RetryTemplate()
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy()
        retryPolicy.setMaxAttempts(3)
        ExponentialRandomBackOffPolicy exponentialPolicy = new ExponentialRandomBackOffPolicy()
        exponentialPolicy.setInitialInterval(1000L)
        exponentialPolicy.setMaxInterval(5000L)
        exponentialPolicy.setMultiplier(1.5d)
        retryTemplate.setRetryPolicy(retryPolicy)
        retryTemplate.setBackOffPolicy(exponentialPolicy)

        return retryTemplate
    }
}
