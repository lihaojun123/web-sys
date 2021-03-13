<template>
  <div id="app">
    <jsx-demo></jsx-demo>
    <child>
      <template v-slot:default="{list}">
        <div>
          <p v-for="(item,index) in list"
             :key="index">{{item.id}}</p>
        </div>
      </template>
    </child>
  </div>
</template>

<script>

import JsxDemo from "./components/jsx-demo"
import Child from "./components/child"
export default {
  name: 'App',
  components: {
    JsxDemo,
    Child
  }
}
</script>

<style>
</style>
