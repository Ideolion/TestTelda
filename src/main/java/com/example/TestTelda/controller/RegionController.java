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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Класс REST контроллер
 *
 * @author Уфилин Д.В.
 */
@RestController
@RequestMapping("/catalog")
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    /**
     * Метод получает список всех регионов в базе
     *
     * @return список регионов
     */
    @GetMapping("/regions")
    @Transactional
    public List<Region> getAllUsers() {
        return regionRepository.findAll();
    }

    /**
     * Метод добавляет новый регион в базу данных
     *
     * @param region добавляемый регион.
     * @return регион который был добавлен
     * @exception RegionIdExistException()
     */
    @PostMapping("/regions")
    @Transactional
    public Region createRegion(@RequestBody Region region) {
        if (regionRepository.findById(region.getId()) == null) {
            int id = regionRepository.insert(region);
            return regionRepository.findById(region.getId());
        } else {
            throw new RegionIdExistException();
        }

    }

    /**
     * Метод для получения имеющегося в базе данных региона по его ID
     *
     * @param id идентификационный номер региона.
     * @return регион, который был запрошен
     * @exception RegionIdNotFoundException()
     */
    @GetMapping("/regions/{id}")
    @Transactional
    public ResponseEntity<Region> getRegionById(@PathVariable Long id) {
        Region region = regionRepository.findById(id);
        if (region != null) {
            return ResponseEntity.ok(region);
        }else {
        throw new RegionIdNotFoundException();
        }
    }

    /**
     * Метод обновляет имеющийся в базе данных регион
     *
     * @param id идентификационный номер региона.
     * @param region данные региона для изменения
     * @return регион который был изменен
     * @exception RegionIdNotFoundException()
     */
    @PutMapping("/regions/{id}")
    @Transactional
    public ResponseEntity<Region> updateRegion(@PathVariable Long id,
            @RequestBody Region region) {
        int resp = regionRepository.update(new Region(id, region.getRegionfullname(), region.getRegionshortname()));
        if (resp != 0) {
        return ResponseEntity.ok(regionRepository.findById(id));
        }else {
        throw new RegionIdNotFoundException();
        }
    }

   
    /**
     * Метод удаляет имеющийся в базе данных регион
     *
     * @param id идентификационный номер региона.
     * @param region данные региона для изменения
     * @return регион который был изменен
     * @exception RegionIdNotFoundException()
     */
    @DeleteMapping("/regions/{id}")
    @Transactional
    public ResponseEntity<Map<String, Boolean>> deleteRegion(@PathVariable Long id) {
        int resp = regionRepository.deleteById(id);
        System.out.println(resp);
        if (resp != 0) {
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
        }else {
        throw new RegionIdNotFoundException();
        }
        
       
    }
}
