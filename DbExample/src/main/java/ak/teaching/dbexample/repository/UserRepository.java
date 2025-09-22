package ak.teaching.dbexample.repository;

import ak.teaching.dbexample.repository.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, name, lastName FROM users WHERE id = ?",
                (ResultSet rs, int rowNum) -> {
                    User u = new User();
                    u.setId(rs.getLong("id"));
                    u.setName(rs.getString("name"));
                    u.setLastName(rs.getString("lastName"));
                    return u;
                },
                id);
    }

    public Integer save(User user) {
        return jdbcTemplate.update(
                "INSERT INTO users (name, lastName) VALUES (?, ?)",
                user.getName(), user.getLastName());
    }
}
