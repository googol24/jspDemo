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

> Servlet的Bean
- 在Servlet中使用Bean和在通常程序中使用Bean类似，属性一般是私有的，第一个字母小写便于Bean自己控制自己的属性，并且具有getters and setters
- Servlet中的Bean一般不应具有GUI表现，一般都是用于实现某一业务逻辑或者取得特定结果

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
> 基本概念
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


# JSP
> 基本概念
- JSP全称Java Server Pages，与 PHP、ASP、ASP.NET 等语言类似，是运行在服务端的语言。
- 是一种动态生成 HTML、XML 或其他格式文档的Web网页的技术标准
- JSP 技术是以 Java 语言作为脚本语言的，JSP 网页为整个服务器端的 Java 库单元提供了一个接口来服务于HTTP的应用程序
> JSP与Servlet
- JSP本身就是一个Servlet，JSP页面在（第一次）运行的时候会直接被编译成Servlet来处理相应web请求
- JSP程序由JSP Engine先将它转换成Servlet代码，接着将它编译成类文件载入执行
> JSP 生命周期:可以参考Servlet生命周期
- 编译阶段：servlet容器编译servlet源文件，生成servlet类
- 初始化阶段：加载与JSP对应的servlet类，创建其实例，并调用它的初始化方法
- 执行阶段：调用与JSP对应的servlet实例的服务方法
- 销毁阶段：调用与JSP对应的servlet实例的销毁方法，然后销毁servlet实例

> 基本语法
- 脚本程序：
    - <% 代码片段 %> 里面可以写一个程序段，但是不能定义方法，因为这里的代码段是在Servlet的service()里面执行的
- 声明：
    - <%! declaration; [ declaration; ]+ ... %>
    - 注意：在<% 代码片段 %>中声明变量时，编译为Servlet为局部变量，在<%! declaration% >中声明时，编译为Servlet的成员变量（Servlet只初始化一次，因而执行处理的Servlet实例也只有一个）
- 表达式：
    - <%= 表达式 %>，这个表达式必须为字符串或者可以被转换成字符串，不需要以;结束，且只有一行
- 注释：
    - <%-- 注释 --> JSP注释1 不同于HTML的注释，HTML注释通过浏览器查看网页源代码时可以看见注释内容(注意：<!-- 注释 -->是HTML注释)
    - <% //注释 %> JSP注释2(同Java)
    - <% /*注释*/ %> JSP注释3(同Java)
- Directive 编译期间的指令，相当于在编译期间的命令
    - 格式：<%Directive 属性名="属性值"%>
    - 常见的Directive有：page include taglib
    - page指令的常见属性
        - language : 一般为默认java
        - extends : 继承的类，实际上为默认的JspBase
        - import : 引入的包，相当于java的import语句
        - buffer : none|kb size,none表示不缓冲，默认为8k
        - session : 是否可以使用session
        - autoFlush : 缓冲器是否可以自动清除
        - errorPage : 该页面对应的错误引导页
        - isErrorPage : 该页面是否为错误引导页
        - contentType : 文件的类型以及编码方式
        - pageEncoding : 指定当前jsp页面的编码
    - include指令：将指定的JSP或者HTML文件包含进来
        - 格式：<%@ include file="file_URL" %>
        - JSP Engine会在编译期间JSP程序转换时期把file属性设定的文件包含进来，然后开始执行转换及编译的工作
        - 注意不能向file_URL中传递参数，因为这个是编译期间并非运行期间的指令
