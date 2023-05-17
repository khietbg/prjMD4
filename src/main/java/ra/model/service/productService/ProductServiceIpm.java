package ra.model.service.productService;

import ra.model.entity.Catalog;
import ra.model.entity.Product;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceIpm implements IProductService{
    @Override
    public List<Product> findAll() {
        List<Product> productList = null;
        Connection conn = null;
        CallableStatement call = null;
        try{
            productList = new ArrayList<>();
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call getProduct()}");
            ResultSet rs = call.executeQuery();
            while (rs.next()){
                Product product = new Product();
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setImage(rs.getString(3));
                product.setPrice(rs.getFloat(4));
                product.setCatalogId(rs.getInt(5));
                product.setProductStatus(rs.getBoolean(6));
                product.setProductQuantity(rs.getInt(7));
                productList.add(product);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return productList;
    }

    @Override
    public boolean save(Product product) {
        Connection conn = null;
        CallableStatement call = null;
        try{
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call createProduct(?,?,?,?)}");
            call.setInt(1,product.getCatalogId());
            call.setString(2,product.getProductName());
            call.setString(3,product.getImage());
            call.setFloat(4,product.getPrice());
            int rs = call.executeUpdate();
            if (rs==1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public Product findById(Integer id) {
        Connection conn = null;
        CallableStatement call = null;
        Product product = null;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call findProductById(?)}");
            call.setInt(1,id);
            ResultSet rs = call.executeQuery();
            if (rs.next()){
                product = new Product();
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setImage(rs.getString(3));
                product.setPrice(rs.getFloat(4));
                product.setCatalogId(rs.getInt(5));
                product.setProductStatus(rs.getBoolean(6));
                product.setProductQuantity(rs.getInt(7));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean update(Product product) {
        Connection conn = null;
        CallableStatement call = null;
        try{
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call updateProduct(?,?,?,?,?,?,?)}");
            call.setInt(1,product.getProductId());
            call.setString(2,product.getProductName());
            call.setString(3,product.getImage());
            call.setFloat(4,product.getPrice());
            call.setInt(5,product.getCatalogId());
            call.setInt(6,product.getProductQuantity());
            call.setBoolean(7,product.isProductStatus());
            int rs = call.executeUpdate();
            if (rs == 1){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement call = null;
        try{
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call deleteProduct(?)}");
            call.setInt(1,id);
            int rs = call.executeUpdate();
            if (rs == 1){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
