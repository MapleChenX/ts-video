const themeColors = {
  a: { color: "#2D8CF0", color2: "#79A2DC" },
  b: { color: "#FA7298", color2: "#E7B6C4" },
  c: { color: "#42B983", color2: "#89D7B2" },
  d: { color: "#607D8B", color2: "#A7C3D5" },
  e: { color: "#5E72E4", color2: "#8794DA" },
  f: { color: "#FF9700", color2: "#E0BF95" },
  g: { color: "#FF5722", color2: "#E1AA97" },
  h: { color: "#009688", color2: "#83E0D0" },
  i: { color: "#673BB7", color2: "#A283D9" },
  j: { color: "#906F61", color2: "#E1865E" },
};

function getTheme() {
  return sessionStorage.getItem(`silence-theme`);
}

function setTheme(theme) {
  sessionStorage.setItem(`silence-theme`, theme);
  $("html").attr("theme", theme);
}

function setMode() {
  sessionStorage.setItem(`silence-mode`, configs.defaultMode);
  $("html").attr("mode", configs.defaultMode);
}
