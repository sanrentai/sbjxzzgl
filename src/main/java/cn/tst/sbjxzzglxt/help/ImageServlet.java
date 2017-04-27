package cn.tst.sbjxzzglxt.help;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.tst.sbjxzzglxt.common.CConst;
import cn.tst.sbjxzzglxt.common.SepC;
import org.apache.commons.lang3.CharEncoding;

/**
 * 图片请求Sevlet <br/>
 * 图片访问路径不包含在Web工程,放在外部文件夹中
 *
 * @author andysilver
 */
@WebServlet("/uploadFiles/*")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String[] reqPath = request.getPathInfo().substring(1).split(CConst.SLASH);

        ///URL不正
        if (reqPath.length == 0) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "URL错误");
        }

        ///获取请求的文件名
        final String CATEGROY = reqPath[0];
        final String FILE_NAME = URLDecoder.decode(reqPath[1], CharEncoding.UTF_8);
        final String FROM = reqPath.length >= 3
            ? URLDecoder.decode(reqPath[2], CharEncoding.UTF_8) : "";

        ///获取临时目录
        final String FILE_UPLOAD_PATH = this.getServletContext()
            .getInitParameter(SepC.INIT_PARAM_UPLOAD_DIRECTORY) + CConst.SLASH + CATEGROY;

        ///文件类型
        String fileType = SepC.UploadFileType.COMPRESSION;
        switch (FROM) {
            case "o":
                fileType = SepC.UploadFileType.ORIGIN;
                break;
            case "p":
                fileType = SepC.UploadFileType.PREVIEW;
                break;
            case "c":
                fileType = SepC.UploadFileType.COMPRESSION;
                break;
            default:
                fileType = SepC.UploadFileType.COMPRESSION;
        }

        ///文件完整路径
        Path path = Paths.get(FILE_UPLOAD_PATH, fileType, FILE_NAME);

        ///读取文件
        File file = path.toFile();

        ///如果数据库中保存的文件名,物理上不存在着获取默认文件
        if (!file.isFile()) {
            String defaultFileName;
            switch (CATEGROY) {
                case SepC.UploadFileCategory.MATERIAL:
                    defaultFileName = SepC.UploadFileDefaultName.MATERIAL;
                    break;
                case SepC.UploadFileCategory.PROFILE:
                    defaultFileName = SepC.UploadFileDefaultName.PROFILE;
                    break;
                case SepC.UploadFileCategory.CONTRACT:
                    defaultFileName = SepC.UploadFileDefaultName.CONTRACT;
                    break;
                default:
                    defaultFileName = SepC.UploadFileDefaultName.PROFILE;
                    break;
            }
            file = new File(FILE_UPLOAD_PATH, defaultFileName);
        }

        ///返回文件流
        response.setHeader("Content-Type", getServletContext().getMimeType(FILE_NAME));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        Files.copy(file.toPath(), response.getOutputStream());
    }
}
