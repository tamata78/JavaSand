package file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * ファイルシステム関連のライブラリ
 *
 */
public class FileUtil {

	public static List<String> readFileBody(File file) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	/**
	 * ファイル書き込みが可能かチェックする
	 * 
	 * @param file
	 * @return true:書き込み可能、false:書き込み不可
	 */
	private static boolean checkBeforeWritefile(File file) {
		if (file.exists()) {
			if (file.isFile() && file.canWrite()) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 指定ディレクトリ内および以下のファイル、ディレクトリを削除する
	 * 
	 * @param ディレクトリパス。
	 * @return 削除に失敗したらfalse
	 */
	public static boolean clearDir(String dir) {
		return clearDir(new File(dir));
	}

	public static boolean clearDir(File dir) {
		if (!dir.exists())
			return true;
		String[] files = dir.list();
		if (files == null)
			return true;
		boolean ret = true;
		for (int i = 0; i < files.length; i++) {
			File f = new File(dir.getPath(), files[i]);
			if (f.isDirectory()) {
				clearDir(f);
			}
			if (!f.delete()) {
				// 削除失敗
				ret = false;
			}
		}
		return ret;
	}

	/**
	 * 指定されたディレクトリを削除
	 *
	 * @param dir
	 * @return
	 */
	public static boolean deledeDir(String dir) {
		File deleteDir = new File(dir);
		if (!deleteDir.exists())
			return true;
		return deleteDir.delete();
	}

	/**
	 * ファイルが存在するか
	 * 
	 * @param path
	 * @return
	 */
	public static boolean isFile(String path) {
		if (StringUtils.isEmpty(path))
			return false;
		File file = new File(path);
		return (file.exists() && file.isFile());
	}

	/**
	 * ディレクトリが存在するか
	 * 
	 * @param path
	 * @return
	 */
	public static boolean isDir(String path) {
		if (StringUtils.isEmpty(path))
			return false;
		File file = new File(path);
		return (file.exists() && file.isDirectory());
	}

	public static void delete(String path) {
		new File(path).delete();
	}

	/**
	 * ファイルの移動
	 * 
	 * @param pathFrom
	 * @param pathTo
	 * @return
	 * @throws Exception
	 */
	public static boolean mv(String pathFrom, String pathTo) throws Exception {
		File file = new File(pathFrom);
		if (!file.exists() || !file.isFile())
			return false;
		return file.renameTo(new File(pathTo));
	}

	/**
	 * ディレクトリ作成
	 * 
	 * @param path
	 * @return
	 */
	public static boolean mkdir(String path) {
		File file = new File(path);
		if (file.exists())
			return true;
		return file.mkdir();
	}

	public static boolean mkdirs(String path) {
		File file = new File(path);
		if (file.exists())
			return true;
		return file.mkdirs();
	}

	/**
	 * 指定されたディレクトリ内のファイルをファイル名順に取得
	 *
	 * @param path
	 * @return
	 */
	public static File[] fileRead(String path) {
		boolean isDir = isDir(path);
		File[] files;
		if (isDir) {
			File file = new File(path);
			files = file.listFiles();
			if (files.length > 1) {
				return fileSort(files);
			}
			return files;
		}
		return null;
	}

	/**
	 * ファイルをソート
	 *
	 * @param files
	 * @return
	 */
	public static File[] fileSort(File[] files) {
		Arrays.sort(files, new Comparator<File>() {
			public int compare(File file1, File file2) {
				return file1.getName().compareTo(file2.getName());
			}
		});
		return files;
	}

}