- Action 动作指令，在运行期间的执行的指令
    - 常见的action:jsp:useBean jsp:include jsp:forward jsp:plugin
    - jsp:include
        - 用于动态包含JSP程序或者html文件等
        - 除非这个指令被执行到，否则它是不会被Tomcat等JSP Engine进行编译的
        - 格式：
            - <jsp:include page="urlSpec" flush="true"/>
            - <jsp:include page="urlSpec" flush="true">
                    <jsp:param name="paramName" value="paramValue"/>
              </jsp:include>
            - flush用于设定是否将结果马上打印出来，必须为“true”
        - <jsp:param>用来设定include文件的时候请求的参数以及对应的值 xxx.jsp?param=value
        - 与Directive指令include的区别：
            - include编译指令是在JSP程序的转换时期就将file属性所指定的程序内容嵌入，然后再编译执行；
              而include动作指令在转换时期是不会被编译的，只有在客户端请求时期如果被执行到才会被动态地编译载入
            - include编译指令不能带参数，而include动作指令可以通过<jsp:param>带指定的请求参数
    - jsp:forward
        - 用于将JSP的内容传送(转发)到page所指定的JSP程序或者Servlet中处理
        - 格式：
            - <jsp:forward page="urlSpec" flush="true"/>
            - <jsp:forward page="urlSpec">
                <jsp:param name="paramName" value="paramValue"/>
              </jsp:forward>
        - forward的页面和forward到的页面用的是同一个request，于此对应的是response.sendRedirect（重定向）
        - jsp:forward与response.sendRedirect的区别
            - 转发是客户端行为，重定向是服务器行为。
                - 转发过程：客户浏览器发送http请求——》web服务器接受此请求——》调用内部的一个方法在容器内部完成请求处理和转发动作——》将目标资源发送给客户；在这里，转发的路径必须是同一个web容器下的url，其不能转向到其他的web路径上去，中间传递的是自己的容器内的request。在客户浏览器路径栏显示的仍然是其第一次访问的路径，也就是说客户是感觉不到服务器做了转发的。转发行为是浏览器只做了一次访问请求。                              
                - 重定向过程：客户浏览器发送http请求——》web服务器接受后发送302状态码响应及对应新的location给客户浏览器——》客户浏览器发现是302响应，则自动再发送一个新的http请求，请求url是新的location地址——》服务器根据此请求寻找资源并发送给客户。在这里location可以重定向到任意URL，既然是浏览器重新发出了请求，则就没有什么request传递的概念了。在客户浏览器路径栏显示的是其重定向的路径，客户可以观察到地址的变化的。重定向行为是浏览器做了至少两次的访问请求的。
            - 转发只有一次request，重定向其实是两次request
            - 假设你去A局办理执照：
              重定向：你先去了A局，A局的人说：“这个事情不归我们管，去B局”，然后，你就从A退了出来，自己乘车去了B局。
              转发：你先去了A局，A局看了以后，知道这个事情其实应该B局来管，但是他没有把你退回来，而是让你坐一会儿，自己到后面办公室联系了B的人，让他们办好后，送了过来。
    
            ![Image text](https://github.com/googol24/image_repo/blob/master/java/javaee/jsp_forward_vs_sendRedirect.png)
    
    - jsp:useBean
        - 使用jsp:bean，可以在JSP中使用定义好的javaBean
        - Bean的基本要素：
            - 必须要有一个不带参数的构造器。在JSP元素创建Bean是会调用空的构造器
            - Bean类元素没有任何公共实例变量，也即不允许访问实例变量，变量名称首字母必须小写
            - 通过Bean定义的getters/setters来读写变量的值，并将变量首字母改成大写
        - jsp:bean的基本用法
            - <jsp:useBean id="beanName" scope="page|request|session|application"
                class="package.BeanClass" type="typeName">
            - <jsp:setProperty name="beanName" property="propertyName" value="propertyValue">
            - <jsp:getProperty name="beanName" property="propertyName">
                        
            - <jsp:useBean/>各项参数的含义
                - id：对象实例名称
                - scope：Bean的作用范围，默认为page，对整个页面都有效
                    > 各个作用域范围的含义：
                        - page: 仅涵盖使用JavaBean的页面（相当于局部变量）
                        - request: 有效范围仅限于使用JavaBean的请求
                        - session: 有效范围在用户整个连接过程中（整个会话阶段均有效）
                        - application：有效范围涵盖整个应用程序。也就是对整个webapp均有效（ServletContext下有效）                      
                - class：Bean类的名称
                - beanName：Bean的名称
                - type：Bean实例的类型，可以是本类（默认），或者其父类，或者本类实现的接口
            
            - <jsp:setProperty>格式
                <jsp setProperty name="beanName" property="propertyName"|property="*"
                    value="propertyValue"|param="paramValue"                
                />
                相当于beanName.setPropertyName(propertyValue)
            - <jsp:getProperty>格式
                <jsp:getProperty name="beanName" property="propertyName"/>
                相当于beanName.getPropertyName()
            - 建立表单参数和Bean属性之间的关联
                - 通过param指定表单元素的名称，通过property属性指定对应Bean属性的名称，由此建立两个变量的关联
                - 通过*来设置所有属性和输入参数之间的关联
                - 在建立Bean属性和表单参数之间的对应关系的时候，服务器会将对应的参数<自动转换>成和属性类型相匹配的数据
                  request.getParameter("paramName")获取的都是String类型
- JSP内置对象：在jsp里面可以直接使用的对象
    - out request response pageContext session application config exception page
    - out内置对象
        - 是一个缓冲的输出流，用来给客户端返回信息。是javax.servlet.jsp.JspWriter的一个实例
        - 常用方法
            - println() 向客户端输出各种类型的数据
            - newLine() 输出一个换行符
            - close() 关闭输出流
            - flush() 输出缓冲区里的数据
            - clearBuffer() 清除缓冲区里的数据，同时把数据输出到客户端
            - clear() 清除缓冲区里的数据
            - getBufferSize() 返回缓冲区的大小
    - request内置对象
        - javax.servlet.http.HttpServletRequest接口的一个实例，用于取得请求的Header、信息（例如浏览器版本、语言、编码等）、请求的方式（GET/POST等）、请求的参数名称、参数值、客户端的主机名称等
        - 常用方法
            - getMethod() 返回客户端向服务器端传送数据的方法
            - getParameter(String paramName) 返回客户端向服务器端传送的参数值，该参数由paramName决定
            - getParameterNames() 获得客户端传送给服务器端的所有参数的名字，结果是一个Enumeration类型的数据
            - getParameterValues(String name) 获得指定参数的所有值，由name指定
            - getRemoteURI() 获得发出请求字符串的客户端地址
            - getRemoteAddr() 获得客户端的IP地址
            - getRemoteHost() 获取客户端的机器名称
            - getServerName() 获取服务器的名字
            - getServletName() 客户端所请求的脚本文件路径
            - getServerPort() 获取服务器端的端口
    - response内置对象
        - javax.servlet.http.HttpServletResponse接口的一个实例，表示服务器端返回给客户端的一个响应，常用于设置HTTP标题，添加Cookie、设置响应内容的类型和状态、发送HTTP重定向和编码URL     
        - 常用方法：
            - addCookie(Cookie cookie) 添加一个Cookie对象，用于在客户端保存特定的信息
            - addHeader(String name, String value) 添加HTTP头信息，该Header信息将发送到客户端
            - containsHeader(String name) 判断指定名字的Http头是否存在
            - sendError(int code) 向客户端发送错误码
            - sendRedirect(String url) 重定向JSP文件（注意和jsp:forward的区别）
            - sendContentTyp(String contentType) 设置MIME类型（多用于互联网邮件扩展，也即消息内容类型）与编码方式
    - session内置对象
        - javax.servlet.http.HttpSession接口的一个实例
        - 常用方法：setAttribute() getAttribute() isNew() getId()等
    - application内置对象
        - javax.servlet.ServletContext 接口的一个实例
        - 注意application与session的区别
- JSP与Servlet的通信
    - 从JSP调用Servlet：<jsp:foward/>直接把请求转发到Servlet或者response.sendRedirect()
    - 从Servlet调用JSP：response.sendRedirect()或者RequestDispatcher接口的forward(req,res)方法
        - getServletConfig().getServletContext().getRequestDispatcher("/jsp_servlet/ServletUseJsp.jsp").forward(request, response);