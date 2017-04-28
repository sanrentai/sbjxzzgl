/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.sbjxzzglxt.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "sys_Msg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysMsg.findAll", query = "SELECT s FROM SysMsg s")
    , @NamedQuery(name = "SysMsg.findById", query = "SELECT s FROM SysMsg s WHERE s.id = :id")
    , @NamedQuery(name = "SysMsg.findByToUserName", query = "SELECT s FROM SysMsg s WHERE s.toUserName = :toUserName")
    , @NamedQuery(name = "SysMsg.findByFromUserName", query = "SELECT s FROM SysMsg s WHERE s.fromUserName = :fromUserName")
    , @NamedQuery(name = "SysMsg.findByCreateTime", query = "SELECT s FROM SysMsg s WHERE s.createTime = :createTime")
    , @NamedQuery(name = "SysMsg.findByMsgType", query = "SELECT s FROM SysMsg s WHERE s.msgType = :msgType")
    , @NamedQuery(name = "SysMsg.findByMsgId", query = "SELECT s FROM SysMsg s WHERE s.msgId = :msgId")
    , @NamedQuery(name = "SysMsg.findByContent", query = "SELECT s FROM SysMsg s WHERE s.content = :content")
    , @NamedQuery(name = "SysMsg.findByMediaId", query = "SELECT s FROM SysMsg s WHERE s.mediaId = :mediaId")
    , @NamedQuery(name = "SysMsg.findByPicUrl", query = "SELECT s FROM SysMsg s WHERE s.picUrl = :picUrl")
    , @NamedQuery(name = "SysMsg.findByFormat", query = "SELECT s FROM SysMsg s WHERE s.format = :format")
    , @NamedQuery(name = "SysMsg.findByThumbMediaId", query = "SELECT s FROM SysMsg s WHERE s.thumbMediaId = :thumbMediaId")
    , @NamedQuery(name = "SysMsg.findByLocationX", query = "SELECT s FROM SysMsg s WHERE s.locationX = :locationX")
    , @NamedQuery(name = "SysMsg.findByLocationY", query = "SELECT s FROM SysMsg s WHERE s.locationY = :locationY")
    , @NamedQuery(name = "SysMsg.findByScale", query = "SELECT s FROM SysMsg s WHERE s.scale = :scale")
    , @NamedQuery(name = "SysMsg.findByLabel", query = "SELECT s FROM SysMsg s WHERE s.label = :label")
    , @NamedQuery(name = "SysMsg.findByTitle", query = "SELECT s FROM SysMsg s WHERE s.title = :title")
    , @NamedQuery(name = "SysMsg.findByDescription", query = "SELECT s FROM SysMsg s WHERE s.description = :description")
    , @NamedQuery(name = "SysMsg.findByUrl", query = "SELECT s FROM SysMsg s WHERE s.url = :url")
    , @NamedQuery(name = "SysMsg.findByAddtime", query = "SELECT s FROM SysMsg s WHERE s.addtime = :addtime")
    , @NamedQuery(name = "SysMsg.findByBeiZhu", query = "SELECT s FROM SysMsg s WHERE s.beiZhu = :beiZhu")
    , @NamedQuery(name = "SysMsg.findByRead", query = "SELECT s FROM SysMsg s WHERE s.read = :read")
    , @NamedQuery(name = "SysMsg.findByReply", query = "SELECT s FROM SysMsg s WHERE s.reply = :reply")
    , @NamedQuery(name = "SysMsg.findByAutoReply", query = "SELECT s FROM SysMsg s WHERE s.autoReply = :autoReply")
    , @NamedQuery(name = "SysMsg.findByInsRep", query = "SELECT s FROM SysMsg s WHERE s.insRep = :insRep")
    , @NamedQuery(name = "SysMsg.findByInsDate", query = "SELECT s FROM SysMsg s WHERE s.insDate = :insDate")
    , @NamedQuery(name = "SysMsg.findByUpdRep", query = "SELECT s FROM SysMsg s WHERE s.updRep = :updRep")
    , @NamedQuery(name = "SysMsg.findByUpdDate", query = "SELECT s FROM SysMsg s WHERE s.updDate = :updDate")
    , @NamedQuery(name = "SysMsg.findByDelFlg", query = "SELECT s FROM SysMsg s WHERE s.delFlg = :delFlg")
    , @NamedQuery(name = "SysMsg.findByVersion", query = "SELECT s FROM SysMsg s WHERE s.version = :version")})
public class SysMsg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "ToUserName")
    private String toUserName;
    @Size(max = 50)
    @Column(name = "FromUserName")
    private String fromUserName;
    @Size(max = 50)
    @Column(name = "CreateTime")
    private String createTime;
    @Size(max = 50)
    @Column(name = "MsgType")
    private String msgType;
    @Size(max = 100)
    @Column(name = "MsgId")
    private String msgId;
    @Size(max = 1073741823)
    @Column(name = "Content")
    private String content;
    @Size(max = 1073741823)
    @Column(name = "MediaId")
    private String mediaId;
    @Size(max = 1073741823)
    @Column(name = "PicUrl")
    private String picUrl;
    @Size(max = 1073741823)
    @Column(name = "Format")
    private String format;
    @Size(max = 1073741823)
    @Column(name = "ThumbMediaId")
    private String thumbMediaId;
    @Size(max = 1073741823)
    @Column(name = "Location_X")
    private String locationX;
    @Size(max = 1073741823)
    @Column(name = "Location_Y")
    private String locationY;
    @Size(max = 1073741823)
    @Column(name = "Scale")
    private String scale;
    @Size(max = 1073741823)
    @Column(name = "Label")
    private String label;
    @Size(max = 1073741823)
    @Column(name = "Title")
    private String title;
    @Size(max = 1073741823)
    @Column(name = "Description")
    private String description;
    @Size(max = 1073741823)
    @Column(name = "Url")
    private String url;
    @Column(name = "Addtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addtime;
    @Size(max = 1073741823)
    @Column(name = "BeiZhu")
    private String beiZhu;
    @Column(name = "read")
    private Integer read;
    @Column(name = "reply")
    private Integer reply;
    @Column(name = "autoReply")
    private Integer autoReply;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ins_rep")
    private String insRep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ins_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "upd_rep")
    private String updRep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "upd_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "del_flg")
    private Character delFlg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private int version;

    public SysMsg() {
    }

    public SysMsg(Integer id) {
        this.id = id;
    }

    public SysMsg(Integer id, String insRep, Date insDate, String updRep, Date updDate, Character delFlg, int version) {
        this.id = id;
        this.insRep = insRep;
        this.insDate = insDate;
        this.updRep = updRep;
        this.updDate = updDate;
        this.delFlg = delFlg;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getBeiZhu() {
        return beiZhu;
    }

    public void setBeiZhu(String beiZhu) {
        this.beiZhu = beiZhu;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public Integer getReply() {
        return reply;
    }

    public void setReply(Integer reply) {
        this.reply = reply;
    }

    public Integer getAutoReply() {
        return autoReply;
    }

    public void setAutoReply(Integer autoReply) {
        this.autoReply = autoReply;
    }

    public String getInsRep() {
        return insRep;
    }

    public void setInsRep(String insRep) {
        this.insRep = insRep;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public String getUpdRep() {
        return updRep;
    }

    public void setUpdRep(String updRep) {
        this.updRep = updRep;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public Character getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Character delFlg) {
        this.delFlg = delFlg;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysMsg)) {
            return false;
        }
        SysMsg other = (SysMsg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.tst.sbjxzzglxt.entity.SysMsg[ id=" + id + " ]";
    }
    
}
