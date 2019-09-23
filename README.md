mygenerate是一个纯Java的模板服务框架，适合熟悉java开发的用户，可以自己拓展定制自己需要的模板，
用于动态生成一些固定格式的代码，脚本等等，区别于org.apache.velocity 这些框架，velocity是使用${} #来定义变量，这就导致不能使用这个框架来生成shell脚本，为了解决这个问题，我自己开发了更易用的mygenerate。他完全采用java语法，**实现原理是将方法代码块动态生成java文件，动态编译成class文件，动态执行class文件得到结果**
# 文件夹结构：
* classpath：用于存放java解释器初始化handler的目录
* lib：为框架需要的jar包，理论上只需要mygenerate.jar  其他的jar包都是运行示例需要用到的jar包。
* work：为需要替换的模板文件
# 配置
cfg.properties是一个配置，需要配置三个必要配置
工具的文件路径
BasePath=D:\\tmp\\mygenerate
代码解释器的初始化handler类全路径名
HandlerClassFullPath=cn.gameboys.test.MyGenerateHandler
debug开关
Debug=true
# 初始化类
MyGenerateHandler.java是代码解释器的初始化handler
# 启动脚本
start.bat是一个执行命令
# 约定（代码开源，这些都是可以按照自己的需求定制）
1. 模板文件必须放到work目录下，且.j结尾，解析完毕之后文件名会去掉.j
2. 代码前缀标记：<@@@@@@
3. 代码后缀标记：@@@@@@>
4. MyGenerateHandler是自己定义的解析类，如果用到了外部类，需要将jar放入lib目录下，并且需要修改start.bat将其引入classPath
## 使用：
文件中已经集成了一个使用通过数据库表来初始化一个javabean，通过数据库表来初始化sql语句两个demo
1. 需要自己创建数据库
2. 修改cfg.properties里面的配置
3. 修改db.properties数据库连接池配置
***
