package com.example.demo.repository;

import com.example.demo.models.Checkbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckboxRepository extends JpaRepository<Checkbox, Long> {

}
