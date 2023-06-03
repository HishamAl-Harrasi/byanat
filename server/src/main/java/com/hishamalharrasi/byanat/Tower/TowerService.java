package com.hishamalharrasi.byanat.Tower;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TowerService {
    private final TowerRepository towerRepository;
    


    @Autowired
    public TowerService(TowerRepository towerRepository) {
        this.towerRepository = towerRepository;

        try {
            getTowerData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getTowerData() throws java.io.IOException {
        try {
            String apiEndpoint = "https://byanat.wiremockapi.cloud/api/v1/towers";
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(apiEndpoint);

            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            ObjectMapper objectMapper = new ObjectMapper();
            List<Tower> towers = objectMapper.readValue(entity.getContent(), new TypeReference<List<Tower>>() {
            });

            towerRepository.saveAll(towers);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Tower> getAllTowers() {
        return towerRepository.findAll();
    }

    public List<Tower> getFilteredTowers(String id, String operator, String technology, String towerType) {

        // Specifications i.e. query criteria (basically a WHERE clause)
        List<Specification<Tower>> specifications = new ArrayList<>();

        if (id != null && !id.isEmpty()) {
            specifications.add(TowerSpecifications.hasId(id));
        }
        if (towerType != null && !towerType.isEmpty()) {
            specifications.add(TowerSpecifications.hasTowerType(towerType));
        }
        if (operator != null && !operator.isEmpty()) {
            specifications.add(TowerSpecifications.hasOperator(operator));
        }
        if (technology != null && !technology.isEmpty()) {
            specifications.add(TowerSpecifications.hasTechnology(technology));
        }

        Specification<Tower> finalSpecification = specifications.stream()
                .reduce(Specification::and)
                .orElse(null);

        List<Tower> towers = towerRepository.findAll(finalSpecification);

        return towers;
        
    }

}

