package com.biblioteca.books_api.service;

import com.biblioteca.books_api.dto.BookRequestDTO;
import com.biblioteca.books_api.model.Book;
import com.biblioteca.books_api.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Obtener todos los libros desde PostgreSQL
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Buscar un libro por ID en PostgreSQL
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Registrar un nuevo libro en PostgreSQL
    public Book createBook(BookRequestDTO dto) {
        Book newBook = new Book(
                null, // PostgreSQL genera el ID automáticamente
                dto.getTitle(),
                dto.getAuthor(),
                dto.getIsbn(),
                dto.getPublicationYear(),
                dto.getCategory(),
                dto.getAvailable() != null ? dto.getAvailable() : true
        );
        return bookRepository.save(newBook);
    }

    // Actualizar un libro existente en PostgreSQL
    public Optional<Book> updateBook(Long id, BookRequestDTO dto) {
        Optional<Book> existingBookOpt = bookRepository.findById(id);
        if (existingBookOpt.isPresent()) {
            Book book = existingBookOpt.get();
            book.setTitle(dto.getTitle());
            book.setAuthor(dto.getAuthor());
            book.setIsbn(dto.getIsbn());
            book.setPublicationYear(dto.getPublicationYear());
            book.setCategory(dto.getCategory());
            book.setAvailable(dto.getAvailable());
            return Optional.of(bookRepository.save(book));
        }
        return Optional.empty();
    }

    // Eliminar un libro de PostgreSQL
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}