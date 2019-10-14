package com.example.controller

import com.example.util.DateUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @Autowired
    DateUtils dateUtils

    @GetMapping("/timeannotaion")
    String getDate() {
        return dateUtils.dateTimeWithRetryableAnnotation
    }

    @GetMapping("/timetemplate")
    String getDateTime() {
        return dateUtils.dateTimeWithRetryTemplate
    }
}
