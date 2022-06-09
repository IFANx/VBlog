# DB Table Design

## user

| Column Name | Type     | Constraint |
| ----------- | -------- | ---------- |
| id          | int      | PK         |
| name        | varchar  |            |
| gender      | enum     |            |
| description | text     |            |
| password    | varchar  |            |
| account     | varchar  | unique     |
| email       | email    |            |
| birthday    | datetime |            |

## article

| Column Name     | Type     | Constraint   |
| --------------- | -------- | ------------ |
| id              | int      | PK           |
| user_id         | int      | FK(user: id) |
| content         | text     |              |
| comment_count   | int      |              |
| like_count      | int      |              |
| read_count      | int      |              |
| title           | varchar  |              |
| tag             | varchar  |              |
| publish_date    | datetime |              |
| subscribe_count | int      |              |

## comment

| Column Name  | Type     | Constraint      |
| ------------ | -------- | --------------- |
| id           | int      | PK              |
| article_id   | int      | FK(article: id) |
| commenter_id | int      | FK(user: id)    |
| content      | text     |                 |
| comment_time | datetime |                 |

## subscribe

| Column Name   | Type | Constraint          |
| ------------- | ---- | ------------------- |
| subscriber_id | int  | PK, FK(user: id)    |
| article_id    | int  | PK, FK(article: id) |

## like

| Column Name | Type | Constraint          |
| ----------- | ---- | ------------------- |
| article_id  | int  | PK, FK(article: id) |
| user_id     | int  | PK, FK(user: id)    |

## Notification

| Column Name | Type     | Constraint   |
| ----------- | -------- | ------------ |
| id          | int      | PK           |
| user_id     | int      | FK(user: id) |
| content     | text     |              |
| time        | datetime |              |