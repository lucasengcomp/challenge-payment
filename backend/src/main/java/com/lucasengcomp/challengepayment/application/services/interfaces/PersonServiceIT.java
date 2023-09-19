package com.lucasengcomp.challengepayment.application.services.interfaces;

import com.lucasengcomp.challengepayment.application.dto.PersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonServiceIT {

    Page<PersonDTO> findAllPaged(Pageable pageable);

    PersonDTO findById(Long id);
}
