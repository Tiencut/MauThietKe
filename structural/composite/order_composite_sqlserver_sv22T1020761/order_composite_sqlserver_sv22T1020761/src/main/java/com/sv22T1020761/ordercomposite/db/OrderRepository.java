package com.sv22T1020761.ordercomposite.db;

import com.sv22T1020761.ordercomposite.model.Combo;
import com.sv22T1020761.ordercomposite.model.OrderComponent;
import com.sv22T1020761.ordercomposite.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    public void clearData() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM dbo.order_components");
        }
    }

    public void saveOrderTree(OrderComponent root) throws SQLException {
        saveOrderTree(root, null);
    }

    private void saveOrderTree(OrderComponent component, Integer parentId) throws SQLException {
        if (component instanceof Product product) {
            saveProduct(product, parentId);
            return;
        }

        Combo combo = (Combo) component;
        saveCombo(combo, parentId);
        for (OrderComponent child : combo.getChildren()) {
            saveOrderTree(child, combo.getId());
        }
    }

    private void saveProduct(Product product, Integer parentId) throws SQLException {
        String sql = """
                INSERT INTO dbo.order_components(id, name, component_type, unit_price, quantity, parent_id)
                VALUES (?, ?, 'PRODUCT', ?, ?, ?)
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getUnitPrice());
            statement.setInt(4, product.getQuantity());
            if (parentId == null) {
                statement.setNull(5, java.sql.Types.INTEGER);
            } else {
                statement.setInt(5, parentId);
            }
            statement.executeUpdate();
        }
    }

    private void saveCombo(Combo combo, Integer parentId) throws SQLException {
        String sql = """
                INSERT INTO dbo.order_components(id, name, component_type, unit_price, quantity, parent_id)
                VALUES (?, ?, 'COMBO', NULL, NULL, ?)
                """;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, combo.getId());
            statement.setString(2, combo.getName());
            if (parentId == null) {
                statement.setNull(3, java.sql.Types.INTEGER);
            } else {
                statement.setInt(3, parentId);
            }
            statement.executeUpdate();
        }
    }

    public OrderComponent findById(int rootId) throws SQLException {
        String sql = "SELECT id, name, component_type, unit_price, quantity, parent_id FROM dbo.order_components ORDER BY id";
        Map<Integer, OrderComponent> componentMap = new HashMap<>();
        Map<Integer, List<Integer>> parentChildrenMap = new HashMap<>();
        Integer foundId = null;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("component_type");
                Integer parentId = (Integer) rs.getObject("parent_id");

                OrderComponent component;
                if ("PRODUCT".equalsIgnoreCase(type)) {
                    double unitPrice = rs.getDouble("unit_price");
                    int quantity = rs.getInt("quantity");
                    component = new Product(id, name, unitPrice, quantity);
                } else {
                    component = new Combo(id, name);
                }

                componentMap.put(id, component);
                if (id == rootId) {
                    foundId = id;
                }
                if (parentId != null) {
                    parentChildrenMap.computeIfAbsent(parentId, k -> new ArrayList<>()).add(id);
                }
            }
        }

        if (foundId == null) {
            return null;
        }

        for (Map.Entry<Integer, List<Integer>> entry : parentChildrenMap.entrySet()) {
            OrderComponent parent = componentMap.get(entry.getKey());
            if (parent instanceof Combo parentCombo) {
                for (Integer childId : entry.getValue()) {
                    parentCombo.addChild(componentMap.get(childId));
                }
            }
        }

        return componentMap.get(rootId);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DatabaseConfig.getDatabaseConnectionString(),
                DatabaseConfig.USERNAME,
                DatabaseConfig.PASSWORD
        );
    }
}
