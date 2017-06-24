/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.servlet;

import cn.tst.sbjxzzglxt.entity.Employee;
import cn.tst.sbjxzzglxt.entity.MapSetting;
import cn.tst.sbjxzzglxt.entity.Uptown;
import cn.tst.sbjxzzglxt.facade.EmployeeFacade;
import cn.tst.sbjxzzglxt.facade.MapSettingFacade;
import cn.tst.sbjxzzglxt.facade.UptownFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aaron-PC-i3-4130
 */
@WebServlet(name="BlockRoutingInspectionServlet", urlPatterns={"/Map/BlockRoutingInspection"})
public class BlockRoutingInspectionServlet extends HttpServlet {
    @EJB
    private MapSettingFacade mapSettingFacade;
    
    @EJB
    private EmployeeFacade employeeLocationFacade;
    
    @EJB
    private UptownFacade uptownFacade;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=UTF-8");
        String jsonString = "{";
        
        List<MapSetting> mapSettingList = mapSettingFacade.findAll();
        MapSetting mapSetting = mapSettingList.get(0);
        jsonString = jsonString.concat("\"mapSetting\":{");
        jsonString = jsonString.concat("\"initialLongtitude\":" + mapSetting.getInitialLongtitude() + ",");
        jsonString = jsonString.concat("\"initialLatitude\":" + mapSetting.getInitialLatitude() + ",");
        jsonString = jsonString.concat("\"zoom\":" + mapSetting.getZoom());
        jsonString = jsonString.concat("},");
        
        List<Uptown> uptownList = uptownFacade.findAll();
        jsonString = jsonString.concat("\"uptownList\":[");
        for(int i = 0; i < uptownList.size(); ++i) {
            Uptown uptown = uptownList.get(i);
            jsonString = jsonString.concat("{");
            jsonString = jsonString.concat("\"longtitude\":" + uptown.getLongtitude() + ",");
            jsonString = jsonString.concat("\"latitude\":" + uptown.getLatitude() + ",");
            jsonString = jsonString.concat("\"countOfListToAdd\":" + uptown.getCountOfListToAdd() + ",");
            jsonString = jsonString.concat("\"countOfListToReply\":" + uptown.getCountOfListToReply() + ",");
            jsonString = jsonString.concat("\"address\":\"" + uptown.getAddress() + "\",");
            jsonString = jsonString.concat("\"name\":\"" + uptown.getName() + "\"");
            jsonString = jsonString.concat("}");
            if(i != uptownList.size() - 1) {
                jsonString = jsonString.concat(",");
            }
        }
        jsonString = jsonString.concat("],");
        
        List<Employee> employeeLocationList = employeeLocationFacade.findAll();
        jsonString = jsonString.concat("\"employeeList\":[");
        for(int i = 0; i < employeeLocationList.size(); ++i) {
            Employee employeeLocation = employeeLocationList.get(i);
            jsonString = jsonString.concat("{");
            jsonString = jsonString.concat("\"longtitude\":" + employeeLocation.getLongtitude() + ",");
            jsonString = jsonString.concat("\"latitude\":" + employeeLocation.getLatitude() + ",");
            jsonString = jsonString.concat("\"name\":\"" + employeeLocation.getName() + "\"" + ",");
            jsonString = jsonString.concat("\"countOfWorkList\":" + employeeLocation.getCountOfWorkList() + ",");
            jsonString = jsonString.concat("\"phoneNumber\":\"" + employeeLocation.getPhoneNumber() + "\"");
            jsonString = jsonString.concat("}");
            if(i != employeeLocationList.size() - 1) {
                jsonString = jsonString.concat(",");
            }
        }
        jsonString = jsonString.concat("]");
        
        jsonString = jsonString.concat("}");
        response.getWriter().write(jsonString);
    }
}
