package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.TollToken;
@Repository
public interface TolltokenDAO extends JpaRepository<TollToken, Integer> {
	@Query("select t from TollToken t where t.RFID=:id")
	Optional<List<TollToken>> findByRFID(@Param("id") Integer RFID);

}
