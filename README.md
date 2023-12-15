## 说明

本仓库修改了 Sentinel 配置的持久化方式（使用 Nacos）：
1. 支持以下规则的持久化
    - 流控规则
    - 熔断规则
    - 热点规则
    - 系统规则
    - 授权规则
    - 网关流控规则
    - 网关API定义
2. 从簇点链路页面弹窗修改（跳转持久化存储的流控页面）
3. 所有配置增删改后的数据刷新延迟了 600ms，防止 Nacos 更新延迟导致的数据显示不一致



增加了以下几个对于 Nacos 的配置：

| 属性                | 默认值            | 说明                   |
|-------------------|----------------|----------------------|
| nacos.server-addr | localhost:8848 | Nacos地址，必填           |
| nacos.namespace   | -              | 命名空间，可选              |
| nacos.group-id    | SENTINEL_GROUP | 存储配置文件的组             |
| nacos.username    | -              | 如果 Nacos 开启了鉴权，则需要填写 |
| nacos.password    | -              | 如果 Nacos 开启了鉴权，则需要填写 |

源仓库地址：https://github.com/alibaba/Sentinel