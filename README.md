教程代码示例：[EduProject](https://github.com/xieyipeng/SSM/tree/master/EduProject)

课程设计代码：[IntelligentStrawberry](https://github.com/xieyipeng/SSM/tree/master/IntelligentStrawberry)

ssm链接测试：[SSMTest](https://github.com/xieyipeng/SSM/tree/master/SSMTest)


### 前言

首先贴上项目目录：

-   父工程：

![](https://raw.githubusercontent.com/xieyipeng/MarkdownPic/master/20190827173956.png)

-   api：

![](https://raw.githubusercontent.com/xieyipeng/MarkdownPic/master/20190827174104.png)

-   model：

![](https://raw.githubusercontent.com/xieyipeng/MarkdownPic/master/20190827174337.png)

-   dao层：

![](https://raw.githubusercontent.com/xieyipeng/MarkdownPic/master/20190827174428.png)

-   service层：

![](https://raw.githubusercontent.com/xieyipeng/MarkdownPic/master/20190827174515.png)

-   manager：

![](https://raw.githubusercontent.com/xieyipeng/MarkdownPic/master/20190827174553.png)

-   个人一点理解：

dao层的mapper从数据库获取数据，再传给service层，service再给controller。

### 1、准备

-   idea-2019
-   maven-3.6.1
-   tomcat-9.0
-   java-1.8

### 2、搭建项目目录

-   创建空项目，项目名随意，这里是：`IntelligentStrawberry`
    ![myrWwj.png](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9zMi5heDF4LmNvbS8yMDE5LzA4LzI0L215cld3ai5wbmc?x-oss-process=image/format,png)
    创建好项目之后，弹出该界面，先不用管。
    ![mys91K.png](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9zMi5heDF4LmNvbS8yMDE5LzA4LzI0L215czkxSy5wbmc?x-oss-process=image/format,png)
-   创建父工程工程：`file-new-model`
    ![myyJqe.png](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9zMi5heDF4LmNvbS8yMDE5LzA4LzI0L215eUpxZS5wbmc?x-oss-process=image/format,png)
    不勾选（create from archetype）
    ![myyvz6.png](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9zMi5heDF4LmNvbS8yMDE5LzA4LzI0L215eXZ6Ni5wbmc?x-oss-process=image/format,png)
    组id与项目id
    ![my6pLD.png](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9zMi5heDF4LmNvbS8yMDE5LzA4LzI0L215NnBMRC5wbmc?x-oss-process=image/format,png)
    自动导入maven
    ![my6eQf.png](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9zMi5heDF4LmNvbS8yMDE5LzA4LzI0L215NmVRZi5wbmc?x-oss-process=image/format,png)
-   父工程不写代码，直接删掉父工程的src目录
-   右键父工程，创建子工程(new-model)

需要创建model,dao,service,manager,api几个子工程

| 子工程名                      | 是否勾选create from archetype | quickstart/webapp |
| ----------------------------- | ----------------------------- | ----------------- |
| IntelligentStrawberry-model   | 是                            | quickstart        |
| IntelligentStrawberry-dao     | 是                            | quickstart        |
| IntelligentStrawberry-service | 是                            | quickstart        |
| IntelligentStrawberry-manager | 是                            | webapp            |
| IntelligentStrawberry-api     | 是                            | webapp            |

![my561J.png](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9zMi5heDF4LmNvbS8yMDE5LzA4LzI0L215NTYxSi5wbmc?x-oss-process=image/format,png)

-   在model工程下创建模型类：`model.User`

`User.java:`

```java
package com.xieyipeng.IntelligentStrawberry.model;

public class User {
    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
```

-   创建完成的项目结构`api（为安卓，ios提供接口，个人认为是为了和前端界面分开，才没有合并在manager）子工程可要可不要`：
    ![my5DtU.png](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9zMi5heDF4LmNvbS8yMDE5LzA4LzI0L215NUR0VS5wbmc?x-oss-process=image/format,png)
-   更改打包方式，修改父工程pom文件，添加：

```xml
    <!--    父工程-->
    <packaging>pom</packaging>
```

添加完成后，父工程pom如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
    <artifactId>commen-parent</artifactId>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>IntelligentStrawberry-model</module>
        <module>IntelligentStrawberry-dao</module>
        <module>IntelligentStrawberry-service</module>
        <module>IntelligentStrawberry-manager</module>
        <module>IntelligentStrawberry-api</module>
    </modules>

    <!--父工程-->
    <packaging>pom</packaging>
    
</project>
```

-   在 model | service | dao 的pom文件中添加

```xml
    <packaging>jar</packaging>
```

`pom(model) 其余类似位置:`

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
  <artifactId>IntelligentStrawberry-model</artifactId>
  <version>1.0-SNAPSHOT</version>
  
  <packaging>jar</packaging>
  
  <name>IntelligentStrawberry-model</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>

  <dependencies>
		...
		...
  </dependencies>

  <build>
		...
		...
  </build>
</project>
```

-   抽取公共依赖（**删除**子工程的所共有的依赖（junit），放到父工程的pom中）：

父工程pom：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
    <artifactId>commen-parent</artifactId>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>IntelligentStrawberry-model</module>
        <module>IntelligentStrawberry-dao</module>
        <module>IntelligentStrawberry-service</module>
        <module>IntelligentStrawberry-manager</module>
        <module>IntelligentStrawberry-api</module>
    </modules>

    <!--父工程-->
    <packaging>pom</packaging>


    <!--公共版本号管理，可能有多余，之后会用到-->
    <properties>
        <junit.version>4.11</junit.version>
        <spring.version>4.3.14.RELEASE</spring.version>
        <mybatis.version>3.4.1</mybatis.version>

        <mybatis-spring.version>1.3.1</mybatis-spring.version>
        <log4j.version>1.2.17</log4j.version>
        <slf4j.version>1.7.12</slf4j.version>
        <jstl.version>1.2</jstl.version>
        <taglibs.version>1.1.2</taglibs.version>
        <c3p0.version>0.9.5.2</c3p0.version>
        <mysql.version>5.1.35</mysql.version>

        <jackson.version>2.5.4</jackson.version>
    </properties>

    <!--公共依赖-->
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```

### 3、为manager工程集成springMVC

-   关联父工程：为manager，api，dao，service子工程pom添加：

```xml
    <parent>
        <artifactId>commen-parent</artifactId>
        <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
```

如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <parent>
        <artifactId>commen-parent</artifactId>
        <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
    <artifactId>IntelligentStrawberry-manager</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <name>IntelligentStrawberry-manager Maven Webapp</name>
    <!-- FIXME change it to the project's website -->
    <url>http://www.example.com</url>

    <properties>
        ...
        ...
    </properties>


    <build>
       ...
       ...
    </build>
</project>
```

-   父工程pom添加公共版本号管理

```xml
 <!--公共版本号管理-->
    <properties>
        <junit.version>4.11</junit.version>
        <spring.version>4.3.14.RELEASE</spring.version>
        <mybatis.version>3.4.1</mybatis.version>

        <mybatis-spring.version>1.3.1</mybatis-spring.version>
        <log4j.version>1.2.17</log4j.version>
        <slf4j.version>1.7.12</slf4j.version>
        <jstl.version>1.2</jstl.version>
        <taglibs.version>1.1.2</taglibs.version>
        <c3p0.version>0.9.5.2</c3p0.version>
        <mysql.version>5.1.35</mysql.version>

        <jackson.version>2.5.4</jackson.version>

    </properties>

```



（只有manager才需要用springMVC的东西）

-   编辑manager的pom文件，添加依赖：

```xml
<dependencies>
        <!-- TODO: 1、添加spring的依赖-->
        <!--aop-->
        <!--aspects-->
        <!--beans-->
        <!--context-->
        <!--core-->
        <!--expression-->
        <!--jdbc-->
        <!--orm-->
        <!--tx-->
        <!--test-->
        <!--web-->
        <!--webmvc-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>4.3.14.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-expression</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
    
    </dependencies>

```

### 配置tomcat运行

![mybz40.png](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9zMi5heDF4LmNvbS8yMDE5LzA4LzI0L215Yno0MC5wbmc?x-oss-process=image/format,png)

![mybLuQ.png](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9zMi5heDF4LmNvbS8yMDE5LzA4LzI0L215Ykx1US5wbmc?x-oss-process=image/format,png)

-   点击run运行即可
    出现：
    ![myqlKe.png](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9zMi5heDF4LmNvbS8yMDE5LzA4LzI0L215cWxLZS5wbmc?x-oss-process=image/format,png)



### mvc配置文件

-   为manager工程添加java包和resources包，并**标记工作目录**
-   在resources下新建springmvc.xml：**(记着修改标了修改的地方)**，并创建（/WEB-INF/views/）文件夹。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
      http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
      http://www.springframework.org/schema/mvc
      http://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd
      http://www.springframework.org/schema/context
      http://www.springframework.org/schema/context/spring-context-4.3.xsd
      http://www.springframework.org/schema/aop
      http://www.springframework.org/schema/aop/spring-aop-4.3.xsd
      http://www.springframework.org/schema/tx
      http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">

    <!-- 1.注解扫描位置-->
    <!--TODO: 修改 -1 -->
    <context:component-scan base-package="com.xieyipeng.IntelligentStrawberry.web.controller"/>

    <!-- 2.配置映射处理和适配器-->
    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>
    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"/>

    <!-- 3.视图的解析器-->
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
</beans>

```

-   在manager工程的（\main\java\com\xieyipeng\IntelligentStrawberry\web\controller）下创建`UserController`

`UserController`:

**- 代码仅作测试使用 -**

```java
package com.xieyipeng.IntelligentStrawberry.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    //测试springmvc -- 输出： ...
    @RequestMapping("login")
    public String login(){
        System.out.println("...");
        return null;
    }
}

```

-   在manager的web.xml文件下加载SpringMVC配置文件

web.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app
        version="3.0"
        xmlns="http://java.sun.com/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">

    <display-name>Archetype Created Web Application</display-name>

    <!-- 配置springmvc-->
    <servlet>
        <servlet-name>DispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <!--TODO: 修改 -->
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>DispatcherServlet</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>
</web-app>

```

-   运行项目（http://localhost:8080/user/login.do）

>   网页：

![](https://raw.githubusercontent.com/xieyipeng/MarkdownPic/master/20190827153303.png)

>   控制台输出：

![](https://raw.githubusercontent.com/xieyipeng/MarkdownPic/master/20190827152036.png)

说明springmvc配置成功

**（webapp里面用service，service里用dao）**

### 整合dao

-   编辑dao工程下的pom.xml:

添加依赖：

```xml
        <dependency>
            <artifactId>IntelligentStrawberry-model</artifactId>
            <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

```

pom.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <parent>
        <artifactId>commen-parent</artifactId>
        <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <modelVersion>4.0.0</modelVersion>

    <artifactId>IntelligentStrawberry-dao</artifactId>
    
    ...

    <dependencies>
        <!--依赖model-->
        <dependency>
            <artifactId>IntelligentStrawberry-model</artifactId>
            <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

    </dependencies>

    <build>
      	...
    </build>
</project>

```

-   加载mapper的xml文件：

dao的pom中添加：

pom.xml:

```xml
<build>
    <!--让.xml文件也被打包-->
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
        </resource>
    </resources>
    
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
   		...
    </pluginManagement>
</build>

```





-   在（IntelligentStrawberry-dao\src\main\java\com\xieyipeng\IntelligentStrawberry）下新建mapper.UserMapper:(接口)

UserMapper:

```java
package com.xieyipeng.IntelligentStrawberry.mapper;

import com.xieyipeng.IntelligentStrawberry.model.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}

```

同级目录下新建UserMapper的实现：

UserMapper.xml:

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
    <mapper namespace="com.xieyipeng.IntelligentStrawberry.mapper.UserMapper">

        <select id="findAll" resultType="com.xieyipeng.IntelligentStrawberry.model.User">SELECT * FROM t_user</select>

</mapper>

```

-   解决http://mybatis.org/dtd/mybatis-3-mapper.dtd报红问题：

导入：mybatis.jar包：导入dao.pom中：

```xml
<!--依赖mybatis-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>${mybatis.version}</version>
        </dependency>

```

**service依赖dao**

### 整合service

-   service.pom添加依赖dao：

```xml
        <!--依赖dao-->
        <dependency>
            <artifactId>IntelligentStrawberry-dao</artifactId>
            <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

```

pom.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <parent>
        <artifactId>commen-parent</artifactId>
        <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <modelVersion>4.0.0</modelVersion>

    ...

    <dependencies>
        <!--依赖dao-->
        <dependency>
            <artifactId>IntelligentStrawberry-dao</artifactId>
            <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>

    <build>
        ...
    </build>
</project>

```

-   service下新建（\main\java\com\xieyipeng\IntelligentStrawberry\service\IUserService.java）接口：

IUserService：

```java
package com.xieyipeng.IntelligentStrawberry.service;

import com.xieyipeng.IntelligentStrawberry.model.User;

import java.util.List;

public interface IUserService {

    public List<User> findAll();

}

```

-   新建实现类：（\main\java\com\xieyipeng\IntelligentStrawberry\service\impl\UserServiceImpl.java）

```java
package com.xieyipeng.IntelligentStrawberry.service.impl;

import com.xieyipeng.IntelligentStrawberry.mapper.UserMapper;
import com.xieyipeng.IntelligentStrawberry.model.User;
import com.xieyipeng.IntelligentStrawberry.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    public UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}

```

-   service中添加spring依赖（目的：添加一些注释）：

service的pom中添加：

```xml
<!--添加依赖spring-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>

		<dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>

```

-   修改IUserServiceImpl：

```java
package com.xieyipeng.IntelligentStrawberry.service.impl;

import com.xieyipeng.IntelligentStrawberry.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IUserServiceImpl {

    @Autowired
    public UserMapper userMapper;
}

```

### 后台整合

-   添加其他依赖

manager的pom.xml添加依赖：

```xml
 		<!-- TODO: 2、添加service依赖-->

        <dependency>
            <artifactId>IntelligentStrawberry-service</artifactId>
            <groupId>com.xieyipeng.IntelligentStrawberry</groupId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
		<!-- TODO: 3、添加mybatis-spring的整合依赖-->
        <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>${mybatis-spring.version}</version>
        </dependency>
        <!-- TODO: 4、添加其他依赖-->
        <!-- 数据库驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
        </dependency>
        <!-- 数据连接池 -->
        <dependency>
            <groupId>com.mchange</groupId>
            <artifactId>c3p0</artifactId>
            <version>${c3p0.version}</version>
        </dependency>
        <!-- jstl标签类 -->
        <dependency>
            <groupId>jstl</groupId>
            <artifactId>jstl</artifactId>
            <version>${jstl.version}</version>
        </dependency>
        <dependency>
            <groupId>taglibs</groupId>
            <artifactId>standard</artifactId>
            <version>${taglibs.version}</version>
        </dependency>
        <!-- log start -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
        <!--导入servlet/api/jsp-->

        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api -->
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>javax.servlet.jsp-api</artifactId>
            <version>2.3.1</version>
            <scope>provided</scope>
        </dependency>

        <!-- 转换为json格式jar包 -->
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20140107</version>
        </dependency>

        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.28</version>
        </dependency>

```

-   UserController中添加自动注入UserService：

```java
package com.xieyipeng.IntelligentStrawberry.web.controller;

import com.xieyipeng.IntelligentStrawberry.model.User;
import com.xieyipeng.IntelligentStrawberry.service.IUserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    //测试springmvc -- 输出： ...
    @RequestMapping("login")
    public String login() {
        System.out.println("...");
        return null;
    }

    @RequestMapping("findAll")
    @ResponseBody
    public String findAll() {
        List<User> users = userService.findAll();
        if (users != null) {
            /**
             for (int i = 0; i < users.size(); i++) {
             System.out.println(users.get(i));
             }
             **/
            JSONObject map = new JSONObject(true);
            map.put("count", users.size());
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", users);
            return map.toString();
        } else {
            System.out.println("user size == null!");
        }
        return null;
    }
}

```

-   解决userService报红：

取消检查，去掉对勾：

![](https://raw.githubusercontent.com/xieyipeng/MarkdownPic/master/20190827162652.png)

-   其他配置文件：

放到manager的resources文件夹下：

applicationContext.xml：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
		http://www.springframework.org/schema/context
		http://www.springframework.org/schema/context/spring-context-4.3.xsd
		http://www.springframework.org/schema/aop
		http://www.springframework.org/schema/aop/spring-aop-4.3.xsd
		http://www.springframework.org/schema/tx
		http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">

    <context:property-placeholder location="classpath:db.properties"/>

    <!-- 配置数据源 -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driver}"/>
        <property name="jdbcUrl" value="${jdbc.url}"/>
        <property name="user" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="maxPoolSize" value="30"/>
        <property name="minPoolSize" value="2"/>
    </bean>

    <!-- 配置sessionFactory -->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean" id="sqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <!-- 指定配置文件位置 -->
        <!--<property name="configLocation" value="classpath:mybatis.xml"/>-->
        <!-- 配置别名 -->
        <!-- TODO: 修改 -->
        <property name="typeAliasesPackage" value="com.xieyipeng.IntelligentStrawberry.model"/>
        <!--配置加载映射文件 UserMapper.xml-->
        <!-- TODO: 修改 -->
        <property name="mapperLocations" value="classpath:com/xieyipeng/IntelligentStrawberry/mapper/*Mapper.xml"/>
    </bean>

    <!-- 自动生成dao,mapper-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!-- TODO: 修改 -->
        <property name="basePackage" value="com.xieyipeng.IntelligentStrawberry.mapper"/>
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactoryBean"/>
    </bean>

    <!--自动扫描Service-->
    <!-- TODO: 修改 -->
    <context:component-scan base-package="com.xieyipeng.IntelligentStrawberry"/>


    <!-- 配置事务-->
    <!-- 5.配置事务管理器 -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <!-- 6.开启事务注解-->
    <tx:annotation-driven></tx:annotation-driven>
</beans>

```

db.properties:

```java
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/strawberryframsystem
jdbc.username=***
jdbc.password=***

```

log4j.properties:

```xml
# Global logging configuration
log4j.rootLogger=DEBUG, stdout
# Console output...
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n

```

manager的webapp下的web.xml添加配置spring:

web.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app
        version="3.0"
        xmlns="http://java.sun.com/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">

    <display-name>Archetype Created Web Application</display-name>
    <!-- 添加：-->
    <!-- 配置spring-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <!--TODO: 修改 -->
        <param-value>classpath:applicationContext.xml</param-value>
    </context-param>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!-- 配置springmvc-->
    <servlet>
        <servlet-name>DispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <!--TODO: 修改 -->
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>DispatcherServlet</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>
</web-app>

```

-   之后运行结果：

![](https://raw.githubusercontent.com/xieyipeng/MarkdownPic/master/20190827173531.png)

















