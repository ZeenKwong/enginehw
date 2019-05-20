# 前端方案说明
## 需求分析
根据已有的表结构和表操作，初步设定为这是一个《物资取用系统》，同事可通过此系统进行物资取用登记、物资新增、用户新增、记录修改等操作；
## 使用指南
- 主体使用vue框架进行构建，通过 npm run serve启动项目
- 同时使用nes框架进行风格风格化，bulma、element框架进行补充（后面两个其实没怎么用到，都是自己写）
## 目录架构
1. 对于vue-cli3需要自己创建vue.config.js
2. 此项目属于单页面应用，可以通过route.js创建路由，这里创建了router文件夹，默认会读取里边的index.js文件
3. page放每个具体页面的vue
4. assets文件放各种静态文件
## 逻辑补充说明
本地存储单独封装了storage.js，因为使用localstorage每次都要进行json的转换


```js
// 这个拥塞思路不错，记录一下
sleep(d) {
      for (var t = Date.now(); Date.now() - t <= d; );
    },
```