package cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.GuanLiZhe;

import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.LuRuRen.*;
import cn.tst.sbjxzzglxt.MoKuai.XunJianGuanLi.XunJianXiangMuGuanLi.*;
import cn.tst.sbjxzzglxt.entity.GuZhangShiLi;
import cn.tst.sbjxzzglxt.entity.LTEquipBasic;
import cn.tst.sbjxzzglxt.entity.LTEquipCheckPoint;
import cn.tst.sbjxzzglxt.entity.LTEquipErrorMessage;
import cn.tst.sbjxzzglxt.entity.SysRoutingInspectionItems;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.TreeNode;

public class ViewModel {

    private List<LTEquipBasic> equipBasicList;

    private LTEquipBasic selectedEquipBasic;
    
    private LTEquipBasic equipBasic;

    private TreeNode equipTreeRoot;//tree节点

    private LTEquipCheckPoint selectedCheckPoint;

    private List<LTEquipCheckPoint> selectedCheckPointList;

    private List<SysRoutingInspectionItems> itemList;

    private SysRoutingInspectionItems itemInEdit;
    
    private SysRoutingInspectionItems examine;
    
    private List<LTEquipErrorMessage> errorMessageList;
    
    private GuZhangShiLi guZhangShiLi;
    
    private ArrayList guZhangJiHe;
    
    private boolean ifShowBoDong = true;

    private boolean ifShowError;
    
    private int xuanZe;
    
    private String name;
    
    private Long xiangMuId;
    
    private String guZhangId;
    
    private int xunJianDianId;
    
    private int boDongShangXian;
    
    private int boDongXiaXian;
    
    private String xiangMuShuoMing;
    
    private int xunJianShunXu;
    
    private int xuanZeFangShi;
    
    private String guZhangMingChen;

    public String getGuZhangMingChen() {
        return guZhangMingChen;
    }

    public void setGuZhangMingChen(String guZhangMingChen) {
        this.guZhangMingChen = guZhangMingChen;
    }

    

    public int getXuanZeFangShi() {
        return xuanZeFangShi;
    }

    public void setXuanZeFangShi(int xuanZeFangShi) {
        this.xuanZeFangShi = xuanZeFangShi;
    }
    
    

    public int getXunJianShunXu() {
        return xunJianShunXu;
    }

    public void setXunJianShunXu(int xunJianShunXu) {
        this.xunJianShunXu = xunJianShunXu;
    }
    
    

    public int getBoDongShangXian() {
        return boDongShangXian;
    }

    public void setBoDongShangXian(int boDongShangXian) {
        this.boDongShangXian = boDongShangXian;
    }

    public int getBoDongXiaXian() {
        return boDongXiaXian;
    }

    public void setBoDongXiaXian(int boDongXiaXian) {
        this.boDongXiaXian = boDongXiaXian;
    }

    public String getXiangMuShuoMing() {
        return xiangMuShuoMing;
    }

    public void setXiangMuShuoMing(String xiangMuShuoMing) {
        this.xiangMuShuoMing = xiangMuShuoMing;
    }
    
    

    public int getXunJianDianId() {
        return xunJianDianId;
    }

    public void setXunJianDianId(int xunJianDianId) {
        this.xunJianDianId = xunJianDianId;
    }
    
    

    public String getGuZhangId() {
        return guZhangId;
    }

    public void setGuZhangId(String guZhangId) {
        this.guZhangId = guZhangId;
    }

    public ArrayList getGuZhangJiHe() {
        return guZhangJiHe;
    }

    public void setGuZhangJiHe(ArrayList guZhangJiHe) {
        this.guZhangJiHe = guZhangJiHe;
    }


    
   

    public GuZhangShiLi getGuZhangShiLi() {
        return guZhangShiLi;
    }

    public void setGuZhangShiLi(GuZhangShiLi guZhangShiLi) {
        this.guZhangShiLi = guZhangShiLi;
    }

    public Long getXiangMuId() {
        return xiangMuId;
    }

    public void setXiangMuId(Long xiangMuId) {
        this.xiangMuId = xiangMuId;
    }
    

    public List<LTEquipErrorMessage> getErrorMessageList() {
        return errorMessageList;
    }

    public void setErrorMessageList(List<LTEquipErrorMessage> errorMessageList) {
        this.errorMessageList = errorMessageList;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public int getXuanZe() {
        return xuanZe;
    }

    public void setXuanZe(int xuanZe) {
        this.xuanZe = xuanZe;
    }
    
    

    public SysRoutingInspectionItems getExamine() {
        return examine;
    }

    public void setExamine(SysRoutingInspectionItems examine) {
        this.examine = examine;
    }
    
    

    public LTEquipBasic getSelectedEquipBasic() {
        return selectedEquipBasic;
    }

    public void setSelectedEquipBasic(LTEquipBasic selectedEquipBasic) {
        this.selectedEquipBasic = selectedEquipBasic;
    }

    public List<LTEquipBasic> getEquipBasicList() {
        return equipBasicList;
    }

    public void setEquipBasicList(List<LTEquipBasic> equipBasicList) {
        this.equipBasicList = equipBasicList;
    }

    public LTEquipBasic getEquipBasic() {
        return equipBasic;
    }

    public void setEquipBasic(LTEquipBasic equipBasic) {
        this.equipBasic = equipBasic;
    }

    public List<LTEquipCheckPoint> getSelectedCheckPointList() {
        return selectedCheckPointList;
    }

    public void setSelectedCheckPointList(List<LTEquipCheckPoint> selectedCheckPointList) {
        this.selectedCheckPointList = selectedCheckPointList;
    }

   

    public boolean isIfShowBoDong() {
        return ifShowBoDong;
    }

    public void setIfShowBoDong(boolean ifShowBoDong) {
        this.ifShowBoDong = ifShowBoDong;
    }

    public boolean isIfShowError() {
        return ifShowError;
    }

    public void setIfShowError(boolean ifShowError) {
        this.ifShowError = ifShowError;
    }

    public SysRoutingInspectionItems getItemInEdit() {
        return itemInEdit;
    }

    public void setItemInEdit(SysRoutingInspectionItems itemInEdit) {
        this.itemInEdit = itemInEdit;
    }

    public List<SysRoutingInspectionItems> getItemList() {
        return itemList;
    }

    public void setItemList(List<SysRoutingInspectionItems> itemList) {
        this.itemList = itemList;
    }

    public LTEquipCheckPoint getSelectedCheckPoint() {
        return selectedCheckPoint;
    }

    public void setSelectedCheckPoint(LTEquipCheckPoint selectedCheckPoint) {
        this.selectedCheckPoint = selectedCheckPoint;
    }

    public TreeNode getEquipTreeRoot() {
        return equipTreeRoot;
    }

    public void setEquipTreeRoot(TreeNode equipTreeRoot) {
        this.equipTreeRoot = equipTreeRoot;
    }

}
