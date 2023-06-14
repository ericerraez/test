package com.example.prueba.service

import com.example.prueba.model.Assistant
import com.example.prueba.repository.AssistantRepository
import com.example.prueba.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class AssistantService {

    @Autowired
    lateinit var assistantRepository: AssistantRepository

    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun list():List<Assistant>{
        return assistantRepository.findAll()
    }
    fun save(assistant: Assistant):Assistant{
        try{
            val responseConference= conferenceRepository.findById(assistant.conferenceId)
                ?: throw Exception("Id no existe")

            val responseAssistants = assistantRepository.save(assistant)
            //paso adicionales antes de devlver
            //obtener el total de las amonstaciones
            var totalAssistant = getTotalAssistants(assistant.conferenceId)
            //actulizar el player
            conferenceRepository.save(responseConference.apply {assistants=totalAssistant})

            return responseAssistants
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun update(assistant: Assistant): Assistant {
        try {
            assistantRepository.findById(assistant.id)
                ?: throw Exception("ID no existe")

            return assistantRepository.save(assistant)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun getTotalAssistants(conferenceId: Long?): Double? {
        return assistantRepository.getTotalAssistants(conferenceId)
    }

    fun listAssistant(age:Int?): List<Assistant>?{
        return assistantRepository.findAvailableAssistants(age)
    }
}

