package top.cdnpaper.model;

import java.util.Date;

/**
 * @author JiangSiying E-mail:1036539739@qq.com
 * @version 创建时间：2017年8月24日 下午5:12:31
 * @description 用户类
 */
public class User {
	private String id; // 标识符
	private String name; // 昵称
	private String phone; // 手机号码
	private String password; // 密码
	private boolean gender; // 性别
	private String email; // 邮箱
	private Date regTime; // 注册时间
	private boolean verify; // 是否激活
	private boolean visible; // 是否可见
	private boolean isTeacher; // 是否教师
	private String roleId; // 角色id

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public boolean isVerify() {
		return verify;
	}

	public void setVerify(boolean verify) {
		this.verify = verify;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isTeacher() {
		return isTeacher;
	}

	public void setTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", password=" + password + ", gender="
				+ gender + ", email=" + email + ", regTime=" + regTime + ", verify=" + verify + ", visible=" + visible
				+ ", isTeacher=" + isTeacher + ", roleId=" + roleId + "]";
	}

}
