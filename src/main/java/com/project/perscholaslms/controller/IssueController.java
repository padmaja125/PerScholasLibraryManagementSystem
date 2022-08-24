package com.project.perscholaslms.controller;

import com.project.perscholaslms.common.Constants;
import com.project.perscholaslms.models.Book;
import com.project.perscholaslms.models.Category;
import com.project.perscholaslms.models.Member;
import com.project.perscholaslms.service.BookService;
import com.project.perscholaslms.service.CategoryService;
import com.project.perscholaslms.service.IssueService;
import com.project.perscholaslms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/issue")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;
    @ModelAttribute(name = "memberTypes")
    public List<String> memberTypes() {
        return Constants.MEMBER_TYPES;
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.getAllBySort();
    }

    @ModelAttribute("members")
    public List<Member> getMembers() {
        return memberService.getAll();
    }

    @ModelAttribute("members")
    public List<Book> getBooks() {
        return bookService.getAll();
    }
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listIssuePage(Model model) {
        model.addAttribute("issues", issueService.getAllUnreturned());
        return "/issue/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newIssuePage(Model model) {
        return "/issue/form";
    }

}
