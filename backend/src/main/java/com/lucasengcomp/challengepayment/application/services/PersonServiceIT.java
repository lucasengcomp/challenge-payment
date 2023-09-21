package com.lucasengcomp.challengepayment.application.services;

import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.PersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.UpdatePersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonServiceIT {

    Page<PersonDTO> findAllPaged(Pageable pageable);

    PersonDTO findById(Long id);

    PersonDTO insert(InsertPersonDTO dto);

    UpdatePersonDTO update(Long id, UpdatePersonDTO dto);
}
