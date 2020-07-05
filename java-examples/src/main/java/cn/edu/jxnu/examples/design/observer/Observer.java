/* All Contributors (C) 2020 */
package cn.edu.jxnu.examples.design.observer;

/**
 * 定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新
 *
 * @author 梦境迷离
 * @since 2020年06月12日11:28:02
 */

//1.Subject被观察者 定义被观察者必须实现的职责，它必须能够动态地增加、取消观察者。它一般是抽象类或者是实现类，仅仅完成作为被观察者必须实现的职责：管理观察者并通知观察者。
//2.Observer观察者 观察者接收到消息后，即进行update（更新方法）操作，对接收到的信息进行处理。
//3.ConcreteSubject具体的被观察者 定义被观察者自己的业务逻辑，同时定义对哪些事件进行通知。
//4.ConcreteObserver具体的观察者 每个观察在接收到消息后的处理反应是不同，各个观察者有自己的处理逻辑。

//使用场景：
//1.关联行为场景。需要注意的是，关联行为是可拆分的，而不是“组合”关系。
//2.事件多级触发场景。
//3.跨系统的消息交换场景，如消息队列的处理机制。
//4.广播链的问题 在一个观察者模式中最多出现一个对象既是观察者也是被观察者，也就是说消息最多转发一次（传递两次）。
//5.异步处理问题 观察者比较多，而且处理时间比较长，采用异步处理需要考虑线程安全和队列的问题。
public abstract class Observer {

    protected Subject subject;

    //收到通知时的动作
    public abstract void update();
}
