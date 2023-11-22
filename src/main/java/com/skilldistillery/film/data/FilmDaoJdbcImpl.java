package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Film;
import com.skilldistillery.film.entities.Actor;

public class FilmDaoJdbcImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private final static String USER = "student";
	private final static String PWD = "student";


	@Override
	public Film findById(int filmId) {
		Film film = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
		
		String sql = "SELECT *, language.name FROM film JOIN language ON language.id = film.language_id JOIN film_list ON film.id = film_list.FID WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, filmId);

		ResultSet filmResult = stmt.executeQuery();

		if (filmResult.next()) {

			film = new Film();

			// Here is our mapping of query columns to our object fields:
			film.setId(filmResult.getInt("id"));
			film.setTitle(filmResult.getString("title"));
			;
			film.setDescription(filmResult.getString("description"));
			film.setReleaseYear(filmResult.getInt("release_year"));
			film.setLanguageId(filmResult.getInt("language_id"));
			film.setRentalDuration(filmResult.getInt("rental_duration"));
			film.setRentalRate(filmResult.getDouble("rental_rate"));
			film.setLength(filmResult.getInt("length"));
			film.setReplacementCost(filmResult.getDouble("replacement_cost"));
			film.setRating(filmResult.getString("rating"));
			film.setSpecialFeatures(filmResult.getString("special_features"));
			film.setLanguage(filmResult.getString("name"));
			film.setCategory(filmResult.getString("category"));
			findActorsByFilmId(filmId);
			System.out.println(film);
			System.out.println("Actors featured in this film " + findActorsByFilmId(filmId));
			
		}
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;

	}
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> listOActors = new ArrayList<>();

		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);

			String sql = "SELECT *, ac.first_name, ac.last_name FROM film_actor JOIN actor ac ON actor_id = ac.id WHERE film_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, filmId);

			ResultSet actorResult = stmt.executeQuery();
			while (actorResult.next()) {
				Actor actor = new Actor();
				actor.setId(actorResult.getInt("actor_id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));
				listOActors.add(actor);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOActors;
	}
	

	@Override
	
	public List<Film> searchByKeyword(String keyword) throws SQLException {
			List<Film> films = new ArrayList<>();
			Connection conn = DriverManager.getConnection(URL, USER, PWD);
			String sql = "SELECT *, language.name, category FROM film JOIN language ON language.id = film.language_id JOIN film_list ON film.id = film_list.FID WHERE film.title LIKE ? OR film.description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet filmResult = stmt.executeQuery();

			while (filmResult.next()) {
				Film film = new Film();

				// Here is our mapping of query columns to our object fields:
				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleaseYear(filmResult.getInt("release_year"));
				film.setLanguageId(filmResult.getInt("language_id"));
				film.setRentalDuration(filmResult.getInt("rental_duration"));
				film.setRentalRate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacementCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecialFeatures(filmResult.getString("special_features"));
				film.setLanguage(filmResult.getString("name"));
				film.setCategory(filmResult.getString("category"));
				findActorsByFilmId(filmResult.getInt("id"));
				System.out.println(film);
				System.out.println("Actors featured in this film " + findActorsByFilmId(filmResult.getInt("id"))+ "\n");
				films.add(film);
			}

			conn.close();
			return films;

		}
	@Override
	public Actor findActorById(int actorId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
