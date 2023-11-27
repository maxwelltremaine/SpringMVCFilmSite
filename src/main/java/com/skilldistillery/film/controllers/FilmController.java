package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.film.data.FilmDAO;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDao;

	@RequestMapping(path = { "home.do", "/" })
	public String goToHome() {
		return "/WEB-INF/home.jsp";
	}
	@RequestMapping(path = "idForm.do")
	public String goToIdForm() {
		return "/WEB-INF/idForm.jsp";
	}
	@RequestMapping(path = "keywordForm.do")
	public String goToKeywordForm() {
		return "/WEB-INF/keywordForm.jsp";
	}

	@RequestMapping(path = "findByFilmId.do", method = RequestMethod.GET, params = "id")
	public String findByFilmId(Model model, int id) {
		model.addAttribute("film",filmDao.findById(id));
		
		return "/WEB-INF/filmIdResults.jsp";
	}

	@RequestMapping(path = "findByKeyword.do", method = RequestMethod.GET, params = "keyword")
	public String findByKeyWord(Model model, String keyword) {
		try {
			model.addAttribute("films",filmDao.searchByKeyword(keyword));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/WEB-INF/keywordResults.jsp";
	}

}
