package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest
{
    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindOneResult() {
        // given
        // when
        List<PatientEntity> results = patientDao.findByLastName("Bond");

        // then
        assertThat(results).hasSize(1);
        PatientEntity actual = results.get(0);
        assertThat(actual.getFirstName()).isEqualTo("Jane");
        assertThat(actual.getLastName()).isEqualTo("Bond");
        assertThat(actual.getEmail()).isEqualTo("jane.smith@example.com");
    }




}
