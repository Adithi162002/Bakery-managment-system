/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Cake;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author POULAMI
 */
public class CakeDao {

    public static void save(Cake product) {
        String query = "insert into cake (flavour,color,price,weight,shape,allergetic,egg_or_eggless,ocassion,name_on_cake,dod,customername,mobilenumber) values('" + product.getFlavour() + "','" + product.getColor() + "','" + product.getPrice() + "','" + product.getWeight() + "','" + product.getShape() + "','" + product.getAllergetic() + "','" + product.getEggoreggless() + "','" + product.getOcassion() + "','" + product.getNameoncake() + "','" + product.getDod() + "','" + product.getCustomername() + "','" + product.getMobilenumber() + "') ";
        Dboperations.setDataOrDelete(query, "Cake Added Successfully");

    }

    public static ArrayList<Cake> getAllRecords() {
        ArrayList<Cake> arrayList = new ArrayList<>();
        try {
            ResultSet rs = Dboperations.getData("select * from cake");
            while (rs.next()) {
                Cake product = new Cake();
                product.setId(rs.getInt("id"));
                product.setFlavour(rs.getString("flavour"));
                product.setColor(rs.getString("color"));
                product.setPrice(rs.getString("price"));
                product.setWeight(rs.getString("weight"));
                product.setShape(rs.getString("shape"));
                product.setAllergetic(rs.getString("allergetic"));
                product.setEggoreggless(rs.getString("egg_or_eggless"));
                product.setOcassion(rs.getString("ocassion"));
                product.setNameoncake(rs.getString("name_on_cake"));
                product.setDod(rs.getString("dod"));
                product.setCustomername(rs.getString("customername"));
                product.setMobilenumber(rs.getString("mobilenumber"));
                arrayList.add(product);
            }
   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return arrayList;

    }
    
     public static ArrayList<Cake> getAllRecordsByInc(String date){
        ArrayList<Cake> arrayList = new ArrayList<>();
        try{
            ResultSet rs = Dboperations.getData("Select * from cake where dod like '%"+date+"%'");
            while(rs.next()){
                Cake product = new Cake();
                product.setId(rs.getInt("id"));
                product.setFlavour(rs.getString("flavour"));
                product.setColor(rs.getString("color"));
                product.setPrice(rs.getString("price"));
                product.setWeight(rs.getString("weight"));
                product.setShape(rs.getString("shape"));
                product.setAllergetic(rs.getString("allergetic"));
                product.setEggoreggless(rs.getString("egg_or_eggless"));
                product.setOcassion(rs.getString("ocassion"));
                product.setNameoncake(rs.getString("name_on_cake"));
                product.setDod(rs.getString("dod"));
                product.setCustomername(rs.getString("customername"));
                product.setMobilenumber(rs.getString("mobilenumber"));
                arrayList.add(product);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    }
    
    public static ArrayList<Cake> getAllRecordsByDesc(String date){
        ArrayList<Cake> arrayList = new ArrayList<>();
        try{
            ResultSet rs = Dboperations.getData("Select * from cake where dod like '%"+date+"%' order by id DESC");
            while(rs.next()){
                Cake product = new Cake();
                product.setId(rs.getInt("id"));
                product.setFlavour(rs.getString("flavour"));
                product.setColor(rs.getString("color"));
                product.setPrice(rs.getString("price"));
                product.setWeight(rs.getString("weight"));
                product.setShape(rs.getString("shape"));
                product.setAllergetic(rs.getString("allergetic"));
                product.setEggoreggless(rs.getString("egg_or_eggless"));
                product.setOcassion(rs.getString("ocassion"));
                product.setNameoncake(rs.getString("name_on_cake"));
                product.setDod(rs.getString("dod"));
                product.setCustomername(rs.getString("customername"));
                product.setMobilenumber(rs.getString("mobilenumber"));
                arrayList.add(product);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    }

    public static void update(Cake product) {
        String query = "update cake set name ='" + product.getFlavour() + "',color ='" + product.getColor() + "', price = '" + product.getPrice() + "' where id = '" + product.getId() + "'";
        Dboperations.setDataOrDelete(query, "Product Updated Successfully");
    }

    public static void delete(String id) {
        String query = "delete from cake where id = '" + id + "'";
        Dboperations.setDataOrDelete(query, "Cake Deleted Successfully");

    }

    public static ArrayList<Cake> getAllRecordsByCategory(String category) {
        ArrayList<Cake> arrayList = new ArrayList<>();
        try {
            ResultSet rs = Dboperations.getData("select * from cake where category ='" + category + "'");
            while(rs.next()){
                
                Cake product = new Cake();
                product.setFlavour(rs.getString("flavour"));
                arrayList.add(product);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return arrayList;
    }

    public static ArrayList<Cake> filterProductByname(String flavour, String color) {
        ArrayList<Cake> arrayList = new ArrayList<>();
        try {
            ResultSet rs = Dboperations.getData("select * from cake where name like '%" + flavour + "%' and color = '" + color + "'");
            while(rs.next()){
                Cake product = new Cake();
                product.setFlavour(rs.getString("flavour"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return arrayList;
    }

    public static Cake getProductByname(String flavour) {
        Cake product = new Cake();
        try {
            ResultSet rs = Dboperations.getData("select * from cake where flavour ='" + flavour + "'");
            while (rs.next()) {
                product.setFlavour(rs.getString(2));
                product.setColor(rs.getString(3));
                product.setPrice(rs.getString(4));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }

}
