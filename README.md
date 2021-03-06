# 引擎计划上半场作业
## 题目
使用SpringBoot，Maven，MyBatis，MySQL，搭建一个数据查询的服务
## 业务需求
1. 可以通过url方式，获取各个表详情信息，并可以对人员数据进行增删改查的操作，
2. 数据表包括人员表，订单表，订单详情表，商品表
3. 订单表有人员表外键，订单详情有订单表外键和商品表外键
4. 表的设计符合正常的购物场景需求
5. 通过表与表之间的关系可以查询到相应的人员、订单及商品信息
## 业务需求分析
1. 搭建数据库（保留所有的sql）
2. 创建Maven工程（SpringBoot）
3. 整合MyBatis,使用逆向工程生成pojo类以及mapper接口和xml映射文件
4. 后台系统实现业务逻辑分层（controller,service,mapper）
5. Controller层，拦截请求
6. Service层，处理业务逻辑
7. Mapper层，负责与数据库交互
8. 提供前台访问接口，实现前端访问并可以获取数据