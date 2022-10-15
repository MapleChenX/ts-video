import { createApp } from "vue";
import { createPinia } from "pinia";
import App from "@/App.vue";
import router from "@/router";

import { setTheme, setMode } from "@/assets/js/theme-helper";
import "bytemd/dist/index.css";
import "@/assets/main.css";
import "@/assets/css/common.css";
import "@/assets/css/layout.css";
import "@/assets/css/theme.css";
import "element-plus/theme-chalk/dark/css-vars.css";
import "element-plus/dist/index.css";

const app = createApp(App);
app.use(router);
app.use(createPinia());
app.mount("#app");

setTheme();
setMode();
