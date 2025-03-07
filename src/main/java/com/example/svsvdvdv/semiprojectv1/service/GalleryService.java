package com.example.svsvdvdv.semiprojectv1.service;

import com.example.svsvdvdv.semiprojectv1.domain.GalleryImageDTO;
import com.example.svsvdvdv.semiprojectv1.domain.GalleryListDTO;

import java.util.List;

public interface GalleryService {

    List<GalleryListDTO> selectGallery();

    GalleryImageDTO readOneGalleryImage(int gno);
}
