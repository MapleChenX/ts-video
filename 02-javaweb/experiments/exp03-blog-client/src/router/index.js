import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      redirect: "/h"
    },
    {
      path: "/h",
      name: "home",
      redirect: "/h/posts",
      component: () => import("@/views/Home.vue"),
      children: [
        {
          path: "posts",
          name: "posts",
          component: () => import("@/views/Posts.vue")
        },
        {
          path: "post",
          name: "post",
          component: () => import("@/views/Post.vue")
        },
        {
          path: "edit",
          name: "edit",
          component: () => import("@/views/Edit.vue")
        },
        {
          path: "new/post",
          name: "newPost",
          component: () => import("@/views/NewPost.vue")
        },
        {
          path: "manage/post",
          name: "managePost",
          component: () => import("@/views/ManagePost.vue")
        }
      ]
    }
  ]
});

export default router;
