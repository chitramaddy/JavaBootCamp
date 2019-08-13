package com.company.ChitraMadhanU2M3Summative.dao;

import com.company.ChitraMadhanU2M3Summative.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao{

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_TSHIRT =
            "insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";

    private static final String SELECT_TSHIRT =
            "select * from t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_TSHIRTS =
            "select * from t_shirt";

    private static final String UPDATE_TSHIRT=
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";

    private static final String DELETE_TSHIRT=
            "delete from  t_shirt where t_shirt_id = ?";

    private static final String SEARCH_TSHIRT_BY_COLOR =
            "select * from t_shirt where color = ?";

    private static final String SEARCH_TSHIRT_BY_SIZE =
            "select * from t_shirt where size = ?";



            @Autowired
    public TShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public TShirt addTShirt(TShirt tShirt) {
            jdbcTemplate.update(INSERT_TSHIRT,
                    tShirt.getSize(),
                    tShirt.getColor(),
                    tShirt.getDescription(),
                    tShirt.getPrice(),
                    tShirt.getQuantity());

            int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

            tShirt.settShirtId(id);

            return tShirt;
    }

    @Override
    public TShirt getTShirt(int id) {

                try{
                    return jdbcTemplate.queryForObject(SELECT_TSHIRT, this::mapToRowTShirt, id);
                }catch (EmptyResultDataAccessException e){
                    return null;
                }
    }

    @Override
    public List<TShirt> getAllTShirts() {
        return jdbcTemplate.query(SELECT_ALL_TSHIRTS, this::mapToRowTShirt);
    }

    @Override
    public TShirt updateTShirt(TShirt tShirt) {
                jdbcTemplate.update(UPDATE_TSHIRT,
                        tShirt.getSize(),
                        tShirt.getColor(),
                        tShirt.getDescription(),
                        tShirt.getPrice(),
                        tShirt.getQuantity(),
                        tShirt.gettShirtId());

                return tShirt;

    }

    @Override
    public void deleteTShirt(int id) {
                jdbcTemplate.update(DELETE_TSHIRT, id);

    }

    @Override
    public List<TShirt> getTShirtByColor(String color) {
        return jdbcTemplate.query(SEARCH_TSHIRT_BY_COLOR, this::mapToRowTShirt, color);
    }

    @Override
    public List<TShirt> getTShirtBySize(String size) {
        return jdbcTemplate.query(SEARCH_TSHIRT_BY_SIZE, this::mapToRowTShirt, size);
    }

    private TShirt mapToRowTShirt(ResultSet rs, int rowNum) throws SQLException{
                TShirt tShirt = new TShirt();
                tShirt.settShirtId(rs.getInt("t_shirt_id"));
                tShirt.setSize(rs.getString("size"));
                tShirt.setDescription(rs.getString("description"));
                tShirt.setColor(rs.getString("color"));
                tShirt.setPrice(rs.getBigDecimal("price"));
                tShirt.setQuantity(rs.getInt("quantity"));

                return tShirt;

    }
}
