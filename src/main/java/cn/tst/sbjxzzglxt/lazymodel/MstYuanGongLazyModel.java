package cn.tst.sbjxzzglxt.lazymodel;

import java.util.List;
import java.util.Map;
import cn.tst.sbjxzzglxt.entity.MstYuanGong;
import cn.tst.sbjxzzglxt.service.impl.MstYuanGongFacade;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

/**
 * 员工延时加载对象
 *
 * @author ps_xy@pscp.co.jp
 */
public class MstYuanGongLazyModel extends LazyDataModel<MstYuanGong> {

    private List<MstYuanGong> dataSource;
    private final MstYuanGongFacade _yuanGongService;

    /**
     * 构造函数<br/>
     * LazyMode种无法注入,所以讲Service对象传入LazyModel中
     *
     * @param yuanGongService 员工Service
     */
    public MstYuanGongLazyModel(MstYuanGongFacade yuanGongService) {
        this._yuanGongService = yuanGongService;
    }

    @Override
    public Object getRowKey(MstYuanGong object) {
        return object.getYuanGongId();
    }

    @Override
    public MstYuanGong getRowData(String rowKey) {
        for (MstYuanGong yuanGong : dataSource) {
            if (yuanGong.getYuanGongId().equals(rowKey)) {
                return yuanGong;
            }
        }
        return null;
    }

    /**
     * 加载数据
     *
     * @param pageNo 页面No
     * @param pageSize 一页显示的行数
     * @param sortField 排序字段
     * @param sortOrder 排序条件
     * @param filters 过滤条件
     * @return 取得的数据
     */
    @Override
    public List<MstYuanGong> load(int pageNo, int pageSize, String sortField,
        SortOrder sortOrder, Map<String, Object> filters) {
        return this.load(pageNo, pageSize, null, filters);
    }

    /**
     * 加载数据
     *
     * @param pageNo 页面No
     * @param pageSize 一页显示的行数
     * @param sortField 排序字段
     * @param sortOrder 排序条件
     * @param filters 过滤条件
     * @return 取得的数据
     */
    @Override
    public List<MstYuanGong> load(int pageNo, int pageSize, List<SortMeta> multiSortMeta, Map<String, Object> filters) {

        ///品类名
        YuanGongSearchCondition condition = new YuanGongSearchCondition();

        ///设置检索条件
        Object name = filters.get("xing");
        Object email = filters.get("email");
        Object dianHua = filters.get("dianHua");
        Object address = filters.get("zhuZhi");

        condition.setEmpName(name == null ? "" : String.valueOf(name).trim());
        condition.setEmail(email == null ? "" : String.valueOf(email).trim());
        condition.setCellPhoneNumber(dianHua == null ? "" : String.valueOf(dianHua).trim());
        condition.setAddress(address == null ? "" : String.valueOf(address).trim());

        ///取得指定页面数和大小的数据
        this.dataSource = this._yuanGongService.findYuanGongLazyData(pageNo, pageSize, condition);

        ///対象件数を取得する
        this.setRowCount(this._yuanGongService.findYuanGongLazyCount(condition));

        return this.dataSource;
    }

}
