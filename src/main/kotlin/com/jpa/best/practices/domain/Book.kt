package com.jpa.best.practices.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne


@Entity
class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val isbn: String,
    val title: String,
    @ManyToOne
    @JoinColumn(name = "author_id")
    var author: Author? // helper 때문에 nullable
)
