### 扩展
1、自定义 beanName
```java
 * 1、自定义 beanName 生成器
 *
 * @see org.springframework.beans.factory.support.BeanNameGenerator#generateBeanName(BeanDefinition, BeanDefinitionRegistry)
 * @see org.springframework.beans.factory.support.DefaultBeanNameGenerator
 * @see org.springframework.context.annotation.AnnotationBeanNameGenerator
 * @see org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator
```
 2、自定义 xml 标签 
```java
  * 1、BeanDefinition 解析器
  * @see org.springframework.beans.factory.xml.BeanDefinitionParser
  * @see org.springframework.beans.factory.xml.AbstractBeanDefinitionParser
  * @see org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser
  * @see org.apache.dubbo.config.spring.schema.AnnotationBeanDefinitionParser
  * @see org.springframework.context.annotation.AnnotationConfigBeanDefinitionParser
  *
  * 案例：
  *   ① Dubbo 自定义 Xml 标签解析器
  *      @see org.apache.dubbo.config.spring.schema.DubboBeanDefinitionParser
  *   ② Mybatis 自定义 Xml 标签解析器
  *      @see org.mybatis.spring.config.MapperScannerBeanDefinitionParser
  *
  * 2、.xsd 文件
  *
  * 3、META-INF/spring.schemas
  *
  * 4、META-INF/spring.handlers
  *      @see org.springframework.beans.factory.xml.NamespaceHandler#init()
  *      @see org.springframework.beans.factory.xml.NamespaceHandlerSupport#init()
```
3、自定义 属性编辑器 xml版
```java
 * 1、属性编辑器
 * @see java.beans.PropertyEditorSupport#setAsText(String)
 * @see org.springframework.beans.PropertyEditorRegistrar#registerCustomEditors(PropertyEditorRegistry)
 *
 * 2、注入 IOC 容器
 * @see org.springframework.beans.factory.config.CustomEditorConfigurer#setPropertyEditorRegistrars(PropertyEditorRegistrar[])
 * @see org.springframework.beans.factory.config.CustomEditorConfigurer#setCustomEditors(Map)
```
4、自定义 属性编辑器 注解版
```java
 * 1、属性编辑器
 * @see java.beans.PropertyEditorSupport#setAsText(String)
 * @see org.springframework.beans.PropertyEditorRegistrar#registerCustomEditors(PropertyEditorRegistry)
 *
 * 2、注入 IOC 容器
 * @see org.springframework.beans.factory.config.CustomEditorConfigurer#setPropertyEditorRegistrars(PropertyEditorRegistrar[])
 * @see org.springframework.beans.factory.config.CustomEditorConfigurer#setCustomEditors(Map)
 *
 * 3、@Configuration - 配置类
 *
 * 4、@PropertySource - 读取配置文件
 *
 * 5、@Bean - 注入对象到 IOC 容器
```
5、BFPP 
```java
 * 1、BFPP 可以对工厂中的 BeanDefinition 进行修改操作
 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(ConfigurableListableBeanFactory)
```
6、BDRPP
```java
 * 1、BDRPP 可以往工厂中注入新的 BD 对象
 * 2、BFPP 可以修改工厂中的 BD
 * @see org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry(BeanDefinitionRegistry)
 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(ConfigurableListableBeanFactory)
```
7、BDRPP 执行顺序
```java
 * 1、BDRPP 有执行顺序
 *  ① 首先执行用户通过编程方式手动注册的 BDRPP 的方法
 *  ② 再执行实现了 PriorityOrdered 接口的排序后的 BDRPP 的方法
 *  ③ 然后执行实现了 Ordered 接口的排序后的 BDRPP 的方法
 *  ④ 最后执行没有实现上面2个接口的 BDRPP 的方法
 *  ⑤ 执行 BFPP 的方法
 *  >>> 按序执行的理由：BDRPP 可以注册 BDRPP 到工厂中
 * @see org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry(BeanDefinitionRegistry)
 *
 * 2、BFPP 有执行顺序
 *  ① 首先执行实现了 PriorityOrdered 接口的排序后的 BFPP 的方法
 *  ② 再执行实现了 Ordered 接口的排序后的 BFPP 的方法
 *  ③ 最后执行没有实现上面2个接口的 BFPP 的方法
 *  >>> 处理 BeanDefinition 的顺序
 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(ConfigurableListableBeanFactory)
```
8、BPP 执行顺序
```java
 * @see org.springframework.beans.factory.config.BeanPostProcessor -> bean 初始化前后干点事
 * 1、注册 BPP 到工厂中的 beanPostProcessors 集合中
 *   ① 首先将实现了 PriorityOrdered 接口的 BPP 实例化并 add 到 beanPostProcessors 集合中
 *   ② 再将实现了 Ordered 接口的 BPP 实例化并 add 到 beanPostProcessors 集合中
 *   ③ 然后将未实现上面2个接口的 BPP 实例化并 add 到 beanPostProcessors 集合中
 *   ④ 最后将 Spring 内部的 BPP 实例化并 add 到 beanPostProcessors 集合中
 *
 * 2、BeanPostProcessor 子接口及其作用
 * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor -> bean实例化前后干点事
 * @see org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor -> bean 循环依赖问题
 * @see org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor -> 允许在实例化 bean 后修改 BeanDefinition
 * @see org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor -> bean 对象销毁前干点事
```
9、自定义类型转换器
```java
 *  1、类型转换器
 *  Converter -> 1 - 1 转换
 *  ConverterFactory -> 1 - N 转换
 *  GenericConverter -> N - N 转换
 * @see org.springframework.core.convert.converter.Converter#convert(Object)
 * @see org.springframework.core.convert.converter.ConverterFactory#getConverter(Class)
 * @see org.springframework.core.convert.converter.GenericConverter#convert(Object, TypeDescriptor, TypeDescriptor)
 *
 * 2、Java 自带的属性编辑器，上面的 Spring 提供的功能更强大
 * @see java.beans.PropertyEditorSupport#setAsText(String)
 * @see com.shadow.extension03_editor_xml
 * @see com.shadow.extension04_editor_annotation
```
10、依赖bean
```java
 * 1、依赖对象
 * @see org.springframework.context.annotation.DependsOn
 *
 * 实例化某个对象时，需要另外一个类型的对象先创建
 * 比如：实例化 JdbcTemplate 对象时，需要先创建好 DataSource 对象
 * @see org.springframework.jdbc.core.JdbcTemplate
 * @see javax.sql.DataSource
```
11、创建 bean 方式
```java
 * 1、允许提前创建 bean 对象
 *  ① InstantiationAwareBeanPostProcessor -> BPP 的子接口
 * @see InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation(Class, String)
 *  ② Supplier
 * @see Supplier
 * @see org.springframework.beans.factory.support.AbstractBeanDefinition#setInstanceSupplier(Supplier)
 *  ③ FactoryMethod or StaticFactoryMethod 工厂方法或静态工厂方法 factory-method、factory-bean
```
12、lookup、replace
```java
 *  1、lookup-method
 *      Spring 中默认的对象是单例的，Spring 会在一级缓存中持有该对象，方便下次直接获取
 *      那么如果是原型作用域的话，会创建一个新的对象
 *
 *      如果想在一个单例 bean 中引用一个原型的 bean 的话，怎么办呢?
 *      此时就需要引用 lookup-method 标签来解决此问题
 *      @see org.springframework.beans.factory.annotation.Lookup
 *
 *      通过拦截器的方式每次需要的时候都去创建新的对象，而不是把原型对象缓存起来
 *      <lookup-method></lookup-method> xml 标签
 *
 *  2、replace-method
 *      @see org.springframework.beans.factory.support.MethodReplacer
 *      <replace-method></replace-method>
```
13、属性填充
```java
 *  1、属性填充
 *  <property></property>
 *  <array></array> -> 数组对象
 *  <list></list>   -> list 集合对象
 *  <set></set>     -> set 集合对象
 *  <map></map>     -> map 集合对象
 *  <props></props> -> Properties 对象
```
14、循环依赖
```java
 *  1、循环依赖
 *      Spring 通过三级缓存来解决循环依赖问题：
 *      其实解决循环依赖问题是要二级缓存就可以了，为什么 Spring 要使用三级缓存呢？
 *  @see org.springframework.beans.factory.support.DefaultListableBeanFactory
 *  ① singletonObjects      -> 一级缓存
 *  ② earlySingletonObjects -> 二级缓存
 *  ③ singletonFactories    -> 三级缓存
 *
 *  提前暴露创建后但未完全创建完成的 bean 对象
 *  @see org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor#getEarlyBeanReference(Object, String)
 *
 *  使用三级缓存的目的是为了能够对 bean 进行代理
 *  @see org.springframework.beans.factory.ObjectFactory#getObject
 *
 *  对比 FactoryBean
 *  @see org.springframework.beans.factory.FactoryBean#getObject
 *
 *  2、可以关闭循环依赖
 * @see AnnotationConfigApplicationContext#setAllowCircularReferences(boolean)
 * @see ClassPathXmlApplicationContext#setAllowCircularReferences(boolean)
 * @see org.springframework.context.support.AbstractXmlApplicationContext#setAllowCircularReferences(boolean)
```
15、bean 生命周期
```java
 * 1、bean 的生命周期：
 *  ① bean 的实例化
 *  ② bean 的属性填充
 *  ③ *Aware 接口方法设置属性
 *  ④ BPP 的 Before 回调方法
 *  ⑤ bean 的初始化方法
 *      @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
 *      自定义 init-method 初始化方法
 *  ⑥ BPP 的 After 回调方法
 *  ⑦ bean 的销毁
 *      @see org.springframework.beans.factory.DisposableBean#destroy
 *      自定义 destroy-method 销毁方法
 *
 *  2、初始化注解插曲
 *  @see javax.annotation.PostConstruct
 *  @see javax.annotation.PreDestroy
 *      处理类 ：
 *      @see org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor
```
16、FactoryBean
```java
 *  1、BeanFactory bean 工厂 IOC 容器
 *      ① 存放 BeanDefinition 的容器 beanDefinitionMap
 *      ② 存放单例的容器 singletonObjects
 *      ③ 创建管理 bean 的容器
 *
 *  2、FactoryBean 工厂 bean
 *      ① FactoryBean 对象也有 BeanFactory 工厂来管理
 *      ② FactoryBean 可以通过其 getObject 方法生产对象
 *      ③ 直接根据 beanName 获取的对象是其 getObject 方法生产的对象
 *      ④ 如果想获取 FactoryBean 对象的话，需要在 beanName 前拼接上取地址符 &
 *      ⑤ FactoryBean 通常来实现对象代理
 *  @see org.mybatis.spring.mapper.MapperFactoryBean     -> Mybatis
 *  @see org.apache.dubbo.config.spring.ReferenceBean    -> Dubbo
```
17、动态代理
```java
 *  1、JDK 动态代理（反射）
 *      -> 代理的类一定要是实现接口的类
 * @see java.lang.reflect.Proxy
 * @see java.lang.reflect.Proxy.ProxyClassFactory#apply(ClassLoader, Class[])
 * @see java.lang.reflect.InvocationHandler#invoke(Object, Method, Object[])
 *
 *  2、CGLIB 动态代理（ASM 字节码操作技术）
 *      -> 代理的类无需实现任何接口
 * @see org.springframework.cglib.proxy.Enhancer#setSuperclass(Class)
 * @see org.springframework.cglib.proxy.Enhancer#setCallback(Callback)
 * @see org.springframework.cglib.proxy.Enhancer#create()
 * @see org.springframework.cglib.proxy.MethodInterceptor#intercept(Object, Method, Object[], MethodProxy)
 *
 *  3、生产的动态代理类保存到本地
 *      -> JDK 动态代理
 *          System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true")
 *      -> CGLIB 动态代理
 *          System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, System.getProperty("user.dir"))
```
18、AOP
```java
 *  1、AOP 切面编程 -> OOP 补充
 *      ① 切面 Aspect -> 自定义
 *      ② 连接点 JoinPoint -> Spring 中的连接点泛指方法
 *      ③ 通知 Advise
 *          @see org.springframework.aop.aspectj.AspectJMethodBeforeAdvice -> 前置通知
 *          @see org.springframework.aop.aspectj.AspectJAfterAdvice -> 后置通知
 *          @see org.springframework.aop.aspectj.AspectJAfterReturningAdvice -> 返回通知
 *          @see org.springframework.aop.aspectj.AspectJAfterThrowingAdvice -> 异常通知
 *          @see org.springframework.aop.aspectj.AspectJAroundAdvice -> 环绕通知
 *      
 *      通知注解：
 *          @see org.aspectj.lang.annotation.Before
 *          @see org.aspectj.lang.annotation.After
 *          @see org.aspectj.lang.annotation.AfterReturning
 *          @see org.aspectj.lang.annotation.AfterThrowing
 *          @see org.aspectj.lang.annotation.Around
 *      
 *      ④ 切点 Pointcut
 *          @see org.springframework.aop.Pointcut
 *          @see org.springframework.aop.aspectj.AspectJExpressionPointcut
 * 
 *      ⑤ 通知器 Advisor 对 Advise 和 Pointcut 的包装
 *          @see org.springframework.aop.aspectj.AspectJPointcutAdvisor
 *          @see org.springframework.aop.aspectj.AspectJPointcutAdvisor#advice
 *          @see org.springframework.aop.aspectj.AspectJPointcutAdvisor#pointcut
 *          
 *          在执行过程中通知器其实是在一个链中的，其链开始的是 ExposeInvocationInterceptor
 *          @see org.springframework.aop.interceptor.ExposeInvocationInterceptor
 *          
 *  2、通知实现的分类：
 *      @see org.aopalliance.intercept.MethodInterceptor
 *      @see org.springframework.aop.aspectj.AspectJAfterAdvice
 *      @see org.springframework.aop.aspectj.AspectJAfterThrowingAdvice
 *      @see org.springframework.aop.aspectj.AspectJAroundAdvice
 *          
 *  3、Xml 方式的通知器在执行过程中与在 Xml 配置的先后顺序有关（取的是配置顺序的下标顺序：Before - Around、After - Around）
```
19、Spring 事务
```java
 *  1、事务隔离级别
 *  @see org.springframework.transaction.annotation.Isolation
 *      ① DEFAULT - 与数据库事务隔离级别保存一致
 *      ② READ_UNCOMMITTED - 读未提交
 *      ③ READ_COMMITTED - 读已提交
 *      ④ REPEATABLE_READ - 可重复读
 *      ⑤ SERIALIZABLE - 可串行化
 *
 *  2、事务传播机制
 *  @see org.springframework.transaction.annotation.Propagation
 *    一、支持当前事务的
 *      ① REQUIRED - 使用当前事务，没有就创建
 *      ② SUPPORTS - 当前有事务就使用当前事务，当前没有事务就不用事务
 *      ③ MANDATORY - 使用当前事务，没有就报错
 *    二、不支持当前事务的
 *      ① REQUIRES_NEW - 当前存在事务就挂起当前事务，重新创建一个新事务
 *      ② NOT_SUPPORTED - 不需要事务，当前存在事务就挂起事务
 *      ③ NEVER - 不需要事务，存在事务就报错
 *    三、内嵌事务
 *      ① NESTED - 当前存在事务，创建保存点，新建一个事务
 *
 *  3、声明式事务注解
 *  @see org.springframework.transaction.annotation.Transactional
 *
 *  4、事务管理器
 *  @see org.springframework.transaction.PlatformTransactionManager
 *  @see org.springframework.jdbc.datasource.DataSourceTransactionManager
```
20、Import 的使用
```java
 *  1、@Import 注解：注册类到 IOC 容器
 *    ① 普通的 class，容器会自动注册这个类，id 默认全类名
 *    ② ImportSelector 接口，注册一批 class
 *      @see org.springframework.context.annotation.ImportSelector#selectImports(AnnotationMetadata)
 *    ③ ImportBeanDefinitionRegistrar 一般结合扫描注解使用
 *      @see org.springframework.context.annotation.ImportBeanDefinitionRegistrar#registerBeanDefinitions(AnnotationMetadata, BeanDefinitionRegistry)
 *      接口方法参数 AnnotationMetadata,它可以获取当前类（被@Import标记）的注解消息，它使用标准的反射来获取指定类的内部注解消息
 *      @see AnnotationMetadata#getAnnotationTypes()
 *      案例：Mybatis mapper 扫描
 *      @see org.mybatis.spring.annotation.MapperScannerRegistrar
 *
 *   特别说明：ImportSelector，ImportBeanDefinitionRegistrar 实现类均可实现以下接口作为扩展需要，注入需要的属性
 *      @see org.springframework.context.EnvironmentAware#setEnvironment(Environment)
 *      @see org.springframework.beans.factory.BeanFactoryAware#setBeanFactory(BeanFactory)
 *      @see org.springframework.beans.factory.BeanClassLoaderAware#setBeanClassLoader(ClassLoader)
 *      @see org.springframework.context.ResourceLoaderAware#setResourceLoader(ResourceLoader)
```
21、自定义扫描器
```java
 *  1、自定义注解扫描：技术参考 Dubbo 的 ServiceBean 注解类注册
 *      ① @Shadow -> @Component
 *      ② @ShadowScan -> @ComponentScan
 *      ③ ShadowBeanFactoryPostProcessor -> org.apache.dubbo.config.spring.beans.factory.annotation.ServiceAnnotationBeanPostProcessor
 *          @see org.apache.dubbo.config.spring.beans.factory.annotation.ServiceAnnotationBeanPostProcessor
 *      ④ CustomerScanImportBeanDefinitionRegistrar -> org.apache.dubbo.config.spring.context.annotation.DubboComponentScanRegistrar
 *          @see org.apache.dubbo.config.spring.context.annotation.DubboComponentScanRegistrar
 *      ⑤ 自定义扫描器  ShadowBeanScannner
```
22、SPI 机制
```java
 *  1、JAVA SPI 机制：
 *      ① 接口
 *      ② 实现类
 *      ③ META-INF/services/接口全类名文件
 *      ④ 接口全类名文件中写入具体的实现类，多个实现可换行处理
 *   原理：
 *      @see ServiceLoader#load(Class)
 *
 *  2、Spring SPI 机制：
 *      ① 接口
 *      ② 接口实现类
 *      ③ META-INF/spring.factories 文件
 *      ④ spring.factories 文件中写入 接口全类名=接口实现类全类名，多个以英文逗号隔开
 *
 *    原理：
 *      @see SpringFactoriesLoader#loadFactories(Class, ClassLoader)
```
23、按需注入 bean
```java
 *  1、条件匹配
 *      @see org.springframework.context.annotation.Condition#matches(ConditionContext, AnnotatedTypeMetadata)
 *      @see org.springframework.context.annotation.Conditional
 *
 *     常用注解：
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnBean
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnClass
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnResource
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
 *         @see org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication
 *
 *  2、自定义条件
 *      ① 实现接口 Condition 的 matches 方法
 *      @see org.springframework.context.annotation.Condition#matches(ConditionContext, AnnotatedTypeMetadata)
 *      ② 使用注解 @Conditional(value = {xxxCondition.class})
 *      @see org.springframework.context.annotation.Conditional#value()
```