package ra.model.service.productService;

import ra.model.dao.productDao.IProductDao;
import ra.model.dao.productDao.ProductDaoIpm;
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
    IProductDao productDao = new ProductDaoIpm();

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public Product findById(Integer integer) {
        return productDao.findById(integer);
    }

    @Override
    public boolean update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean delete(Integer integer) {
        return productDao.delete(integer);
    }
}
