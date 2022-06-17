# Rest API: Article

以下是Article相关资源的REST API

## 单个article资源获取接口

### GET:/article/{id}

根据传入的{id}获取唯一的article对象

| 传参方式 | 参数  | 返回                  |
|------|-----|---------------------|
| url  | id  | 对应article对象的JSON字符串 |

**Example:**

* 请求：GET:/article/1

* Response Body:

  ```json
  {
    "id": 1,
    "userId": 1,
    "commentCount": 0,
    "likeCount": 0,
    "readCount": 0,
    "title": "test article",
    "tag": "test",
    "publishTime": "2022-06-10T15:26:40.000+08:00",
    "subscribeCount": 0,
    "content": "has no content, its just test data"
  }
  ```

## 全部article资源获取接口

以下是获取全部article相关的接口

### GET:/article/counts

获取总article的数量

| 传参方式 | 参数  | 返回            |
|------|-----|---------------|
| /    | /   | 总article记录的数量 |

**Example:**

* 请求：GET:/article/counts

* Response Body:

  ```json
  11
  ```

### GET:/articles

获取全部的article记录

| 传参方式 | 参数  | 返回                   |
|------|-----|----------------------|
| /    | /   | 包含所有article记录的JSON数组 |

**Example:**

* 请求：GET:/articles

* Response Body:

  ```json
  [
    {
      "id": 1,
      "userId": 1,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, its just test data"
    },
    {
      "id": 2,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:27:11.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, just test data"
    },
    {
      "id": 3,
      "userId": 1,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:27:51.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, just another test data"
    },
    {
      "id": 4,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2yeahhhhh",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article, butt for update this time"
    },
    {
      "id": 5,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 6,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 7,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 9,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 11,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 12,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 14,
      "userId": 1,
      "commentCount": null,
      "likeCount": null,
      "readCount": null,
      "title": "yet another test title, but updated...",
      "tag": null,
      "publishTime": null,
      "subscribeCount": null,
      "content": "pretend there is the content..."
    }
  ]
  ```

### GET:/articles/paged/{startPage}/{pageSize}

对全部article对象进行分页，按{startPage}确定页数，按{pageSize}确定每页有多少数据，返回一个包含分页内容以及相关数据的分页信息对象。

| 传参方式 | 参数                  | 返回                                                       |
|------|---------------------|----------------------------------------------------------|
| url  | startPage, pageSize | 按每页{pageSize}条记录划分所有的记录，其中第{startPage}页的记录以及相关信息的JSON字符串 |

**Example:**

* 请求：GET:/articles/paged/1/3

* Response Body:

  ```json
  {
    "total": 11,
    "list": [
      {
        "id": 1,
        "userId": 1,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article",
        "tag": "test",
        "publishTime": "2022-06-10T15:26:40.000+08:00",
        "subscribeCount": 0,
        "content": "has no content, its just test data"
      },
      {
        "id": 2,
        "userId": 2,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article",
        "tag": "test",
        "publishTime": "2022-06-10T15:27:11.000+08:00",
        "subscribeCount": 0,
        "content": "has no content, just test data"
      },
      {
        "id": 3,
        "userId": 1,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article",
        "tag": "test",
        "publishTime": "2022-06-10T15:27:51.000+08:00",
        "subscribeCount": 0,
        "content": "has no content, just another test data"
      }
    ],
    "pageNum": 1,
    "pageSize": 3,
    "size": 3,
    "startRow": 1,
    "endRow": 3,
    "pages": 4,
    "prePage": 0,
    "nextPage": 2,
    "isFirstPage": true,
    "isLastPage": false,
    "hasPreviousPage": false,
    "hasNextPage": true,
    "navigatePages": 8,
    "navigatepageNums": [
      1,
      2,
      3,
      4
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 4
  }
  ```

## 按title获取article资源接口

以下是按title获取article资源的相关的接口

### GET:/article/counts/title/{title}

获取title为{title}的article数量

| 传参方式 | 参数    | 返回                     |
|------|-------|------------------------|
| url  | title | 标题为{title}的article记录数量 |

**Example:**

* 请求：GET:/article/counts/title/test article

* Response Body:

  ```json
  3
  ```

