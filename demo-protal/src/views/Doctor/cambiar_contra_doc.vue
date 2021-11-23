<template>
  <div class="wrapper_principal">
    <Barra_lateral></Barra_lateral>
    <div class="pantalla">
      <h1>Cambiar Contraseña</h1>
      <div class="contededor_formulario">
        <div class="barra_input">
          <p>Ingrese su nueva contraseña</p>
          <input type="password" class="input" id="nombre" />
        </div>
      </div>

      <Boton msg="Cambiar"></Boton>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import Boton from "@/components/boton.vue";
import Barra_lateral from "@/components/barra_lateral.vue";
export default defineComponent({
  name: "El",
  components: { Boton, Barra_lateral },
});
</script>

<style scoped lang="scss">
h1 {
  margin-left: 2.4em;
  margin-top: 2em;
}
.descripcion {
  margin-left: 2.4em;
  width: 40em;
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
.contededor_formulario {
  margin-top: 5em;
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
.input {
  padding-left: 0.5em;
  margin-top: 0.5em;
  height: 1.5em;
  background: white;
  color: #47525e;
  width: 100%;
  font-family: "Roboto", sans-serif;
  font-size: 1em;
  border-style: solid;
  border-color: #68b0ab;

  outline: none;
  border-radius: 0.5em;
}
</style>
