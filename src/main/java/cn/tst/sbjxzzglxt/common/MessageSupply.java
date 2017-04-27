package cn.tst.sbjxzzglxt.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.context.FacesContext;

/**
 * メッセージサプライヤーの使い方<br />
 * 1. サプライヤーインスタンスの取得 <br />
 *   getInstance(メッセージバンドル名) <br />
 * 2. メッセージ
 * @author PS
 */
public class MessageSupply implements Serializable {

    // メッセージ提供インスタンス
    private static Map<String, MessageSupply> MS_INSTANCE_MAP = new HashMap<>();

    // faces-config.xmlに定義された resource-bundle.var の設定値
    private final String jsfBundleName;

    /**
     * カスタムコンストラクタ
     * 
     * @param bundleName
     */
    private MessageSupply(String bundleName) {
        this.jsfBundleName = bundleName;
    }

    /**
     * 国際対応メッセージファイル毎のサプライインスタンス取得
     * @param bundleName
     * @return 
     */
    public static MessageSupply getInstance(String bundleName) {
        MessageSupply retMs = MS_INSTANCE_MAP.get(bundleName);
        if (retMs != null) {
            return retMs;
        }
        
        synchronized (MS_INSTANCE_MAP) {
            retMs = MS_INSTANCE_MAP.get(bundleName);
            if (retMs != null) {
                return retMs;
            }
            
            retMs = new MessageSupply(bundleName);
            MS_INSTANCE_MAP.put(bundleName, retMs);
        }
        return retMs;
    }

    /**
     * 言語を切り替える関数<br />
     * 中国語 (簡体)zh_CN/(繁体)zh_TW<br />
     * 英語en/フランス語fr<br />
     * ドイツ語de/イタリア語it<br />
     * 日本語ja/韓国語ko <br />
     * スペイン語es/スウェーデン語sv
     *
     * @param language 言語
     */
    public void changeLanguage(String language) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }

    /**
     * メッセージキーによりメッセージを取得する
     *
     * @param key
     * @return
     */
    public String getMessage(String key) {
        FacesContext jsfContext = FacesContext.getCurrentInstance();
        String propertyHandle = "#{" + this.jsfBundleName + "['" + key + "']}";
        String value = jsfContext.getApplication().evaluateExpressionGet(jsfContext, propertyHandle, String.class);
        return value;
    }

    /**
     * 名称パラメータが一個しかない場合のメッセージ取得
     * @param key
     * @param paramName
     * @param paramVal
     * @return 
     */
    public String getMessage(String key, String paramName, String paramVal) {
        String templateMsg = getMessage(key);
        return templateMsg.replaceAll("\\{" + key + "\\}", templateMsg);
    }
    
    /**
     * ポジションパラメータ
     * @param key
     * @param position
     * @param paramVal
     * @return 
     */
    public String getMessage(String key, int position, String paramVal) {
        return getMessage(key, "" + position, paramVal);
    }
    
    /**
     * 複数のポジションがある場合のメッセージ
     * @param key
     * @param valArray
     * @return 
     */
    public String getMessage(String key, String[] valArray) {
        String templateMsg = getMessage(key);
        int paramNum = valArray.length;
        for (int i = 0; i < paramNum; i++ ){
            templateMsg = templateMsg.replaceAll("\\{" + i + "\\}", valArray[i]);
        }
        return templateMsg;
    }    
    
     /**
     * 複数の名称パラメータがある場合のメッセージ
     * @param key
     * @param valArray
     * @return 
     */
    public String getMessage(String key, String[][] valArray) {
        String templateMsg = getMessage(key);
        int paramNum = valArray.length;
        for (int i = 0; i < paramNum; i++ ){
            templateMsg = templateMsg.replaceAll("\\{" + valArray[i][0] + "\\}", valArray[i][1]);
        }
        return templateMsg;
    }    
}
