package com.jpacourse.service.impl;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.AddressMapper;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class VisitServiceImpl implements VisitService
{
    private final VisitDao visitDao;

    @Autowired
    public VisitServiceImpl(VisitDao pvisitDao)
    {
        visitDao = pvisitDao;
    }

    @Override
    public List<VisitTO> findAllByPatientId(long patientId) {
        List<VisitEntity> allByPatientId = visitDao.findAllByPatientId(patientId);
        return allByPatientId.stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());
    }
}
