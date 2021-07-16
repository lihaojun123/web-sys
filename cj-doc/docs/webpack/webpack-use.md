---
id: webpack-use
title: 为什么选择webpack
---

#### 前言

在构建工具出现之前，我们是如何在web应用中使用javascript的

在浏览器中，我们一般以一个js文件保存一个页面的功能，或者加载一个js文件包含整个项目的功能，显而易见，这种实现方式，很难维护，拓展性差，全局变量过多等问题

随即，为了解决函数作用域问题，出现了立即调用函数表达式（IIFE），比如

```
(funciton(){
//函数体
})()
```

当脚本文件，封装在IIFE内部时，可以随意拼接所有文件，而不必担心作用域问题

从而产生了，gulp，grunt，等任务执行器，它们将所有文件，拼接在一起，但如何判断拼接在一起的文件中的某个函数被使用，即使你只是用到了某个函数，但依然要把整个文件压缩进来，如何解决代码依赖，减少文件体积？难以大规模的实现延迟加载代码块！

#### javascript模块

 CommonJS 问世并引入了 `require` 机制，它允许你在当前文件中加载和使用某个模块。导入需要的每个模块，这一开箱即用的功能，帮助我们解决了作用域问题 

 但 CommonJS 没有浏览器支持。没有 [live binding(实时绑定)](https://medium.com/webpack/the-state-of-javascript-modules-4636d1774358)。循环引用存在问题。同步执行的模块解析加载器速度很慢。虽然 CommonJS 是 Node.js 项目的绝佳解决方案，但浏览器不支持模块，因而产生了 Browserify, RequireJS 和 SystemJS 等打包工具，允许我们编写能够在浏览器中运行的 CommonJS 模块。 

 传统的任务构建工具基于 Google 的 Closure 编译器都要求你手动在顶部声明所有的依赖。然而像 webpack 一类的打包工具自动构建并基于你所引用或导出的内容推断出[依赖的图谱](https://webpack.docschina.org/concepts/dependency-graph/)。这个特性与其它的如[插件](https://webpack.docschina.org/concepts/plugins/) and [加载器](https://webpack.docschina.org/concepts/loaders/)一道让开发者的体验更好。 

#### webpack工具

不仅可以让我们编写模块，而且还支持任何模块格式（至少在我们到达 ESM 之前），并且可以同时处理资源和资产？

这就是 webpack 存在的原因。它是一个工具，可以打包你的 JavaScript 应用程序（支持 ESM 和 CommonJS），可以扩展为支持许多不同的资产，例如：images, fonts 和 stylesheets。

#### webpack内部原理

项目中使用的每一个文件都是一个模块，这些模块的互相引用，会形成一个图，

在打包的过程中，模块之间会合并成一个chunk，chunk合并成chunk组，并形成一个通过模块连接的图，什么意思呢？

入口文件：

```
module.exports = {
  entry: './index.js',
};
```

执行时，会创建一个main的chunk组，此chunk组内有一个index.js模块，index.js模块中如果有import时，import导入的新模块就会被添加到整个组内

以此类推，如果有两个或者多个入口文件，执行时，会创建多个chunk组，chunk组内，都有包含模块的chunk

#### chunk

chunk有两种形式

1.initial(初始化)，是入口起点的main chunk，此chunk包含入口起点指定的所有模块

2 non-initial，延迟加载的块， 可能会出现在使用 [动态导入(dynamic imports)](https://webpack.docschina.org/guides/code-splitting/#dynamic-imports) 或者 [SplitChunksPlugin](https://webpack.docschina.org/plugins/split-chunks-plugin/) 时。 

这两种chunk都对应相应的资源，

webpack.config.js

```
module.exports={
  entry:'./index.js'
}
```

index.js

```
import React from 'react';
import ReactDOM from 'react-dom';

import('./app.jsx').then((App) => {
  ReactDOM.render(<App />, root);
});
```

这会创建出一个名为 `main` 的 initial chunk。其中包含：

- `./src/index.jsx`
- `react`
- `react-dom`

以及除 `./app.jsx` 外的所有依赖

然后会为 `./app.jsx` 创建 non-initial chunk，这是因为 `./app.jsx` 是动态导入的。

**Output:**

- `/dist/main.js` - 一个 `initial` chunk

- `/dist/394.js` - `non-initial` chunk

  

## output(输出) 

输出文件的名称会受配置中的两个字段的影响：

- [`output.filename`](https://webpack.docschina.org/configuration/output/#outputfilename) - 用于 `initial` chunk 文件
- [`output.chunkFilename`](https://webpack.docschina.org/configuration/output/#outputchunkfilename) - 用于 `non-initial` chunk 文件
- 在某些情况下，使用 `initial` 和 `non-initial` 的 chunk 时，可以使用 `output.filename`。

这些字段中会有一些 [占位符](https://webpack.docschina.org/configuration/output/#template-strings)。常用的占位符如下：

- `[id]` - chunk id（例如 `[id].js` -> `485.js`）
- `[name]` - chunk name（例如 `[name].js` -> `app.js`）。如果 chunk 没有名称，则会使用其 id 作为名称
- `[contenthash]` - 输出文件内容的 md4-hash（例如 `[contenthash].js` -> `4ea6ff1de66c537eb9b2.js`）

