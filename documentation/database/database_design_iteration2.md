# DataBase

使用Ver 8.0.20 for Linux on x86_64 (MySQL Community Server - GPL)

目前表的定义和创建SQL在下面列出，开发阶段在`121.36.209.225:3306` 下的vblog数据库中进行测试

## 改动

在上次的基础上给用户增加了头像的存储，文章增加了封面的存储，使用blob存储二进制图像

## DB Table Design

### user

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
```

### article

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

```sql
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
```

### comment

| Column Name  | Type     | Constraint      |
|--------------|----------|-----------------|
| id           | int      | PK              |
| article_id   | int      | FK(article: id) |
| commenter_id | int      | FK(user: id)    |
| content      | text     | not null        |
| comment_time | datetime | not null        |

```sql
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

```

### subscribe

| Column Name   | Type | Constraint          |
|---------------|------|---------------------|
| subscriber_id | int  | PK, FK(user: id)    |
| article_id    | int  | PK, FK(article: id) |

```sql
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

```

### like

| Column Name | Type | Constraint          |
|-------------|------|---------------------|
| article_id  | int  | PK, FK(article: id) |
| user_id     | int  | PK, FK(user: id)    |

```sql
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

```

### notification

| Column Name | Type     | Constraint   |
|-------------|----------|--------------|
| id          | int      | PK           |
| user_id     | int      | FK(user: id) |
| content     | text     | not null     |
| time        | datetime | not null     |

```sql
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

