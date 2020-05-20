/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delta.compiler;

import java.sql.*;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;

/**
 *
 * @author maiquelknechtel
 */
public class Main {

    public static void main(String[] args) {
        try {
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mariadb://10.0.0.111:3306/loja", "root", "123");
            
            HashMap parametros = new HashMap();
            parametros.put("OS", 124);
            parametros.put("OS_ID", 124);
            
           parametros.put("subReport","/home/maiquelknechtel/JaspersoftWorkspace/MyReports/aparelho_subrelatorio_A4.jasper");
          
            JasperReport jasperReport = JasperCompileManager.compileReport("/home/maiquelknechtel/JaspersoftWorkspace/MyReports/cliente_A4.jrxml");
           
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros,conn);
            System.out.println("Done! filling Jasper Report ");
            JasperExportManager.exportReportToPdfFile(jasperPrint, "/home/maiquelknechtel/dynamic1.pdf");
            System.out.println("Done!!!exporting the pdf report");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
