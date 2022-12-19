import axios from "axios";

axios.defaults.baseURL = "http://localhost:8080/stu";

export function getCourses(data, success, error) {
  axios.post(`/query/courses`, data).then((res) => {
    success(res);
  }).catch(err => {
    error(err);
  });
}

export function getCoursesScore(data, success, error) {
  axios.post(`/query/scores`, data).then(res => {
    success(res);
  }).catch(err => {
    error(err);
  });
}

export function getSelf(data, success, error) {
  axios.post(`/query/self`, data).then(res => {
    success(res);
  }).catch(err => {
    error(err);
  });
}

export function updateSelf(data, success, error) {
  axios.post(`/update/self`, data).then(res => {
    success(res);
  }).catch(err => {
    error(err);
  });
}

export function getActs(data, success, error) {
  axios.post(`/query/acts`, data).then(res => {
    success(res);
  }).catch(err => {
    error(err);
  });
}