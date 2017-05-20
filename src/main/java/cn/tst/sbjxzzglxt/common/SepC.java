package cn.tst.sbjxzzglxt.common;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 常量定义
 *
 * @author ps_xy@pscp.co.jp
 */
public final class SepC {

    /**
     * 系统ID
     */
    public static final String SYSTEM_ID = "material";
    
    public static final String PING_MIAN_TU_DIRECTORY = "pingmiantu";

    /**
     * 图片上传路径配置KEY
     */
    public static final String INIT_PARAM_UPLOAD_DIRECTORY = "uploadDirectory";
    /**
     * 设备文档上传文件夹名称
     */
    public static final String DEVICE_DOCUMENTS_DIRECTORY_NAME = "DeviceDocuments";

    /**
     * 图片上传默认文件名
     */
    public static final class UploadFileDefaultName {

        /**
         * 物资
         */
        public static final String MATERIAL = "unselect-material.svg";
        /**
         * 个人头像
         */
        public static final String PROFILE = "unselect-profile.png";
        /**
         * 合同
         */
        public static final String CONTRACT = "unselect-contract.png";
    }

    /**
     * 图片上传路径类型
     */
    public static final class UploadFileType {

        /**
         * 原始照片路径
         */
        public static final String ORIGIN = "origin";
        /**
         * 压缩后照片路径
         */
        public static final String COMPRESSION = "compression";
        /**
         * 预览用照片路径
         */
        public static final String PREVIEW = "preview";
    }

    /**
     * 图片上传分类
     */
    public static final class UploadFileCategory {

        /**
         * 物资
         */
        public static final String MATERIAL = "material";
        /**
         * 员工头像
         */
        public static final String PROFILE = "profile";
        /**
         * 合同
         */
        public static final String CONTRACT = "contract";
    }

    /**
     * 性别
     */
    public static final class Sex {

        /**
         * 男
         */
        public static final String MALE = "1";
        /**
         * 女
         */
        public static final String FEMALE = "0";
    }

    /**
     * 默认创建者ID
     */
    public static final String DEFAULT_CREATOR_ID = "EMP0000000";

    /**
     * 持久化单元名称,参考: persistence.xml
     */
    public static final String PERSISTENCE_UNIT = "PSUT_MaterialMG";

    /**
     * 持久化单元名称,参考: persistence.xml
     */
    public static final String PERSISTENCE_UNIT2 = "subdb1";

    /**
     * 常量: msgKey
     */
    public static final String S_MSG_KEY = "msgKey";

    /**
     * Format: MM-dd
     */
    public static final String FORMAT_DATE_MD = "MM-dd";

    /**
     * Format: yyyy-MM
     */
    public static final String FORMAT_DATE_YM = "yyyy-MM";

    /**
     * Format: yyyy-MM-dd
     */
    public static final String FORMAT_DATE_TYPE = "yyyy-MM-dd";

    /**
     * Format: yyyy-MM-dd :mm
     */
    public static final String FORMAT_DATETIME_TYPE = "yyyy-MM-dd HH:mm";

    /**
     * Format: yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_DATETIME2_TYPE = "yyyy-MM-dd HH:mm:ss";

    /**
     * Format: HH:mm
     */
    public static final String FORMAT_TIME_TYPE24HM = "HH:mm";

    /**
     * 数量等显示格式
     */
    public static final String FORMAT_NUMBER = "#,##0.###";

    /**
     * 正規表現：Email
     */
    public static final String REGEX_EMAIL = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

    /**
     * 模块ID常量
     */
    public static final class MoKuaiCategory {

        /**
         * 设备管理
         */
        public static final String EQP = "equipment";
        /**
         * 车辆管理
         */
        public static final String CHE_LIANG = "cheliang";
        /**
         * 能源管理
         */
        public static final String NENG_YUAN = "nengyuan";
        /**
         * 用油管理
         */
        public static final String YONG_YOU = "yongyou";
        /**
         * 用煤管理
         */
        public static final String YONG_MEI = "yongmei";
        /**
         * 委外加工管理
         */
        public static final String WEI_WAI = "weiwai";
        /**
         * 系统维护
         */
        public static final String SETTINGS = "settings";
    }

    /**
     * 菜单ID常量
     */
    public static final class MenuCategory {

