package com.hishamalharrasi.byanat.Tower;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/towers")
public class TowerController {
        private final TowerService towerService;

        @Autowired
        public TowerController(TowerService towerService){
            this.towerService = towerService;
        }



        @GetMapping("/all")
        public ResponseEntity<List<Tower>> getAllTowersHandler() {
            try {
                List<Tower> towers = towerService.getAllTowers();

                return new ResponseEntity<>(towers, HttpStatus.OK);
                
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @GetMapping("")
        public ResponseEntity<List<Tower>> getFilteredTowersHandler(
            @RequestParam(required=false) String id,
            @RequestParam(required=false) String operator, 
            @RequestParam(required=false) String technology, 
            @RequestParam(required=false) String tower_type) {
            try {
                List<Tower> towersFiltered =  towerService.getFilteredTowers(id, operator, technology, tower_type);

                return new ResponseEntity<>(towersFiltered, HttpStatus.OK);
                
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


}
