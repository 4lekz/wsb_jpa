package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public List<PatientEntity> findByLastName(String lastName) {

        return entityManager.createNativeQuery("SELECT * FROM patient WHERE last_name = ?", PatientEntity.class)
                .setParameter(1, lastName)
                .getResultList();



    }

    @Override
    public List<PatientEntity> findByVisitCountGreaterThen(int visitCount) {
        return new ArrayList<>();


    }
}
