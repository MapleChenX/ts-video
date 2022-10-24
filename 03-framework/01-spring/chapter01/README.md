# 项目说明

2022年10月17日，学期第八周。

## Spring 框架的优点

Spring 具有简单、可测试和松耦合等特点，Spring 框架具体如下：

### 非侵入式设计

Spring 是一种非侵入式框架，它可以使应用程序代码对框架的一来最小化。

### 方便解耦、简化开发

Spring 就是一个大工厂。可以将所有对象的创建和依赖关系的维护工作都交给 Spring 容器管理，大大降低了组件之间的耦合性。

### 支持 AOP

Spring 提供了对 AOP 的支持，它允许将一些通用任务，如安全、事务、日志等进行集中式处理，从而提高程序的复用性。

### 支持声明式事务处理

只需要通过配置就可以完成对事务的管理，而无需手动编程。

### 方便程序的测试

Spring 提供了对 Junit4 的支持。

### 方便集成各种优秀框架

Spring 提供了对各种优秀框架（如 Struts、Hibernate、Mybatis 等）的直接支持。

## Spring 的体系结构

Spring 框架的功能呗分成20个模块，大体分为：
5

1. Core Container；
2. Data Access/Integration
3. Web
4. AOP
5. Instrumentation
6. Messaging
7. Test

### Core Container

Spring 的核心容器是其他模块建立的基础，它主要是由 Beans 模块、Core 模块、Context 模块、Context-support 模块 和 SpEL 模块组成。

1. Beans 模块：提供 BeanFactory，是工厂模式的经典实现，Spring 将管理对象称之为 Bean。
2. Core 核心模块：提供 Spring 框架的基础组成部分，包括 IoC 和 DI 功能。
3. Context 上下文模块：建立在 Core 和 Beans 模块的基础之上，它是访问定义和配置的任何对象的媒介。其中 ApplicationContext 接口是上下文模块的焦点。
4. Context-support 模块：提供对第三方库嵌入 Spring 应用的集成支持，比如缓存（EhCache、Guava、JCache）、邮件服务（JavaMail）、任务调度（CommonJ、Quartz）和模板引擎（FreeMarker、JasperReports）。

### Data Access/Integration

包括 JDBC、ORM、OXM、JMS 和 Transaction 模块。

1. JDBC 模块：提供一个 JDBC 抽象层，大幅度地减少了在开发过程中对数据库操作的编码。
2. ORM 模块：对流行的对象关系映射 API，包括 JPA、JDO 和 Hibernate 提供了集成层支持。

## 依赖注入

依赖注入（Dependency Injection，DI）与控制反转（IoC）同义。

1. 调用者 new 被调用者
2. 调用者从容器中获取被调用者的实例

依赖注入使我们的关系1，转变了关系2，控制反转是站在一个“上帝”视角来看的，即所有的关系都被放进了 IoC 容器中。
控制一个关系，改变一个关系，关系反转了，就是控制反转。

在 Spring 中，对象的实例不再由调用者创建，而是由 Spring 容器（IoC）来创建，Spring 容器会负责控制程序之间的关系，而不是由调用者的程序代码直接控制。这样，控制权由应用代码转移到了 Spring 容器，控制权发生了反转，即控制反转（IoC）。

👉代码示例：com.chapter01.stage04

1. 依赖注入：xml 实现依赖注入👉com.chapter01.stage01。xml 实现依赖注入👉com.chapter01.stage02
2. 依赖注入：实体类注入属性值（构造函数、setter）👉com.chapter01.stage03