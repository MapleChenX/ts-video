function queryURLParams() {
  let pattern = /(\w+)=(\w+)/gi;
  let params = {};
  getURL().replace(pattern, ($, $1, $2) => {
    params[$1] = $2;
  });
  return params;
}

function getURL() {
  return window.location.href;
}