### GET:/articles/title/{title}

获取包含全部title为{title}的article对象的数组

| 传参方式 | 参数    | 返回                           |
|------|-------|------------------------------|
| url  | title | 包含标题为{title}的article的全部记录的数组 |

**Example:**

* 请求：GET:/articles/title/test article

* Response Body:

  ```json
  [
    {
      "id": 1,
      "userId": 1,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, its just test data"
    },
    {
      "id": 2,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:27:11.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, just test data"
    },
    {
      "id": 3,
      "userId": 1,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:27:51.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, just another test data"
    }
  ]
  ```

### GET:/articles/title/paged/{title}/{startPage}/{pageSize}

对全部title为{title}article对象进行分页，按{startPage}确定页数，按{pageSize}确定每页有多少数据，返回一个包含分页内容以及相关数据的分页信息对象。

| 传参方式 | 参数                         | 返回                                                                 |
|------|----------------------------|--------------------------------------------------------------------|
| url  | title, startPage, pageSize | 按每页{pageSize}条记录划分所有标题为{title}的记录，其中第{startPage}页的记录以及相关信息的JSON字符串 |

**Example:**

* 请求：GET:/articles/title/paged/test article2/1/3

* Response Body:

  ```json
  {
    "total": 6,
    "list": [
      {
        "id": 5,
        "userId": 2,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article2",
        "tag": "test",
        "publishTime": "2022-06-12T15:26:40.000+08:00",
        "subscribeCount": 0,
        "content": "just another test article"
      },
      {
        "id": 6,
        "userId": 2,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article2",
        "tag": "test",
        "publishTime": "2022-06-12T15:26:40.000+08:00",
        "subscribeCount": 0,
        "content": "just another test article"
      },
      {
        "id": 7,
        "userId": 2,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article2",
        "tag": "test",
        "publishTime": "2022-06-12T15:26:40.000+08:00",
        "subscribeCount": 0,
        "content": "just another test article"
      }
    ],
    "pageNum": 1,
    "pageSize": 3,
    "size": 3,
    "startRow": 1,
    "endRow": 3,
    "pages": 2,
    "prePage": 0,
    "nextPage": 2,
    "isFirstPage": true,
    "isLastPage": false,
    "hasPreviousPage": false,
    "hasNextPage": true,
    "navigatePages": 8,
    "navigatepageNums": [
      1,
      2
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 2
  }
  ```

## 按title模糊搜索获取article资源接口

### GET:/article/counts/title/fuzzy/{title}

模糊查询名称为{title}的article资源数量，模糊查询规则为`like %{title}%`

| 传参方式 | 参数    | 返回                        |
|------|-------|---------------------------|
| url  | title | 文章标题模糊匹配{title}的article数量 |

**Example:**

* 请求：GET:/article/counts/title/fuzzy/test

* Response Body:

  ```json
  11
  ```

### GET:/articles/title/fuzzy/{title}

模糊查询名称为{title}的article资源列表，模糊查询规则为`like %{title}%`

| 传参方式 | 参数    | 返回                          |
|------|-------|-----------------------------|
| url  | title | 文章标题模糊匹配{title}的article对象列表 |

**Example:**

* 请求：GET:/articles/title/fuzzy/le2

* Response Body:

  ```json
  [
    {
      "id": 4,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2yeahhhhh",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article, butt for update this time"
    },
    {
      "id": 5,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 6,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 7,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 9,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 11,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 12,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    }
  ]
  ```

### GET:/articles/title/fuzzy/paged/{title}/{startPage}/{pageSize}

模糊查询名称为{title}的article资源数量，模糊查询规则为`like %{title}%`，并进行分页，返回分页信息和页内对象列表

| 传参方式 | 参数                         | 返回                                                                       |
|------|----------------------------|--------------------------------------------------------------------------|
| url  | title, startPage, pageSize | 按每页{pageSize}条记录划分所有标题能够模糊匹配上{title}的记录，其中第{startPage}页的记录以及相关信息的JSON字符串 |

**Example:**

* 请求：GET:/articles/title/fuzzy/paged/test/1/3

