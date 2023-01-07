package com.example.dz_3_3.controller;

import com.example.dz_3_3.model.Avatar;
import com.example.dz_3_3.service.AvatarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RestController
@RequestMapping("/student/avatar")
public class AvatarController {
    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @GetMapping
    public Collection<Avatar> getAllAvatars(@RequestParam Integer page, @RequestParam Integer size) {
        return avatarService.getAllAvatars(page, size);
    }
}
