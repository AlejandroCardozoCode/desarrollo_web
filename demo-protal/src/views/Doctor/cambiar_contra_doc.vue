<template>
  <div class="wrapper_principal">
    <Header title="Cambiar Contraseña" class="header"></Header>
    <Barra_lateral class="sidebar"></Barra_lateral>

    <section class="pantalla">
      <div class="pantalla">
        <div class="contededor_formulario">
          <div class="barra_input">
            <p>Ingrese su nueva contraseña</p>
            <input type="password" class="input" id="nombre" />
          </div>
          <div class="barra_input">
            <p>Confirme su contraseña</p>
            <input type="password" class="input" id="nombre" />
          </div>

        </div>

        <Boton msg="Cambiar"></Boton>
      </div>
    </section>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import Boton from "@/components/boton.vue";
import Barra_lateral from "@/components/barra_lateral.vue";
import HelloWorld from "@/components/HelloWorld.vue";
import Header from "@/components/layouts/Header.vue";
export default defineComponent({
  name: "El",
  components: { Boton, Barra_lateral, Header },
});
</script>

<style scoped lang="scss">
h1 {
  margin-left: 2.4em;
  margin-top: 2em;
}
.wrapper_principal {
  display: grid;
  grid-template-columns: 200px 1fr;
  grid-template-rows: 100px 1fr;
  height: 100vh;
}
.header {
  grid-column: 2/3;
  grid-row: 1/2;
}
.sidebar {
  grid-column: 1/2;
  grid-row: 1/3;
  background-color: #68b0ab;
  font-size: 0.7em;
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
  grid-column: 2 / 3;
  font-family: "Roboto", sans-serif;
  font-size: 1.2em;
  justify-content: center;

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
