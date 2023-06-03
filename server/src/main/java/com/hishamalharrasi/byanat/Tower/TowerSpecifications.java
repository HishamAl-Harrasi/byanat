package com.hishamalharrasi.byanat.Tower;


import org.springframework.data.jpa.domain.Specification;

// Class to build custom queries for Tower entity - this will enable filtering
// data based on only the provided query parameters
public class TowerSpecifications {

    public static Specification<Tower> hasId(String id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<Tower> hasTowerType(String towerType) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("towerType"), towerType);
    }

    public static Specification<Tower> hasOperator(String operator) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("operator"), operator);
    }

    public static Specification<Tower> hasTechnology(String technology) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("technology"), technology);
    }
}