* Response Body:

  ```json
  {
    "total": 11,
    "list": [
      {
        "id": 1,
        "userId": 1,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article",
        "tag": "test",
        "publishTime": "2022-06-10T15:26:40.000+08:00",
        "subscribeCount": 0,
        "content": "has no content, its just test data"
      },
      {
        "id": 2,
        "userId": 2,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article",
        "tag": "test",
        "publishTime": "2022-06-10T15:27:11.000+08:00",
        "subscribeCount": 0,
        "content": "has no content, just test data"
      },
      {
        "id": 3,
        "userId": 1,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article",
        "tag": "test",
        "publishTime": "2022-06-10T15:27:51.000+08:00",
        "subscribeCount": 0,
        "content": "has no content, just another test data"
      }
    ],
    "pageNum": 1,
    "pageSize": 3,
    "size": 3,
    "startRow": 1,
    "endRow": 3,
    "pages": 4,
    "prePage": 0,
    "nextPage": 2,
    "isFirstPage": true,
    "isLastPage": false,
    "hasPreviousPage": false,
    "hasNextPage": true,
    "navigatePages": 8,
    "navigatepageNums": [
      1,
      2,
      3,
      4
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 4
  }
  ```

## 按tag获取article资源接口

以下是按tag获取article资源的相关的接口

### GET:/article/counts/tag/{tag}

获取tag为{tag}的article数量

| 传参方式 | 参数  | 返回                   |
|------|-----|----------------------|
| url  | tag | 所有标签为{tag}的article数量 |

**Example:**

* 请求：GET:/article/counts/tag/test

* Response Body:

  ```json
  10
  ```

### GET:/articles/tag/{tag}

获取包含全部tag为{tag}的article对象的数组

| 传参方式 | 参数  | 返回                        |
|------|-----|---------------------------|
| url  | tag | 包含全部标签为{tag}的article对象的数组 |

**Example:**

* 请求：GET:/articles/tag/test

* Response Body:

  ```json
  [
    {
      "id": 1,
      "userId": 1,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, its just test data"
    },
    {
      "id": 2,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:27:11.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, just test data"
    },
    {
      "id": 3,
      "userId": 1,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:27:51.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, just another test data"
    },
    {
      "id": 4,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2yeahhhhh",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article, butt for update this time"
    },
    {
      "id": 5,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 6,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 7,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 9,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 11,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 12,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    }
  ]
  ```

### GET:/articles/tag/paged/{tag}/{startPage}/{pageSize}

对全部tag为{tag}article对象进行分页，按{startPage}确定页数，按{pageSize}确定每页有多少数据，返回一个包含分页内容以及相关数据的分页信息对象。

| 传参方式 | 参数                       | 返回                                                               |
|------|--------------------------|------------------------------------------------------------------|
| url  | tag, startPage, pageSize | 按每页{pageSize}条记录划分所有标签为{tag}的记录，其中第{startPage}页的记录以及相关信息的JSON字符串 |

**Example:**

* 请求：GET:/articles/tag/paged/test/1/3

* Response Body:

  ```json
  {
    "total": 10,
    "list": [
      {
        "id": 1,
        "userId": 1,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article",
        "tag": "test",
        "publishTime": "2022-06-10T15:26:40.000+08:00",
        "subscribeCount": 0,
        "content": "has no content, its just test data"
      },
      {
        "id": 2,
        "userId": 2,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article",
        "tag": "test",
        "publishTime": "2022-06-10T15:27:11.000+08:00",
        "subscribeCount": 0,
        "content": "has no content, just test data"
      },
      {
        "id": 3,
        "userId": 1,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article",
        "tag": "test",
        "publishTime": "2022-06-10T15:27:51.000+08:00",
        "subscribeCount": 0,
        "content": "has no content, just another test data"
      }
    ],
    "pageNum": 1,
    "pageSize": 3,
    "size": 3,
    "startRow": 1,
    "endRow": 3,
    "pages": 4,
    "prePage": 0,
    "nextPage": 2,
    "isFirstPage": true,
    "isLastPage": false,
    "hasPreviousPage": false,
    "hasNextPage": true,
    "navigatePages": 8,
    "navigatepageNums": [
      1,
      2,
      3,
      4
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 4
  }
  ```

