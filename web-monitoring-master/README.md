# web-monitoring

###  [功能列表]

- [x] 允许用户创建多个监测站点
- [x] 从不同维度统计用户访问情况
- [x] 自定义查询时间
- [x] 多种图表展示
- [x] 支持自定义上报（js错误，api请求，性能信息）
- [x] 用户访问路径追踪
- [x] 自定义阈值(注册用户)
- [x] 自动报警功能，发送报警邮件提醒(注册用户)

------
###  [技术支持]

- [x] 前端：Angular5+,ant-design
- [x] 后端：Nodejs+Express
- [x] 数据库：Mongoose+MongoDB


------
前端监控平台专注于 Web 端体验数据监控。监测 Web 页面的健康度的三个方面：
> * 页面打开速度（测速）
> * 页面稳定性（JS Error）
> * 外部服务调用成功率（API）

然后从不同纬度去分析用户体验。

 >  - 访问页面
 >  - 访问速度
 >  - API请求
 >  - 地理
 >  - 终端
 


参考：
>  http://fex.baidu.com/blog/2014/05/build-performance-monitor-in-7-days

>  阿里云前端监控


### 页面打开速度

网络耗时数据可以借助前面提到 Navigation Timing 接口获取，与之类似的还有Resource Timing,可以获取页面所有静态资源的加载耗时。通过此接口可以轻松获取 DNS、TCP、首字节、html 传输等耗时，Navigation Timing 的接口示意图如下所示：

![file-list](https://github.com/kisslove/web-front-end-monitoring/blob/master/Demo/timing.png)


### API请求

默认情况下，使用XMLHTTP拦截用户请求，在请求成功/失败后，统计时间，上报请求。
用户可使用**__ml.api(api,success, time, code, msg)**手动上报。
```javascript
 api:请求接口
 success:上传是否成功(true/false )
 time:耗时(ms)
 code:返回码
 msg:消息(string/object)
```
### JS错误

默认情况下，使用window.onError去监听用户错误脚本，自动上报。
用户使用的有些前端框架会捕获js错误，错误信息不会抛至window.onError,这种情况需用户手动调用。
例如在Angular2+，在你的框架全局捕获错误的地方调用**__ml.error(errorObj)**
```javascript
  export class MyErrorHandler implements ErrorHandler {
      handleError(error) {
        console.error(error);
        window.__ml && window.__ml.error && window.__ml.error(error.stack ||     error);
      }
    }
    @NgModule({
      declarations: [],
      imports: [],
      providers: [{ provide: ErrorHandler, useClass: MyErrorHandler }],
      bootstrap: []
    })
    export class AppModule { }
```
在Vue:
```javascript
import Vue from 'vue'
const errorHandler = (error, vm)=>{
 console.error(error);
 window.__ml && window.__ml.error && window.__ml.error(error);
}
Vue.config.errorHandler = errorHandler;
Vue.prototype.$throw = (error)=> errorHandler(error,this);
```
### 如何使用(easy!!!)  

网页地址：<a href="http://hubing.online:8083" target="_blank">WEB-MONITOR</a>

第一步：在监控站点中创建一个站点。

![file-list](https://github.com/kisslove/web-front-end-monitoring/blob/master/Demo/demo1.png)

第二步：复制应用配置中的探针到你需要监控的站点（index.html）页面。大功告成！

![file-list](https://github.com/kisslove/web-front-end-monitoring/blob/master/Demo/demo2.png)

### 贡献者支持

您的支持，是我们最大的前进动力。

支付宝：

![file-list](https://github.com/kisslove/web-front-end-monitoring/blob/master/Demo/zhifubao.png)

微信：

![file-list](https://github.com/kisslove/web-front-end-monitoring/blob/master/Demo/weixin.png)

