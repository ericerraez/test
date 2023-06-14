package com.example.prueba.repository

import com.example.prueba.model.Assistant
import com.example.prueba.model.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository

interface AssistantRepository:JpaRepository<Assistant, Long> {
    fun findById(id: Long?):Assistant?

    @Query(nativeQuery =true)//Va a leer jpa-named.....
    fun getTotalAssistants(@Param ("conferenceId") conferenceId: Long?): Double?

    @Query(nativeQuery = true)
    fun findAvailableAssistants(@Param("age") age: Int?):List<Assistant>?

}