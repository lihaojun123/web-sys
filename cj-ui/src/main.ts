import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import Button from "../components"
createApp(App).use(router).use(Button).mount("#app");
