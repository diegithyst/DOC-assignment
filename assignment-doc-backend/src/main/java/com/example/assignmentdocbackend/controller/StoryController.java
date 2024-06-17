package com.example.assignmentdocbackend.controller;

import java.util.List;

import com.example.assignmentdocbackend.model.Story;
import com.example.assignmentdocbackend.service.StoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/stories")
public class StoryController {
    private StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping
    public List<Story> getStoriesForDepartment(@RequestParam(name = "departmentId", required = false) int departmentId) {
        if (departmentId == 0) {
            return storyService.getStories();
        }
        return storyService.getStoriesForDepartment(departmentId);
    }

    @PostMapping
    public Story createStory(@RequestBody Story story) {
        return storyService.createStory(story);
    }

    @PutMapping("/{id}")
    public Story updateStory(@PathVariable int id, @RequestBody Story story) {
        return storyService.updateStory(id, story);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStory(@PathVariable int id) {
        storyService.deleteStory(id);
        return ResponseEntity.noContent().build();
    }
}