        /**
         * 申请使用
         */
        public static final String BIZ = "BIZ";
        /**
         * 设备
         */
        public static final String EQP = "EQP";
        /**
         * 审核
         */
        public static final String ARP = "ARP";
        /**
         * 库存管理
         */
        public static final String INV = "INV";
        /**
         * 采购计划
         */
        public static final String SUP = "SUP";
        /**
         * 系统维护
         */
        public static final String MST = "MST";
        /**
         * 车辆管理
         */
        public static final String CAR = "CAR";
        /**
         * 用油管理
         */
        public static final String YOU = "YOU";
        /**
         * 用煤管理
         */
        public static final String MEI = "MEI";
        /**
         * 委外加工
         */
        public static final String WAI = "WAI";

        /**
         * 能源管理
         */
        public static final String MET = "MET";
    }

    /**
     * 控制器ID
     */
    public static final class ControllerID {

        /**
         * 系统登录
         */
        public static final String SYSTEM_CONFIG = "ctrlSystemConfig";

        /**
         * 登录
         */
        public static final String LOGIN = "ctrlLogin";

        /**
         * 模板页
         */
        public static final String MASTER = "ctrlMaster";

        /**
         * 菜单状态
         */
        public static final String MENU = "ctrlMenu";

        /**
         * 密码变更
         */
        public static final String CHANGE_PASSWORD = "ctrlPassChange";

        /**
         * 工作台信息
         */
        public static final String GONG_ZUO_TAI = "ctrlGongZuoTai";

        /**
         * 查看信息
         */
        public static final String CHA_KAN = "ctrlChaKan";

        /**
         * 物资申请
         */
        public static final String BIZ0001 = "ctrlBIZ0001";

        /**
         * 申请状态确认
         */
        public static final String BIZ0002 = "ctrlBIZ0002";

        /**
         * 申请历史
         */
        public static final String BIZ0003 = "ctrlBIZ0003";

        /**
         * 请求领货
         */
        public static final String BIZ0004 = "ctrlBIZ0004";

        /**
         * 归还物资
         */
        public static final String BIZ0005 = "ctrlBIZ0005";

        /**
         * 归集项统计
         */
        public static final String BIZ0006 = "ctrlBIZ0006";

        /**
         * 车辆申请
         */
        public static final String CAR0011 = "ctrlCAR0011";

        /**
         * 车辆审批
         */
        public static final String CAR0012 = "ctrlCAR0012";

        /**
         * 车辆审批历史
         */
        public static final String CAR0013 = "ctrlCAR0013";

        /**
         * 车辆维保申请
         */
        public static final String CAR0014 = "ctrlCAR0014";

        /**
         * 车辆维保申请审批
         */
        public static final String CAR0015 = "ctrlCAR0015";

        /**
         * 车辆维保申请审批履历
         */
        public static final String CAR0016 = "ctrlCAR0016";
        /**
         * 物资申请审批
         */
        public static final String ARP0001 = "ctrlARP0001";

        /**
         * 购买申请审批
         */
        public static final String ARP0002 = "ctrlARP0002";

        /**
         * 购买计划审批
         */
        public static final String ARP0003 = "ctrlARP0003";

        /**
         * 采购合同审批
         */
        public static final String ARP0004 = "ctrlARP0004";

        /**
         * 物资申请审批历史
         */
        public static final String ARP0005 = "ctrlARP0005";

        /**
         * 购买申请审批历史
         */
        public static final String ARP0006 = "ctrlARP0006";

        /**
         * 采购计划审批历史
         */
        public static final String ARP0007 = "ctrlARP0007";

        /**
         * 采购合同历史
         */
        public static final String ARP0008 = "ctrlARP0008";

        /**
         * 采购支付计划审批
         */
        public static final String ARP0009 = "ctrlARP0009";

        /**
         * 采购支付计划历史
         */
        public static final String ARP0010 = "ctrlARP0010";

        /**
         * 采购计划制定
         */
        public static final String SUP0001 = "ctrlSUP0001";

        /**
         * 采购计划调整
         */
        public static final String SUP0002 = "ctrlSUP0002";

        /**
         * 采购计划执行
         */
        public static final String SUP0003 = "ctrlSUP0003";

        /**
         * 采购范围指定
         */
        public static final String SUP0004 = "ctrlSUP0004";

