package com.simpleweb.app.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.simpleweb.app.entity.Address;
import com.simpleweb.app.entity.Author;
import com.simpleweb.app.entity.Book;
import com.simpleweb.app.entity.Publisher;
import com.simpleweb.app.repository.AddressRepository;
import com.simpleweb.app.repository.AuthorRepository;
import com.simpleweb.app.repository.BookRepository;
import com.simpleweb.app.repository.PublisherRepository;

@Component
public class InitialData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	private final AddressRepository addressRepository;
	
	public InitialData(AuthorRepository authorRepository, BookRepository bookRepository, AddressRepository addressRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.addressRepository = addressRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Publisher publisher = new Publisher("Nuevo publisher");
		Address address = new Address("Cdla. El Cóndor", "Guayaquil", "Guayas", "090107");

		publisher.setAddress(address);

		addressRepository.save(address);
		publisherRepository.save(publisher);

		Author author = new Author("Allan", "Alarcón");
		Book book = new Book("Harry Potter", "12345");

		author.getBooks().add(book);
		book.getAuthors().add(author);

		book.setPublisher(publisher);
		publisher.getBooks().add(book);

		authorRepository.save(author);
		bookRepository.save(book);
		publisherRepository.save(publisher);

		System.out.println("Data1");
		System.out.println("Number of authors: " + authorRepository.count());
		System.out.println("Number of publishers: " + publisherRepository.count());
	}

}
