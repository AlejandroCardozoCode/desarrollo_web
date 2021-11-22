import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import CrearDoctor from "../views/crear_doctor.vue";
import login from "@/views/login.vue";
import AgregarHC from "@/views/AgregarHC.vue";



const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    component: login,
  },
  {
    path: "/crear_doctor",
    component: CrearDoctor,
  },
  {
    path: "/AgregarHC",
    component: AgregarHC,
  },

];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
