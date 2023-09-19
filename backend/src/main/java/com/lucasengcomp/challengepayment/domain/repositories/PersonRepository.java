package com.lucasengcomp.challengepayment.domain.repositories;

import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonRepository {

    Page<PersonDTO> findPageable(Pageable pageable);

    PersonDTO findById(Long id);
}
