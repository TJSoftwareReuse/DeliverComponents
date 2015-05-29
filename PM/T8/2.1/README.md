#Performance Management
负责人 丁宇笙 QQ916189241  手机18817876233 欢迎骚扰
##请使用lastest_version文件夹下的jar文件
##项目说明：

1. 所有方法均为静态方法，无需实例化对象。
2. 发送PM消息请调用  `void sendPMMessage(String name,int value)` 方法,不支持其他格式其他类型的PM消息
    * value>0且value<MAX_int
3. 若不指定存储目录，日志文件默认存储到项目文件夹的LOG文件夹，若用`void setPathName(String name)`设置目录，则存储到指定目录下。
4. 若不指定时间间隔，默认一分钟存储一次，若需要调整存储时间周期，则调用`void setPeriod(int period)`修改时间周期，默认单位为分钟，若需要使用不同的时间间隔单位则调用`void setPeriod(int period, TimeUnit periodUnit)`。
5. 每接受一条消息,都会将该时间周期内收到的**所有消息**输出到指定目录下,若起止时间是同一天则以`yyyy-MM-dd HH-mm-ss to HH-mm-ss`命名该文件，若起止时间不是同一天则以`yyyy-MM-dd HH-mm-ss to yyyy-MM-dd HH-mm-ss`命名该文件。
    * 如2015年4月28日19时33分30秒发送的消息,将会保存在 "项目路径\LOG\2015-04-24 19-33-30 to 19-34-30"文件中
    * 输出格式  每行一个不同类型的消息    name:value
    * 如果该文件已存在，将会覆盖该文件中的内容
6. 如果该周期内没有收到任何消息,将不会建立该周期所对应的log文件
7. 若一个时间周期未结束就对时间周期做出了修改，且该周期内有数据产生，则新的修改会在当前时间周期结束后生效。若修改前该周期无数据产生，则接上一周期结束时间立即生效。
7. 支持多线程
8. 该类中还提供其他几个方法,他们是为了提高测试人员进行测试使用的。不建议使用该模块的时候进行调用。
9. 该类中的其他方法将在java doc中进行描述,详情请查看java doc开发文档

##使用说明：

1. 下载jar包
2. 在项目中添加jar包 ->Add External JARs
3. 开始项目

##代码介绍

使用语句 ：PM.sendPMMessage(String name,int value);即可发送相关消息


##使用示例：

``` java

import com.team8.PerformanceManagement.PM;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PM.sendPMMessage("First Message", 10);
		PM.sendPMMessage("First Message", 3);
		PM.sendPMMessage("Second Message", 5);
		PM.sendPMMessage("Third Message", 8);
		PM.sendPMMessage("Second Message", 5);
		PM.sendPMMessage("First Message", 5);
		PM.sendPMMessage("Second Message", 5);
		//修改存储相对路径
		PM.setPathName("test/log");
		//修改存储绝对路径
		PM.setPathName("F:\\github\\eclipse\\fenyinLearning\\android-swipelistview-master");   
		//修改间隔时间到30s
		PM.setPeriod(30,TimeUnit.SECONDS);
		//修改时间间隔到5min
		PM.setPeriod(5);

		
	}

}

```

输出结果：

``` 
First Message:18
Third Message:8
Second Message:15


```



##Release Notes

###v1.1
由于需要更改文件路径，所以添加了两个功能

1. PM.setPathName("newFilePath"); 设置新的文件路径
	* 文件路径必须是已经存在的文件 可以是绝对路径，也可以是相对路径
	* 允许最后一级文件夹不存在，程序只会自动创建最后一级的文件
	* 文件路径不能为空，否则设置无效
	* 默认路径是    "项目路径\LOG\"

2. PM.getPathName()
	* 获得目前文件路径
	* 实际上是调用setPathName时输入的数据
	

======
###v1.2
* 修复类unix系统文件路径识别错误的问题（感谢 @王笑盈 同学为我们提供的bug信息）

======
###v2.0
* 新增对输出时间周期的设置功能
* 支持动态修改输出时间周期
* 支持动态修改输出路径
* 输出性能文件名称包含起始时间和结束时间
* 对模块内部实现做出调整

======
###v2.1

* 修复无论配置如何第一个周期都为1分钟的bug


