package com.example.prueba.repository

import com.example.prueba.model.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository

interface ConferenceRepository:JpaRepository<Conference, Long> {
    fun findById(id: Long?):Conference?



}