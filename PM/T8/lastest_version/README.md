#请使用lastest_version文件夹下的jar文件
##负责人 丁宇笙 QQ916189241  手机18817876233 欢迎骚扰
##项目说明：

### 貌似需要更改文件路径，所以添加了两个功能
1. 功能1 PM.setPathName("newFilePath"); 设置新的文件路径
	* 文件路径必须是已经存在的文件 可以是绝对路径，也可以是相对路径
	* 允许最后一级文件夹不存在，程序只会自动创建最后一级的文件
	* 文件路径不能为空，否则设置无效
	* 默认路径是    "项目路径\LOG\"
2. 功能2 PM.getPathName()
	* 获得目前文件路径
	* 实际上是调用setPathName时输入的数据
	

##使用示例：

``` java

import com.team8.PerformanceManagement.PM;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PM.setPathName("newFile");  //相对路径
		PM.sendPMMessage("message", 11);   
		PM.setPathName("F:\\github\\eclipse\\fenyinLearning\\android-swipelistview-master");   //绝对路径
		PM.sendPMMessage("message", 11);
		System.out.println(PM.getPathName());
		
	}
}

```


###Console输出结果：

F:\github\eclipse\fenyinLearning\android-swipelistview-master


