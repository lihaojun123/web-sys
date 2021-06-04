import { defineComponent, ref } from 'vue'
import { useRouter } from 'vue-router';
import "./home.less"
export default defineComponent(() => {
  const router = useRouter();
  const goDashboard = () => {
    router.push('/dashboard')
  }
  return () => (
    <div class="home">
      <div id="deccription">
        <div class="title">前端监控平台</div>
        <div class="desc">
          日活跃、用户行为记录、访问日志、JS错误日志、API请求详情、访问性能评估，开发者必须关心的各种运营数据
      </div>
        <div class="opt" >
          <button onClick={goDashboard}>马上体验</button>
        </div>
      </div>
    </div>
  )
})

