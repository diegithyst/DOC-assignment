package com.example.assignmentdocbackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.example.assignmentdocbackend.model.Department;
import com.example.assignmentdocbackend.model.Story;
import org.junit.jupiter.api.Test;

public class StoryTest {

    @Test
    public void testConstructorAndGetters() {
        Department department = new Department("Test Department");
        Story story = new Story("Test Title", "Test Description", department);

        assertEquals("Test Title", story.getTitle());
        assertEquals("Test Description", story.getDescription());
        assertEquals(department, story.getDepartment());
    }

    @Test
    public void testSetters() {
        Department department = new Department("Department 2");
        Story story = new Story();

        story.setTitle("New Title");
        story.setDescription("New Description");
        story.setDepartment(department);

        assertEquals("New Title", story.getTitle());
        assertEquals("New Description", story.getDescription());
        assertEquals(department, story.getDepartment());

        story.setDepartment(null);
        assertNull(story.getDepartment());
    }

    @Test
    public void testToString() {
        Department department = new Department("Test Department");
        Story story = new Story("Test Title", "Test Description", department);

        String expectedToString = "Story { id: 0, title: Test Title, description: Test Description, department: " + department + "}";
        assertEquals(expectedToString, story.toString());
    }
}