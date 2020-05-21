package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;

import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job ();
        Job job2 = new Job ();

        assertFalse(job1.getId() == job2.getId());
        assertTrue(job1.getId() + 1 == job2.getId() || job1.getId() - 1 == job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", job1.getName());
        assertEquals(true, job1.getEmployer() instanceof Employer);
        assertEquals(true, job1.getLocation() instanceof Location);
        assertEquals(true, job1.getPositionType() instanceof PositionType);
        assertEquals(true, job1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1 == job2);
    }

    @Test
    public void toStringContainsBlankSpaceBeforeAndAfterJobInfo() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job1.toString().startsWith("\n") && job1.toString().endsWith("\n"));
    }

    @Test
    public void toStringContainsLabelAndDataForEachField() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = "\n" + "ID: " + job1.getId() +
                          "\n" + "Name: " + job1.getName() +
                          "\n" + "Employer: " + job1.getEmployer() +
                          "\n" + "Location: " + job1.getLocation() +
                          "\n" + "Position Type: " + job1.getPositionType() +
                          "\n" + "Core Competency: " + job1.getCoreCompetency() +
                          "\n";
        assertEquals(expected,job1.toString());
    }

    @Test
    public void toStringAddsMessageForMissingData() {
        Job job1 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1.toString().contains("Name: Data not available"));
    }

}