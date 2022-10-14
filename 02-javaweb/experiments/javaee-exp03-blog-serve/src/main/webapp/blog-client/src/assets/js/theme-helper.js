import { configs } from "../config/index";
import $ from "jquery";

export function getTheme() {
  return sessionStorage.getItem(`silence-theme`);
}

export function setTheme() {
  sessionStorage.setItem(`silence-theme`, configs.defaultTheme);
  $("html").attr("theme", configs.defaultTheme);
}

export function setMode() {
  sessionStorage.setItem(`silence-mode`, configs.defaultMode);
  $("html").attr("mode", configs.defaultMode);
}
