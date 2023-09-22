package com.lucasengcomp.challengepayment.domain.repositories;

import com.lucasengcomp.challengepayment.application.dto.person.InsertPersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.PersonDTO;
import com.lucasengcomp.challengepayment.application.dto.person.UpdatePersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonRepository {

    Page<PersonDTO> findPageable(Pageable pageable);

    PersonDTO findById(Long id);

    PersonDTO insert(InsertPersonDTO dto);

    UpdatePersonDTO update(Long id, UpdatePersonDTO dto);

    void deleteResource(Long id);
}
