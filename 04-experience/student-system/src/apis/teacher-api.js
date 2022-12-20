import axios from "axios";

export function getCourses(data, success, error) {
  axios.post(`http://localhost:8080/tch/query/courses`, data).then((res) => {
    success(res);
  }).catch(err => {
    error(err);
  });
}

export function getStuCourses(data, success, error) {
  axios.post(`http://localhost:8080/tch/query/stu/courses`, data).then((res) => {
    success(res);
  }).catch(err => {
    error(err);
  });
}

export function updateStuCourseScore(data, success, error) {
  axios.post(`http://localhost:8080/tch/update/course/score`, data).then((res) => {
    success(res);
  }).catch(err => {
    error(err);
  });
}