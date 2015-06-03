##告警管理（FM）复用文档

---
###目录

<br>

一、告警管理（FM）要求

二、告警管理（FM）设计

三、告警管理（FM）输入

四、告警管理（FM）输出

五、告警管理（FM）使用流程

---

###内容

<br>

**一、告警管理（FM）要求**

1. 接收应用程序的告警信息2. 输出告警信息到一个单独的告警文件
**二、告警管理（FM）设计**
1. 用户代码中调用告警构件
2. 传入告警信息，和告警文件地址
3. 将告警信息写入告警文件
4. 告警完成**三、告警管理（FM）输入**
| 名称 | 类型 | 注意事项 |
| :------:| :------: | :------: |
| 告警信息 | string | 非空 |
| 告警文件路径 | string | 非空 |

**四、告警管理（FM）输出**

| 名称 | 类型 | 注意事项 |
| :------:| :------: | :------: |
| 告警文件 | 文本文件 | ----|

**五、告警管理（FM）使用流程**

*	首先，导入告警管理（FM）构件包

```
import warning.DealWarning;

```

*	生成告警管理（FM）构件实例

```
//没有输入告警信息和告警文件地址，文件地址为默认地址："./error_yyyy_mm_dd.txt"(当前的日期)
DealWarning dealWarning = new DealWarning();

//只输入了告警信息，告警文件默认地址为"./error_yyyy_mm_dd.txt"(当前的日期)
DealWarning dealWarning = new DealWarning(warningMsg);

//输入了告警信息和告警文件地址
DealWarning dealWarning = new DealWarning(warningMsg, warningFile);

```

*	将告警信息写入告警文件

```
dealWaring.OutputInfo();

```

*	告警管理（FM）构件Log日志

```
写入告警文件成功：Console中输出：success!
写入告警文件失败：Console中输出：something wrong!

```

---

#V2.0

*	增加功能：连续多条相同的告警信息只输出一条
* 	支持使用过程中更改告警输出文件路径

**示例程序**

```java
public static void main(String[] args) {
    DealWarning warning = new DealWarning("./text");
    warning.OutputInfo("Hello");
    warning.OutputInfo("Hello");
    warning.setOutoutPath(".Hello.txt");
    warning.OutputInfo("123");
}
```