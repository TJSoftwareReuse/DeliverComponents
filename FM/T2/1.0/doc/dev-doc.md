# Failure Management 开发文档

### 功能说明
1. 接收应用程序的告警信息
2. 输出告警信息到一个单独的告警文件
   
### 使用说明
1. 参数说明
	* 默认错误信息会输入到log.out文件，输出格式为“YYYY-MM-DD HH:mm:ss 错误名称 错误信息”。
	* 错误名称有DEBUG ERROR FATAL INFO 和 WARN 分别对应FailureManager.java中的五个log4j实现的函数——logDebug(String log)，logError(String log)，logFatal(String log)，logInfo(String log)和logWarn(String log)。
	* 用户可以通过resetOutputFile(String file)函数修改报错信息的输出文件路径，修改成功会返回True，失败返回False。
2. 输入输出
	* 输入：无需输入
	* 输出：将在默认路径下自动生成“log.out”文件，该文件将生成所有告警信息的报告时间以及具体报告内容，
         格式为“YYYY-MM-DD HH:mm:ss 错误名称 错误信息”。
         
   
### 系统设计概述
1. FailureManager.java
   该模块为程序的核心模块，利用输入流读入应用程序告警信息，再利用输出流将告警信息以及告警时间录入到告警日志中。

2. FailureManagerTest.java
   采用Junit进行测试，针对FailureManager.java中的5个错误输出函数进行测试，读取错误日志的最新生成信息，并与预期
   输出用 assertEquals(expResult==result,1);进行验证。
   
### 运行环境说明

1. 操作系统： Windows7及以上
2. 测试支持软件：JUNIT测试工具
   
### 输出实例
   
```
2015-04-30 16:02:36 DEBUG here is a debug
2015-04-30 16:02:36 ERROR here is an error
2015-04-30 16:02:36 INFO here is an info
2015-04-30 16:02:36 FATAL here is a fatal
2015-04-30 16:02:36 WARN here is a warning
```




