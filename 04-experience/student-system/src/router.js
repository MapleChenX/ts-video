import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
  {
    path: "/h",
    component: () => import("./components/Home.vue"),
    children: [
      {
        name: "Course",
        path: "stu/course",
        component: () => import("./components/student/Course.vue")
      },
      {
        name: "CourseScore",
        path: "stu/course/score",
        component: () => import("./components/student/CourseScore.vue")
      },
      {
        name: "MyInfo",
        path: "stu/self",
        component: () => import("./components/student/MyInfo.vue")
      },
      {
        name: "MyActs",
        path: "stu/acts",
        component: () => import("./components/student/MyActs.vue")
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