        /**
         * 采购合同登记
         */
        public static final String SUP0005 = "ctrlSUP0005";

        /**
         * 采购支付计划登记
         */
        public static final String SUP0006 = "ctrlSUP0006";

        /**
         * 采购进度登记
         */
        public static final String SUP0007 = "ctrlSUP0007";

        /**
         * 物资调配
         */
        public static final String INV0001 = "ctrlINV0001";

        /**
         * 物资信息
         */
        public static final String INV0002 = "ctrlINV0002";

        /**
         * 仓库信息
         */
        public static final String INV0003 = "ctrlINV0003";

        /**
         * 物资入库
         */
        public static final String INV0004 = "ctrlINV0004";

        /**
         * 物资出库
         */
        public static final String INV0005 = "ctrlINV0005";

        /**
         * 仓储管理
         */
        public static final String INV0006 = "ctrlINV0006";

        /**
         * 物资分配
         */
        public static final String INV0007 = "ctrlINV0007";

        /**
         * 购买申请一览
         */
        public static final String INV0008 = "ctrlINV0008";

        /**
         * 物资调拨申请受理
         */
        public static final String INV0009 = "ctrlINV0009";

        /**
         * 调拨申请一览
         */
        public static final String INV0010 = "ctrlINV0010";

        /**
         * 物资申请受理
         */
        public static final String INV0011 = "ctrlINV0011";

        /**
         * 盘库
         */
        public static final String INV0012 = "ctrlINV0012";

        /**
         * 用油管理
         */
        public static final String INV0013 = "ctrlINV0013";

        /**
         * 用煤管理
         */
        public static final String INV0014 = "ctrlINV0014";

        /**
         * 仓库现状（集团用）
         */
        public static final String INV0015 = "ctrlINV0015";

        /**
         * 出库入库统计
         */
        public static final String INV0016 = "ctrlINV0016";

        /**
         * 仓管员报告
         */
        public static final String INV0017 = "ctrlINV0017";

        /**
         * 仓库信息管理
         */
        public static final String MST0001 = "ctrlMST0001";

        /**
         * 供应商信息管理
         */
        public static final String MST0002 = "ctrlMST0002";

        /**
         * 物资信息管理
         */
        public static final String MST0003 = "ctrlMST0003";

        /**
         * 员工信息管理
         */
        public static final String MST0004 = "ctrlMST0004";

        /**
         * 工程信息管理
         */
        public static final String MST0005 = "ctrlMST0005";

        /**
         * 部门信息管理
         */
        public static final String MST0006 = "ctrlMST0006";

        /**
         * 角色分配管理
         */
        public static final String MST0007 = "ctrlMST0007";

        /**
         * 供应商管理
         */
        public static final String MST0008 = "ctrlMST0008";

        /**
         * 供应商物资管理
         */
        public static final String MST0009 = "ctrlMST0009";

        /**
         * 工程项目管理
         */
        public static final String MST0010 = "ctrlMST0010";

        /**
         * 审批流程管理
         */
        public static final String MST0011 = "ctrlMST0011";

        /**
         * 物资简易登录
         */
        public static final String MST0012 = "ctrlMST0012";

        /**
         * 部门与职能管理
         */
        public static final String MST0013 = "ctrlMST0013";

        /**
         * 车辆管理
         */
        public static final String MST0014 = "ctrlMST0014";

        /**
         * 支付登记
         */
        public static final String MST0015 = "ctrlMST0015";

        /**
         * 系统设定
         */
        public static final String MST0016 = "ctrlMST0016";

        /**
         * 系统设定
         */
        public static final String MST0018 = "ctrlMST0018";

        /**
         * 系统设定
         */
        public static final String MST0019 = "ctrlMST0019";

        /**
         * 系统设定
         */
        public static final String MST0020 = "ctrlMST0020";

        /**
         * 巡检角色设置
         */
        public static final String MST0021 = "ctrlMST0021";
        /**
         * 车辆信息管理
         */
        public static final String CAR0001 = "ctrlCAR0001";

        /**
         * 用车信息管理
         */
        public static final String CAR0002 = "ctrlCAR0002";

        /**
         * 司机登记
         */
        public static final String CAR0003 = "ctrlCAR0003";

        /**
         * 用油登记
         */
        public static final String CAR0004 = "ctrlCAR0004";

        /**
         * 维修登记
         */
        public static final String CAR0005 = "ctrlCAR0005";

