Spring框架从2.0版本开始，提供了基于Schema风格的XML扩展机制，允许开发者扩展最基本的spring配置文件（一般是classpath下的spring.xml）。试想一下，如果我们直接在spring.xml中加入一个自定义标签<mytag id="aty"></matag>，会发生什么呢？spring框架启动的时候会报错，因为spring根本不认识我们自定义的<mytag>，这样对spring.xml的校验就会失败，最终结果就是框架不能启动。有什么方法，能够让spring认识并加载解析我们自定义的<mytag>呢？这就是spring提供的xml扩展机制。我们可以在spring.xml中加入自己的标签，之后spring会帮我们解析并纳入自己的管理范围内，这也就是说我们扩展了spring的功能。
现在我们来看下怎么实现这个功能，可以参考spring帮助文档中的extensible-xml.html。我们知道如果在需要在spring.xml中配置数据源，需要进行如下的配置：
<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">       
    <property name="driverClassName" value="com.mysql.jdbc.Driver" />      
    <property name="url" value="jdbc:mysql://localhost:3309/sampledb" />      
    <property name="username" value="root" />      
    <property name="password" value="1234" />      
</bean>
这种方式配置虽然也比较简单，但是有一个缺点：使用<property>标签不够明显，不如元素属性那么直接。现在我们希望在spring.xml中做如下的配置，就能够完成数据源的配置。<aty:datasource id="myDataSourcce" url="jdbc:mysql://localhost:3309/demodb" userName="root" password="root" />
这种方式比较直接，配置不容易出错。如果让spring能够解析这个标签，需要4步。1、提供一个xsd文件，负责对xml的标签<datasource>进行校验
<?xml version="1.0" encoding= "UTF-8"?>
<xsd:schema xmlns="http://www.aty.com/schema/aty" xmlns:xsd="http://www.w3.org/2001/XMLSchema"
  xmlns:beans= "http://www.springframework.org/schema/beans"
  targetNamespace= "http://www.aty.com/schema/aty" elementFormDefault="qualified"
  attributeFormDefault= "unqualified">

  <xsd:import namespace= "http://www.springframework.org/schema/beans"
              schemaLocation="http://www.springframework.org/schema/beans/spring-beans-4.1.xsd" />

  <xsd:element name="datasource">
    <xsd:complexType >
      <xsd:complexContent >
        <xsd:extension base="beans:identifiedType" >
          <xsd:attribute name="url" type="xsd:string" use="required" />
          <xsd:attribute name="userName" type="xsd:string" use="required" />
          <xsd:attribute name="password" type="xsd:string" use="required" />
        </xsd:extension>
      </xsd:complexContent >
    </xsd:complexType >
  </xsd:element >

</xsd:schema>
2、定义一个BeanDefinitionParser负责解析xml,并将必要的信息放入spring中
DataSourceInfo类
package com.dyp.test.spring.test;

public class DataSourceInfo {
       private String url ;
       private String userName ;
       private String password ;
       public String getUrl() {
             return url ;
      }
       public void setUrl(String url) {
             this.url = url;
      }
       public String getUserName() {
             return userName ;
      }
       public void setUserName(String userName) {
             this.userName = userName;
      }
       public String getPassword() {
             return password ;
      }
       public void setPassword(String password) {
             this.password = password;
      }
      
       @Override
       public String toString()
      {
             return userName + " " + password + " " + url ;
      }
}

