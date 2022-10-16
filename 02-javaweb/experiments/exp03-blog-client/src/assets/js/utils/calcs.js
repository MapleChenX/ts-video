export function calcBlogAge(datetime) {
  let endtime = new Date(datetime);
  let nowtime = new Date();
  let milliseconds = nowtime.getTime() - endtime.getTime();
  let seconds = Math.round(milliseconds / 1000);
  let minutes = Math.round(milliseconds / 1000 / 60);
  let hours = Math.round(milliseconds / 1000 / 60 / 60);
  let days = Math.round(milliseconds / 1000 / 60 / 60 / 24);
  let months = Math.round(milliseconds / 1000 / 60 / 60 / 24 / 30);
  return { seconds, minutes, hours, days, months };
}
