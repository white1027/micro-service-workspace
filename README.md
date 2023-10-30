# MicroServiceWorkspace

## 專案目的與說明
- 以微服務為主的專案架構
- 由於之前的架構 會將每個微服務都開一堆專案處理 造成管理上的困難 所以希望能將多個微服務放在同一個專案 使其較容易管理
- 底下如果有需要 可以改用 git submodule 管理
- **gateway** 是入口 通常只會有一個 (如果有不同的服務想要接系統 可以考慮另外開一個 gateway)
- **lib** 共用函式庫 通常放所有模組都會用到的 (如果是使用 Spring JPA 之類的 需要另外再開一個 只給 modules 使用)
- **modules** 各個微服務
- **database** 預計每個微服務都會有自己的database

## 使用的 Library

### Gateway
- **actuator** 監控用
- **web** Restful Api
- **dubbo** 微服務通訊用   
- **zookeeper** 微服務註冊用   
   
### CommonLibrary
- **Lombok** 好用的 getter setter 工具

### Modules
- **dubbo** 微服務通訊用
- **zookeeper** 微服務註冊用
- **mybatis** DB的ORM工具
- **postgres** 目前引用的JDBC

## 可能的問題
- 專案太多導致 gradle oom


## TODO
- [ ] Flyway
- [ ] mybatis 切換 schema
- [ ] dubbo service mesh
- [ ] dubbo 序列化調整
- [ ] dubbo admin
- [ ] 加入設定檔
- [ ] 加入 Controller 呼叫微服務