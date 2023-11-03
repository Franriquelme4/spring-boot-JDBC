package com.fsrg.mycrud.repositories;

import com.fsrg.mycrud.model.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final BookMapper mapper = new BookMapper();
    private final SimpleJdbcInsert insert;
    private final String table = "books";

    public BookRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource datasource){
        this.jdbcTemplate = namedParameterJdbcTemplate;
        this.insert = new SimpleJdbcInsert(datasource).withTableName(table).usingGeneratedKeyColumns("id");
    }

    public List<Book> getAllBooks(){
        String sql = "select * from books";
        return this.jdbcTemplate.query(sql,mapper);
    }
    public long createBook(Book book) {
        return insert.executeAndReturnKey(
                new MapSqlParameterSource("name",book.name)
        ).longValue();
    }
    public static class BookMapper implements RowMapper<Book>{
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            return new Book(id,name);
        }
    }
}
