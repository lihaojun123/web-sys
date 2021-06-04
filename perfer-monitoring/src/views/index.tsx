import { defineComponent, ref, reactive } from "vue"
export default defineComponent({
  setup() {
    const selectedKeys2 = ref<number[]>([3]);
    const meauData = reactive({
      meanu: [{
        key: 1,
        title: 'dashboard',
        path: '/xxx1'
      }, {
        key: 2,
        title: '访问页面',
        path: '/xxx2'
      }, {
        key: 3,
        title: '访问速度',
        path: '/xxx1'
      }, {
        key: 4,
        title: 'JS错误',
        path: '/xxx1'
      }, {
        key: 5,
        title: 'Api请求',
        path: '/xxx1'
      }, {
        key: 6,
        title: '地理',
        path: '/xxx1'
      }, {
        key: 7,
        title: '终端',
        path: '/xxx1'
      }, {
        key: 8,
        title: '设置',
        path: '/xxx1'
      }]
    })
    const selectActive = (item: any) => {
      console.log(item)
      selectedKeys2.value = item.selectedKeys
    }
    return () => {
      const menuList = meauData.meanu
      return (
        <div>
          <a-layout>
            <a-layout-content>
              <a-layout >
                <a-layout-sider width="200"
                >
                  <a-menu mode="inline"
                    selectedKeys={selectedKeys2}
                    onSelect={selectActive}
                  >
                    {menuList.map((item) => {
                      return (
                        <a-menu-item key={item.key}>
                          <router-link to={item.path}>
                            <span>{item.title}</span>
                          </router-link>
                        </a-menu-item>
                      )
                    })}
                  </a-menu>
                </a-layout-sider>
                <a-layout-content >
                  <router-view></router-view>
                </a-layout-content>
              </a-layout>
            </a-layout-content>
            <a-layout-footer>
              Ant Design ©2018 Created by Ant UED
             </a-layout-footer>
          </a-layout>
        </div>
      )
    }
  }
})