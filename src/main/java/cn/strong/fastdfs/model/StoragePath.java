/**
 * 
 */
package cn.strong.fastdfs.model;


/**
 * 存储文件路径
 * 
 * @author liulongbiao
 *
 */
public class StoragePath {

	public static final char SEPARATER = '/';

	public final String group;
	public final String path;

	public StoragePath(String group, String path) {
		this.group = group;
		this.path = path;
	}

	@Override
	public String toString() {
		return group + SEPARATER + path;
	}

	/**
	 * 从全路径构造存储路径
	 * 
	 * @param fullPath
	 * @return
	 */
	public static StoragePath valueOf(String fullPath) {
		if (fullPath == null || fullPath.length() == 0) {
			throw new IllegalArgumentException("fullPath should not be empty.");
		}
		int idx = fullPath.indexOf(SEPARATER);
		if (idx < 0) {
			throw new IllegalArgumentException(
					"fullPath cannot find path separater.");
		}
		String group = fullPath.substring(0, idx);
		String path = fullPath.substring(idx + 1);
		return new StoragePath(group, path);
	}
}
