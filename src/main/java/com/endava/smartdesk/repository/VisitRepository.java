package com.endava.smartdesk.repository;

import com.endava.smartdesk.data.Card;
import com.endava.smartdesk.data.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {

    List<Visit> findByDateBetween(Date startDate, Date endDate);

    List<Visit> findByVisitorCardIn(List<Card> cards);

    List<Visit> findByVisitorCardInAndDateBetween(List<Card> cards, Date startDate, Date endDate);
}
