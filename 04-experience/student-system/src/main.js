import { createApp } from "vue";
import router from "./router";
import App from "./App.vue";
import "./style.css";
import "element-plus/dist/index.css";

createApp(App)
  .use(router)
  .mount("#app");