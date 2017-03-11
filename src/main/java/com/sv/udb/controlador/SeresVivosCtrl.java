/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.SeresVivos;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class SeresVivosCtrl {
    public List<SeresVivos> consTodo()
    {
       List<SeresVivos> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("SELECT s2.codi_sere, s2.codi_refe_sere, s1.nomb_sere 'PERTENECE A', s2.nomb_sere, s2.desc_sere \n" +
                                                        "FROM seresvivos s1 RIGHT JOIN seresvivos s2 on s1.codi_sere = s2.codi_refe_sere\n" +
                                                        "ORDER BY s1.codi_sere");
            ResultSet rs = cmd.executeQuery();
            resp.add(new SeresVivos(0,0,null,"Reino Base",null));
            while(rs.next())
            {
                resp.add(new SeresVivos(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            //Se carga el 
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    } 
    
    // Guardar una nueva especie
    
    public boolean guar(SeresVivos obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO seresvivos VALUES(NULL,?,?,?)");
            cmd.setString(1, obje.getNombreSerVivo());
            cmd.setString(2, obje.getDesSerVivo());
            cmd.setInt(3, obje.getRefSerVivo());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al guardar el Ser Vivo: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    // guardar Reino
    public boolean guarR(SeresVivos obje)
    {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO seresvivos VALUES(NULL,?,?,NULL)");
            cmd.setString(1, obje.getNombreSerVivo());
            cmd.setString(2, obje.getDesSerVivo());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al guardar el Ser Vivo: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    //Eliminar un Ser Vivo
    public boolean elim(SeresVivos obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("Delete from seresvivos where codi_sere = ?");
            cmd.setString(1, String.valueOf(obje.getIdSerVivo()));
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al eliminar el Ser Vivo " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    //modificar ser vivo
     public boolean modi(SeresVivos obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("update seresvivos set nomb_sere = ?, desc_sere = ?, "
            + "codi_refe_sere = ? where codi_sere = ? ");
            cmd.setString(1, String.valueOf(obje.getNombreSerVivo())); 
            cmd.setString(2, String.valueOf(obje.getDesSerVivo()));
            cmd.setString(3, String.valueOf(obje.getRefSerVivo()));
            cmd.setString(4, String.valueOf(obje.getIdSerVivo()));
;
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al modificar el Ser vivo " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
     //modi 0 
     public boolean modiR(SeresVivos obje)
    {
         boolean resp = false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("update seresvivos set nomb_sere = ?, desc_sere = ?, "
            + "codi_refe_sere = NULL where codi_sere = ? ");
            cmd.setString(1, String.valueOf(obje.getNombreSerVivo())); 
            cmd.setString(2, String.valueOf(obje.getDesSerVivo()));
            cmd.setString(3, String.valueOf(obje.getIdSerVivo()));
;
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex)
        {
            System.err.println("Error al modificar el Ser vivo " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
}

