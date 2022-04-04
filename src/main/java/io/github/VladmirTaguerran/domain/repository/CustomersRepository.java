package io.github.VladmirTaguerran.domain.repository;


import io.github.VladmirTaguerran.domain.entity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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


    public Customers save(Customers customer){
        jdbcTemplate.update(iNSERT, new Object[]{customer.getName()});
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


    public Customers update(Customers customer){
        jdbcTemplate.update(UPDATE,new Object[]{customer.getId(),customer.getName()} );
        return customer;
    }

    public void delete(Customers customer){
        delete(customer.getId());
    }
    public void delete(int id){
        jdbcTemplate.update(DELETE, new Object[]{id});

    }


}
