package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void collectTest() {
        Address alex = new Address("EKB", "Lenina", 13, 28);
        Address oleg = new Address("SPB", "Fontanka", 9, 75);
        Address lena = new Address("MSK", "Putina", 100, 3000);
        List<Profile> prof = Arrays.asList(
                new Profile(alex),
                new Profile(oleg),
                new Profile(lena)
        );
        List<Address> result = Profiles.collect(prof);
        List<Address> expected = Arrays.asList(alex, oleg, lena);
        assertThat(result, is(expected));
    }

    @Test
    public void collectTestUnicArray() {
        Address alex = new Address("EKB", "Lenina", 13, 28);
        Address oleg = new Address("SPB", "Fontanka", 9, 75);
        Address lena = new Address("EKB", "Lenina", 13, 28);
        List<Profile> prof = Arrays.asList(
                new Profile(alex),
                new Profile(oleg),
                new Profile(lena)
        );
        List<Address> result = Profiles.collectUnic(prof);
        List<Address> expected = Arrays.asList(alex, oleg);
        assertThat(result, is(expected));
    }
}
