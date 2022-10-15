import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: () => import("@/views/Home.vue")
    },
    {
      path: "/post",
      name: "post",
      component: () => import("@/views/Post.vue")
    },
    {
      path: "/edit",
      name: "edit",
      component: () => import("@/views/Edit.vue")
    },
    {
      path: "/new/post",
      name: "newPost",
      component: () => import("@/views/NewPost.vue")
    },
    {
      path: "/manage/post",
      name: "managePost",
      component: () => import("@/views/ManagePost.vue")
    }
  ]
});

export default router;
