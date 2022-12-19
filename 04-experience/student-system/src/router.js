import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
  {
    path: "/stu",
    children: [
      {
        name: "Course",
        path: "course",
        component: () => import("./components/Course.vue")
      },
      {
        name: "CourseScore",
        path: "course/score",
        component: () => import("./components/CourseScore.vue")
      },
      {
        name: "MyInfo",
        path: "self",
        component: () => import("./components/MyInfo.vue")
      }
    ]
  }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes
});

export default router;