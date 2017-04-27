package cn.tst.sbjxzzglxt.common;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import cn.tst.sbjxzzglxt.mail.MailAuthenticator;

/**
 * 邮件处理类
 *
 * @author ps_xy@pscp.co.jp
 */
public class MailUtils {

    private final static String MAIL_CONFIG = "i18n.mail-config";
    private final static String KEY_SEND_BY = "send_by";
    private final static String KEY_FROM_ADDRESS = "from.address";          ///KEY:发件人地址(位地址,只用于先是)
    private final static String KEY_MAIL_SMTP_HOST = "mail.smtp.host";
    private final static String KEY_MAIL_SMTP_PORT = "mail.smtp.port";
    private final static String KEY_USER_NAME = "user.name";
    private final static String KEY_PASSWORD = "password";
    private final static String KEY_MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    private final static String KEY_MAIL_SMTP_AUTH = "mail.smtp.auth";

    /**
     * 新用户创建后的邮件
     *
     * @param toAddress 目标对象邮箱地址
     * @param loginId 登录用ID
     * @param receiverName 接受者用户名
     * @param generatedPassword 生成的密码
     * @return
     */
    public static boolean sendCreateNewLoginUser(String toAddress,
        String loginId,
        String receiverName,
        String generatedPassword) {

        return MailUtils.sendMail(SepE.MailType.CREATE_NEW_LOGIN_USER,
            toAddress, receiverName, loginId, generatedPassword);
    }

    /**
     * 重置密码后的邮件
     *
     * @param toAddress 目标对象邮箱地址
     * @param loginId 登录用ID
     * @param receiverName 接受者用户名
     * @param generatedPassword 生成的密码
     * @return
     */
    public static boolean sendResetPassword(String toAddress,
        String receiverName,
        String generatedPassword) {

        return MailUtils.sendMail(SepE.MailType.RESET_PASSWORD,
            toAddress, receiverName, generatedPassword);
    }

    /**
     * 发送邮件
     *
     * @param type 邮件类型
     * @param toAddress 收件地址
     * @param content 邮件内容(替换内容)
     * @return true: 发送成功 false:发送失败
     */
    public static boolean sendMail(SepE.MailType type, String toAddress, Object... content) {

        ///获取邮件配置信息
        final ResourceBundle bundle = ResourceBundle.getBundle(MailUtils.MAIL_CONFIG);

        String mailSubject = "系统邮件";
        String mailContent = "";

        ///根据邮件类型判断主体与内容文本
        switch (type) {
            case CREATE_NEW_LOGIN_USER:
                mailSubject = bundle.getString("mail.create.newuser.subject");
                mailContent = MessageFormat.format(bundle.getString("mail.create.newuser.content"), content);
                break;
            case RESET_PASSWORD:
                mailSubject = bundle.getString("mail.reset.password.subject");
                mailContent = MessageFormat.format(bundle.getString("mail.reset.password.content"), content);
                break;
            case FREE:
                mailContent = Arrays.toString(content);
                break;
        }

        ///创建邮件对象
        Properties prop = new Properties();
        ///邮件发送认证方式
        prop.put(KEY_MAIL_SMTP_STARTTLS_ENABLE, bundle.getString(KEY_MAIL_SMTP_STARTTLS_ENABLE));
        ///邮件送信服务器
        prop.put(KEY_MAIL_SMTP_HOST, bundle.getString(KEY_MAIL_SMTP_HOST));
        ///邮件送信默认端口
        prop.put(KEY_MAIL_SMTP_PORT, bundle.getString(KEY_MAIL_SMTP_PORT));
        ///是否需要认证
        prop.put(KEY_MAIL_SMTP_AUTH, "true");
        prop.put("mail.smtp.debug", true);

        ///认证信息
        MailAuthenticator authenticator
            = new MailAuthenticator(
                bundle.getString(KEY_USER_NAME),
                bundle.getString(KEY_PASSWORD));

        ///邮件会话
        Session sendMailSession = Session.getInstance(prop, authenticator);
        try {

            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);

            // 创建邮件发送者地址
            Address from = new InternetAddress(bundle.getString(KEY_FROM_ADDRESS));

            // 设置邮件消息的发送者
            mailMessage.setFrom(from);

            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(toAddress);
            mailMessage.setRecipient(Message.RecipientType.TO, to);

            // 设置邮件消息的主题
            mailMessage.setSubject(mailSubject);

            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());

            // 设置邮件消息的主要内容
            mailMessage.setText(mailContent);

            // 发送邮件
            Transport.send(mailMessage);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
