# DataBase

使用Ver 8.0.20 for Linux on x86_64 (MySQL Community Server - GPL)

## DB Table Design

### user

| Column Name | Type     | Constraint       |
| ----------- | -------- | ---------------- |
| id          | int      | PK               |
| name        | varchar  | not null         |
| gender      | enum     |                  |
| description | text     |                  |
| password    | varchar  | not null         |
| account     | varchar  | unique, not null |
| email       | varchar  |                  |
| birthday    | datetime |                  |

### article

| Column Name     | Type     | Constraint   |
| --------------- | -------- | ------------ |
| id              | int      | PK           |
| user_id         | int      | FK(user: id) |
| content         | text     | not null     |
| comment_count   | int      |              |
| like_count      | int      |              |
| read_count      | int      |              |
| title           | varchar  | not null     |
| tag             | varchar  |              |
| publish_date    | datetime |              |
| subscribe_count | int      |              |

### comment

| Column Name  | Type     | Constraint      |
| ------------ | -------- | --------------- |
| id           | int      | PK              |
| article_id   | int      | FK(article: id) |
| commenter_id | int      | FK(user: id)    |
| content      | text     | not null        |
| comment_time | datetime | not null        |

### subscribe

| Column Name   | Type | Constraint          |
| ------------- | ---- | ------------------- |
| subscriber_id | int  | PK, FK(user: id)    |
| article_id    | int  | PK, FK(article: id) |

### like

| Column Name | Type | Constraint          |
| ----------- | ---- | ------------------- |
| article_id  | int  | PK, FK(article: id) |
| user_id     | int  | PK, FK(user: id)    |

### Notification

| Column Name | Type     | Constraint   |
| ----------- | -------- | ------------ |
| id          | int      | PK           |
| user_id     | int      | FK(user: id) |
| content     | text     | not null     |
| time        | datetime | not null     |