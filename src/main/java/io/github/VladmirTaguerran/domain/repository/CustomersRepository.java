package io.github.VladmirTaguerran.domain.repository;


import io.github.VladmirTaguerran.domain.entity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomersRepository {

    private static String iNSERT = "INSERT INTO Customers (name) VALUES (?)";
    private static String SELECT_ALL = "SELECT * FROM Customers";
    private static String UPDATE = "UPDATE Customers set name = ? WHERE id = ?";
    private static String DELETE = "DELETE FROM Customers WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManeger;

    @Transactional
    public Customers save(Customers customer){
        entityManeger.persist(customer);
        return customer;
    }

    public List<Customers> listAll(){
        return jdbcTemplate.query(SELECT_ALL, getCustomersRowMapper());
    }

    private RowMapper<Customers> getCustomersRowMapper() {
        return new RowMapper<Customers>() {
            @Override
            public Customers mapRow(ResultSet rs, int i) throws SQLException {
                String name = rs.getString("name");
                int id  =   rs.getInt("id");

                return new Customers(id,name);
            }
        };
    }

    @Transactional
    public Customers update(Customers customer){
        entityManeger.merge(customer);

        return customer;
    }
    @Transactional
    public void delete(Customers customer){
        entityManeger.remove(customer);
    }
    @Transactional
    public void delete(int id){
        Customers customer = entityManeger.find(Customers.class, id);
        delete(customer);


    }


}
