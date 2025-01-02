package com.jpacourse.service;

import com.jpacourse.dto.VisitTO;
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
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Transactional
    @Test
    public void testShouldFindOneResult() {
        // given
        // when
        List<VisitTO> results = visitService.findAllByPatientId(1L);

        // then
        assertThat(results).hasSize(2);
        assertThat(results.get(0).getDescription()).isEqualTo("Cardiac consultation");
        assertThat(results.get(1).getDescription()).isEqualTo("Skin check-up");
    }
}