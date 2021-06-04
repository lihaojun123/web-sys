import { App } from 'vue';
import { default as Button } from './button/index';
const components = [
  Button
]
const install = function (app: App) {
  components.forEach(component => {
    app.use(component);
  })
}
export default {
  install
};