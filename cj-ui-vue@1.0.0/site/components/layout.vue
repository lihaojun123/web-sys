<script>
import * as AllDemo from '../demo'
import Header from './header'
import zhCN from 'antd/locale-provider/zh_CN'
import enUS from 'antd/locale-provider/default'
import _ from 'lodash'
import { isZhCN } from '../util'
import { Provider, create } from '../../components/_util/store'

export default {
  props: {
    name: String,
  },
  data() {
    this.store = create({
      currentSubMenu: [],
    })
    this.subscribe()
    return {
      currentSubMenu: [],
    }
  },
  beforeDestroy() {
    if (this.unsubscribe) {
      this.unsubscribe()
    }
  },
  watch: {
    '$route': function () {
      this.store.setState({ currentSubMenu: [] })
    },
  },
  methods: {
    subscribe() {
      const { store } = this
      this.unsubscribe = store.subscribe(() => {
        this.currentSubMenu = this.store.getState().currentSubMenu
      })
    },
    getSubMenu(isCN) {
      const currentSubMenu = this.currentSubMenu
      const lis = []
      currentSubMenu.forEach(({ cnTitle, usTitle, id }) => {
        const title = isCN ? cnTitle : usTitle
        const className = window.location.hash === `#${id}` ? 'current' : ''
        lis.push(<li title={title}><a href={`#${id}`} class={className}>{title}</a></li>)
      })
      return (
        <a-affix>
          <ul id='demo-toc' class='toc'>
            {lis}
            <li title='API' key='API'>
              <a
                href='#api'
                class={{
                  current: window.location.hash === '#api',
                }}
              >API</a>
            </li>
          </ul>
        </a-affix>
      )
    },
    getDocsMenu(isCN) {
      const docs = [
        // { key: 'introduce', enTitle: 'cj UI of Vue', title: 'cj UI of Vue' },
        // { key: 'getting-started', enTitle: 'Getting Started', title: '快速上手' },
        // { key: 'use-with-vue-cli', enTitle: 'Use in vue-cli', title: '在 vue-cli 中使用' },
        // { key: 'customize-theme', enTitle: 'Customize Theme', title: '定制主题' },
        // { key: 'i18n', enTitle: 'Internationalization', title: '国际化' },
      ]
      const docsMenu = []
      docs.forEach(({ key, enTitle, title }) => {
        const k = isCN ? `${key}-cn` : key
        docsMenu.push(<a-menu-item key={k}>
          <router-link to={`../cj-ui/docs/vue/${k}/`}>{isCN ? title : enTitle}</router-link>
        </a-menu-item>)
      })
      return docsMenu
    },
  },
  render() {
    const name = this.name
    const isCN = isZhCN(name)
    // name = name.replace(/-cn\/?$/, '')
    const titleMap = {}
    const menuConfig = {
      General: [],
      Layout: [],
      Navigation: [],
      'Data Entry': [],
      'Data Display': [],
      Feedback: [],
      Other: [],
    }
    for (const [title, d] of Object.entries(AllDemo)) {
      const type = d.type || 'Other'
      const key = `${title.replace(/(\B[A-Z])/g, '-$1').toLowerCase()}`
      titleMap[key] = title
      menuConfig[type] = menuConfig[type] || []
      menuConfig[type].push(d)
    }
    const Demo = AllDemo[titleMap[name.replace(/-cn\/?$/, '')]]
    const MenuGroup = []
    for (const [type, menus] of Object.entries(menuConfig)) {
      const MenuItems = []
      _.sortBy(menus, ['title']).forEach(({ title, subtitle }) => {
        const linkValue = isCN
          ? [<span>{title}</span>, <span class='chinese'>{subtitle}</span>]
          : [<span>{title}</span>]
        let key = `${title.replace(/(\B[A-Z])/g, '-$1').toLowerCase()}`
        if (isCN) {
          key = `${key}-cn`
        }
        MenuItems.push(<a-menu-item key={key}>
          <router-link to={`/cj-ui/components/${key}/`}>{linkValue}</router-link>
        </a-menu-item>)
      })
      MenuGroup.push(<a-menu-item-group title={type}>{MenuItems}</a-menu-item-group>)
    }
    let locale = zhCN
    if (!isCN) {
      locale = enUS
    }
    return (
      <div class='page-wrapper'>
        <Header num={Object.keys(AllDemo).length} name={name} />
        <a-locale-provider locale={locale}>
          <div class='main-wrapper'>
            <a-row>
              <a-col xxl={4} xl={5} lg={5} md={6} sm={24} xs={24}>
                <a-menu
                  class='aside-container menu-site'
                  selectedKeys={[name]}
                  defaultOpenKeys={['Components']}
                  inlineIndent={40}
                  mode='inline'>
                  {this.getDocsMenu(isCN)}
                  <a-sub-menu title='Components' key='Components'>
                    {MenuGroup}
                  </a-sub-menu>
                </a-menu>
              </a-col>
              <a-col xxl={20} xl={19} lg={19} md={18} sm={0} xs={0}>
                <div class='content main-container'>
                  <div class='toc-affix' style='width: 110px;'>
                    {Demo ? this.getSubMenu(isCN) : ''}
                  </div>
                  {Demo ? <Provider store={this.store}>
                    <Demo key={isCN ? 'cn' : 'en'} />
                  </Provider> : ''}
                  <div class='markdown api-container'>
                    <router-view></router-view>
                  </div>
                </div>
              </a-col>
            </a-row>
          </div>
        </a-locale-provider>
      </div>
    )
  },
}
</script>
