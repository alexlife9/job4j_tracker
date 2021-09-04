package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void collectTest() {
        List<Address> adr = List.of(
                new Address("EKB", "Lenina", 13, 28),
                new Address("SPB", "Fontanka", 9, 75),
                new Address("MSK", "Putina", 100, 3000)
                );
        Profile prof = new Profile();
        List<Address> rsl = prof.collect(adr);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("EKB", "Lenina", 13, 28));
        expected.add(new Address("SPB", "Fontanka", 9, 75));
        expected.add(new Address("MSK", "Putina", 100, 3000));
        assertThat(rsl, is(expected));

    }
}
