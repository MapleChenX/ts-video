import { createRouter, createWebHistory } from "vue-router";
import { useCookies } from "@vueuse/integrations/useCookies";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/"
    },
    {
      path: "/login",
      name: "login",
      component: () => import("@/views/Login.vue")
    },
    {
      path: "/register",
      name: "register",
      component: () => import("@/views/Register.vue")
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

router.beforeEach((to, from, next) => {
  let cookie = useCookies().get("signed");
  if (to.name === "register") {
    next();
  } else {
    if (!cookie && to.name !== "login") {
      next({ name: "login" });
    } else {
      next();
    }
  }
});

export default router;
