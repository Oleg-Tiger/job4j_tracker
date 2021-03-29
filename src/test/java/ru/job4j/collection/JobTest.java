package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobSortedByNameDesc().thenComparing(new JobSortedByPriorityDesc());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndProrityAsc() {
        Comparator<Job> cmpNamePriority = new JobSortedByNameAsc().thenComparing(new JobSortedByPriorityAsc());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAsc() {
        int rsl = new JobSortedByNameAsc().compare(
                new Job("Impl task", 1),
                new Job("Rem task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameDescIsEq() {
        int rsl = new JobSortedByNameDesc().compare(
                new Job("Impl task", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenComparatorByNameDesc() {
        int rsl = new JobSortedByNameDesc().compare(
                new Job("Rem task", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }


    @Test
    public void whenComparatorByPriorityAscIsEq() {
        int rsl = new JobSortedByPriorityAsc().compare(
                new Job("Impl task", 1),
                new Job("Rem task", 1)
        );
        assertThat(rsl, is(0));
    }

    @Test
    public void whenComparatorByPriorityAsc() {
        int rsl = new JobSortedByPriorityAsc().compare(
                new Job("Impl task", 2),
                new Job("Rem task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        int rsl = new JobSortedByPriorityDesc().compare(
                new Job("Impl task", 1),
                new Job("Impl task", 2)
        );
        assertThat(rsl, greaterThan(0));
    }
}
