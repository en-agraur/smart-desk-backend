package com.endava.smartdesk.repository;

import com.endava.smartdesk.data.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {

}
