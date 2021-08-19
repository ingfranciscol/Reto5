/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Req1;
import modelo.Req2;
import modelo.Req3;
import view.App;

/**
 *
 * @author Acer
 */
public class Controller {

    private ArrayList<Req1> req1s;
    private ArrayList<Req2> req2s;
    private ArrayList<Req3> req3s;
    private Conector conectorDB;
    private static ResultSet RTA;
    private App app ;

    public Controller(String url) throws ClassNotFoundException {
        super();
        conectorDB = new Conector(url);
    }

    public void req1() {
        req1s = new ArrayList<>();
        try {
            RTA = conectorDB.getReq1DB();
            while (RTA.next()) {
                Req1 req1 = new Req1(RTA.getInt(1), RTA.getInt(2), RTA.getString(3), RTA.getString(4));
                req1s.add(req1);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar2 " + e.getMessage());
        } 
    }
    
    public void req2() {
        req2s = new ArrayList<>();
        try {
            
            RTA = conectorDB.getReq2DB();
            while (RTA.next()) {
                Req2 req2 = new Req2(RTA.getInt(2), RTA.getString(1), RTA.getInt(3), RTA.getDouble(4));
                req2s.add(req2);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar2 " + e.getMessage());
        }
    }

    public void req3() {
        req3s = new ArrayList<>();
        try {
            RTA = conectorDB.getReq3DB();
            while (RTA.next()) {
                Req3 req3 = new Req3(RTA.getString(3), RTA.getInt(2), RTA.getString(1));
                req3s.add(req3);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar2 " + e.getMessage());
        } 
    }
    public ArrayList<Req1> printReq1() {
        return req1s;
    }

    public ArrayList<Req2>  printReq2() {
        return req2s;
    }

    public ArrayList<Req3>  printReq3() {
        return req3s;
    }
    
}
