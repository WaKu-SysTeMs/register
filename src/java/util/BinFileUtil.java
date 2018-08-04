package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 * バイナリファイルの入力と出力を行うクラスメソッド<br/>
 *
 * @author takashi kawaba
 */
public class BinFileUtil {

    static final Logger log = Logger.getLogger(BinFileUtil.class.getName());

    /**
     * バイナリファイルの全内容を読みだしてバイト配列として返す<br/>
     * 使用例： byte[] img = getBinary("/resources/picture.jpg");<br/>
     *
     * @param fpath	入力元のバイナリファイルのURL<br/>
     * アプリケーションルートからの相対パスで指定する（/resources/～）
     * @return	byte[]型のバイナリデータ
     */
    public static byte[] getBinary(String fpath) {
        String filePath = getRealPath(fpath);		// 絶対パスに変換
        Path path = Paths.get(filePath);	// Pathオブジェクトを作成
        byte[] binaryData = null;
        try {
            binaryData = Files.readAllBytes(path);		// 全データを読み出す
        } catch (IOException ex) {
            log.severe("◆" + ex.toString());
        }
        return binaryData;
    }

    /**
     * バイナリデータをファイルに書き出す<br/>
     * 使用例： putBinary(data, "/resources/images/picture.jpg");<br/>
     *
     * @param binaryData 出力するbyte[]型のバイナリデータ
     * @param outFile	出力先のファイルURL<br/>
     * アプリケーションルートからの相対パスで指定する（/resources/～）
     */
    public static void putBinary(byte[] binaryData, String outFile) {
        String filePath = getRealPath(outFile);		// 絶対パスに変換
        Path path = Paths.get(filePath);		// Pathオブジェクトを作成
        try {
            Files.write(path, binaryData);					// 全データを書き出す
        } catch (IOException ex) {
            log.severe("◆" + ex.toString());
        }
    }

    /**
     * I/Oで使用する絶対パスを求める
     *
     * @param path	アプリケーションルートのリソースからの相対パス（/resources/～）
     * @return	絶対パス
     */
    public static String getRealPath(String path) {
        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        return ctx.getRealPath(path);
    }
}
