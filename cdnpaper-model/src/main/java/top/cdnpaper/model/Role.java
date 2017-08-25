package top.cdnpaper.model;

/**
 * @author JiangSiying E-mail:1036539739@qq.com
 * @version 创建时间：2017年8月24日 下午5:10:36
 * @description 角色类
 */
public class Role {
	private String id; // 标识符
	private String name; // 名称
	private String description; // 描述
	private int level; // 等级（排序）

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", level=" + level + "]";
	}

}
