package com.chapter01.stage04;

public class Main {

  public static void main(String[] args) {
    // 通过传递抽象父类，全部都在这里声明对象的方式，一定程度上可以减少代码的耦合度，比较灵活。这就是依赖 -> 注入。
    // 对于 BreadMachineVer2 来讲，它是调用者，调用者不会直接 new 对象，而是在这个 Main 这里来 new 对象。是我们决定该类接收什么类型的呗调用者，即 ToastBread 还是 SlicedBread。
    new BreadMachineVer2().make(new ToastBread());
    new BreadMachineVer2().make(new SlicedBread());

    // 1. 一般来讲，这个容器就是 IoC 容器，所有有依赖于其他对象的对象，都不通过自己内部来 new 对象，而是统一地全部实例化到 IoC 容器中
    // 进行统一管理。
    // 2. 如果 A 对象需要 B 对象，而 A 和 B 对象都被 IoC 容器管理，那么 A 只需要从 IoC 容器中获取 B 对象的实例。
    // 3. 这种依赖关系被一个中间商代理了，从表面上看着，确实少了很多依赖程度。
    // 其实这里的 Main 也可以当作一个 IoC 容器，只不过没有 Spring 那么强大。
  }

}
