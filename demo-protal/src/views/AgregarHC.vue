<template>
  <div class="wrapper-layout">
    <Header title="Agregar Historia Clinica" class="header"></Header>

    <Barra_lateral class="sidebar"></Barra_lateral>

    <section class="content">
      <div class="print-data">
        <label for="idMascota" class="tag-input-login">Id Mascota</label>
        <input type="text" class="input-login" id="idMascota" />
      </div>
      <div class="print-data">
        <label for="idMedico" class="tag-input-login">Id Medico</label>
        <input type="text" class="input-login" id="idMedico" />
      </div>
      <div class="print-data">
        <label for="fecha" class="tag-input-login">Fecha</label>
        <input type="text" class="input-login" id="fecha" />
      </div>
      <div class="print-data">
        <label for="edad" class="tag-input-login">Edad</label>
        <input type="text" class="input-login" id="edad" />
      </div>
      <div class="write-data">
        <label for="descripcion" class="tag-input-login">Descripcion</label>
        <input type="text" class="input-login" id="descripcion" />
      </div>
      <div class="write-data">
        <label for="Receta" class="tag-input-login">Receta</label>
        <input type="text" class="input-login" id="Receta" />
      </div>
      <input type="submit" value="Guardar" class="submit-info" />
    </section>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import Header from "@/components/layouts/Header.vue";
import Barra_lateral from "@/components/barra_lateral.vue";
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
.content {
  grid-column: 2/3;
  grid-row: 2/3;
  background-color: #faf3dd;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  .print-data {
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
  .write-data {
    display: flex;
    flex-direction: column;
    width: 80%;
    margin: 0.5rem auto;
    .input-login {
      padding: 0.5rem 0.5rem;
      outline: none;
      border-radius: 0.5rem;
      border: #08afaf 1.5px solid;
      line-height: 70px;
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
