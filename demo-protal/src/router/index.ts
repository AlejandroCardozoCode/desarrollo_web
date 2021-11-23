import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import CrearDoctor from "../views/Doctor/crear_doctor.vue";
import ActualizarHI from "../views/Doctor/actualizar_hi.vue";
import ActualizarHF from "../views/Doctor/actualizar_hf.vue";
import EliminarDoc from "../views/Doctor/eliminar_doc.vue";
import CambiarContraDoc from "../views/Doctor/cambiar_contra_doc.vue";
import AgregarPacienteDoc from "../views/Doctor/agregar_paciente.vue";
import login from "@/views/login.vue";
import AgregarHC from "@/views/Paciente/AgregarHC.vue";
import CrearPaciente from "@/views/Paciente/CrearPaciente.vue";

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
    path: "/actualizar_hi",
    component: ActualizarHI,
  },
  {
    path: "/actualizar_hf",
    component: ActualizarHF,
  },
  {
    path: "/eliminar_doc",
    component: EliminarDoc,
  },
  {
    path: "/cambiar_contra_doc",
    component: CambiarContraDoc,
  },
  {
    path: "/agregar_paciente",
    component: AgregarPacienteDoc,
  },
  {
    path: "/AgregarHC",
    component: AgregarHC,
  },
  {
    path: "/CrearPaciente",
    component: CrearPaciente,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
