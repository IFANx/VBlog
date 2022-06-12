# Rest API: Article

以下是Article相关资源的REST API

## 单个article资源获取接口

### GET:article/{id}

根据传入的{id}获取唯一的article对象

## 全部article资源获取接口

以下是获取全部article相关的接口

### GET:article/counts

获取总article的数量

### GET:articles

获取包含全部article对象的数组

### GET:articles/paged/{startPage}/{pageSize}

对全部article对象进行分页，按{startPage}确定页数，按{pageSize}确定每页有多少数据，返回一个包含分页内容以及相关数据的分页信息对象。

## 按title获取article资源接口

以下是按title获取article资源的相关的接口

### GET:article/counts/title/{title}

获取title为{title}的article数量

### GET:articles/title/{title}

获取包含全部title为{title}的article对象的数组

### GET:articles/title/paged/{title}/{startPage}/{pageSize}

对全部title为{title}article对象进行分页，按{startPage}确定页数，按{pageSize}确定每页有多少数据，返回一个包含分页内容以及相关数据的分页信息对象。

## 按tag获取article资源接口

以下是按tag获取article资源的相关的接口

### GET:article/counts/tag/{tag}

获取tag为{tag}的article数量

### GET:articles/tag/{tag}

获取包含全部tag为{tag}的article对象的数组

### GET:articles/tag/paged/{tag}/{startPage}/{pageSize}

对全部tag为{tag}article对象进行分页，按{startPage}确定页数，按{pageSize}确定每页有多少数据，返回一个包含分页内容以及相关数据的分页信息对象。

## 新建article接口

以下是创建article资源的相关接口

### POST:article

按RequestBody中包含的JSON对象创建新的article记录，注意article的id字段请省略或置为null(自动生成主键，无法指定),RequestBody中JSON对象的缺省字段或值为null字段的属性将被初始化为默认值(
Selective Insert)

## 删除article接口

以下是删除article资源的相关接口

### DELETE:article/{id}

删除id为{id}的article记录

## 更新article接口

以下是更新article资源的相关接口

### PUT:article

按RequestBody中包含的JSON对象的id属性去查找article记录，并更新该记录，RequestBody中JSON对象的缺省字段或值为null字段的属性将不被更新(Selective Update)
