# Servlet
> Servlet是服务器应用小程序（是运行在 Web 服务器或应用服务器上的Java程序，为web服务器解析Java代码提供了桥梁）
- 用来完成B/S架构下，客户端请求的响应处理
- 平台独立（Java跨平台），性能优良，能够以线程方式运行
- Servlet API为Servlet提供了统一的编程接口
- Servlet一般在容器中运行，常见的Servlet容器为Tomcat。Tomcat是一种web server

> Servlet是在服务器端运行的小程序，所有的Servlet都必须实现javax.servlet。Servlet接口
- GenericServlet抽象类实现了一部分Servlet的通用方法。Servlet类的service()方法是服务器端Servlet处理客户端请求的主要逻辑
- GenericServlet的子类HttpServlet是主要用于在web服务器端运行的Servlet类
- HttpServlet的service()方法会根据情况相应调用doGet doPost doHead doPut doDelete等方法

> Servlet的生命周期
- Servlet 通过调用 init () 方法进行初始化。
  init 方法被设计成只调用一次。它在第一次创建 Servlet 时被调用，在后续每次用户请求时不再调用。因此，它是用于一次性初始化
- Servlet 调用 service() 方法来处理客户端的请求。
  service() 方法是执行实际任务的主要方法。对于HTTP请求来说，就是doGet doPost等方法
- Servlet 通过调用 destroy() 方法终止（结束）。web app退出的时候，destroy() 方法只会被调用一次，在 Servlet 生命周期结束时被调用。
- 最后，Servlet 是由 JVM 的垃圾回收器进行垃圾回收的。


# Tomcat
Tomcat 服务器是一个免费的开放源代码的Web应用服务器，可以作为jsp/servlet的容器，运行JSP 页面和Servlet
> 目录结构
- bin -- 二进制可执行的文件和脚本，包含启动和关闭的脚本
- conf -- tomcat配置文件目录，包括server.xml(Tomcat的主要配置文件)和为不同的Tomcat配置的web应用设置缺省值的文件web.xml等
- lib -- 包含Tomcat使用的jar文件.unix平台此目录下的任何文件都被加到Tomcat的classpath中
- logs -- 存放Tomcat的日志文件
- temp -- 存放一些临时文件
- webapps -- 包含web项目示例，当发布web应用时，默认情况下把web文件夹放于此目录下
- work -- Tomcat自动生成,放置Tomcat运行时的临时文件(如编译后的JSP文件).如在Tomcat运行时删除此目录.JSP页面将不能运行.[ jsp生成的sevlet放在此目录下]

# Cookie
- HTTP协议的无连接性：HTTP对于交互性场景没有记忆能力。只要服务器返回了响应，一个HTTP请求和响应就结束了
- Cookie：为了解决HTTP的无状态性，服务器保存到客户端的一种文本文件，与特定客户相关
- Cookie以“名值对”的方式保存数据
- Cookie实际上是一小段的文本信息。客户端请求服务器，如果服务器需要记录该用户状态，就使用response向客户端浏览器颁发一个Cookie。客户端浏览器会把Cookie保存起来。
  当浏览器再请求该网站时，浏览器把请求的网址连同该Cookie一同提交给服务器。服务器检查该Cookie，以此来辨认用户状态。服务器还可以根据需要修改Cookie的内容
- Cookie具有不可跨域名性。根据Cookie规范，浏览器访问Google只会携带Google的Cookie，而不会携带Baidu的Cookie。
  Google也只能操作Google的Cookie，而不能操作Baidu的Cookie（浏览器来保证。浏览器判断一个网站能否操作另一个网站的cookie的依据是域名）
- cookie并不是单纯为了实现 session机制而生的。Cookie可以记住用户的登录账号和密码，提高网页的访问速度

> 常见的Cookie操作的API
- 创建Cookie:new Cookie(String name, String value)
- 可以使用Cookie的setXXX()方法来设定一些相应的值
  - setName(String name)/getName()
  - setValue(String value)/getValue()
  - setMaxAge(int age)/getMaxAge()
  - HttpServletResponse的addCookie(Cookie)将Cookie设置到客户端
  - HttpServletRequest的getCookies()来读取客户端的所有Cookie,返回一个Cookie数组
- Cookie默认的maxAge是-1，表示这个cookie仅仅适用于当前的浏览会话(该cookie只会存在内存里而不会持久化，关闭浏览器就消失了)
- Cookie的共享访问规则：一个Servlet/JSP设置的Cookie能够被同一个路径下面或者其子路径下面的Servlet/JSP读到，其他的路径下的JSP/Servlet读取不到
    > 这里的路径指的是URL，并非真实的文件路径
    
# Session
> 基本概念
- Session又叫会话跟踪，表示某段时间一连串客户端与服务器的“交易”
- Session是另一种记录客户状态的机制，不同的是Cookie保存在客户端浏览器中，而Session保存在服务器上
- 客户端浏览器访问服务器的时候，服务器把客户端信息以某种形式记录在服务器上。这就是Session。客户端浏览器再次访问时只需要从该Session中查找该客户的状态就可以了。
- 如果说Cookie机制是通过检查客户身上的“通行证”来确定客户身份的话，那么Session机制就是通过检查服务器上的“客户明细表”来确认客户身份
- Session相当于程序在服务器上建立的一份客户档案，客户来访的时候只需要查询客户档案表就可以了。
- Session的两种实现方式：通过Cookie实现或者通过URL重写实现
    - 如果浏览器支持Cookie，创建Session的时候会把SessionId保存在Cookie里面
    - 如果浏览器不支持Cookie，必须自己编程使用URL重写的方式实现Session
        > 使用response.encodeURL()来实现。该函数可以转码(链接里面的中文进行urlEncode)，也可以在URL后面加上sessionId
        
> Session和Cookie的关系
- cookie 是一个实际存在的、具体的东西，http 协议中定义在 header 中的字段。
- session 是一个抽象概念、开发者为了实现中断和继续等操作，将client和server之间一对一的交互，抽象为“会话”，进而衍生出“会话状态”，也就是 session 的概念
- session描述的是一种通讯会话机制，而cookie只是目前实现这种机制的主流方案里面的一个参与者，它一般是用于保存session ID。

> Session的过期时间
- 自lastAccessTime开始经过指定的过期时间之后，服务器端保存的Session就会被清除
- 可以在web.xml文件里面配置Session的过期时间

          <!-- ==================== Default Session Configuration ================= -->
          <!-- ==================== From conf/web.xml of tomcat ================= -->
          <!-- You can set the default session timeout (in minutes) for all newly   -->
          <!-- created sessions by modifying the value below.                       -->
            <session-config>
                <session-timeout>30</session-timeout>
            </session-config>
- Session的共享访问规则与Cookie不同：同一个application下面的servlet/jsp可以共享同一个Session，前提是同一个客户端（窗口）

# Application
> 基本概念
- 用于保存这个web app的声明周期都可以访问的数据
- 在API中的表现为ServletContext
    - 通过HttpServlet的getServletContext()可以拿到
    - 通过ServletContext的getAttribute/setAttribute方法取得/设置相关属性

