package com.gpotdesevo.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gpotdesevo.hrworker.entityes.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
