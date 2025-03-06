package com.example.svsvdvdv.semiprojectv1.controller;

import com.example.svsvdvdv.semiprojectv1.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("/list")
    public String list(Model m) {

        return "views/gallery/list";
    }
}
