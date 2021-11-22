import { crear_doc } from "@/types/Doctor/crearDoc";
import { Ref, ref } from "vue";
import { crearDoc } from "../../store/urls";
import { crear_doctor } from "../../services/crear_doctor/servicio_crear_doc";

export function vm() {
  const doctor_a_crear: Ref<crear_doc> = ref({
    nombre: "",
    cedula: 0,
    horaI: 0,
    horaF: 0,
    usuario: "",
    contra: "",
  });

  async function crear() {
    await crear_doctor.crear(doctor_a_crear.value);
    alert(doctor_a_crear.value.nombre);
  }

  return {
    doctor_a_crear,
    crear,
  };
}
