# VBlog

本项目为高级软件工程课程大作业，开发使用的GitHub仓库地址为https://github.com/IFANx/VBlog。

本文档为项目整体情况介绍，详细开发文档参见`/documentation`中内容。

## 如何运行该项目

项目目录结构如下：

```
├─VBblog
│  ├─VBlogService
│  ├─documentation
|  ├─vblogfront
|  ├─.gitingore
|  ├─README.md
```

* VBlogService: 后端项目根目录。
* documentation: 文档目录。
* vblogfront: 前端项目根目录。

该项目采用前后端分离的方式进行开发，正常运行需要分别启动两个服务。

### 后端项目启动(VBlogService)

需要切换到后端工程根目录`/VblogService`下然后执行以下命令启动后端服务：

```bash
java VblogService-0.0.1-SNAPSHOT.jar
```

* 后端项目默认在`localhost:8989`启动，如需自定义配置端口请在`/VBlogService/src/main/resources/application.yaml`内修改响应配置项。
* 后端项目使用jdk11，其余项目详细信息参见`pom.xml`

### 前端项目启动(vblogfront)

需要切换到前端工程根目录`/vblogfront`下，然后执行以下命令启动前端服务：

```bash
npm run serve
```

* 前端项目默认在`localhost:8080`启动，如需自定义配置端口请在`/vblogfront/vue.config.js`中修改添加对应配置项。
* 前端还需要根据情况配置后端的地址，从而正确的获取持久化的数据。在`vblogfront/src/service/service.js`中配置`axios`的`baseURL`。
* 前端采用vue3 + bootstrap5构建。

## 数据库迁移

数据库涉及的表如下：

* user

| Column Name | Type    | Constraint       |
|-------------|---------|------------------|
| id          | int     | PK               |
| name        | varchar | not null         |
| gender      | enum    |                  |
| description | text    |                  |
| password    | varchar | not null         |
 | account     | varchar | unique, not null |
 | email       | varchar |                  |
 | birthday    | date    |                  |
 | portrait    | blob    |                  |

* article

| Column Name     | Type     | Constraint   |
|-----------------|----------|--------------|
 | id              | int      | PK           |
 | user_id         | int      | FK(user: id) |
 | content         | text     | not null     |
 | comment_count   | int      |              |
 | like_count      | int      |              |
 | read_count      | int      |              |
 | title           | varchar  | not null     |
 | tag             | varchar  |              |
 | publish_time    | datetime |              |
 | subscribe_count | int      |              |
 | cover           | blob     |              |

* comment

| Column Name  | Type     | Constraint      |
|--------------|----------|-----------------|
 | id           | int      | PK              |
 | article_id   | int      | FK(article: id) |
 | commenter_id | int      | FK(user: id)    |
 | content      | text     | not null        |
 | comment_time | datetime | not null        |

* subscribe

| Column Name   | Type | Constraint          |
|---------------|------|---------------------|
 | subscriber_id | int  | PK, FK(user: id)    |
 | article_id    | int  | PK, FK(article: id) |

* like

| Column Name | Type | Constraint          |
|-------------|------|---------------------|
 | article_id  | int  | PK, FK(article: id) |
 | user_id     | int  | PK, FK(user: id)    |

* notification

| Column Name | Type     | Constraint   |
|-------------|----------|--------------|
 | id          | int      | PK           |
 | user_id     | int      | FK(user: id) |
 | content     | text     | not null     |
 | time        | datetime | not null     |

可以使用如下脚本进行快速创建：

```sql
create table user
(
    id          int auto_increment,
    name        varchar(255)                     not null,
    gender      enum ('male', 'female', 'other') null,
    description text                             null,
    password    varchar(255)                     not null,
    account     varchar(255)                     not null,
    email       varchar(255)                     null,
    birthday    date                             null,
    constraint user_pk
        primary key (id)
);

create unique index user_account_uindex
    on user (account);

alter table user
    add portrait blob null;

create table article
(
    id              int auto_increment,
    user_id         int          not null,
    content         text         not null,
    comment_count   int          null,
    like_count      int          null,
    read_count      int          null,
    title           varchar(255) not null,
    tag             varchar(255) null,
    publish_time    datetime     null,
    subscribe_count int          null,
    constraint article_pk
        primary key (id),
    constraint article_user_id_fk
        foreign key (user_id) references user (id)
);

alter table article
    add cover blob null;
create table comment
(
    id           int auto_increment,
    article_id   int      not null,
    commenter_id int      not null,
    content      text     not null,
    comment_time datetime not null,
    constraint comment_pk
        primary key (id),
    constraint comment_article_id_fk
        foreign key (article_id) references article (id),
    constraint comment_user_id_fk
        foreign key (commenter_id) references user (id)
);

create table subscribe
(
    subscriber_id int not null,
    article_id    int not null,
    constraint subscribe_pk
        primary key (article_id, subscriber_id),
    constraint subscribe_article_id_fk
        foreign key (article_id) references article (id),
    constraint subscribe_user_id_fk
        foreign key (subscriber_id) references user (id)
);

create table `like`
(
    article_id int not null,
    user_id    int not null,
    constraint like_pk
        primary key (user_id, article_id),
    constraint like_article_id_fk
        foreign key (article_id) references article (id),
    constraint like_user_id_fk
        foreign key (user_id) references user (id)
);

create table notification
(
    id      int auto_increment,
    user_id int      not null,
    content text     not null,
    time    datetime not null,
    constraint notification_pk
        primary key (id),
    constraint notification_user_id_fk
        foreign key (user_id) references user (id)
);
```

