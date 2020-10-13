package com.dw.sms.service.impl;

import com.dw.sms.entity.User;
import com.dw.sms.mapper.UserMapper;
import com.dw.sms.service.UserService;
import com.github.pagehelper.Page;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

/*
 事务：
    1.编程式事务管理： 编程式事务管理使用TransactionTemplate或者直接使用底层的PlatformTransactionManager。对于编程式事务管理，spring推荐使用TransactionTemplate。
    2.声明式事务管理： 建立在AOP之上的。其本质是对方法前后进行拦截，然后在目标方法开始之前创建或者加入一个事务，在执行完目标方法之后根据执行情况提交或者回滚事务。
        @Transactional可以作用于接口、接口方法、类以及类方法上。当作用于类上时，该类的所有 public 方法将都具有该类型的事务属性，同时，我们也可以在方法级别使用该标注来覆盖
        类级别的定义。因此可以在Service层和Controller层使用。
 */
@Service
public class UserServiceImpl implements UserService {
    /*
    变量方式注入应该尽量避免，使用set方式注入或者构造器注入，这两种方式的选择就要看这个类是强制依赖的话就用构造器方式，选择依赖的话就用set方法注入
     */

    private UserMapper userMapper;

    @Autowired
    UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    //加入默认事务管理
    @Transactional
    /*
     *  1.通过@Transactional，实现了事务操作。
        2.Spring的AOP即声明式事务管理默认是针对unchecked exception回滚。也就是默认对RuntimeException()异常或是其子类进行事务回滚；checked异常,即Exception可try{}捕获的不会回滚，因此对于我们自定义异常，通过rollbackFor进行设定，后续会单独讲
        3.如果我们需要捕获异常后，同时进行回滚，通过TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();进行手动回滚操作。
        4.使用Object savePoint = TransactionAspectSupport.currentTransactionStatus().createSavepoint();设置回滚点，使用TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(savePoint);回滚到savePoint.
        5.只有目标方法由外部调用，才能被 Spring 的事务拦截器拦截
        *
        常用属性：
        * value、transactionManager 它们两个是一样的意思。当配置了多个事务管理器时，可以使用该属性指定选择哪个事务管理器
        * propagation:事务的传播行为 默认值为 Propagation.REQUIRED
            Propagation.REQUIRED：如果当前存在事务，则加入该事务，如果当前不存在事务，则创建一个新的事务。
            Propagation.SUPPORTS：如果当前存在事务，则加入该事务；如果当前不存在事务，则以非事务的方式继续运行。
            Propagation.MANDATORY：如果当前存在事务，则加入该事务；如果当前不存在事务，则抛出异常。
            Propagation.REQUIRES_NEW：重新创建一个新的事务，如果当前存在事务，暂停当前的事务。
            Propagation.NOT_SUPPORTED：以非事务的方式运行，如果当前存在事务，暂停当前的事务。
            Propagation.NEVER：以非事务的方式运行，如果当前存在事务，则抛出异常。
            Propagation.NESTED：和 Propagation.REQUIRED 效果一样。

         * isolation:隔离级别 默认值为 Isolation.DEFAULT
            Isolation.DEFAULT：使用底层数据库默认的隔离级别
            Isolation.READ_UNCOMMITTED：读未提交的数据
            Isolation.READ_COMMITTED:读已提交的数据
            Isolation.REPEATABLE_READ：可重复读
            Isolation.SERIALIZABLE：串行化

         * timeout:超时时间
            事务的超时时间，默认值为-1。如果超过该时间限制但事务还没有完成，则自动回滚事务

         * readOnly:只读
            指定事务是否为只读事务，默认值为 false；为了忽略那些不需要事务的方法，比如读取数据，可以设置 read-only 为 true

         * rollbackFor:用于指定能够触发事务回滚的异常类型，可以指定多个异常类型。
         * noRollbackFor:抛出指定的异常类型，不回滚事务，也可以指定多个异常类型。


     * @param [user]
     * @return com.dw.sms.entity.User
     */
    @Override
    public User add(User user) {
        try {
            userMapper.add(user);
            return userMapper.findById(user.getUserId());
        } catch (Exception e) {//此处可以自定义异常
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return new User();
    }

    @Override
    public int delete(Long userId) {
        return userMapper.delete(userId);
    }

    @Override
    public User update(User user) {
        userMapper.update(user);
        return userMapper.findById(user.getUserId());
    }

    @Override
    public List<User> queryCondition(String username, Integer age) {
        return userMapper.queryCondition(username, age);
    }

    @Override
    public Page<User> findByPaging(Map params) {
        return userMapper.findByPaging(params);
    }

    @Override
    public List<User> findAllDetail() {
        return userMapper.findAllDetail();
    }

    @Override
    public List<User> findAllDetails() {
        return userMapper.findAllDetails();
    }
}
