
# logback

## 简介    
`logback`用于日志记录，可以将日志输出到控制台、文件、数据库和邮件。使用时需要引入`logback.xml`，配置日志信息的优先级、输出目的地、输出格式等。  

`logback`是由`log4j`创始人设计的另一个开源日志组件，目前是`SpringBoot`的默认日志实现，相比`log4j`，`logback`有以下优点：
1. 性能更好；
2. 支持运行时自动加载配置文件；
3. 自动去除旧的日志文件；  

关于`log4j`的介绍，可以参考以下链接：  
[log4j-demo](https://github.com/ZhangZiSheng001/log4j-demo)

## 使用例子
### 需求
使用`logback`将日志信息分别输出到控制台、文件、数据库。

### 工程环境
JDK：1.8.0_201  
maven：3.6.1  
IDE：Spring Tool Suites4 for Eclipse  
mysql：5.7

### 主要步骤
由于`slf4j`会自动发现并应用`logback`，所以我们只需要调用`slf4j`的方法就行了。  
1. 调用`LoggerFactory`的`getLogger`方法获得`logger`实例；
2. 利用`logger`实例打印日志，当然，前提我们需要配置好`logger`。

### 创建表
这里涉及到三个表，具体官方给出了各种数据库的sql文件。  
在这个项目的resources/script目录中也可以找到。  
`logging_event`
`logging_event_exception`
`logging_event_exception`

### 创建项目
项目类型`Maven Project`，打包方式`jar`

### 引入依赖
前面已经说过，`logback`可以搭配`slf4j`等日志门面（`Logging Facade`）一起使用。另外，为了支持将日志存储到数据库，需要引入`mysql`的驱动，如果采用`dataSource`方式还需要引入从`c3p0`（`jdbc`的话就不用）。  
```xml
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
	<scope>test</scope>
</dependency>
<!-- logback+slf4j -->
<dependency>
	<groupId>org.slf4j</groupId>
	<artifactId>slf4j-api</artifactId>
	<version>1.7.28</version>
	<type>jar</type>
	<scope>compile</scope>
</dependency>
<dependency>
	<groupId>ch.qos.logback</groupId>
	<artifactId>logback-core</artifactId>
	<version>1.2.3</version>
	<type>jar</type>
</dependency>
<dependency>
	<groupId>ch.qos.logback</groupId>
	<artifactId>logback-classic</artifactId>
	<version>1.2.3</version>
	<type>jar</type>
</dependency>
<!-- 数据库驱动开启了DBAppender才需要 -->
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>8.0.17</version>
</dependency>
<!-- 采用`dataSource`方式才需要引入c3p0 -->
<dependency>
	<groupId>com.mchange</groupId>
	<artifactId>c3p0</artifactId>
	<version>0.9.5.4</version>
</dependency>
```

### 编写logback.xml
路径：`cn.zzs.logback`  
这里配置了四种输出类型：  
1. 控制台
2. 文件，按日期和大小滚动，输出debug->error(不包含error)的信息
3. 文件，按日期和大小滚动，输出error的信息
4. 数据库（其实不建议输出到数据库的，开销太大，测试着玩就行了）  

考虑篇幅问题，这里就不放了。可以在项目中查看。另外由于使用了`c3p0`，所以记得引入`c3p0-config.xml`

### 编写测试类
路径：test目录下的`cn.zzs.logback`
```java
/**
 * @ClassName: LogbackTest
 * @Description: 测试logback
 * @author: zzs
 * @date: 2019年9月1日 下午7:18:08
 */
public class LogbackTest {
	private Logger logger = LoggerFactory.getLogger(LogbackTest.class);
	/**
	 * 测试logback
	 */
	@Test
	public void test01() {
		logger.debug("输出DEBUG级别的日志");
		logger.info("输出INFO级别的日志");
		logger.warn("输出WARN级别的日志");
		logger.error("输出ERROR级别的日志");
	}
}
```
## logback配置详解
项目中的logback.xml已经使用注释解读了。这里不再赘述。 
 
另外配置的语法和log4j差不多，也可以参考[log4j的内容](https://github.com/ZhangZiSheng001/log4j-demo)


> 学习使我快乐！！