        /**
         * 违章登记
         */
        public static final String CAR0006 = "ctrlCAR0006";

        /**
         * 事故登记
         */
        public static final String CAR0007 = "ctrlCAR0007";

        /**
         * 保险登记
         */
        public static final String CAR0008 = "ctrlCAR0008";

        /**
         * 保养登记
         */
        public static final String CAR0009 = "ctrlCAR0009";

        /**
         * 用车统计
         */
        public static final String CAR0010 = "ctrlCAR0010";

        /**
         * 车辆年检
         */
        public static final String CAR0017 = "ctrlCAR0017";

        /**
         * 车辆计划
         */
        public static final String CAR0018 = "ctrlCAR0018";

        /**
         * 委外加工登记
         */
        public static final String WAI0001 = "ctrlWAI0001";

        /**
         * 委外加工管理
         */
        public static final String WAI0002 = "ctrlWAI0002";

        /**
         * 物料清单登记
         */
        public static final String WAI0003 = "ctrlWAI0003";

        /**
         * 抄表管理
         */
        public static final String MET0001 = "ctrlMET0001";

        /**
         * 抄表月报表
         */
        public static final String MET0002 = "ctrlMET0002";

        public static final String EQP0001 = "ctrlEQP0001";

        public static final String EQP0002 = "ctrlEQP0002";

        public static final String EQP0005 = "ctrlEQP0005";

        public static final String EQP0006 = "ctrlEQP0006";

        public static final String EQP0004 = "ctrlEQP0004";

        public static final String EQP0007 = "ctrlEQP0007";

        /**
         * 巡检管理
         */
        public static final String XUN_JIAN_XIN_XI_JI_LU_CONTROLLER_NAME = "XunJianXinXiJiLuController";
        public static final String XUN_JIAN_DIAN_SHE_ZHI_CONTROLLER_NAME = "XunJianDianSheZhiController";
        public static final String XUN_JIAN_XIANG_MU_CONTROLLER_NAME = "XunJianXiangMuController";
        public static final String XUN_JIAN_XIANG_MU_WEN_TI_CONTROLLER_NAME = "XunJianXiangMuWenTiController";
        public static final String LU_RU_XUN_JIAN_JIE_GUO_CONTROLLER_NAME = "LuRuXunJianJieGuoController";
        public static final String XUN_JIAN_JUE_SE_GUAN_LI_CONTROLLER_NAME = "XunJianJueSeGuanLiController";
    }

    /**
     * 品类关系根元素Code
     */
    public static final String PIN_LEI_GUAN_XI_ROOT = "GL0000000001";

    /**
     * 设备根元素Code
     */
    public static final String EQP_ROOT = "0";

    /**
     * 分类：油 用于车辆
     */
    public static final String FEN_LEI_YOU_ID = "PL00000001";

    /**
     * 分类：煤
     */
    public static final String FEN_LEI_MEI_ID = "PL00000002";

    /**
     * 油卡所在仓库
     */
    public static final String YOU_KA_CANG_KU = "CK000001";

    /**
     * 油卡物资ID
     */
    public static final String YOU_KA_WU_ZI_ID = "BH0000000001";

    /**
     * 综合仓库ID
     */
    public static final String ZONG_HE_CANG_KU_ID = "CK000001";

    /**
     * 物资调配状态：等待入库 (购买完成，等待入库)
     */
    public static final int STATUS_WUZISHENQING_DENGDAIRUKU = 14;

    /**
     * 物资调配状态：调拨申请中 (物资已申请调拨，等待出库)
     */
    public static final int STATUS_WUZIDIAOBO_SHENGQINGZHONG = 0;

    /**
     * 物资调配状态：调拨申请出库 (物资调拨申请，已出库，等待入库)
     */
    public static final int STATUS_WUZIDIAOBO_CHUKUZHONG = 1;

    /**
     * 物资调配状态：调拨申请入库 (物资调拨申请，已入库)
     */
    public static final int STATUS_WUZIDIAOBO_RUKU = 2;

    //すべて倉庫を選択するときLISTのIDに関するVALUE
    public static final String SUO_YOU_CANG_KU = "suoyoucangku";

    // 登录错误次数限制
    public static final int MAX_ERROR_LOGIN_COUNT = 3;

