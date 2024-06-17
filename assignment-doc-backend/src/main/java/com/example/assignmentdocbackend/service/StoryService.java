package com.example.assignmentdocbackend.service;

import java.util.List;
import java.util.Optional;

import com.example.assignmentdocbackend.model.Story;
import com.example.assignmentdocbackend.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StoryService {
    @Autowired
    StoryRepository storyRepository;

    public List<Story> getStories() {
        return storyRepository.findAll();
    }

    public List<Story> getStoriesForDepartment(int departmentId) {
        return storyRepository.findByDepartmentId(departmentId);
    }

    public Story createStory(Story story) {
        return storyRepository.save(story);
    }

    public Story updateStory(int id, Story updatedStory) {
        Optional<Story> optionalStory = storyRepository.findById(id);
        if (optionalStory.isPresent()) {
            Story story = optionalStory.get();
            story.setTitle(updatedStory.getTitle());
            story.setDescription(updatedStory.getDescription());
            story.setDepartment(updatedStory.getDepartment());
            return storyRepository.save(story);
        }
        return null;
    }

    public void deleteStory(int id) {
        storyRepository.deleteById(id);
    }
}