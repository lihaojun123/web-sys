---
id: nginx
title: nginx安装说明
---

### 安装依赖

```
yum install gcc
yum install pcre-devel
yum install zlib zlib-devel
yum install openssl openssl-devel
```

### 一键安装上面四个依赖

```
yum -y install gcc zlib zlib-devel pcre-devel openssl openssl-devel
```

### 下载nginx的tar包

创建一个文件夹

```
cd /usr/local
mkdir nginx
cd nginx
```

下载tar包

```
wget http://nginx.org/download/nginx-1.13.7.tar.gz
tar -zxvf nginx-1.13.7.tar.g
```

### 安装nginx

进入nginx目录

```
cd /usr/local/nginx
```

执行命令

```
./configure
```

执行make命令

```
make
```

执行make install命令

```
make install
```

启动命令
安装路径下的

```
/nginx/sbin/nginx
```


停止命令
安装路径下的

```
/nginx/sbin/nginx -s stop
```


或者 : nginx -s quit
重启命令
安装路径下的

```
/nginx/sbin/nginx -s reload
```

