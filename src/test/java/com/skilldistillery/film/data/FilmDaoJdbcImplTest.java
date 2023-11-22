package com.skilldistillery.film.data;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.film.entities.Film;

class FilmDaoJdbcImplTest {
	private FilmDaoJdbcImpl dao;

	@BeforeEach
	void setUp() throws Exception {
		dao = new FilmDaoJdbcImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		dao = null;
	}

	@Test
	void test_findById_returns_film() {
		Film film = dao.findById(1);
		assertNotNull(film);
//	 	assertEquals("ACADEMY DINOSAUR", film.getTitle());
	}

	@Test
	 void test_findById_returns_null_for_invalid_id() {
	 	Film film = dao.findById(1234567);
	 	assertNull(film);
	 }

	@Test
	 void test_findBy_keyword_returns_film() {
	 	List<Film> film;
		try {
			film = dao.searchByKeyword("ACADEMY");
			assertNotNull(film);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		@Test
		 void test_findBy_Keyword_returns_null_for_invalid_Keyword() {
			List<Film> film;
			try {
				film= dao.searchByKeyword("yeehaw PARTNER");
				assertTrue(film.size() == 0 );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 	

}