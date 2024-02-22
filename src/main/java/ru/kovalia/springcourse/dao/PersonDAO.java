package ru.kovalia.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.kovalia.springcourse.models.Person;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Arseni"));
        people.add(new Person(++PEOPLE_COUNT, "Ivan"));
        people.add(new Person(++PEOPLE_COUNT, "Nikolay"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}