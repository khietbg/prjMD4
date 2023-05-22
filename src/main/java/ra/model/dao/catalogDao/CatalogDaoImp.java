package ra.model.dao.catalogDao;

import ra.model.dao.cartDao.ICartDao;
import ra.model.entity.Catalog;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogDaoImp implements ICatalogDao {
    @Override
    public List<Catalog> findAll() {
        List<Catalog> catalogList = null;
        Connection conn = null;
        CallableStatement call = null;
        try{
            catalogList= new ArrayList<>();
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call getCatalog()}");
            ResultSet rs = call.executeQuery();
            while (rs.next()){
                Catalog catalog = new Catalog();
                catalog.setCatalogId(rs.getInt("catalogId"));
                catalog.setCatalogName(rs.getString("catalogName"));
                catalog.setCatalogStatus(rs.getBoolean("catalogStatus"));
                catalogList.add(catalog);
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
        return catalogList;
    }

    @Override
    public boolean save(Catalog catalog) {
        Connection conn = null;
        CallableStatement call = null;
        try{
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call createCatalog(?)}");
            call.setString(1,catalog.getCatalogName());
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
    public Catalog findById(Integer id) {
        Connection conn = null;
        CallableStatement call = null;
        Catalog catalog = null;
        try {
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call findCatalogById(?)}");
            call.setInt(1,id);
            ResultSet rs = call.executeQuery();
            if (rs.next()){
                catalog = new Catalog(rs.getInt(1),rs.getString(2),rs.getBoolean(3));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return catalog;
    }

    @Override
    public boolean update(Catalog catalog) {

        Connection conn = null;
        CallableStatement call = null;
        try{
            conn = ConnectionDB.getConnection();
            call = conn.prepareCall("{call updateCatalog(?,?,?)}");
            call.setInt(1,catalog.getCatalogId());
            call.setString(2,catalog.getCatalogName());
            call.setBoolean(3,catalog.isCatalogStatus());
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
            call = conn.prepareCall("{call deleteCatalog(?)}");
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