## 按发布时间获取article资源接口

### GET:/article/counts/publish_time/{publishTime}

获取发布于指定时间的article记录数量

| 传参方式 | 参数          | 返回                            |
|------|-------------|-------------------------------|
| url  | publishTime | 所有发布于为{publishTime}的article数量 |

**Example:**

* 请求：GET:/article/counts/publish_time/2022-06-10 15:27:51

* Response Body:

  ```json
  1
  ```

### GET:/articles/publish_time/{publishTime}

获取所有发布于指定时间的文章记录

| 传参方式 | 参数          | 返回                              |
|------|-------------|---------------------------------|
| url  | publishTime | 所有发布于为{publishTime}的article对象数组 |

**Example:**

* 请求：GET:/articles/publish_time/2022-06-10 15:27:51

* Response Body:

  ```json
  [
    {
      "id": 3,
      "userId": 1,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:27:51.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, just another test data"
    }
  ]
  ```

### GET:/articles/publish_time/paged/{publishTime}/{startPage}/{pageSize}

获取发布于指定时间的article记录数量，并进行分页，返回分页信息和页内对象列表

| 传参方式 | 参数                               | 返回                                                                         |
|------|----------------------------------|----------------------------------------------------------------------------|
| url  | publishTime, startPage, pageSize | 按每页{pageSize}条记录划分所有发布时间为{publishTime}的记录，其中第{startPage}页的记录以及相关信息的JSON字符串 |

**Example:**

* 请求：GET:/articles/publish_time/paged/2022-06-12 15:26:40/1/2

* Response Body:

  ```json
  {
    "total": 7,
    "list": [
      {
        "id": 4,
        "userId": 2,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article2yeahhhhh",
        "tag": "test",
        "publishTime": "2022-06-12T15:26:40.000+08:00",
        "subscribeCount": 0,
        "content": "just another test article, butt for update this time"
      },
      {
        "id": 5,
        "userId": 2,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article2",
        "tag": "test",
        "publishTime": "2022-06-12T15:26:40.000+08:00",
        "subscribeCount": 0,
        "content": "just another test article"
      }
    ],
    "pageNum": 1,
    "pageSize": 2,
    "size": 2,
    "startRow": 1,
    "endRow": 2,
    "pages": 4,
    "prePage": 0,
    "nextPage": 2,
    "isFirstPage": true,
    "isLastPage": false,
    "hasPreviousPage": false,
    "hasNextPage": true,
    "navigatePages": 8,
    "navigatepageNums": [
      1,
      2,
      3,
      4
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 4
  }
  ```

## 按发布时间范围获取article资源接口

### GET:/article/counts/publish_time/{startTime}/{endTime}

获取发布于指定时间范围内的article记录数量

| 传参方式 | 参数                 | 返回                                          |
|------|--------------------|---------------------------------------------|
| url  | startTime, endTime | 所有发布于[{startTime}, {endTime}]范围内的的article数量 |

**Example:**

* 请求：GET:/article/counts/publish_time/2022-06-10 15:26:40/2022-06-12 15:26:40

* Response Body:

  ```json
  10
  ```

### GET:/articles/publish_time/{startTime}/{endTime}

获取发布于指定时间范围的全部article记录

| 传参方式 | 参数                 | 返回                                               |
|------|--------------------|--------------------------------------------------|
| url  | startTime, endTime | 包含所有发布于[{startTime}, {endTime}]范围内的的article的对象数组 |

**Example:**

* 请求：GET:/articles/publish_time/2022-06-10 15:26:40/2022-06-12 15:26:40

* Response Body:

  ```json
  [
    {
      "id": 1,
      "userId": 1,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, its just test data"
    },
    {
      "id": 2,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:27:11.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, just test data"
    },
    {
      "id": 3,
      "userId": 1,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article",
      "tag": "test",
      "publishTime": "2022-06-10T15:27:51.000+08:00",
      "subscribeCount": 0,
      "content": "has no content, just another test data"
    },
    {
      "id": 4,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2yeahhhhh",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article, butt for update this time"
    },
    {
      "id": 5,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 6,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 7,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 9,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 11,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    },
    {
      "id": 12,
      "userId": 2,
      "commentCount": 0,
      "likeCount": 0,
      "readCount": 0,
      "title": "test article2",
      "tag": "test",
      "publishTime": "2022-06-12T15:26:40.000+08:00",
      "subscribeCount": 0,
      "content": "just another test article"
    }
  ]
  ```

