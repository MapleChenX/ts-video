import axios from "axios";

export function getCourses(data, success, error) {
  axios.post(`http://localhost:8080/stu/query/courses`, data).then((res) => {
    success(res);
  }).catch(err => {
    error(err);
  });
}

export function getCoursesScore(data, success, error) {
  axios.post(`http://localhost:8080/stu/query/scores`, data).then(res => {
    success(res);
  }).catch(err => {
    error(err);
  });
}

export function getSelf(data, success, error) {
  axios.post(`http://localhost:8080/stu/query/self`, data).then(res => {
    success(res);
  }).catch(err => {
    error(err);
  });
}

export function updateSelf(data, success, error) {
  axios.post(`http://localhost:8080/stu/update/self`, data).then(res => {
    success(res);
  }).catch(err => {
    error(err);
  });
}

export function getActs(data, success, error) {
  axios.post(`http://localhost:8080/stu/query/acts`, data).then(res => {
    success(res);
  }).catch(err => {
    error(err);
  });
}