    /**
     * 全部選択
     */
    public static final String QUAN_XIANG = "all";
    /**
     * 全部選択
     */
    public static final Integer QUAN_BU = 10;

    /**
     * 空選
     */
    public static final String KONG_XIANG = "empty";

    /**
     * 默认供应商
     */
    public static final String MO_REN_GONGYINGSHANG = "GYS00000";

    /**
     * 列挙特性は列挙です
     */
    public static final String LIE_JU_XING = "1";

    /**
     * 基層、底層、0から
     */
    public static final int JI_CENG = 0;

    /**
     * 第一層
     */
    public static final int DI_YI_CENG = 1;

    /**
     * 新規
     */
    public static final int XIN_GUI = 1;

    /**
     * 追加
     */
    public static final int ZHUI_JIA = 2;

    /**
     * 刪除
     */
    public static final int SHAN_CHU = 3;

    /**
     * 常量:属性列举类型
     */
    public static final class ShuXingLieJuLeiXing {

        /**
         * 可数
         */
        public final static String KESHU = "0";
        /**
         * 列举
         */
        public final static String LIEJU = "1";
        /**
         * 描述性
         */
        public final static String MIAOSHU = "2";
    }

    /**
     * 常量:购买方式Code
     */
    public static final class GouMaiFangShi {

        /**
         * 厂家订购
         */
        public final static int CHANGJIA = 1;
        /**
         * 网购
         */
        public final static int WANGGOU = 2;
        /**
         * 商店购买
         */
        public final static int SHANGDIAN = 3;
    }

    /**
     * 默认采购周期（天）
     */
    public static final int CAI_GOU_ZHOU_QI = 15;

    /**
     * 默认最小单位
     */
    public static final BigDecimal WU_ZI_ZUI_XIAO_DAN_WEI = BigDecimal.ONE;

    /**
     * 三年的毫秒数
     */
    public static final long DATE_SAN_NIAN = 3 * 365 * 24 * 60 * 60 * 1000;

    /**
     * 员工默认初始密码（暂定）
     */
    public static final String DEFAULT_LOGIN_PASSWORD = "123456";

    /**
     * 正则常量
     */
    public static final class Regex {

        /**
         * 手机号码1
         */
        public static final String MOBILE_PATTERN1 = "^(\\d{3})(\\d{4})(\\d{4})$";
        /**
         * 手机号码2
         */
        public static final String MOBILE_PATTERN2 = "^(\\d{2})(\\d{4})(\\d{4})$";
        /**
         * 座机号码
         */
        public static final String MOBILE_PATTERN3 = "^(\\d{4})(\\d{4})$";
        /**
         * 邮编号码
         */
        public static final String ZIP_PATTERN = "^(\\d{3})(\\d{3})$";
        /**
         * 数字
         */
        public static final String NUMBER_ONLY_PATTERN = "^\\d+$";
        /**
         * 小数
         */
        public static final String FLOAT_NUMER_PATTERN = "^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$";
        /**
         * 邮箱地址
         */
        public static final String EMAIL_PATTERN = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    }

    /**
     * 错误页面
     */
    public static final class ErrorPagePathConst {

        /**
         * 404（页面不存在）
         */
        public static final String CODE_404 = "views/error/404.xhtml";

        /**
         * 403（没有访问权限）
         */
        public static final String CODE_403 = "views/error/403.xhtml";

        /**
         * 500（服务器内部错误）
         */
        public static final String CODE_500 = "views/error/500.xhtml";
    }

    /**
     * 购买方式
     */
    public static final class GouMaiFangShiConst {

        /**
         * 厂家订购
         */
        public static final int DING_GOU = 1;
        /**
         * 网购
         */
        public static final int WANG_GOU = 2;
        /**
         * 商店购买
         */
        public static final int SHANG_GOU = 3;
    }

    /**
     * 员工角色
     */
    public static final class yuanGongRole {

        /**
         * 采购员
         */
        public static final String CAI_GOU_YUAN = "RL000007";
    }

    /**
     * 默认供应商
     */
    public static final class DEFAULT_GONG_YING_SHANG {

        /// 默认供应商ID
        public static final String ID = "GYS00000";
        /// 默认供应商名
        public static final String GONG_SI_MING = "默认供应商";
    }

    public static final int AUTO_COMPLETE_MAX_RESULTS = 10;
}
