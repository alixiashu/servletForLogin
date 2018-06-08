# servletForLogin
java EE : Login implement with httpServlet

## cn.alixia.domain
定义用户类User
## cn.alixia.servlet
### QuickStartServlet.java
测试Servlet的生命周期<br />
* 1、对象创建(默认第一次访问servlet)的时候执行init(...)
* 2、每次请求都会执行service（...)
* 3、servlet销毁(服务器关闭)的时候执行destory()
### QuickStartServlet2.java
HttpServlet模板
### LoginServlet.java
功能实现：<br />
1、完成用户登录功能<br />
2、记录成功登录系统的人次
#### 登录功能
* 1、通过request获得用户名密码
* 2、数据库校验(DButils + C3P0连接池（p.s.在/src文件下进行xml文件配置）)
* 3、返回结果不为空即登录成功
#### 记录人数功能
* 1、在init()函数里，this.getServletContext().setAttribute("count", 0);
* 2、登录成功的情况下：
  *   i) 取出count，并+1；
  *  ii) 输出人数；
  * iii) 存入Context count的值：this.getServletContext().setAttribute("count", count);
## cn.alixia.utils
### DataSourceUtils.java 
数据库连接池封装类

## 注意：访问登录页面时访问login.html而不是login；
## 每一个访问页面都对应一个servlet；
### 应用<web.xml>没有定义.html文件对应的servlet，会使用tomcat全局定义的一个servlet对login.html进行显示；在点击提交以后，会跳转到login界面；login根据<web.xml>定义连接到LoginServlet，对数据进行验证并对应输出。
