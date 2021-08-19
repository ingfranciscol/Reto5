
package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

class Conector {
    private Connection connect;

    public Conector(String url) throws ClassNotFoundException {
        super();
        connectDB(url);
    }

    public ResultSet getReq1DB() {
        String sql = "SELECT sum(cantidad) as total, id_proyecto, pagado, proveedor FROM Compra WHERE pagado = 'No' GROUP BY ID_Proyecto HAVING (total) > 50 ORDER BY `id_proyecto` ASC";
        return executeQuery(sql);

    }

    public ResultSet getReq2DB() {
        //TODO
        String sql = "SELECT Proyecto.Fecha_Inicio as inicio, Tipo.Estrato, Tipo.Financiable,  Proyecto.Porcentaje_Cuota_Inicial * 100 FROM Tipo, Proyecto WHERE Proyecto.ID_Tipo = Tipo.ID_Tipo AND Proyecto.Porcentaje_Cuota_Inicial > 0.2 AND Tipo.Estrato >= 5 AND Tipo.Financiable = 0 \n" +
"AND DATE(proyecto.Fecha_Inicio) > DATE('2019-01-01') ORDER BY `Fecha_Inicio` ASC";
        
        return executeQuery(sql);
    }

    public ResultSet getReq3DB() {
        //TODO
        String sql = "SELECT proyecto.Clasificacion, proyecto.ID_Proyecto, compra.pagado  FROM materialconstruccion, compra, proyecto WHERE materialconstruccion.Importado = 'Si' AND compra.ID_MaterialConstruccion = materialconstruccion.ID_MaterialConstruccion AND proyecto.ID_Proyecto = compra.ID_Proyecto AND compra.Pagado != 'Si' AND proyecto.Clasificacion IN ('Apartamento','Apartaestudio') AND proyecto.Acabados = 'No' GROUP BY proyecto.ID_Proyecto  \n" +
"ORDER BY `proyecto`.`ID_Proyecto` ASC";
        return executeQuery(sql);
    }

    public Connection connectDB(String url) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            connect = (Connection) DriverManager.getConnection(url, "root", "zxc123");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        PreparedStatement PS;
        try {
            //Statement stmt = connect.createStatement();
            PS = connect.prepareStatement(sql);
            rs = PS.executeQuery();
            //rs = (ResultSet) connect.prepareStatement(sql);
        } catch (SQLException e) {
        }
        return rs;
    }
}
