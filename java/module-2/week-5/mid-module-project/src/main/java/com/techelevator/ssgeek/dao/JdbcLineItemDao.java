package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.LineItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcLineItemDao implements LineItemDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLineItemDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<LineItem> getLineItemsBySaleId(int saleId) {
        List<LineItem> lineItems = new ArrayList<>();
        String sql = "SELECT line_item_id, sale_id, product_id, quantity FROM line_item WHERE sale_id = ? ORDER BY line_item_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, saleId);
        while (results.next()) {
            lineItems.add(mapRowToLineItem(results));
        }
        return lineItems;
    }

    private LineItem mapRowToLineItem(SqlRowSet rs) {
        LineItem lineItem = new LineItem();
        lineItem.setLineItemId(rs.getInt("line_item_id"));
        lineItem.setSaleId(rs.getInt("sale_id"));
        lineItem.setProductId(rs.getInt("product_id"));
        lineItem.setQuantity(rs.getInt("quantity"));
        return lineItem;
    }
}
