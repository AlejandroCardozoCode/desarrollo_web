<template>

  <div class="wrapper-layout">
    <Header title="Crear Paciente" class="header"></Header>
    <Barra_lateral class="sidebar"></Barra_lateral>
    <section class="content">
      <div class="print-data">
        <label for="nombreMascota" class="tag-input-login">Nombre</label>
        <input type="text" class="input-login" id="nombreMascota" />
      </div>
      <div class="print-data">
        <label for="animal" class="tag-input-login">Animal</label>
        <input type="text" class="input-login" id="animal" />
      </div>
      <div class="print-data">
        <label for="raza" class="tag-input-login">Raza</label>
        <input type="text" class="input-login" id="raza" />
      </div>
      <div class="print-data">
        <label for="Cliente" class="tag-input-login">Cliente</label>
        <input type="text" class="input-login" id="Cliente" />
      </div>
      <input type="submit" value="Guardar" class="submit-info" />
    </section>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import Barra_lateral from "@/components/barra_lateral.vue";
import Header from "@/components/layouts/Header.vue";
export default defineComponent({
  name: "AgregarHC",
  components: {
    Header,
    Barra_lateral,
  },
});
</script>

<style scoped lang="scss">
.wrapper-layout {
  display: grid;
  grid-template-columns: 200px 1fr;
  grid-template-rows: 100px 1fr;
  height: 100vh;
}
.header {
  grid-column: 2/3;
  grid-row: 1/2;
  background-color: #faf3dd;
}
.sidebar {
  grid-column: 1/2;
  grid-row: 1/3;
  background-color: #68b0ab;
  font-size: 0.7em;
}
.content{
  grid-column: 2/3;
  grid-row: 2/3;
  background-color: #faf3dd;
  display: flex;
  flex-direction: column;
  align-items: center;

.print-data{
  font-family: "Roboto", sans-serif;
  display: flex;
  flex-direction: column;
  width: 80%;
  margin: 0.5rem auto;
  .input-login {
    padding: 0.5rem 0.5rem;
    outline: none;
    border-radius: 0.5rem;
    border: #08afaf 1.5px solid;
  }
  .tag-input-login {
    font-size: 1.2rem;
    margin-bottom: 0.2rem;
  }
}
  .submit-info {
    border: none;
    padding: 0.5rem 3rem;
    border-radius: 0.5rem;
    background-color: #68b0ab;
    color: #ffffffff;
    font-size: 1.2rem;
    margin-top: 1rem;
  }
}

</style>