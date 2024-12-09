package Items;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.DatabaseConnectionUtil;

public class ItemDAO {
	
	// Add Item to the database
    public void addItem(Item item) {
        String sql = "INSERT INTO items (i_name, category, price, description, image) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, item.getI_name());
            preparedStatement.setString(2, item.getCategory());
            preparedStatement.setDouble(3, item.getPrice());
            preparedStatement.setString(4, item.getDescription());
            preparedStatement.setString(5, item.getImage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Item from the database
    public void deleteItem(int id) {
        String sql = "DELETE FROM items WHERE id = ?";
        try (Connection connection = DatabaseConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all items from the database
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items";
        try (Connection connection = DatabaseConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Item item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("i_name"),
                        resultSet.getString("category"),
                        resultSet.getDouble("price"),
                        resultSet.getString("description"),
                        resultSet.getString("image")
                );
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    
    public void updateItem(Item item) {
        String sql = "UPDATE items SET i_name = ?, category = ?, price = ?, description = ?, image = ? WHERE id = ?";

        try (Connection connection = DatabaseConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, item.getI_name());
            preparedStatement.setString(2, item.getCategory());
            preparedStatement.setDouble(3, item.getPrice());
            preparedStatement.setString(4, item.getDescription());
            preparedStatement.setString(5, item.getImage());
            preparedStatement.setInt(6, item.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public Item getItemById(int id) {
        String sql = "SELECT * FROM items WHERE id = ?";
        Item item = null;

        try (Connection connection = DatabaseConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                item = new Item(
                    resultSet.getInt("id"),
                    resultSet.getString("i_name"),
                    resultSet.getString("category"),
                    resultSet.getDouble("price"),
                    resultSet.getString("description"),
                    resultSet.getString("image")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }
    
    public List<Item> getItemsByCategory(String category) {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE category = ?";

        try (Connection connection = DatabaseConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, category);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("i_name"),
                            resultSet.getString("category"),
                            resultSet.getDouble("price"),
                            resultSet.getString("description"),
                            resultSet.getString("image")
                    );
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    
    public List<Item> getItemsByName(String i_name) {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE i_name = ?";

        try (Connection connection = DatabaseConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, i_name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("i_name"),
                            resultSet.getString("category"),
                            resultSet.getDouble("price"),
                            resultSet.getString("description"),
                            resultSet.getString("image")
                    );
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }


}
