package com.mal.springbooklib;

import com.mal.springbooklib.model.OwnerModel;
import com.mal.springbooklib.model.BookModel;
import com.mal.springbooklib.repository.BookRepository;
import com.mal.springbooklib.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBookLibApplication implements CommandLineRunner{
	@Autowired
    OwnerRepository ownerRepository;

	@Autowired
    BookRepository bookRepository;

	public static void main(String[] args){
	    SpringApplication.run(SpringBookLibApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
////	    <!--Book(String title, String author, Date publishDate, String ISBN, String description)-->
//        TODO: Turn these into flyway scripts
//	    Book a = new Book("Gardens of the Moon", "Steven Erikson","First Book of Malazan Book of the Fallen");
//        Book b = new Book("Deadhouse Gates", "Steven Erikson","Second Book of Malazan Book of the Fallen");
//        Book c = new Book("Memories of Ice", "Steven Erikson","Third Book of Malazan Bok of the Fallen");
//        Book d = new Book("House of Chains", "Steven Erikson","Fourth Book of Malazan Book of the Fallen");
//        Book e = new Book("Midnight Tides", "Steven Erikson","Fifth Book of Malazan Book of the Fallen");
//        Book f = new Book("The Bonehunters", "Steven Erikson","Sixth Book of Malazan Book of the Fallen");
//        Book g = new Book("Reaper\'s Gale", "Steven Erikson","Seventh Book of Malazan Book of the Fallen");
//        Book h = new Book("Toll the Hounds", "Steven Erikson","Eighth Book of Malazan Book of the Fallen");
//        Book i = new Book("Dust of Dreams", "Steven Erikson","Ninth Book of Malazan Book of the Fallen");
//        Book j = new Book("The Crippled God", "Steven Erikson","Tenth Book of Malazan Book of the Fallen");
//
//        bookRepository.save(a);
//        bookRepository.save(b);
//        bookRepository.save(c);
//        bookRepository.save(d);
//        bookRepository.save(e);
//        bookRepository.save(f);
//        bookRepository.save(g);
//        bookRepository.save(h);
//        bookRepository.save(i);
//        bookRepository.save(j);

//        List<OwnerModel> owners = new LinkedList<OwnerModel>();
//        owners.add(new OwnerModel("Malcolm","Leehan","malcolm.leehan@gmail.com","651-341-8046",
//                Arrays.asList(new Book[] {a,b,c,d,e,f,g,h,i,j})));
//        owners.add(new OwnerModel( "David", "Hadley","d.hads.gmail.com","555-555-5555",
//                Arrays.asList(new Book[]{a,b,c})));
//        owners.add(new OwnerModel("Ben","Gappa","ben.gappa@gmail.com","612-555-5555",
//                Arrays.asList(new Book[] {d,e,f,g})));
//        owners.add(new OwnerModel("Amy","Blumke","kukukodama@gmail.com","651-341-6619",
//                Arrays.asList(new Book[]{h,i,j})));
//        ownerRepository.save(owners);
	}

}
