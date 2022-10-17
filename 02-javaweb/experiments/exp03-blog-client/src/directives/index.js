import hljs from "highlight.js";
import "highlight.js/styles/atom-one-dark.css";

class Directives {
  constructor(app) {
    this.app = app;
  }

  parseCode() {
    this.app.directive("parse-code", (el, binding) => {
      let blocks = el.querySelectorAll("pre code");
      let imgs = el.querySelectorAll("img");
      blocks.forEach(block => {
        hljs.highlightBlock(block);
      });
      imgs.forEach(img => {
        img.style.width = "100%";
        img.style.height = "100%";
        img.style.objectFit = "cover";
      });
    });
  }
}

export { Directives };