BeanDefinitionParser类
package com.dyp.test.spring.test;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class DatasourceBeanDefinitionParser implements BeanDefinitionParser {

       @Override
       public BeanDefinition parse(Element element , ParserContext context) {
            RootBeanDefinition def = new RootBeanDefinition();

          // 设置Bean Class
          def.setBeanClass(DataSourceInfo.class);

          // 注册ID属性
          String id = element.getAttribute("id" );
          BeanDefinitionHolder idHolder = new BeanDefinitionHolder(def, id);
          BeanDefinitionReaderUtils. registerBeanDefinition(idHolder,
              context.getRegistry());

          // 注册属性
          String url = element .getAttribute("url");
          String userName = element .getAttribute("userName");
          String password = element .getAttribute("password");

          BeanDefinitionHolder urlHolder = new BeanDefinitionHolder(def, url);
          BeanDefinitionHolder userNameHolder = new BeanDefinitionHolder(def ,
              userName);
          BeanDefinitionHolder passwordHolder = new BeanDefinitionHolder(def ,
              password);

          BeanDefinitionReaderUtils. registerBeanDefinition(urlHolder,
              context.getRegistry());
          BeanDefinitionReaderUtils.registerBeanDefinition( userNameHolder,
              context.getRegistry());
          BeanDefinitionReaderUtils.registerBeanDefinition( passwordHolder,
              context.getRegistry());

          def.getPropertyValues().addPropertyValue("url", url);
          def.getPropertyValues().addPropertyValue("userName", userName);
          def.getPropertyValues().addPropertyValue("password", password);

          return def ;
      }

}
该类的功能：设置相关的BeanClass，解析了对应的xsd文件，并将解析的内容注册到上下文中，同时返回一个BeanDefinition对象（BeanDefinition是Spring的bean定义，提供了bean部分的操作方法，如isSingleton()、isLazyInit()等)。注意：id属性是一个默认的属性，可以不在xsd文件中描述，但是需要注册它，否则将无法通过getBean方法获取标签定义的bean，也无法被其他bean引用。
3、定义个NamespaceHandler,由sping框架的调用入口。这也是我们自定义xml解析的入口
package com.dyp.test.spring.test;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class DatasourceNamespaceHandlerSupport extends NamespaceHandlerSupport {

       @Override
       public void init() {
            // register name have to set to the name of aty xsd root element name == "<xsd:element name="datasource">"
            registerBeanDefinitionParser( "datasource",
                    new DatasourceBeanDefinitionParser());
      }

}
4、配置schema和handlerSpring没那么聪明，它无法知道我们在什么地方定义了哪些扩展标签，这些标签将被谁解析，怎么解析。这个过程要我们通过一些配置文件来告知Spring知道，它们就是spring.handlers和spring.schemas，它们放在META-INF目录中。Spring.jar的META-INF目录中也有同名的文件，它们的文件内容基本上是相似的，而Spring在执行过程中，如果发现其他jar文件的META-INF文件夹中包含有这两个文件，Spring将会合并它们。
spring.handlers内容如下: 

http\://www.aty.com/schema/aty=com.dyp.test.spring.test.DatasourceNamespaceHandlerSupport
spring.schemas内容如下:
http\://www.aty.com/schema/aty.xsd=aty.xsd
测试工程的spring.xml配置如下：
<?xml version="1.0" encoding= "UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi= "http://www.w3.org/2001/XMLSchema-instance"
  xmlns:aty= "http://www.aty.com/schema/aty"
  xsi:schemaLocation= "http://www.springframework.org/schema/beans
  http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
  http://www.aty.com/schema/aty aty.xsd" >
 
  <aty:datasource id="myDataSourcce" url="jdbc:mysql://localhost:3309/demodb" userName= "root" password ="root" />

</beans>
测试类代码如下：
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
       private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml" );
    public static void main( String[] args )
    {
      DataSourceInfo d = (DataSourceInfo) context.getBean("myDataSourcce" );
        System. out.println(d );
    }
}
测试的工程目录结构如下：
Pom.xml
  <dependencies >
    <dependency >
      <groupId >junit</ groupId>
      <artifactId >junit</ artifactId>
      <version >3.8.1</ version>
      <scope >test</ scope>
    </dependency >
    <dependency >
      <groupId >org.springframework</ groupId>
      <artifactId >spring-core</ artifactId>
      <version >4.1.7.RELEASE</ version>
    </dependency >
    <dependency >
      <groupId >org.springframework</ groupId>
      <artifactId >spring-beans</ artifactId>
      <version >4.1.7.RELEASE</ version>
    </dependency >
    <dependency >
      <groupId >org.springframework</ groupId>
      <artifactId >spring-context</ artifactId>
      <version >4.1.7.RELEASE</ version>
    </dependency >
  </dependencies >
