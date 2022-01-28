package com.example.TestTelda.controller;

import com.example.TestTelda.entity.Region;
import com.example.TestTelda.exseptions.RegionIdExistException;
import com.example.TestTelda.exseptions.RegionIdNotFoundException;
import com.example.TestTelda.repository.RegionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable("region")
    @Transactional
    public List<Region> getRegions() {
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
    @CacheEvict(value = "region", allEntries = true)
    @Transactional
    public ResponseEntity<String> createRegion(@RequestBody Region region) {
        if (region.getId() == null || region.getRegionfullname() == null || region.getRegionshortname() == null) {
            return ResponseEntity.ok("Недостаточно данных для создания записи");
        } else {
            if (regionRepository.findById(region.getId()) == null) {
                int id = regionRepository.insert(region);
                return ResponseEntity.ok("регион с ID: " + region.getId() + " cоздан.");
            } else {
                throw new RegionIdExistException();
            }
        }
    }

    /**
     * Метод получает имеющийся в базе данных регион по его ID
     *
     * @param id идентификационный номер региона.
     * @return регион, который был запрошен
     * @exception RegionIdNotFoundException()
     */
    @GetMapping("/regions/{id}")
    @Cacheable("region")
    @Transactional
    public ResponseEntity<Region> getRegionById(@PathVariable Long id) {
        Region region = regionRepository.findById(id);
        if (region != null) {
            return ResponseEntity.ok(region);
        } else {
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
    @CacheEvict(value = "region", allEntries = true)
    public ResponseEntity<Region> updateRegion(@PathVariable Long id,
            @RequestBody Region region) {
        int resp = regionRepository.update(new Region(id, region.getRegionfullname(), region.getRegionshortname()));
        if (resp != 0) {
            return ResponseEntity.ok(regionRepository.findById(id));
        } else {
            throw new RegionIdNotFoundException();
        }
    }

    /**
     * Метод удаляет имеющийся в базе данных регион
     *
     * @param id идентификационный номер региона.
     * @return регион который был изменен
     * @exception RegionIdNotFoundException()
     */
    @DeleteMapping("/regions/{id}")
    @CacheEvict(value = "region", allEntries = true)
    @Transactional
    public ResponseEntity<String> deleteRegion(@PathVariable Long id) {
        int resp = regionRepository.deleteById(id);
        if (resp != 0) {
            return ResponseEntity.ok("регион с ID: " + id + " удален.");
        } else {
            throw new RegionIdNotFoundException();
        }
    }

}
