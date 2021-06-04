<template>
  <a-layout>
    <a-layout-content>
      <a-layout style="padding: 24px 0; background: #fff">
        <a-layout-sider width="200"
                        style="background: #fff">
          <a-menu mode="inline"
                  :selectedKeys="selectedKeys2"
                  style="height: 100%">
            <a-menu-item key="1">
              <span>dashboard</span>
            </a-menu-item>
            <a-menu-item key="2">
              <span>访问页面</span>
            </a-menu-item>
            <a-menu-item key="3">
              <span>访问速度</span>
            </a-menu-item>
            <a-menu-item key="4">
              <span>JS错误</span>
            </a-menu-item>
            <a-menu-item key="5">
              <span>Api请求</span>
            </a-menu-item>
            <a-menu-item key="6">
              <span>地理</span>
            </a-menu-item>
            <a-menu-item key="7">
              <span>终端</span>
            </a-menu-item>
            <a-menu-item key="8">
              <span>设置</span>
            </a-menu-item>
          </a-menu>
        </a-layout-sider>
        <a-layout-content :style="{ padding: '0 24px', minHeight: '700px' }">
          Content
        </a-layout-content>
      </a-layout>
    </a-layout-content>
    <a-layout-footer style="text-align: center">
      Ant Design ©2018 Created by Ant UED
    </a-layout-footer>
  </a-layout>
</template>
<script lang="ts">
import { defineComponent, ref } from "vue";
export default defineComponent({
  components: {},
  setup() {
    return {
      selectedKeys2: ref<string[]>(["3"]),
    };
  },
});
</script>
<style>
</style>


