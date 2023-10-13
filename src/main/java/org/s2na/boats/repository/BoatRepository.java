package org.s2na.boats.repository;

import org.s2na.boats.domain.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Integer> {
}