### GET:/articles/publish_time/paged/{startTime}/{endTime}/{startPage}/{pageSize}

获取发布于指定时间范围内的article记录数量，并进行分页，返回分页信息和页内对象列表

| 传参方式 | 参数                                     | 返回                                                                                            |
|------|----------------------------------------|-----------------------------------------------------------------------------------------------|
| url  | startTime, endTime, startPage, pageSie | 按每页{pageSize}条记录划分所有发布于[{startTime}, {endTime}]范围内的article记录，其中第{startPage}页的记录以及相关信息的JSON字符串 |

**Example:**

* 请求：GET:/articles/publish_time/paged/2022-06-10 15:26:40/2022-06-12 15:26:40/1/3

* Response Body:

  ```json
  {
    "total": 10,
    "list": [
      {
        "id": 1,
        "userId": 1,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article",
        "tag": "test",
        "publishTime": "2022-06-10T15:26:40.000+08:00",
        "subscribeCount": 0,
        "content": "has no content, its just test data"
      },
      {
        "id": 2,
        "userId": 2,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article",
        "tag": "test",
        "publishTime": "2022-06-10T15:27:11.000+08:00",
        "subscribeCount": 0,
        "content": "has no content, just test data"
      },
      {
        "id": 3,
        "userId": 1,
        "commentCount": 0,
        "likeCount": 0,
        "readCount": 0,
        "title": "test article",
        "tag": "test",
        "publishTime": "2022-06-10T15:27:51.000+08:00",
        "subscribeCount": 0,
        "content": "has no content, just another test data"
      }
    ],
    "pageNum": 1,
    "pageSize": 3,
    "size": 3,
    "startRow": 1,
    "endRow": 3,
    "pages": 4,
    "prePage": 0,
    "nextPage": 2,
    "isFirstPage": true,
    "isLastPage": false,
    "hasPreviousPage": false,
    "hasNextPage": true,
    "navigatePages": 8,
    "navigatepageNums": [
      1,
      2,
      3,
      4
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 4
  }
  ```

## 新建article接口

以下是创建article资源的相关接口

### POST:/article

按RequestBody中包含的JSON对象创建新的article记录，注意article的id字段请省略或置为null(自动生成主键，无法指定),RequestBody中JSON对象的缺省字段或值为null字段的属性将被初始化为默认值(
Selective Insert)

| 传参方式         | 参数      | 返回      |
|--------------|---------|---------|
| request body | article | 新建资源的id |

**Example:**

* 请求：POST:/article

  request body:

  ```Json
  {
    "userId": 2,
    "commentCount": 0,
    "likeCount": 0,
    "readCount": 0,
    "title": "test article2",
    "tag": "test",
    "publishTime": "2022-06-12T15:26:40.000+00:00",
    "subscribeCount": 0,
    "content": "just another test article"
  }
  ```

* Response Body:

  ```json
  14
  ```

## 删除article接口

以下是删除article资源的相关接口

### DELETE:/article/{id}

删除id为{id}的article记录

| 传参方式 | 参数  | 返回  |
|------|-----|-----|
| url  | id  | /   |

**Example:**

* 请求：DELETE:/article/1

## 更新article接口

以下是更新article资源的相关接口

### PUT:/article

按RequestBody中包含的JSON对象的id属性去查找article记录，并更新该记录，RequestBody中JSON对象的缺省字段或值为null字段的属性将不被更新(Selective Update)

| 传参方式         | 参数      | 返回  |
|--------------|---------|-----|
| request body | article | /   |

**Example:**

* 请求：PUT:/article

  request body:

  ```Json
  {
    "userId": 2,
    "commentCount": 0,
    "likeCount": 0,
    "readCount": 0,
    "title": "test article2",
    "tag": "test",
    "publishTime": "2022-06-12T15:26:40.000+00:00",
    "subscribeCount": 0,
    "content": "just another test article"
  }
  ```
