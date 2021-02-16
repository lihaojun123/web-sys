
module.exports = {
  title: '前端技术学习总结',
  tagline: '组件库，vue,react，webpack,前端性能监控，d3学习等总结',
  url: 'https://your-docusaurus-test-site.com',
  baseUrl: '/',
  onBrokenLinks: 'throw',
  onBrokenMarkdownLinks: 'warn',
  favicon: 'img/favicon.ico',
  organizationName: '前端技术学习',
  projectName: '前端技术学习',
  themeConfig: {
    navbar: {
      title: '前端技术学习',

      items: [
        {
          to: 'docs/',
          activeBasePath: 'docs',
          label: '文档',
          position: 'left',
        },
        {
          href: 'http://121.4.130.239/cj-ui/',
          label: '组件库',
          position: 'left'
        },
        {
          href: 'https://github.com/facebook/docusaurus',
          label: 'd3(echart)',
          position: 'left'
        },
        {
          href: 'https://github.com/facebook/docusaurus',
          label: '前端性能监控',
          position: 'left'
        },
        { to: 'blog', label: '个人博客', position: 'left' },
        // Please keep GitHub link to the right for consistency.
        {
          href: 'https://github.com/lihaojun123/web-sys',
          label: 'GitHub',
          position: 'right',
        },
      ],
    },
    footer: {
      style: 'dark',
      links: [
        {
          title: 'Learn',
          items: [
            {
              label: 'vue',
              href: 'https://cn.vuejs.org/',
            },
            {
              label: 'react',
              href: 'https://react.docschina.org/',
            },
            {
              label: 'angular',
              href: 'https://angular.cn/',
            },
            {
              label: 'webapck',
              href: 'https://webpack.docschina.org/',
            }
          ],
        },
        {
          title: 'Community',
          items: [
            {
              label: 'Stack Overflow',
              href: 'https://stackoverflow.com/questions/tagged/docusaurus',
            },
            {
              label: 'Twitter',
              href: 'https://twitter.com/docusaurus',
            },
            {
              label: 'Discord',
              href: 'https://discordapp.com/invite/docusaurus',
            },
          ],
        },
        {
          title: 'More',
          items: [
            {
              label: 'd3',
              href: 'https://d3js.org/',
            },
            {
              label: 'GitHub',
              href: 'https://github.com/lihaojun123/web-sys',
            },
          ],
        }
      ],

      // Please do not remove the credits, help to publicize Docusaurus :)
      copyright: `Copyright © ${new Date().getFullYear()}`,
    },
  },
  presets: [
    [
      '@docusaurus/preset-classic',
      {
        docs: {
          sidebarPath: require.resolve('./sidebars.js'),
          // Please change this to your repo.
          editUrl:
            'https://github.com/lihaojun123/web-sys/tree/master/cj-doc/',
        },
        theme: {
          customCss: require.resolve('./src/css/custom.css'),
        },
      },
    ],
  ],
};
