/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianDianSheZhi;

import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.viewmodel.BaseViewModel;
import java.util.List;

/**
 *
 * @author Aaron-PC-i3-4130
 */
public class ViewModel extends BaseViewModel {
    private List<LTEquipBasic> equipmentList;
    
    private LTEquipBasic currentEquipment;
    
    private Integer x;
    
    private Integer y;
    
    private Integer checkPointId;
    
    private String checkPointName;
    
    private String checkPointSpecification;
    
    private Integer checkPointOrder;

    public Integer getCheckPointOrder() {
        return checkPointOrder;
    }

    public void setCheckPointOrder(Integer checkPointOrder) {
        this.checkPointOrder = checkPointOrder;
    }

    public String getCheckPointSpecification() {
        return checkPointSpecification;
    }

    public void setCheckPointSpecification(String checkPointSpecification) {
        this.checkPointSpecification = checkPointSpecification;
    }

    public String getCheckPointName() {
        return checkPointName;
    }

    public void setCheckPointName(String checkPointName) {
        this.checkPointName = checkPointName;
    }

    public Integer getCheckPointId() {
        return checkPointId;
    }

    public void setCheckPointId(Integer checkPointId) {
        this.checkPointId = checkPointId;
    }

    public List<LTEquipBasic> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<LTEquipBasic> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public LTEquipBasic getCurrentEquipment() {
        return currentEquipment;
    }

    public void setCurrentEquipment(LTEquipBasic currentEquipment) {
        this.currentEquipment = currentEquipment;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
    
    public String getHotPointImagePath() {
        return "/uploadFiles/".concat("images/HotPoint.png");
    }
    
    public List<LTEquipCheckPoint> getCheckPointList() {
        return this.currentEquipment.getCheckPointList();
    }
}
