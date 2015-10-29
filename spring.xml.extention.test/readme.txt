Spring��ܴ�2.0�汾��ʼ���ṩ�˻���Schema����XML��չ���ƣ�����������չ�������spring�����ļ���һ����classpath�µ�spring.xml��������һ�£��������ֱ����spring.xml�м���һ���Զ����ǩ<mytag id="aty"></matag>���ᷢ��ʲô�أ�spring���������ʱ��ᱨ����Ϊspring��������ʶ�����Զ����<mytag>��������spring.xml��У��ͻ�ʧ�ܣ����ս�����ǿ�ܲ�����������ʲô�������ܹ���spring��ʶ�����ؽ��������Զ����<mytag>�أ������spring�ṩ��xml��չ���ơ����ǿ�����spring.xml�м����Լ��ı�ǩ��֮��spring������ǽ����������Լ��Ĺ���Χ�ڣ���Ҳ����˵������չ��spring�Ĺ��ܡ�
����������������ôʵ��������ܣ����Բο�spring�����ĵ��е�extensible-xml.html������֪���������Ҫ��spring.xml����������Դ����Ҫ�������µ����ã�
<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">       
    <property name="driverClassName" value="com.mysql.jdbc.Driver" />      
    <property name="url" value="jdbc:mysql://localhost:3309/sampledb" />      
    <property name="username" value="root" />      
    <property name="password" value="1234" />      
</bean>
���ַ�ʽ������ȻҲ�Ƚϼ򵥣�������һ��ȱ�㣺ʹ��<property>��ǩ�������ԣ�����Ԫ��������ôֱ�ӡ���������ϣ����spring.xml�������µ����ã����ܹ��������Դ�����á�<aty:datasource id="myDataSourcce" url="jdbc:mysql://localhost:3309/demodb" userName="root" password="root" />
���ַ�ʽ�Ƚ�ֱ�ӣ����ò����׳��������spring�ܹ����������ǩ����Ҫ4����1���ṩһ��xsd�ļ��������xml�ı�ǩ<datasource>����У��
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
2������һ��BeanDefinitionParser�������xml,������Ҫ����Ϣ����spring��
DataSourceInfo��
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

BeanDefinitionParser��
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

          // ����Bean Class
          def.setBeanClass(DataSourceInfo.class);

          // ע��ID����
          String id = element.getAttribute("id" );
          BeanDefinitionHolder idHolder = new BeanDefinitionHolder(def, id);
          BeanDefinitionReaderUtils. registerBeanDefinition(idHolder,
              context.getRegistry());

          // ע������
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
����Ĺ��ܣ�������ص�BeanClass�������˶�Ӧ��xsd�ļ�����������������ע�ᵽ�������У�ͬʱ����һ��BeanDefinition����BeanDefinition��Spring��bean���壬�ṩ��bean���ֵĲ�����������isSingleton()��isLazyInit()��)��ע�⣺id������һ��Ĭ�ϵ����ԣ����Բ���xsd�ļ���������������Ҫע�����������޷�ͨ��getBean������ȡ��ǩ�����bean��Ҳ�޷�������bean���á�
3�������NamespaceHandler,��sping��ܵĵ�����ڡ���Ҳ�������Զ���xml���������
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
4������schema��handlerSpringû��ô���������޷�֪��������ʲô�ط���������Щ��չ��ǩ����Щ��ǩ����˭��������ô�������������Ҫ����ͨ��һЩ�����ļ�����֪Spring֪�������Ǿ���spring.handlers��spring.schemas�����Ƿ���META-INFĿ¼�С�Spring.jar��META-INFĿ¼��Ҳ��ͬ�����ļ������ǵ��ļ����ݻ����������Ƶģ���Spring��ִ�й����У������������jar�ļ���META-INF�ļ����а������������ļ���Spring����ϲ����ǡ�
spring.handlers��������: 

http\://www.aty.com/schema/aty=com.dyp.test.spring.test.DatasourceNamespaceHandlerSupport
spring.schemas��������:
http\://www.aty.com/schema/aty.xsd=aty.xsd
���Թ��̵�spring.xml�������£�
<?xml version="1.0" encoding= "UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi= "http://www.w3.org/2001/XMLSchema-instance"
  xmlns:aty= "http://www.aty.com/schema/aty"
  xsi:schemaLocation= "http://www.springframework.org/schema/beans
  http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
  http://www.aty.com/schema/aty aty.xsd" >
 
  <aty:datasource id="myDataSourcce" url="jdbc:mysql://localhost:3309/demodb" userName= "root" password ="root" />

</beans>
������������£�
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
���ԵĹ���Ŀ¼�ṹ���£�
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
