package spring;

import hib.Person;

import java.util.List;

public interface IPersonService {
    void addPerson(Person p);
    void updatePerson(Person p);
    List<Person> listPersons();
    Person getPersonById(int id);
    void removePerson(int id);
}
