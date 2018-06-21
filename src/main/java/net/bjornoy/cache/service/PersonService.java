package net.bjornoy.cache.service;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService {

    @Cacheable("personscache")
    public Person getPerson(int age) {
        log.info("Not cached");
        return Person.builder()
                .age(age)
                .build();
    }

    @Data
    @Builder
    public static class Person {
        private final int age;
    }

}
