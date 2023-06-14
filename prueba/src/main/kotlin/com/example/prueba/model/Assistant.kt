package com.example.prueba.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name="assistant")

class Assistant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name= "conference_id")
    var conferenceId: Long? = null
    @NotBlank(message="Campo obligatorio")
    var fullname: String? = null
    @NotBlank(message="Campo obligatorio")
    var roles: String? = null
    var age: Int? = null
}