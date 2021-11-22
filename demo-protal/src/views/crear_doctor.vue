<template>
  <div class="wrapper_principal">
    <div class="barra_lateral"></div>
    <div class="pantalla">
      <h1>Crear Doctor</h1>
      <div>
        <div class="barra_input">
          <p>Ingrese el nombre</p>
          <input
            type="text"
            class="input_doctor"
            id="nombre"
            v-model="doctor_a_crear.nombre"
          />
        </div>
        <div class="barra_input">
          <p>Ingrese la cedula</p>
          <input
            type="number"
            class="input_doctor"
            id="cedula"
            v-model="doctor_a_crear.cedula"
          />
        </div>
        <div class="barra_input">
          <p>Ingrese la hora inicial</p>
          <input
            type="number"
            class="input_doctor"
            id="inicial"
            v-model="doctor_a_crear.horaI"
          />
        </div>
        <div class="barra_input">
          <p>Ingrese la hora final</p>
          <input
            type="number"
            class="input_doctor"
            id="final"
            v-model="doctor_a_crear.horaF"
          />
        </div>
        <div class="barra_input">
          <p>Ingrese el usuario</p>
          <input
            type="text"
            class="input_doctor"
            id="user"
            v-model="doctor_a_crear.usuario"
          />
        </div>
        <div class="barra_input">
          <p>Ingrese la contraseña</p>
          <input
            type="password"
            class="input_doctor"
            id="contra"
            v-model="doctor_a_crear.contra"
          />
        </div>
      </div>
      <button class="boton" @click="crear">Crear</button>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import { vm } from "@/viewModels/Doctor/crear_doctor_vm";
export default defineComponent({
  name: "CrearDoctor",
  setup() {
    const { doctor_a_crear, crear } = vm();
    return { doctor_a_crear, crear };
  },
});
</script>

<style scoped lang="scss">
h1 {
  font-family: "Roboto", sans-serif;
  color: #47525e;
  margin-left: 2.5em;
  margin-top: 0.5em;
}
body {
  font-family: "Roboto", sans-serif;
}
.wrapper_principal {
  height: 100vh;
  overflow: auto;
  background-color: rgb(172, 172, 172);
  display: grid;
  grid-template-columns: auto;
}

.barra_lateral {
  background: #68b0ab;
  display: flex;
  flex-direction: column;
  grid-column: 1 / 2;
}
.pantalla {
  background: #faf3dd;
  display: flex;
  flex-direction: column;
  grid-column: 2 / 5;
  font-family: "Roboto", sans-serif;
  color: #47525e;
  font-size: 1.5em;

  .barra_input {
    margin-top: 1.2em;
    margin-left: 5em;
    margin-right: 5em;
  }
}

.input_doctor {
  padding-left: 0.5em;
  margin-top: 0.5em;
  height: 2em;
  background: white;
  color: #47525e;
  width: 100%;
  font-family: "Roboto", sans-serif;
  font-size: 1em;
  border: none;
  outline: none;
  border-radius: 2em;
}
.boton {
  margin-top: 5em;
  align-self: center;
  height: 4em;
  width: 10em;
  background: #68b0ab;
  color: white;
  border-radius: 2em;
  outline: none;
  border: none;
  font-family: "Roboto", sans-serif;
  font-size: 0.7em;
  margin-bottom: 5em;
}
</style>
