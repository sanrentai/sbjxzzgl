package cn.tst.sbjxzzglxt.common;

/**
 * 常用字符串常量
 *
 * @author ps_xy@pscp.co.jp
 */
public class CConst {

    /**
     * 文字列:\
     */
    public static final String BACKSLASH = "\\";
    /**
     * 文字列:/
     */
    public static final String SLASH = "/";
    /**
     * 文字列:[改行コード]
     */
    public static final String LINEBREAK = "\n";
    /**
     * 文字列:'
     */
    public static final String QUOTATION = "'";
    /**
     * 文字列:"
     */
    public static final String D_QUOTATION = "\"";
    /**
     * 文字列:%
     */
    public static final String PERCENT = "%";
    /**
     * 文字列:,
     */
    public static final String COMMA = ",";
    /**
     * 文字列:.
     */
    public static final String DOT = ".";
    /**
     * 文字列:[空文字]
     */
    public static final String BLANK = "";
    /**
     * 文字列:[半角スペース]
     */
    public static final String SPACE = " ";
    /**
     * 文字列: &
     */
    public static final String AND = "&";
    /**
     * 文字列: =
     */
    public static final String EQU = "=";
    /**
     * 文字列: ?
     */
    public static final String QUS = "?";
    /**
     * 文字列:[全角スペース]
     */
    public static final String SPACE_Z = "　";
    /**
     * 文字列: {
     */
    public static final String L_BRACES = "{";
    /**
     * 文字列: }
     */
    public static final String R_BRACES = "}";
    /**
     * 文字列: #
     */
    public static final String SHARP = "#";
    /**
     * 文字列: !
     */
    public static final String EXCLAMATION = "!";
    /**
     * 文字列: *
     */
    public static final String ASTERISK = "*";
    /**
     * 文字列: ~
     */
    public static final String TILDE = "~";
    /**
     * 文字列: >
     */
    public static final String GT = ">";
    /**
     * 文字列: <
     */
    public static final String LT = "<";
    /**
     * 文字列: -
     */
    public static final String HYPHEN = "-";
    /**
     * 文字列: [:]
     */
    public static final String CORON = ":";
    /**
     * 文字列: [
     */
    public static final String L_SQ_BCT = "[";
    /**
     * 文字列: ]
     */
    public static final String R_SQ_BCT = "]";
    /**
     * 文字列: _
     */
    public static final String UNDERBAR = "_";
    /**
     * 文字列: |
     */
    public static final String PIPE = "|";

