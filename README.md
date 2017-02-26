# android.base

Android 项目模板


# 模块

## 1. view animation

存放 UI 相关组件，动画等

## 2. database

数据库

  1. App内部数据api
  2. 对外数据api，如 Content Provider
  
      `Content Provider` 设计为 一个主 `DataProvider` 处理路由分发，
      
      调用者注册`RouterProvider` 处理对应的数据操作逻辑。
      
      与一般的 `REST API` 设计类似。
      
      例如:
      
      ```
      /users -> UserProvider
      /notes -> NodeProvider
      /comments -> CommentProvider
      
      ```

## 3. net

网络库

## 4. concurrent

多线程，多进程 

## 5. hotfix

热补丁

## 6. config

配置


# TODO

# Doc
