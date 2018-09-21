package com.middleearth.middleearth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.middleearth.middleearth.model.Command;

public interface CommandRepository extends JpaRepository<Command, Long> {
}
