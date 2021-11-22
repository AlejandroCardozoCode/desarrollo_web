import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Home from "../views/Home.vue";
import CrearDoctor from "../views/crear_doctor.vue";
import login from "@/views/login.vue";


const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    component: login,
  },
  {
    path: "/about",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
  {
    path: "/crear_doctor",
    component: CrearDoctor,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
