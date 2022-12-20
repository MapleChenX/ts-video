import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
  {
    path: "/h",
    component: () => import("./components/Home.vue"),
    children: [
      {
        name: "StuCourse",
        path: "stu/course",
        component: () => import("./components/student/Course.vue")
      },
      {
        name: "StuCourseScore",
        path: "stu/course/score",
        component: () => import("./components/student/CourseScore.vue")
      },
      {
        name: "StuMyInfo",
        path: "stu/self",
        component: () => import("./components/student/MyInfo.vue")
      },
      {
        name: "StuMyActs",
        path: "stu/acts",
        component: () => import("./components/student/MyActs.vue")
      },
      {
        name: "TchCourse",
        path: "tch/course",
        component: () => import("./components/teacher/TchCourse.vue")
      },
      {
        name: "TchCourseScore",
        path: "tch/course/score",
        component: () => import("./components/teacher/TchCourseScore.vue")
      },
      {
        name: "TchMyInfo",
        path: "tch/self",
        component: () => import("./components/teacher/TchMyInfo.vue")
      }
    ]
  },
  {
    path: "/login",
    name: "Login",
    component: () => import("./components/Login.vue")
  }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes
});

export default router;