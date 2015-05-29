#About FM2.1

用FM2.1，不要用2.0嗷嗷嗷


#FM2.1 说明文档

##实现
<code>
log4j.rootLogger = DEBUG, FILE
</code>

<code>
log4j.appender.FILE=org.apache.log4j.DailyRollingFileAppender
</code>

<code>
log4j.appender.FILE.File=D:/softwareReuse/FMlogs/app.log
</code>

<code>
log4j.appender.file.datePattern=’.'yyyy-MM-dd-HH-mm-SS
</code>

<code>
log4j.appender.FILE.layout=org.apache.log4j.PatternLayout
</code>

<code>
log4j.appender.FILE.layout.conversionPattern=%d{YYYY-MM-DD HH:mm:ss} %p %m%n
</code>

用log4j.appender.FILE=org.apache.log4j.DailyRollingFileAppender，以及log4j.appender.file.datePattern=’.'yyyy-MM-dd-HH-mm-SS实现每秒检查一次

##改了log文件的输出地址，然后把propertie文件放在了根目录下

