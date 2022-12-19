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
      },
      {
        name: "MyActs",
        path: "acts",
        component: () => import("./components/MyActs.vue")
      }
    ]
  }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes
});

export default router;