<template>
  <div>
    <p>我是标题</p>
    <slot :list="list">
       <div>
          <li v-for="(item,index) in list" :key="index">{{item.id}}</li>
       </div>
    </slot>
  </div>
</template>
<script>
export default {
  data() {
    return {
      list: [
        {
          id: 1
        }, {
          id: 2
        }
      ]
    }
  }
}
</script>