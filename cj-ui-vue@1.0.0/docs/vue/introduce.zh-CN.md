
# cj-ui of Vue




## 特性

- 提炼自企业级中后台产品的交互语言和视觉风格。
- 开箱即用的高质量 Vue 组件。

## 支持环境

* 现代浏览器和 IE9 及以上（需要 [polyfills](https://vuecomponent.github.io/ant-design/docs/react/getting-started-cn#兼容性)）。
* 支持服务端渲染。

## 版本

cj-ui@1.0.0

## 安装

### 使用 npm 或 yarn 安装

**我们推荐使用 npm 或 yarn 的方式进行开发**，不仅可在开发环境轻松调试，也可放心地在生产环境打包部署使用，享受整个生态圈和工具链带来的诸多好处。

```bash
$ npm install cj-ui --save
```

```bash
$ yarn add cj-ui
```

## 示例

```jsx
import Vue from 'vue'
import { DatePicker } from 'cj-ui';
Vue.component(DatePicker.name, DatePicker)
```

引入样式：

```jsx
import 'cj-ui/dist/antd.css';  // or 'vue-antd-ui/dist/antd.less'
```



