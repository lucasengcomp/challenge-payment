package com.lucasengcomp.challengepayment.application.services.impl;

import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import com.lucasengcomp.challengepayment.application.services.interfaces.PersonServiceIT;
import com.lucasengcomp.challengepayment.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonServiceIT {

    private PersonRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<PersonDTO> findAllPaged(Pageable pageable) {
        return repository.findPageable(pageable);
    }
}
