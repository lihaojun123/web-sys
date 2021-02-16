<script>
import { isZhCN } from '../util'
export default {
  props: {
    num: Number,
    name: String,
  },
  data() {
    return {
      current: ["components"]
    }
  },
  methods: {
    handleClick() {
      const name = this.name
      const path = this.$route.path
      const newName = isZhCN(name) ? name.replace(/-cn\/?$/, '') : `${name}-cn`
      this.$router.push({
        path: path.replace(name, newName),
      })
    },
    changeMenu(event) {
      this.$message.warning('系统持续升级中，敬请期待!');
    }
  },
  render() {
    const name = this.name
    const isCN = isZhCN(name)
    const current = this.current
    return (
      <header id='header'>
        <a-row>
          <a-col xxl={4} xl={5} lg={5} md={6} sm={24} xs={24}>
            <router-link to={{ path: '/cj-ui' }} id='logo'>
              <img alt='logo' height='32' src='http://qmcwivzc2.hd-bkt.clouddn.com/cj-logo.png' />
              <span>web生态体系</span>
            </router-link>
          </a-col>
          <a-col xxl={20} xl={19} lg={19} md={18} sm={0} xs={0}>
            <div id='search-box'>
              进度：{this.num} / 52
            </div>
            <a-button ghost size='small' onClick={this.handleClick} class='header-lang-button' key='lang-button'>
              {isCN ? 'English' : '中文'}
            </a-button>
            <a-menu selectedKeys={current} mode='horizontal' class='menu-site' id='nav' onClick={this.changeMenu}>
              <a-menu-item key='performanceMonitor'>
                {isCN ? '前端性能监控' : 'performance-monitor'}
              </a-menu-item>
              <a-menu-item key='cjcli'>
                {isCN ? '脚手架工具' : 'cj-cli'}
              </a-menu-item>
              <a-menu-item key='echarts'>
                {isCN ? '数据可视化' : 'echarts'}
              </a-menu-item>
              <a-menu-item key='components'>
                {isCN ? '组件' : 'Components'}
              </a-menu-item>
              <a-menu-item key='github'>
                <a href='https://github.com/lihaojun123/express'>GitHub</a>
              </a-menu-item>
            </a-menu>
          </a-col>
        </a-row>
      </header>
    )
  },
}
</script>
