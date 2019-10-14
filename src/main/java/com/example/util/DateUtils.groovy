package com.example.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.retry.RetryCallback
import org.springframework.retry.RetryContext
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Retryable
import org.springframework.retry.support.RetryTemplate
import org.springframework.stereotype.Component

@Component
class DateUtils {

    @Autowired
    RetryTemplate retryTemplate

    @Retryable(value = [Exception.class], maxAttempts = 3, backoff = @Backoff(delayExpression = "#{1}", maxDelayExpression = "#{5}", multiplierExpression = "#{1.3}"))
    String getDateTimeWithRetryableAnnotation() {
        println("@@@@@@@@@@@@@@@@@@:getDateTimeWithRetryableAnnotation")
        String time = new Date().toString()
        println("request came in at ${time}")
        throw new Exception("Testing excception")
        return time
    }

    String getDateTimeWithRetryTemplate() {
        String dateTime = retryTemplate.execute(new RetryCallback<String, Exception>() {
            @Override
            String doWithRetry(RetryContext retryContext) throws Exception {
                println("retrying count #####################:${retryContext.retryCount}")
                String time = new Date().toString()
                println("request came in at ${time}")
                throw new Exception("Testing excception")
                return time
            }
        })
        return dateTime
    }

}
