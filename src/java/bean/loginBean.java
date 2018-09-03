/*
 * 一時保管
 */
package bean;

import java.io.Serializable;

/**
 *
 * @author s20163037
 */
public class loginBean implements Serializable{
    
    private static final long serialVersionUID = 1L; // シリアルバージョンUIDのバージョン管理

	private String syainNo = null; // 社員番号
	private String syainName = null; // 社員名
	private String password = null; // パスワード
	private String role = null; // ロール名
	private boolean loginFlg = false; // ログインフラグ



	public String getSyainNo() { // 社員番号ゲッター
		return syainNo;
	}

	public void setSyainNo(String syainNo) { // 社員番号セッター
		this.syainNo = syainNo;
	}

	public String getSyainName() { // 社員名ゲッター
		return syainName;
	}

	public void setSyainName(String syainName) { // 社員名セッター
		this.syainName = syainName;
	}

	public String getPassword() { // パスワードゲッター
		return password;
	}

	public void setPassword(String password) { // パスワードセッター
		this.password = password;
	}

	public String getRole() { // ロールゲッター
		return role;
	}

	public void setRole(String role) { // ロールセッター
		this.role = role;
	}

	public boolean isLoginFlg() { // ログインフラグゲッター
		return this.loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) { // ログインフラグセッター
		this.loginFlg = loginFlg;
	}


}
