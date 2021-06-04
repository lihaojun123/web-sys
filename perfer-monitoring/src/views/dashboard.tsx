
import { defineComponent, ref } from 'vue'
import { useRouter } from 'vue-router';
import "./dashboard.less"
export default defineComponent(() => {
  const router = useRouter();
  const goIndex = () => {
    router.push('/index')
  }
  return () => (
    <div class="dashboard">
      <p style="text-align:right">
        <a-button type="primary">新建应用站点</a-button>
      </p>
      <a-row gutter="32">
        <a-col span="8">
          <div class="wrap">
            <div class="header">
              <span class="title" onClick={goIndex}>我的站点</span>
            </div>
          </div>
        </a-col>
        <a-col span="8">
          <div class="wrap">
            <div class="header">
              <span class="title" onClick={goIndex}>我的站点</span>
            </div>
          </div>
        </a-col>
        <a-col span="8">
          <div class="wrap">
            <div class="header">
              <span class="title" onClick={goIndex}>我的站点</span>
            </div>
          </div>
        </a-col>
      </a-row>
    </div>
  )
})

