package com.epam.xmlparser.repository;

import com.epam.xmlparser.model.entities.EPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EPaperRepository extends JpaRepository<EPaper, Long> {
}
