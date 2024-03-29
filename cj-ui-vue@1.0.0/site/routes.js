import Layout from './components/layout.vue'

const AsyncTestComp = () => {
  const d = window.location.hash.replace('#', '')
  return {
    component: import(`../components/transfer/demo/${d}`),
  }
}

export default [
  { path: '/cj-ui/components/:name/', component: Layout, props: true },
  {
    path: '/cj-ui',
    component: Layout,
    props: (route) => {
      const name = route.path.split('/docs/vue/')[1].split('/')[0]
      return { name }
    },
    children: [
      {
        path: 'docs/vue/customize-theme',
        component: () => import('../docs/vue/customize-theme.en-US.md'),
      },
      {
        path: 'docs/vue/customize-theme-cn',
        component: () => import('../docs/vue/customize-theme.zh-CN.md'),
      },
      {
        path: 'docs/vue/getting-started',
        component: () => import('../docs/vue/getting-started.en-US.md'),
      },
      {
        path: 'docs/vue/getting-started-cn',
        component: () => import('../docs/vue/getting-started.zh-CN.md'),
      },
      {
        path: 'docs/vue/i18n',
        component: () => import('../docs/vue/i18n.en-US.md'),
      },
      {
        path: 'docs/vue/i18n-cn',
        component: () => import('../docs/vue/i18n.zh-CN.md'),
      },
      {
        path: 'docs/vue/introduce',
        component: () => import('../docs/vue/introduce.en-US.md'),
      },
      {
        path: 'docs/vue/introduce-cn',
        component: () => import('../docs/vue/introduce.zh-CN.md'),
      },
      {
        path: 'docs/vue/use-with-vue-cli',
        component: () => import('../docs/vue/use-with-vue-cli.en-US.md'),
      },
      {
        path: 'docs/vue/use-with-vue-cli-cn',
        component: () => import('../docs/vue/use-with-vue-cli.zh-CN.md'),
      },
      { path: '', redirect: '/' },
    ],
  },

  { path: '/:prefix?/test/:demo?/', component: AsyncTestComp },
  { path: '/*', redirect: '/' },
]
