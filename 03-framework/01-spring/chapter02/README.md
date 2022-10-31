# 项目说明

2022年10月24日，学期第八周。

# 注解依赖注入

学习 Spring 依赖注入之注解方式注入。主要用到以下几种注解，虽然主要的作用没什么区别，但为了符合三层架构（MVC）的设计思路，有了不同名称的但功能差不多的注解：

1. @Component：可以使用此诸结描述 Bean，是一个泛化的概念，可以作用于任何层次（比如，Service 层）。
2. @Repository：用于描述数据访问层（DAO 层）的类，并表示为 Bean。其功能与 @Component 一样。
3. @Service：描述业务层（Service 层），业务层的 Bean。
4. @Controller：描述控制层的 Bean。
5. @AutoWired：对 Bean 的变量、属性的 setter 方法，以及构造方法进行标注，配合完成 Bean 的自动装配工作。
6. @Resource：与 @AutoWired 作用一样，但是这个注解是 javax 的注解，所以需要额外导入包。@Resource 默认按照 Bean 的名称装配。

👉具体实践在：com.ioc

# AOP

AOP 的意思是切面编程，切面就是用横向的思维去编程。假如说，一个类的函数，通过一步步调用是依次从上往下顺序执行的，
如果我要在某一个步骤中间插入一个新的函数，可以做到吗？这种编程是不是横向切入进去的呢，这样做的好处是随时可以删除或修改。

AOP 就是把一些重复的代码抽取出来，在程序编译或运行时，再把这些代码应用到需要执行的地方，OOP（面向对象）只能实现父子关系的纵向重用，而 AOP 是横向重用。 使用过 Junit 的知道，有@Before、@After，在一个测试函数中，可以指定一个函数在整个测试中什么时候横向切入执行。这是最直观的感受 AOP。

👉直接体验 AOP：com.aop