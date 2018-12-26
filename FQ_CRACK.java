
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 修改飞秋。其实可以修改任何没有经过压缩的文件或程序
 * 编译本代码，然后把飞秋程序复制到同一目录，并且更名为4.exe，然后运行本程序
 * @author 71934
 *
 */
 
 
 
public class Tools1 {
	public static void main(String[] args) {
		try {
			go("自己", "大神");
			//这样，当你打开修改后的飞秋的时候你会发现“自己”分组变成“大神”分组了
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	private static void go(String lodField,String newField) throws IOException{
		// TODO 自动生成的方法存根
		byte[] feiQiu = new byte[1024*64];		//64K的对比空间
		FileInputStream in = new FileInputStream(new File("4.exe"));
		FileOutputStream out = new FileOutputStream(new File("5.exe"));
		String title = lodField;		//飞秋(FeiQ) 2013 正式版
		for (int i = in.read(feiQiu, 0, feiQiu.length); i > 0; i = in.read(feiQiu, 0, feiQiu.length)) {
			String temp = new String(feiQiu);
			if(temp.contains(title)){
				//锁定二进制位置
				int head = temp.indexOf(title);
				int foot = title.length();
				//字节提取
				ArrayList<Byte> headlist = new ArrayList<>();
				for(int j = 0 ; j < head ; j++){
					//X
					headlist.add(feiQiu[j]);
				}
				byte[] newtitle = newField.getBytes();
				for(int j = 0 ; j < foot ; j++){
					//Y
					headlist.add(newtitle[j]);
				}
				for(int j = head+foot ; j < feiQiu.length ; j++){
					//Z
					headlist.add(feiQiu[j]);
				}
				//移花接木
				for(int j = 0 ; j < headlist.size() ; j++){
					out.write(headlist.get(j));
				}
				
				System.out.println("找到1项匹配，更改");
				
			}else{
				out.write(feiQiu, 0, i);
			}
			
		}
		in.close();
		out.close();
	}
}