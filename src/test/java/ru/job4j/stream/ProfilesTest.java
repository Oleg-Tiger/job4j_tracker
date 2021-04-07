package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenCollectAddresses() {
        List<Profile> prof = List.of(
                new Profile(new Address("Москва", "Молодёжная", 3, 1)),
                new Profile(new Address("Санкт-Петербург", "Степана Разина", 12, 24)),
                new Profile(new Address("Воскресенск", "Победы", 10, 47))
        );
        List<Address> rsl = new Profiles().collect(prof);
        List<Address> expected = List.of(
                new Address("Москва", "Молодёжная", 3, 1),
                new Address("Санкт-Петербург", "Степана Разина", 12, 24),
                new Address("Воскресенск", "Победы", 10, 47)
        );
        assertThat(rsl, is(expected));
    }

}