/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TestTelda.controller;

import com.example.TestTelda.entity.Region;
import com.example.TestTelda.exseptions.RegionIdExistException;
import com.example.TestTelda.exseptions.RegionIdNotFoundException;
import com.example.TestTelda.repository.RegionRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kiry
 */
@RestController
@RequestMapping("/catalog")
public class RegionController {
 @Autowired
    private RegionRepository regionRepository;

// получить все регионы из базы
    @GetMapping("/regions")
    public List<Region> getAllUsers()
    {
        return regionRepository.findAll();
    }

// создать новый регион в базе
    @PostMapping("/regions")
    public Region createRegion(@RequestBody Region region)  {
        if(regionRepository.findById(region.getId())==null) {
            int id = regionRepository.insert(region);
            return regionRepository.findById(region.getId());
        }else
        {
            throw new RegionIdExistException();
        }

    }

// получить имеющийся в базе регион по id
    @GetMapping("/regions/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable Long id) {
        Region region = regionRepository.findById(id);
        if(region==null)
        {
            throw new RegionIdNotFoundException();
        }
        return ResponseEntity.ok(region);
    }

// обновить имеющийся в базе регион
    @PutMapping("/regions/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable Long id,
             @RequestBody Region regionDetails) {
            if(regionRepository.update(new Region(id, regionDetails.getRegionfullname(), regionDetails.getRegionshortname()))==0)
            {
                throw new RegionIdNotFoundException();
            }

       return ResponseEntity.ok(regionRepository.findById(id));
    }

// удалить регион из базы по id
    @DeleteMapping("/regions/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser
               (@PathVariable Long id) {
        regionRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}