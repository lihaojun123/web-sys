<template>
  <div>
    <div>
      <a-layout>
        <a-layout-header class="header">
          <LineChartOutlined /><span style="margin-left:10px">前端性能监控</span>
        </a-layout-header>
      </a-layout>
    </div>
    <router-view></router-view>
  </div>
</template>
<script lang="ts">
import { Options, Vue } from "vue-class-component";
import { LineChartOutlined } from "@ant-design/icons-vue";
@Options({
  components: { LineChartOutlined },
})
export default class Home extends Vue {}
</script>
<style lang="less" scoped>
.header {
  background: #096dd9;
  color: #fff;
}
</style>
