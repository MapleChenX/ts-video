import { configs } from "../config/index";
import $ from "jquery";

class Theme {
  getTheme() {
    return sessionStorage.getItem(`silence-theme`);
  }

  setTheme() {
    sessionStorage.setItem(`silence-theme`, configs.defaultTheme);
    $("html").attr("theme", configs.defaultTheme);
    return this;
  }

  setMode() {
    sessionStorage.setItem(`silence-mode`, configs.defaultMode);
    $("html").attr("mode", configs.defaultMode);
    return this;
  }

  getMode() {
    return sessionStorage.getItem(`silence-mode`);
  }
}

export { Theme };
