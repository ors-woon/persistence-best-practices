package com.jpa.best.practices.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val age: Int,
    val genre: String,
    val name: String,
    @OneToMany(
        cascade = [CascadeType.ALL],
        mappedBy = "author",
        // bulk 처리에 주의해야함. (sql 이 하나씩 날아 갈 수 있음)
        orphanRemoval = true
    )
    val books: MutableList<Book>
) {
    // 양방향 관계를 위해 아래와 같은 helper method 가 필요함
    fun addBook(book: Book) {
        books.add(book)
        book.author = this
    }

    fun removeBook(book: Book) {
        books.remove(book)
        book.author = null
    }

    fun removeAllBooks() {
        books.map { book ->
            book.author = null
        }

        books.clear()
    }
}
