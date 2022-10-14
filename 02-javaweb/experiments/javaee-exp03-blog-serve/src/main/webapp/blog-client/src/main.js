import { createApp } from "vue";
import { createPinia } from "pinia";
import { setTheme, setMode } from "./assets/js/theme-helper";

import App from "./App.vue";
import router from "./router";

import "./assets/main.css";
import "./assets/css/common.css";
import "./assets/css/layout.css";
import "./assets/css/theme.css";

const app = createApp(App);
app.use(router);
app.use(createPinia());
app.mount("#app");

setTheme();
setMode();
