package ra.model.service.catalog;

import ra.model.dao.cartDao.ICartDao;
import ra.model.dao.catalogDao.CatalogDaoImp;
import ra.model.dao.catalogDao.ICatalogDao;
import ra.model.entity.Catalog;
import ra.model.entity.User;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class catalogServiceIpm implements ICatalogService{
    ICatalogDao catalogDao = new CatalogDaoImp();

    @Override
    public List<Catalog> findAll() {
        return catalogDao.findAll();
    }

    @Override
    public boolean save(Catalog catalog) {
        return catalogDao.save(catalog);
    }

    @Override
    public Catalog findById(Integer integer) {
        return catalogDao.findById(integer);
    }

    @Override
    public boolean update(Catalog catalog) {
        return catalogDao.update(catalog);
    }

    @Override
    public boolean delete(Integer integer) {
        return catalogDao.delete(integer);
    }
}
