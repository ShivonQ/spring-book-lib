package com.mal.springbooklib.controller;

import com.mal.springbooklib.model.BookModel;
import com.mal.springbooklib.repository.BookRepository;
import com.mal.springbooklib.model.OwnerModel;
import com.mal.springbooklib.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OwnersController {
    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    BookRepository bookRepository;

//    get all owner records
    @GetMapping("/owners")
    public List<OwnerModel> getAllOwners(){
        return ownerRepository.findAll();
    }
//    get a single record of an owner
    @GetMapping("/owner/{id}")
    public String owner(@PathVariable Long id, Model model){
        model.addAttribute("owner", ownerRepository.findOne(id));
        model.addAttribute("books", bookRepository.findAll());
        return "owner";
    }
//    get all owner records
//    @GetMapping(value="/owners")
//    public String ownersList(Model model){
//        model.addAttribute("owners",ownerRepository.findAll());
//        return "owners";
//    }

//    Add a new book owner to the system

    @PostMapping(value = "/owners")
    public OwnerModel ownersAdd(@Valid @RequestBody OwnerModel ownerModel) {

        return ownerRepository.save(ownerModel);
    }
//            @RequestParam String firstName,
//            @RequestParam String lastName,
//            @RequestParam String email,
//            @RequestParam String phone,
//            Model model){
//        OwnerModel newOwner = new OwnerModel();
//        newOwner.setAllAtts(firstName,lastName,email,phone);
//        ownerRepository.save(newOwner);
//
//        model.addAttribute("owner", newOwner);
//        model.addAttribute("books", bookRepository.findAll());
//
//        return "redirect:/owner/" + newOwner.getId();


//    get the books an owner owns, or add one.

    @RequestMapping(value = "/owner/{id}/books", method = RequestMethod.POST)
    public String ownerAddBook(@PathVariable Long id, @RequestParam Long bookId, Model model){

        BookModel book = bookRepository.findOne(bookId);
//        TODO: ADD TRY CATCH FOR IF THE BOOK DOESN"T EXIST
        OwnerModel owner = ownerRepository.findOne(id);
        if (owner !=null){
            if (!owner.hasBook(book)){
                owner.getBooks().add(book);
            }
            ownerRepository.save(owner);
            model.addAttribute("owner", ownerRepository.findOne(id));
            model.addAttribute("books", bookRepository.findAll());
            return "redirect:/owner/"+owner.getId();
        }

        model.addAttribute("owners",ownerRepository.findAll());
        return "redirect:/owners";
    }
}
