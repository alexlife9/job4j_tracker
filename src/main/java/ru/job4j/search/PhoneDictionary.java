package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = (Person person) -> person.getName().contains(key);
        Predicate<Person> predSurname = (Person person) -> person.getSurname().contains(key);
        Predicate<Person> predPhone = (Person person) -> person.getPhone().contains(key);
        Predicate<Person> predAdress = (Person person) -> person.getAddress().contains(key);
        Predicate<Person> combine = predName.or(predSurname).or(predPhone).or(predAdress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
//        for (Person value : persons) {
//            if (value.getName().contains(key) || value.getSurname().contains(key)
//                    || value.getPhone().contains(key) || value.getAddress().contains(key)) {
//                result.add(value);
//            }
        }
        return result;
    }
}
