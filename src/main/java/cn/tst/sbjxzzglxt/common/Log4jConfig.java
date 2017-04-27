package cn.tst.sbjxzzglxt.common;

import java.io.File;
import javax.faces.application.ProjectStage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

/**
 * 日志配置文件
 *
 * @author ps_xy@pscp.co.jp
 */
public class Log4jConfig extends HttpServlet {

    /**
     * 初始化日志配置
     *
     * @param config webConfig对象
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {

        ///工程阶段
        ProjectStage projectStage = FacesContext.getCurrentInstance().getApplication().getProjectStage();

        File logPropFile = null;
        ServletContext sc = config.getServletContext();

        ///Web App根目录
        final String WEB_APP_PATH = sc.getRealPath("/");

        ///Log4j配置目录
        final String LOG4J_LOCATION
            = config.getInitParameter(projectStage.equals(ProjectStage.Development)
                ? "log4j.dev.config" : "log4j.prod.config");

        ///如果找不到配置文件路劲
        if (StringUtils.isEmpty(LOG4J_LOCATION)) {
            System.out.println("★---------无法获取日志配置文件---------★");
            BasicConfigurator.configure();
        }

        ///配置文件完整路径
        final String LOG4_PROP_CONFIG = WEB_APP_PATH + LOG4J_LOCATION;

        ///读取配置文件
        logPropFile = new File(LOG4_PROP_CONFIG);

        ///如果存在
        if (logPropFile.exists()) {
            System.out.println("开始初始化日志配置: " + LOG4_PROP_CONFIG);
            PropertyConfigurator.configure(LOG4_PROP_CONFIG);
        } else {
            System.err.println("找不到文件" + LOG4_PROP_CONFIG + "使用BasicConfigurator初始化日志");
            BasicConfigurator.configure();
        }

        super.init(config);
    }

}