    /**
     * 自動採用番号エンティティクラス一覧
     */
    public static final String[][] AUTO_ID_ENTITY = new String[][]{
        //        {"DatDiaoBoMingXi", "DBMX", "11"},
        //        {"MstPinLeiSuoShuGuanXi", "GL", "10"},
        //        {"DatFenPeiMingXi", "FPMX", "11"},
        //        {"DatChuKuLuLi", "CKH", "9"},
        //        {"DatDiaoBoLuLi", "DBO", "9"},
        //        {"DatGouMaiJiHuaLuLi", "GMJH", "12"},
        //        {"DatGouMaiShenQingLuLi", "GMS", "13"},
        //        {"DatRuKuLuLi", "RKL", "9"},
        //        {"DatWuZiShenQingLuLi", "SQL", "12"},
        //        {"DatFenPeiLuLi", "FPL", "9"},
        //        {"DatChuKuShenQingLuLi", "CKSQLL", "9"},
        //        {"DatRuKuShenQingLuLi", "RKSQLL", "9"},

        {"DatDiaoBoMingXi", "DBMX", "6"},
        {"MstPinLeiSuoShuGuanXi", "GL", "10"},
        {"DatFenPeiMingXi", "FPMX", "7"},
        {"DatChuKuLuLi", "CKH", "6"},
        {"DatDiaoBoLuLi", "DBO", "6"},
        {"DatFenPeiLuLi", "FPL", "6"},
        {"DatGouMaiJiHuaLuLi", "GMJH", "6"},
        {"DatGouMaiShenQingLuLi", "GMS", "6"},
        {"DatRuKuLuLi", "RKL", "6"},
        {"DatWuZiShenQingLuLi", "SQL", "6"},
        {"DatChuKuShenQingLuLi", "CKSQLL", "6"},
        {"DatRuKuShenQingLuLi", "RKSQLL", "6"},
        
        {"DatWeiWaiJiaGong", "WWJG", "6"},
        {"DatWeiWaiJiaGong", "WWJG", "6"},
        {"DatWeiWaiJiaGong", "WWJG", "6"},
        {"MstYouKa", "YK", "2"},
        {"DatYongChe", "YC", "6"},
        {"DatYongCheShenQing", "YCSQ", "6"},
        {"DatYongCheShenQingMingXi", "YCSQMX", "6"},
        {"MstShenPiLiuChengXiangXi", "LCXX", "6"},
        {"MstRoleInfo", "RL", "6"},
        {"DatPanKuLuLi", "PKLL", "4"},
        {"DatPanKuMingXi", "PKMX", "8"},
        {"MstPinLeiName", "PL", "8"},
        {"DatGouMaiJiHuaMingXi", "JHMX", "12"},
        {"DatGouMaiShenQingMingXi", "GSMX", "12"},
        {"DatShenQingMingXi", "SMX", "13"},
        {"MstBuMen", "BM", "6"},
        {"MstCangKu", "CK", "6"},
        {"MstGongChengXiangMu", "XM", "6"},
        {"MstGongYingShang", "GYS", "5"},
        {"MstGysFuZeRen", "FZR", "5"},
        {"MstHuoWei", "HW", "6"},
        {"MstKuFang", "KF", "6"},
        {"MstKuFangNeiBuFengQu", "KNQY", "8"},
        {"MstKuNeiHuoJia", "HJ", "8"},
        {"MstKuQu", "KQ", "8"},
        {"MstShiTiWuZiBianHao", "BH", "10"},
        {"MstShuXing", "SX", "8"},
        {"MstXiTongGongNeng", "GN", "6"},
        {"MstYuanGong", "EMP", "3"},
        {"MstZhiNeng", "ZN", "6"},
        {"MstShenPiLiuCheng", "LC", "6"},
        {"DatChuKuShenQing", "CKSQ", "10"},
        {"DatRuKuShenQing", "RKSQ", "10"},
        {"DatCaiGouHeTong", "HT", "6"},
        {"DatCaiGouZhiFu", "GZF", "6"},
        {"DatCaiGouZhiFuMingXi", "GZFMX", "7"},
        {"DatHaoYouYueBaoBiao", "HYYBB", "3"},
        {"DatHaoYouYueBaoMingXiBiao", "BBMX", "6"},
        {"DatYongYouKuCunYueBiao", "YYKC", "6"},
        {"MstCheLiang", "CL", "4"},
        {"DatCheWeiXiu", "WX", "7"},
        {"DatCheWeiZhang", "WZ", "7"},
        {"DatCheShiGu", "SG", "7"},
        {"DatCheBaoXian", "BX", "7"},
        {"DatCheBaoYang", "BY", "7"},
        {"DatCheBaoYangJiHua", "BYJH", "6"},
        {"DatCheWeiBao", "WB", "7"},
        {"DatCheWeiBaoMingXi", "WBMX", "7"},
        {"DatCheWeiBaoShenQing", "CWBSQ", "5"},
        {"DatCheWeiBaoShenQingMingXi", "CWBSQMX", "7"},
        {"DatCheWeiBaoXiaoHao", "WBXH", "7"},
        {"MstSiJi", "SJ", "7"},
        {"DatWuLiao", "WL", "7"},
        {"DatWuLiaoQingDan", "WLQD", "7"},
        {"DatCheNianJian", "CNJ", "5"},
        {"DatCheJiHua", "CJH", "5"},
        {"DatWzJinDuXiangXi", "JD", "10"},
        {"MstNyDanJia", "DJ", "4"},
        {"LTEquipBasic", "", "6"}
    };
}
