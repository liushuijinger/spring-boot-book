# 附录：使用 Docker 配置开发环境



## Docker 常用命令



### 镜像操作

```bash
# 搜索镜像
docker search <镜像名>
# 例：搜索 MySQL
docker search mysql

# 安装镜像
docker pull <镜像名>
# 例：安装 MySQL
docker pull mysql

# 查看所有镜像
docker images

# 删除镜像
docker rmi <镜像ID>/<镜像名:tag>
# 例：删除 MySQL 镜像
docker rmi mysql
```

> 如果省略 tag 参数，则使用 tag 的默认值，一般为 latest。



### 容器操作



```bash
# 创建并运行容器
docker run --name <容器名> -p <主机端口>:<容器端口> -d -e <环境变量> <镜像名:tag>
# 例：创建并运行 MySQL 容器
docker run --name mysql -p 3305:3306 -d -e MYSQL_ROOT_PASSWORD=123456 mysql
```



容器创建后，可以对容器进行启动、停止、重启等操作。

```bash
# 启动容器
docker start <容器ID>/<容器名>
# 例：启动 MySQL 容器
docker start mysql

# 停止容器
docker stop <容器ID>/<容器名>
# 例：停止 MySQL 容器
docker stop mysql

# 重启容器
docker restart <容器ID>/<容器名>
# 例：重启 MySQL 容器
docker restart mysql

# 删除容器
docker rm <容器ID>/<容器名>
# 例：删除 MySQL 容器
docker rm mysql

# 查看正在运行的容器
docker ps

# 查看所有容器
docker ps -a

# 进入容器
docker exec -it <容器ID>/<容器名> bash
# 例：进入 MySQL 容器
docker exec -it mysql bash

# 创建客户端登录容器
docker run -it --rm <镜像名> <连接命令> -h<宿主机IP> <连接参数>
# 例：使用 MySQL 客户端连接 MySQL 容器
docker run -it --rm mysql mysql -h172.17.0.2 -uroot -p
```



## 安装环境



### 安装 MySQL



```bash
# 拉取镜像
docker pull mysql

# 运行
docker run --name mysql -p 3305:3306 -d -e MYSQL_ROOT_PASSWORD=123456 mysql
```





### 安装 Redis



```bash
# 拉取镜像
docker pull redis

# 运行
docker run --name redis -p 6379:6379 -d redis
```





### 安装 RabbitMQ



```bash
# 拉取镜像
docker pull rabbitmq:management

# 运行
docker run --name rabbitmq -p 5672:5672 -p 15672:15672 -d rabbitmq:management
```





### 安装 Elasticsearch



```bash
# 拉取镜像
docker pull elasticsearch:7.14.2

# 运行
docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:7.14.2
```



#### 安装 ik 分词器

```bash
# 进入容器
docker exec -it elasticsearch bash

# 安装 ik 分词器
./bin/elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.14.2/elasticsearch-analysis-ik-7.14.2.zip

# 重启 elasticsearch
docker restart elasticsearch
```

> 分词字典位置：config/analysis-ik



#### 解决中文乱码

```bash
# 创建 ~/.vimrc 文件
touch ~/.vimrc

# 编辑
vi ~/.vimrc

set fileencodings=utf-8,ucs-bom,gb18030,gbk,gb2312,cp936
set termencoding=utf-8
set encoding=utf-8

# 重启 elasticsearch
docker restart elasticsearch
```