package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobSorterTest {
    @Test
    public void whenJobByNameDown() {
        Comparator<Job> cmpJobNameDown = new JobByNameDown();
        int rsl = cmpJobNameDown.compare(
                new Job("Fix bug", 2),
                new Job("Reboot server", 4)
        );
        assertThat(rsl, greaterThan(2));
    }

    @Test
    public void whenJobByNameUp() {
        Comparator<Job> cmpJobNameUp = new JobByNameUp();
        int rsl = cmpJobNameUp.compare(
                new Job("Reboot bug", 2),
                new Job("Fix server", 3)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenJobByPriorityDawn() {
        Comparator<Job> cmpJobPriorityDown = new JobByPriorityDown();
        int rsl = cmpJobPriorityDown.compare(
                new Job("Reboot bug", 4),
                new Job("Fix server", 5)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenJobByPriorityUp() {
        Comparator<Job> cmpJobPriorityUp = new JobByPriorityUp();
        int rsl = cmpJobPriorityUp.compare(
                new Job("Reboot bug", 7),
                new Job("Fix server", 5)
        );
        assertThat(rsl, greaterThan(0));
    }
}
