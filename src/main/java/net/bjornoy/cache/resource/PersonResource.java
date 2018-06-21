package net.bjornoy.cache.resource;

import net.bjornoy.cache.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/persons")
public class PersonResource {

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = Objects.requireNonNull(personService);
    }

    @GetMapping("{age}")
    public PersonService.Person getPerson(@PathVariable int age) {
        return personService.getPerson(age);
    }
}
